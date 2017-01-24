package cn.com.sweetcandy.websocket.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

/****
 * 处理websocket消息的handle
 * 
 * @author tangyu
 *
 */
@Component
public class MessageHandler implements WebSocketHandler {

	private final Logger logger = LoggerFactory.getLogger(MessageHandler.class);

	// 连接断开的逻辑在这里体现
	public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {
		logger.info("connect closed,status:{}", closeStatus);

	}

	// 连接成功的逻辑在这里体现
	public void afterConnectionEstablished(WebSocketSession webSocketSession) throws Exception {
		logger.info("connection established!session info:{}", webSocketSession);
	}

	// 接收到消息的逻辑在这里体现
	public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage)
			throws Exception {
		logger.info("received message:{},session:{}", webSocketMessage, webSocketSession);
		webSocketSession.sendMessage(
				new TextMessage("oh,we just received your message,it's:" + webSocketMessage.getPayload(), true));
	}

	// 传输异常的逻辑在这里体现
	public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) throws Exception {
		logger.error("chtch throwable,message is:", throwable);

	}

	public boolean supportsPartialMessages() {
		return false;
	}

}
