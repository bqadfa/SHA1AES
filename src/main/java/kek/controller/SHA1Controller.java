package kek.controller;

import kek.models.SHA1;
import lombok.RequiredArgsConstructor;
import kek.models.SHADTO;
import kek.models.SHADTOResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import kek.service.SHA1Service;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@Controller
//@RequestMapping("/sha")
public class SHA1Controller {

    private final SHA1Service sha1Service;

    @RequestMapping(value = "/sha1encrypt", method = RequestMethod.POST)
    public ModelAndView encrypt(@ModelAttribute SHADTO message) {
        ModelAndView md = new ModelAndView();
        md.setViewName("redirect:/main/sha");
        SHA1 sha1 = sha1Service.encrypt(message.getMessage());
        md.addObject("msg", sha1.getEncryptedMessage());
        return md;
    }

}
