package kek.service;

import kek.models.SHA1;
import kek.models.SHADTOResponse;
import org.springframework.stereotype.Service;

@Service
public class SHA1Service {

    public SHA1 encrypt(String message) {
        SHA1 sha1 = new SHA1();
        sha1.encrypt(message);
        return sha1;
    }

}
