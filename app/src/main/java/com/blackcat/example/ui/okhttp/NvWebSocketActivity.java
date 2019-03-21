package com.blackcat.example.ui.okhttp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewConfiguration;

import com.blackcat.example.R;
import com.blackcat.example.utils.DebugUtil;
import com.neovisionaries.ws.client.WebSocket;

public class NvWebSocketActivity extends AppCompatActivity {
    private WebSocket webSocket;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nv_web_socket);

    }


    public void wsOpen(View view){
        webSocket= WebSocketDome.getNvWebSocket(new NvWebSocketListener());
        webSocket.connectAsynchronously();

    }
    public void wsSend(View view){
        view.getX();
        view.getY();
        if(webSocket.isOpen()){
            DebugUtil.debug("------wsSend");
            webSocket.sendText("你好！！");
        }else{
            DebugUtil.debug("------连接不可用");
        }

    }
    public void wsClose(View view){

        if(webSocket.isOpen()){
            DebugUtil.debug("------wsClose");
            webSocket.sendClose();
        }else{
            DebugUtil.debug("------连接已经关闭");
        }

    }
}
