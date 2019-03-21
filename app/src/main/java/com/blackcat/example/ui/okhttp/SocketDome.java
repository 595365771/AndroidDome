package com.blackcat.example.ui.okhttp;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

/**
 * Created by blackcat on 2018/12/4.20.43
 */
public class SocketDome {
    public void TCPSendMessage(String msg) {
        Socket socket = null;
        OutputStream outputStream = null;
        InputStream inputStream = null;
        try {
            socket = new Socket("192.168.1.100", 8888);
            //获取socket的输出流
            outputStream = socket.getOutputStream();
            //写入发送的信息到输出流中
            outputStream.write(msg.getBytes());
            //写入完毕调用shutdownOutput()方法，如果不调用可能收不到服务端返回的信息
            socket.shutdownOutput();
            //获取服务器返回的信息进行读取
            inputStream = socket.getInputStream();
            byte[] b = new byte[1024];
            int len = -1;
            final StringBuffer stringBuffer = new StringBuffer();
            while ((len = inputStream.read(b)) != -1) {
                stringBuffer.append(new String(b, 0, len, Charset.forName("gbk")));
            }
            //todo 在主线程中更新UI
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //注意没有关闭输入/输出流对象，因为它们只是在Socket中得到对象，并没有去创建
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void ReceiveMessage() {
        //服务端Socket对象
        ServerSocket serverSocket = null;
        Socket socket =null;
        try {
            //开启服务端Socket对象去监听8888端口
            serverSocket =new ServerSocket(8888);
            while (true){
                //通过serverSocket的accept()方法获取客户客户端发送的Socket信息，如果客户端没有发送Socket信息这个方法会阻塞，等待客户端的信息。
                socket = serverSocket.accept();
                System.out.println(socket.getInetAddress().getHostName());
                System.out.println(socket.getInetAddress().getHostAddress());
                //获取socket的输入流 进行读取
                InputStream inputStream =socket.getInputStream();
                BufferedInputStream bufferedInputStream =new BufferedInputStream(inputStream);
                byte[] bytes =new byte[1024];
                int len = -1;
                while ((len =bufferedInputStream.read(bytes))!= -1){
                    System.out.println(new String(bytes,0,len,"UTF-8"));
                }
                socket.shutdownInput();
                OutputStream outputStream = socket.getOutputStream();
                outputStream.write("ok,我已经收到信息".getBytes());
                //关闭缓存输入流和socket对象。
                // 这里的BufferedInputStream需要关闭是因为我们创建了这个对象，
                // ServerSocket不需要关闭，如果关闭了服务端就收不到客户端发送的信息了
                bufferedInputStream.close();
                socket.close();
                socket=null;


            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
