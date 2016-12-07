package testBook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import testBook.model.Book;
import testBook.service.BookService;

/**
 * Created by yasha on 04.12.2016.
 */
@Controller
public class ControllerBook {
    private BookService bookService;

    @Autowired(required = true)
    @Qualifier(value = "bookService")
    public void setServiceBook(BookService bookService) {
        this.bookService = bookService;
    }


    @RequestMapping(value = "books", method = RequestMethod.GET)
    public String listBooks(Model model){
        model.addAttribute("book", new Book());
        System.out.println(bookService);
        model.addAttribute("listBooks", this.bookService.listBooks());
        return "books";
    }
}
