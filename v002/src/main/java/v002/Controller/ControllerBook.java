package v002.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import v002.domain.Book;
import v002.service.ServiceBook;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by yasha on 21.11.2016.
 */

@Controller
public class ControllerBook {
    private ServiceBook serviceBook;

@Autowired
@Qualifier(value = "bookService")
    public void setServiceBook(ServiceBook serviceBook) {
        this.serviceBook = serviceBook;
    }

@RequestMapping(value = "books", method = RequestMethod.GET)
    public String listBooks(Model model){
    model.addAttribute("book", new Book());
    model.addAttribute("listBooks", this.serviceBook.listBooks());
    return "books";

}

}
