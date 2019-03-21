package com.blackcat.example.ui.okhttp;

import com.blackcat.example.utils.DebugUtil;
import com.neovisionaries.ws.client.WebSocket;
import com.neovisionaries.ws.client.WebSocketAdapter;
import com.neovisionaries.ws.client.WebSocketException;
import com.neovisionaries.ws.client.WebSocketFrame;
import com.neovisionaries.ws.client.WebSocketState;

import java.util.List;
import java.util.Map;

/**
 * Created by blackcat on 2019/3/8.16.13
 */
public class NvWebSocketListener extends WebSocketAdapter {
    /**
     *WebSocket状态改变
     * @param websocket
     * @param newState
     * @throws Exception
     */
    @Override
    public void onStateChanged(WebSocket websocket, WebSocketState newState) throws Exception {
        super.onStateChanged(websocket, newState);
    }

    /**
     * WebSocket连接成功
     * @param websocket
     * @param headers
     * @throws Exception
     */
    @Override
    public void onConnected(WebSocket websocket, Map<String, List<String>> headers) throws Exception {
        super.onConnected(websocket, headers);
        DebugUtil.debug("onConnected");
    }

    /**
     * WebSocket连接失败异常
     * @param websocket
     * @param exception
     * @throws Exception
     */
    @Override
    public void onConnectError(WebSocket websocket, WebSocketException exception) throws Exception {
        super.onConnectError(websocket, exception);
        DebugUtil.debug("onConnectError-");
        exception.printStackTrace();
    }

    /**
     * WebSocket连接关闭回调
     * @param websocket
     * @param serverCloseFrame
     * @param clientCloseFrame
     * @param closedByServer
     * @throws Exception
     */
    @Override
    public void onDisconnected(WebSocket websocket, WebSocketFrame serverCloseFrame, WebSocketFrame clientCloseFrame, boolean closedByServer) throws Exception {
        super.onDisconnected(websocket, serverCloseFrame, clientCloseFrame, closedByServer);
        DebugUtil.debug("onDisconnected-");
    }

    /**
     * 接收到的字符串消息
     * @param websocket
     * @param text
     * @throws Exception
     */
    @Override
    public void onTextMessage(WebSocket websocket, String text) throws Exception {
        super.onTextMessage(websocket, text);
        DebugUtil.debug("onTextMessage-"+text);
    }

    /**
     * 接收到的字节消息
     * @param websocket
     * @param data
     * @throws Exception
     */
    @Override
    public void onTextMessage(WebSocket websocket, byte[] data) throws Exception {
        super.onTextMessage(websocket, data);
        DebugUtil.debug("onTextMessage2-"+data);
    }

    /**
     * WebSocket异常抛出
     * @param websocket
     * @param cause
     * @throws Exception
     */
    @Override
    public void onError(WebSocket websocket, WebSocketException cause) throws Exception {
        super.onError(websocket, cause);
        DebugUtil.debug("onError-");
        cause.printStackTrace();

    }
}
