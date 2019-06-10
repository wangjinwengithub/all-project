package com.daka.web.websocket;

import com.alibaba.fastjson.JSON;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DaKaWebSocketService extends TextWebSocketHandler {

    private static final Map<WebSocketSession, String> connections = new ConcurrentHashMap<>();
    /**
     * 建立连接时调用
     * @param session
     * @throws Exception
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        String uri = session.getUri().toString();
        System.out.print("uri:"+uri);
        String userName = uri.substring(uri.lastIndexOf("/") + 1);
        System.out.println("userName"+userName);
        String nickname = URLDecoder.decode(userName, "utf-8");
        System.out.println("nickname:"+nickname);
        connections.put(session, nickname);
        String message = nickname+ "建立连接成功！";
        System.out.print("==========="+message);
        broadcast(new TextMessage(message));
    }

    /**
     * 发消息时
     * @param session
     * @param message
     * @throws Exception
     */
    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        Map<String,String> map=new HashMap<>();
        map.put("user",connections.get(session));
        map.put("status",message.getPayload()+"");
        System.out.println("发送消息："+message.getPayload());
        String msg = JSON.toJSONString(map);
        broadcast(new TextMessage(msg));
    }


    /**
     * 关闭连接时
     * @param session
     * @param status
     * @throws Exception
     */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        String nickname = connections.remove(session);
        String message = String.format(nickname, "断开链接！");
        broadcast(new TextMessage(message));
    }

    private static void broadcast(TextMessage msg) {
        // 广播形式发送消息
        for (WebSocketSession session : connections.keySet()) {
            try {
                synchronized (session) {
                    System.out.print(msg);
                    session.sendMessage(msg);
                }
            } catch (Exception e) {
                connections.remove(session);
                try {
                    session.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                String message = String.format("* %s %s", connections.get(session), "断开连接");
                broadcast(new TextMessage(message));
            }
        }
    }
}
