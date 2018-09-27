package com.tiantian.config.webSocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
      //  //注册一个Stomp的节点（endpoint）,并指定使用SockJS协议。
        stompEndpointRegistry.addEndpoint("/ws/endpointChat").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // //服务端发送消息给客户端的域,多个用逗号隔开
        registry.enableSimpleBroker("/queue","/topic");
        //   //定义一对一推送的时候前缀
        //   registry.setUserDestinationPrefix(Constant.P2PPUSHBASEPATH);
        //       //定义websoket前缀SimpMessagingTemplate
        //        registry.setApplicationDestinationPrefixes(Constant.WEBSOCKETPATHPERFIX);
    }
}

/**
 * A1）EnableWebSocketMessageBroker注解表明： 这个配置类不仅配置了 WebSocket，还配置了 基于代理的 STOMP 消息；
 * A2）它重载了 registerStompEndpoints() 方法：将 "/hello" 路径 注册为 STOMP 端点。这个路径与之前发送和接收消息的目的路径有所不同， 这是一个端点，客户端在订阅或发布消息 到目的地址前，要连接该端点，即 用户发送请求 url='/server/hello' 与 STOMP
 *  server 进行连接，之后再转发到 订阅url；（server== name of
 * your springmvc project ）（干货——端点的作用——客户端在订阅或发布消息 到目的地址前，要连接该端点）
 * A3）它重载了 configureMessageBroker() 方法：配置了一个 简单的消息代理。如果不重载，默认case下，会自动配置一个简单的 内存消息代理，用来处理 "/topic" 为前缀的消息。但经过重载后，消息代理将会处理前缀为 "/topic" and "/queue" 消息。
 * A4）之外：发送应用程序的消息将会带有 "/app" 前缀，下图展现了 这个配置中的 消息流；
 *
 * ---------------------
 *
 * 本文来自 PacosonSWJTU 的CSDN 博客 ，全文地址请点击：https://blog.csdn.net/pacosonswjtu/article/details/51914567?utm_source=copy
 */