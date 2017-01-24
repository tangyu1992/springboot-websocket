package cn.com.sweetcandy.websocket.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import cn.com.sweetcandy.websocket.handler.MessageHandler;
import cn.com.sweetcandy.websocket.interceptor.MessageInterceptor;

@Configuration
@EnableWebSocket
public class WebsocketConfig implements WebSocketConfigurer {
	@Autowired
	private MessageHandler messageHandler;
	@Autowired
	private MessageInterceptor messageInterceptor;

	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(messageHandler, "/websockettest")//添加一个websocket处理器，可以添加多个 后面是其对应的url
		.addInterceptors(messageInterceptor)//添加拦截器
		.setAllowedOrigins("*");//允许所有的客户端连接

	}
}
