package org.usm.labwork.labwork.controller;

import org.usm.labwork.labwork.models.AES;
import org.usm.labwork.labwork.models.SHA1;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class IndexController {

    @GetMapping("/")
    public String main() {
        return "index";
    }

    @RequestMapping(value = "/sha", method = RequestMethod.GET)
    public String encryptedMessage() {
        return "sha";
    }

    @RequestMapping(value = "/sha", method = RequestMethod.POST)
    public String encryptSHA(@ModelAttribute(name = "initmsg")String message, Model model) {
        model.addAttribute("encryptedMessage", new SHA1(message).getEncryptedMessage());
        return "sha";
    }

    @RequestMapping(value = "/aes", method = RequestMethod.GET)
    public String aesPage() {
        return "aes";
    }

    @RequestMapping(value = "/aes", method = RequestMethod.POST)
    public String encryptAes(@ModelAttribute(name = "initmsg")String message,
                             @ModelAttribute(name = "secKey")String secretKey, Model model) {
        model.addAttribute("encryptedMessage", new AES(message, secretKey).getEncryptedMessage());
        return "aes";
    }

    @RequestMapping(value = "/aesDecrypt", method = RequestMethod.POST)
    public String decryptAes(@ModelAttribute(name = "decryptedText")String message,
                             @ModelAttribute(name = "secretKey")String secretKey, Model model) {
        model.addAttribute("decryptedMessage", AES.decrypt(message, secretKey));
        return "aes";
    }

}
