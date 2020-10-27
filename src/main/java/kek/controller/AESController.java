package kek.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import kek.service.AESService;

@RestController
//@RequestMapping("/aes")
@RequiredArgsConstructor
public class AESController {

    private final AESService aesService;

    @PostMapping("/encr")
    public String encrypt(String message, String key) {
        return aesService.encrypt(message, key);
    }

    @GetMapping("/decr")
    public String decrypt(String message, String key) {
        return aesService.decrypt(message, key);
    }

}
