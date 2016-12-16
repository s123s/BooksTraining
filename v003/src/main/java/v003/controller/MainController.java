package v003.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import v003.service.BookService;
import v003.service.BookServiceImpl;

@Controller
public class MainController {
	private BookService bookService;

	@RequestMapping(value = "books", method = RequestMethod.GET)
	public String listBooks(ModelMap model) {
		model.addAttribute("books", bookService.readAll());
		return "book_table";
	}

	@Autowired(required = true)
	public void setBookService(BookServiceImpl bookService) {
		this.bookService = bookService;
	}
}