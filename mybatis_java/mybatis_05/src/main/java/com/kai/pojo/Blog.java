package com.kai.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Blog {
    private String id;  // 通过IDUtils生成随机ID
    private String title;
    private String author;
    private Date createTime;//开启驼峰命名映射
    private int views;
}
