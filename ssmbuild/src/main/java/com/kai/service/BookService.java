package com.kai.service;

import com.kai.pojo.Books;

import java.util.List;

public interface BookService {

    int insertBook(Books books);
    int deleteBook(int id);
    int updateBook(Books books);
    Books getBook(int id);
    List<Books> listBooks();
    List<Books> queryBookByName(String bookName);
}
