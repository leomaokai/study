package com.kai.mapper;

import com.kai.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
    //添加博客
    int addBlog(Blog blog);

    //查询博客if
    List<Blog> listIfBlogs(Map map);

    //查询博客choose
    List<Blog> listChooseBlogs(Map map);

    //更新博客
    int updateBlog(Map map);

    //查询第1,2,3号记录的博客
    List<Blog> listForeachBlogs(Map map);
}
