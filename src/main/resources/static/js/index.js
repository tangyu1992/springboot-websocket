var websocket;

function echoMessage(message) {
	document.getElementById('message').innerHTML += message + '<br/>';
}
// 发送消息
function send() {
	hasWebsocket();
	var message = document.getElementById('text').value;
	websocket.send(message);
}
function closeWebSocket() {
	websocket.close();
}
function hasWebsocket() {
	if (websocket == undefined || websocket == null) {
		alert('请先链接websocket！');
		return;
	}
}
function connect() {
	// 判断当前浏览器是否支持WebSocket
	if ('WebSocket' in window) {
		websocket = new ReconnectingWebSocket(
				"ws://127.0.0.1:8081/websockettest");
	} else {
		echoMessage('当前浏览器不支持websocket！');
		return;
	}
	// 连接发生错误的回调方法
	websocket.onerror = function() {
		echoMessage('error!');
	};

	// 连接成功建立的回调方法
	websocket.onopen = function() {
		websocket.send("init works!"); // Sends a message.
	}

	// 接收到消息的回调方法
	websocket.onmessage = function(event) {
		echoMessage(event.data);
	}

	// 连接关闭的回调方法
	websocket.onclose = function() {
		echoMessage('connection closed!');
	}
}
// 监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
window.onbeforeunload = function() {
	closeWebSocket();
}