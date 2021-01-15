package com.kai.controller;


import com.kai.pojo.Books;
import com.kai.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    //调service层

    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    //查询全部书籍,并且返回到一个书籍展示页面
    @RequestMapping("/allBook")
    public String list(Model model) {
        List<Books> books = bookService.listBooks();
        model.addAttribute("list", books);
        return "allBook";
    }

    //跳转到增加书籍页面
    @RequestMapping("/toaddBook")
    public String toAddPaper() {
        return "addBook";
    }

    //添加书籍的请求
    @RequestMapping("/addbook")
    public String addBook(Books book){
        bookService.insertBook(book);
        return "redirect:/book/allBook";
    }

    //跳转到修改页面
    @RequestMapping("/toUpdate")
    public String toUpdatePaper(int id,Model model){
        Books book = bookService.getBook(id);
        model.addAttribute("getbook",book);
        return "updateBook";
    }
    //修改书籍请求
    @RequestMapping("/updatebook")
    public String updateBook(Books book){
        bookService.updateBook(book);
        return "redirect:/book/allBook";
    }

    //删除书籍
    @RequestMapping("/toDelete/{bookid}")
    public String deleteBook(@PathVariable("bookid") int id){
        bookService.deleteBook(id);
        return "redirect:/book/allBook";
    }

    //查询书籍
    @RequestMapping("/queryBook")
    public String queryBook(String queryBookName,Model model){
        List<Books> books = bookService.queryBookByName(queryBookName);
        model.addAttribute("list",books);
        return "allBook";
    }

}
