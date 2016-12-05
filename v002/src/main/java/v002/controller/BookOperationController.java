package v002.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/BookOperation")
public class BookOperationController {
 
    @RequestMapping(method = RequestMethod.POST, params="func=delete_book")
    public String printWelcome(ModelMap model) {
 
        model.addAttribute("message", "Spring 3 MVC - Hello World");
        return "hello";
 
    }
}