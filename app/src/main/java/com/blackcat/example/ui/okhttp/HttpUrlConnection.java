package com.blackcat.example.ui.okhttp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by blackcat on 2018/12/5.16.09
 */
public class HttpUrlConnection {
    /**
     * Get请求
     *
     * @throws IOException
     */
    public static void readContentFromGet() throws IOException {
        //创建一个getURL字符串，使用URLEncoder.encode()对特殊字符进行编码
        String getURL = "GET_URL" + " ?username= "
                + URLEncoder.encode(" fat man ", "utf-8");
        URL getUrl = new URL(getURL);
        //获取连接对象
        HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();
        //进行连接，这里进行了连接，但是并没有真正的把Request请求发送给服务端 在下面的connection.getInputStream()才把真正的Request发送给了服务端
        connection.connect();
        //取得输入流，并使用Reader读取
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        System.out.println("==========================");
        System.out.println("Contents of get request");
        System.out.println("==========================");
        String lines;
        //读取输入流
        while ((lines = reader.readLine()) != null) {
            System.out.println(lines);
        }
        //关闭输入流
        reader.close();
        //断开连接，其实就是断开了底层的Socket连接
        connection.disconnect();
        System.out.println("==========================");
        System.out.println("Contents of get request ends");
        System.out.println("==========================");
    }

    /**
     * 断点续传
     */
    public void doBreakDownloadJava() {
        URL url = null;
        try {
            //创建一个URL对象
            url = new URL("http://www.sjtu.edu.cn/down.zip");
            //通过URL对象来创建一个HttpURLConnection来进行网络请求
            HttpURLConnection httpUrlConnection = (HttpURLConnection) url.openConnection();
            //添加RANGE头部信息，断点续传的开始位置为字节2000080。表示down.zip文件从字节2000080开始下载
            httpUrlConnection.setRequestProperty("RANGE", "bytes=2000080-");
            InputStream inputStream = httpUrlConnection.getInputStream();
            //RandomAccessFile 可以对文件进行指定字节的读写
            RandomAccessFile oSavedFile = new RandomAccessFile("down.zip", "rw");
            long nPos = 2000070;
            //从文件的nPos字节开始读写
            oSavedFile.seek(nPos);
            byte[] b = new byte[1024];
            int nRead;
            while ((nRead = inputStream.read(b, 0, 1024)) > 0) {
                //写入文件
                oSavedFile.write(b, 0, nRead);

            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 多线程文件下载
     *
     * @throws Exception
     */
    public void download() throws Exception {
        //线程总数
        int threadCount = 4;
        URL url = new URL("服务器文件地址");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(10000);
        //根据服务器返回的ResponseCode进行操作
        int code = connection.getResponseCode();
        if (code == 200) {
            //获取资源大小
            int connectionLength = connection.getContentLength();
            //在本地创建一个与资源同样大小的文件来站位
            RandomAccessFile randomAccessFile = new RandomAccessFile(new File("文件路径", "文件名"), "rw");
            randomAccessFile.setLength(connectionLength);
            //计算每一个线程理论上加载的资源大小
            int blockSize = connectionLength / threadCount;
            //开启for循环为每一个线程分配任务
            for (int threadId = 0; threadId < threadCount; threadId++) {
                //线程开始下载的位置
                int startIndex = threadId * blockSize;
                //线程结束下载的位置
                int endIndex = (threadId + 1) * blockSize - 1;
                //最后一个线程结束下载的位置,剩余的任务全部交给最后一个线程去完成
                if (threadId == (threadCount - 1)) {
                    endIndex = connectionLength - 1;
                }
                //开启线程下载
                new DownloadThread(threadId, startIndex, endIndex).start();
            }

        }

    }

    private class DownloadThread extends Thread {
        private int  threadId;
        private int  startIndex;
        private int  endIndex;

        public DownloadThread(int threadId,int startIndex,int endIndex ){
            this.threadId=threadId;
            this.startIndex=startIndex;
            this.endIndex=endIndex;
        }

        @Override
        public void run() {
            super.run();
            System.out.println("线程" +threadId +"开始下载");
            try {
                //重新创建一个URL去读取数据
                URL url = new URL("服务器连接地址");
                //线程下载文件
                File downThreadFile = new File("targetFilePath","downThread_"+threadId+".dt");
                RandomAccessFile downThreadStream = null;
                if(downThreadFile.exists()){//如果文件存在
                    downThreadStream = new RandomAccessFile(downThreadFile,"rwd");
                    String startIndex_str = downThreadStream.readLine();
                    if(null != startIndex_str||!"".equals(startIndex_str)){
                        //设置下载起点
                        this.startIndex = Integer.parseInt(startIndex_str)-1;
                    }
                }else {
                    downThreadStream = new RandomAccessFile(downThreadFile,"rwd");
                }
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setConnectTimeout(10000);
                //设置分段数据请求头信息
                connection.setRequestProperty("Range","bytes="+startIndex+"-"+endIndex);
                //206 分段数据请求成功
                if(connection.getResponseCode()==206){
                    InputStream inputStream = connection.getInputStream();
                    //获取前面创建好的文件
                    RandomAccessFile randomAccessFile = new RandomAccessFile(
                            new File("targetFilePath","文件名"),"rw");
                    randomAccessFile.seek(startIndex);
                    byte[] buffer = new byte[1024];
                    int length = -1;
                    int total = 0;
                    while ((length = inputStream.read(buffer))>0){
                        randomAccessFile.write(buffer,0,length);
                        total+=length;
                        downThreadStream.seek(0);
                        downThreadStream.write((startIndex+total+"").getBytes("UTF-8"));
                    }
                    downThreadStream.close();
                    inputStream.close();
                    randomAccessFile.close();
                    //TODO 删除downThreadFile临时文件
                }else{
                    System.out.println("响应码是"+connection.getResponseCode()+"服务器不支持多线程下载");
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
