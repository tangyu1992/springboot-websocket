package cn.com.sweetcandy.websocket.interceptor;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

/****
 * websocket拦截器，可对消息处理的开始和结束进行拦截，处理
 * 
 * @author tangyu
 *
 */
@Component
public class MessageInterceptor implements HandshakeInterceptor {

	private final Logger logger = LoggerFactory.getLogger(MessageInterceptor.class);

	public void afterHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse,
			WebSocketHandler webSocketHandler, Exception exception) {
	}

	public boolean beforeHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse,
			WebSocketHandler webSocketHandler, Map<String, Object> arg3) throws Exception {
		logger.info("before message,retnrn messageis:{}", serverHttpRequest);
		return true;// 这里可对消息进行处理，如果不符合某些条件可以返回false，消息将不会走到处理逻辑
	}

}
