package kek.service;

import kek.models.AES;
import org.springframework.stereotype.Service;

@Service
public class AESService {

    public String encrypt(String message, String key) {
        return AES.encrypt(message, key);
    }

    public String decrypt(String message, String key) {
        return AES.decrypt(message, key);
    }

}
