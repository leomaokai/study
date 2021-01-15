package com.kai.Response;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

public class Response extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        //获取路径
        String realPath ="filePath";
        //获取文件名
        String filename = realPath.substring(realPath.lastIndexOf("\\" + 1));

        //设置下载头信息
        //resp.setHeader("Content-disposition","attachment;filename"+ URLEncoder.encode(filename));
        resp.setHeader("Content-disposition","attachment;filename"+ URLEncoder.encode(filename,"UTF-8"));

        //将文件输入流再输出
        FileInputStream fileInputStream = new FileInputStream(realPath);
        int len=0;
        byte[] buffer = new byte[1024];
        ServletOutputStream outputStream = resp.getOutputStream();
        while((len=fileInputStream.read(buffer))>0){
            outputStream.write(buffer,0,len);
        }

        outputStream.close();
        fileInputStream.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
