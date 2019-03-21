package com.blackcat.example.ui.okhttp;

import com.neovisionaries.ws.client.WebSocket;
import com.neovisionaries.ws.client.WebSocketAdapter;
import com.neovisionaries.ws.client.WebSocketFactory;

import java.io.IOException;

/**
 * Created by blackcat on 2019/3/8.15.51
 */
public class WebSocketDome {

    public static WebSocket getNvWebSocket(WebSocketAdapter webSocketAdapter){
        try {
            WebSocket webSocket = new WebSocketFactory()
                    //配置连接地址和网络超时时间5000毫秒
                    .createSocket("ws://echo.websocket.org",5000)
                    //设置帧队列的大小。默认值为0，这意味着对队列大小没有限制。
                    .setFrameQueueSize(3)
                    //是否允许服务器在关闭连接的时候不发送关闭帧，false为不允许
                    .setMissingCloseFrameAllowed(false)
                    //添加WebSocket连接监听
                    .addListener(webSocketAdapter);

            return webSocket;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
