package v002.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import v002.service.BookServiceImpl;


@Controller
@RequestMapping("/BookOperation")
public class BookOperationController {
 
	private BookServiceImpl bookService;

    @RequestMapping(value="edit/{id}", method = RequestMethod.POST)
    public String printWelcome(@PathVariable("id") int id, Model model) {
    	
        return "hello";
    }

    @Autowired(required = true)
    @Qualifier(value = "bookService")
	public void setBookService(BookServiceImpl bookService) {
		this.bookService = bookService;
	}
}