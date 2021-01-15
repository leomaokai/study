package com.kai.mapper;

import com.kai.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {
    //增删改查
    int insertBook(Books books);
    int deleteBook(@Param("bookID") int id);
    int updateBook(Books books);
    Books getBook(@Param("bookID") int id);
    List<Books> listBooks();

    List<Books> queryBookByName(@Param("bookName") String bookName);
}
