package v002.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import v002.model.Book;
import v002.service.BookService;
import v002.service.BookServiceImpl;

@Controller

@RequestMapping(value = "/book")
public class BookOperationController {

	private BookService bookService;

	@RequestMapping(value = "/edit/{id}")
	public String editBook(@PathVariable("id") int id, Model model) {
		model.addAttribute("book", bookService.read(id));
		return "book/edit";
	}

	  
	@RequestMapping(value = "/save_edited",  method = RequestMethod.POST)
	public String saveEditedBook(@ModelAttribute("book") Book book) {
		bookService.update(book);

		return "redirect:/books";
	}

	@RequestMapping(value = "/delete/{id}")
	public String deleteBook(@PathVariable("id") int id, Model model) {
		bookService.markDeleted(id);

		return "redirect:/books";
	}
	
	
	
	@Autowired(required = true)
	@Qualifier(value = "bookService")
	public void setBookService(BookServiceImpl bookService) {
		this.bookService = bookService;
	}
}