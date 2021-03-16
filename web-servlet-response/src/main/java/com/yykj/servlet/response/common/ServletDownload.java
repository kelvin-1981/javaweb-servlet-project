package com.yykj.servlet.response.common;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * Response: Web服务器接收到客户端的http请求，针对这个请求，分别创建一个代表请求的HTTPServletRequest对象，代表响应的一个HTTPServletResponse
 * Response 下载附件
 */
public class ServletDownload extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO: 1.要获取下载文件的路径
        String realPath="D:\\Program Files\\ideaspace2\\javaweb-servlet-project\\web-servlet-response\\src\\main\\resources\\file.txt";
        System.out.println("下载文件的路径："+realPath);
        // TODO: 2.下载的文件名是啥？
        String fileName=realPath.substring(realPath.lastIndexOf("\\")+1);
        // TODO: 3.设置想办法让浏览器能够支持(Content-Disposition)下载我们需要的东西,中文文件名URLEncoder.encode编码，否则可能乱麻
        resp.setHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(fileName,"UTF-8"));
        // TODO: 4.获取下载文件的输入流
        FileInputStream in = new FileInputStream(realPath);
        // TODO: 5.创建缓冲区
        int len=0;
        byte[] buffer= new byte[1024];
        // 6. 获取OutputStream对象
        ServletOutputStream out = resp.getOutputStream();
        // 7. 将FileOutputStream流写入到buffer缓冲区,使用OutputStream将缓冲区中的数据输出到客户端！
        while ((len=in.read(buffer))>0){
            out.write(buffer,0,len);
        }
        in.close();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
