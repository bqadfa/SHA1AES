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
        SHA1 sha1 = new SHA1(message);
        String encryptedMessage = sha1.getEncryptedMessage();
        model.addAttribute("encryptedMessage", encryptedMessage);
        System.out.println(encryptedMessage);
        return "sha";
    }

    @RequestMapping(value = "/aes", method = RequestMethod.GET)
    public String aesPage() {
        return "aes";
    }

    @RequestMapping(value = "/aes", method = RequestMethod.POST)
    public String encryptAes(@ModelAttribute(name = "initmsg")String message,
                             @ModelAttribute(name = "secKey")String secretKey, Model model) {
        AES aes = new AES(message, secretKey);
        String encryptedMessage = aes.getEncryptedMessage();
        model.addAttribute("encryptedMessage", encryptedMessage);
        System.out.println(encryptedMessage);
        return "aes";
    }

    @RequestMapping(value = "/aesDecrypt", method = RequestMethod.POST)
    public String decryptAes(@ModelAttribute(name = "decryptedText")String message,
                             @ModelAttribute(name = "secretKey")String secretKey, Model model) {

        String decryptedMessage = AES.decrypt(message, secretKey);
        model.addAttribute("decryptedMessage", decryptedMessage);
        System.out.println(decryptedMessage);
        return "aes";
    }

}
