package com.kai.service;

import com.kai.mapper.BookMapper;
import com.kai.pojo.Books;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookServiceImpl implements BookService {
    private BookMapper bookMapper;

    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Override
    public int insertBook(Books books) {
        return bookMapper.insertBook(books);
    }

    @Override
    public int deleteBook(int id) {
        return bookMapper.deleteBook(id);
    }

    @Override
    public int updateBook(Books books) {
        return bookMapper.updateBook(books);
    }

    @Override
    public Books getBook(int id) { return bookMapper.getBook(id);
    }

    @Override
    public List<Books> listBooks() {
        return bookMapper.listBooks();
    }

    @Override
    public List<Books> queryBookByName(String bookName) {
        return bookMapper.queryBookByName(bookName);
    }
}
