package com.blackcat.example.ui.okhttp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.blackcat.example.R;
import com.blackcat.example.utils.DebugUtil;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

public class OkhttpActivity extends AppCompatActivity {
    private Button btn_okget, btn_okpost, btn_wsopen, btn_wssend, btn_wsclose;
    private WebSocket webSocket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp);
        initView();

        initListener();

    }

    private void initView() {
        btn_okget = (Button) findViewById(R.id.btn_okget);
        btn_okpost = (Button) findViewById(R.id.btn_okpost);
        btn_wsopen = (Button) findViewById(R.id.btn_wsopen);
        btn_wssend = (Button) findViewById(R.id.btn_wssend);
        btn_wsclose = (Button) findViewById(R.id.btn_wsclose);
    }

    /**
     * 创建一个简单的基础版OkHttpClient。这种创建方式也在OkHttpClient中创建了一个Builder对象只不过是系统默认的。
     */
    //    OkHttpClient client = new OkHttpClient();
    /**
     * Builder 用来构造比较复杂的OkHttpClient类，它是OkHttpClient的一个静态内部类，构造方法的第一行创建了Dispatch分发器类，Dispatch分发器类会接收到我们同步和异步的请求队列然后根据相应的条件进行分发。
     * <p>
     * 调用Builder的build()方法来完成OkHttpClient的构建
     */
    OkHttpClient client = new OkHttpClient
            .Builder()
            //File表示缓存目录，MaxSize表示缓存目录大小
            .cache(new Cache(new File("cache"), 24 * 1024 * 1024))
            .readTimeout(5, TimeUnit.SECONDS)
            .build();

    private void initListener() {
        btn_okget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                synGetRequest();
            }
        });
        btn_okpost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btn_wsopen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                connect();
            }
        });
        btn_wssend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webSocket.send("6666667");
            }
        });
        btn_wsclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webSocket.close(1000, null);
            }
        });
    }

    /**
     * ws://192.168.1.210:8283
     * OkHttp发起WebSocket请求
     * ws://echo.websocket.org
     */
    private void connect() {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("ws://echo.websocket.org")
                .build();
        EchoWebSocketListener listener = new EchoWebSocketListener();
        webSocket = client.newWebSocket(request, listener);
        webSocket.cancel();
        client.dispatcher().executorService().shutdown();
//            //OkHttp会调用自己的后台来发送数据，所以这里不会阻塞当前线程
//            webSocket.send("hello word");
//            webSocket.send("welcome");
//            webSocket.send(ByteString.decodeHex("abcd"));
//            //发送消息完成
//            webSocket.close(1000, "再见");
    }

    private final class EchoWebSocketListener extends WebSocketListener {
        /**
         * 客户端在和远程的服务端建立连接时的回调
         *
         * @param webSocket
         * @param response
         */
        @Override
        public void onOpen(WebSocket webSocket, Response response) {
            super.onOpen(webSocket, response);
            DebugUtil.debug("-------onOpen");

        }

        /**
         * 接收字符串格式的信息
         *
         * @param webSocket
         * @param text
         */
        @Override
        public void onMessage(WebSocket webSocket, String text) {
            super.onMessage(webSocket, text);
            //onMessage 方法运行在后台线程中，如果和主线程交互需要使用Handler
            DebugUtil.debug("-------onMessage---" + text);
        }

        /**
         * 接收字节流格式的信息
         *
         * @param webSocket
         * @param bytes
         */
        @Override
        public void onMessage(WebSocket webSocket, ByteString bytes) {
            super.onMessage(webSocket, bytes);
            //onMessage 方法运行在后台线程中，如果和主线程交互需要使用Handler
            DebugUtil.debug("-------onMessageByteString---" + String.valueOf(bytes));
        }

        /**
         * 连接失败时的回调
         *
         * @param webSocket
         * @param t
         * @param response
         */
        @Override
        public void onFailure(WebSocket webSocket, Throwable t, Response response) {
            super.onFailure(webSocket, t, response);
            DebugUtil.debug("-------onFailure---");
            t.printStackTrace();
        }

        /**
         * 准备关闭WebSocket连接时的回调
         *
         * @param webSocket
         * @param code
         * @param reason
         */
        @Override
        public void onClosing(WebSocket webSocket, int code, String reason) {
            super.onClosing(webSocket, code, reason);
            DebugUtil.debug("-------onClosing---");
            webSocket.close(1000, null);
        }

        /**
         * 连接已经被关闭释放后的回调
         *
         * @param webSocket
         * @param code
         * @param reason
         */
        @Override
        public void onClosed(WebSocket webSocket, int code, String reason) {
            super.onClosed(webSocket, code, reason);
            DebugUtil.debug("-------onClosed---");
        }
    }

    /**
     * 同步Get请求
     */
    private void synGetRequest() {
        /**
         * Request代表我们请求报文的信息，包含我们请求的url和请求方式Get/POST等，也可以设置我们的请求头，也是通过Builder模式来创建
         */
        Request request = new Request.Builder().url("http://www.baidu.com").get().build();
        /**
         * 将Request封装成Call对象
         * Call对象代表了一个实际的http请求，也是连接Request和Response的一个桥梁，这一步是同步和异步的分水岭
         */
        Call call = client.newCall(request);
        try {
            /**
             * 调用Call的execute()发送同步请求并获得返回的Response，Call其实是一个接口它的具体实现在RealCall里面
             * Response代表响应报文的信息，包含响应头和响应体等，同步和异步请求的最大区别就在这里同步调用的是execute
             */
            Response response = call.execute();
            /**
             * 打印response的body体
             */
            DebugUtil.debug(response.body().string());
            /**
             * OkHttp发送同步请求后会进入阻塞状态，直到收到响应。
             */
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 异步Get请求
     */
    private void asyGetRequest() {
        /**
         * Request代表我们请求报文的信息，包含我们请求的url和请求方式Get/POST等，也可以设置我们的请求头，也是通过Builder模式来创建
         */
        Request request = new Request.Builder().url("http://www.baidu.com").get().build();
        /**
         * 将Request封装成Call对象
         * Call对象代表了一个实际的http请求，也是连接Request和Response的一个桥梁，这一步是同步和异步的分水岭
         */
        Call call = client.newCall(request);
        /**
         * 调用Call的enqueue()发送异步请求，这里的enqueue()方法需要一个Callback对象，这里需要注意的是
         * 当我们调用enqueue()进行异步请求的时候，Okhttp会开启一个子线程去进行网络请求，当子线程请求成功的时候
         * 会回调Callback的onResponse()返回给我们一个Call和Response数据，当子线程网络请求失败或者我们取消的时候
         * 会回调Callback的onFailure()返回给我们一个Call和错误信息。
         *
         * onFailure()和onResponse(）都是在子线程中执行的
         *
         *
         */
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //打印response的body体
                DebugUtil.debug(response.body().string());
            }
        });

        /**
         * OkHttp发送同步请求后会进入阻塞状态，直到收到响应。
         */
    }

    /**
     * OkHttp断点续传
     */
    public void doBreakDownloadOkHttp() {
        //代表已经下载的文件字节大小
        long downloadLength = 0;
        //代表服务器文件下载地址
        String downloadUrl = "";
        InputStream is;
        RandomAccessFile savedFile;
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                //添加RANGE头部信息
                .addHeader("RANGE", "bytes=" + downloadLength + "-")
                .url(downloadUrl)
                .build();
        try {
            //发送同步请求
            Response response = client.newCall(request).execute();
            if (response != null) {
                is = response.body().byteStream();
                savedFile = new RandomAccessFile("文件名", "rw");
                savedFile.seek(downloadLength);
                byte[] b = new byte[1024];
                int total = 0;
                int len;
                while ((len = is.read(b)) != -1) {
                    total += len;
                    savedFile.write(b, 0, len);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
