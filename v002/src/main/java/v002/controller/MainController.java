package v002.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import v002.model.Book;
import v002.service.BookServiceImpl;

@Controller
public class MainController {
	private BookServiceImpl bookService;

	@RequestMapping(value = "books", method = RequestMethod.GET)
	public String listBooks(ModelMap model) {
		/*
		 * model.addAttribute("bookService", bookService);
		 */
		model.addAttribute("books", bookService.getBooks());

		return "book_table";
	}

	@Autowired(required = true)
	public void setBookService(BookServiceImpl bookService) {
		this.bookService = bookService;
	}
}