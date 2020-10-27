package kek.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/main")
public class MainPageController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView main() {
        ModelAndView md = new ModelAndView();
        md.addObject("title", "Authentication scheme of MAC messages:");
        md.setViewName("views/mainPage");
        return md;
    }

    @RequestMapping(value = "/sha", method = RequestMethod.GET)
    public ModelAndView shaPage() {
        ModelAndView md = new ModelAndView();
        md.setViewName("views/sha1");
        md.addObject("msg", "test");
        return md;
    }

    @RequestMapping(value = "/aes", method = RequestMethod.GET)
    public ModelAndView aesPage() {
        ModelAndView md = new ModelAndView();
        md.setViewName("views/AES");
        return md;
    }

}
