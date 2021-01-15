package com.kai.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

@RestController
public class FileController {

    //@RequestParam("file")将name=file控件得到的文件封装成CommonsMultipartFile对象
    //批量上传CommonsMultipartFile则为数组即可
    @RequestMapping("/upload")
    public String fileUpload1(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request) throws IOException {
        //获取文件名:file.getOriginalFilename();
        String uploadFileName = file.getOriginalFilename();

        //如果文件名为空,直接返回首页
        if ("".equals(uploadFileName)) {
            return "redirect:/index.jsp";
        }
        System.out.println("filename:" + uploadFileName);

        //上传路径保存位置
        String path = request.getServletContext().getRealPath("/upload");
        //如果路径不存在则创建一个
        File realPath = new File(path);
        if (!realPath.exists()) {
            realPath.mkdir();
        }
        System.out.println("filePath:" + realPath);

        //文件输入流
        InputStream is = file.getInputStream();
        //文件输出流
        OutputStream os = new FileOutputStream(new File(realPath, uploadFileName));

        //读取写出
        int len = 0;
        byte[] buffer = new byte[1024];
        while ((len = is.read(buffer)) != -1) {
            os.write(buffer, 0, len);
            os.flush();
        }
        os.close();
        is.close();
        return "ok";
    }

    //采用file.TransferTo来保存上传的文件
    @RequestMapping("/upload2")
    public String fileUpload2(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request) throws IOException {

        //上传路径保存设置
        String path = request.getServletContext().getRealPath("/upload");
        File realPath = new File(path);
        if (!realPath.exists()) {
            realPath.mkdir();
        }
        //上传文件地址
        System.out.println("uploadFilePath:" + realPath);
        //通过CommonsMultipartFile得方法直接写文件
        file.transferTo(new File(realPath + "/" + file.getOriginalFilename()));

        return "ok";
    }

    @RequestMapping("/download")
    public String downLoads(HttpServletResponse response, HttpServletRequest request) throws Exception {
        //要下载图片的地址
        String path = request.getServletContext().getRealPath("/upload");
        String fileName = "hhxx.jpg";
        //设置response响应头
        response.reset();//设置页面不存在,清空buffer
        response.setCharacterEncoding("utf-8");//字符编码
        response.setContentType("multipart/form-data");
        //设置响应头
        response.setHeader("Content-Disposition",
                "attachment;fileName=" + URLEncoder.encode(fileName, "utf-8"));
        File file = new File(path, fileName);
        //读取文件输入流
        FileInputStream is = new FileInputStream(file);
        //写出文件输出流
        OutputStream out = response.getOutputStream();

        byte[] buff = new byte[1024];
        int index = 0;
        //执行写出操作
        while ((index = is.read(buff)) != -1) {
            out.write(buff, 0, index);
            out.flush();
        }
        out.close();
        is.close();
        return null;
    }
}
