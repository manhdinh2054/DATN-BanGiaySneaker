package org.example.baitapbuoi3.bangiaythethaosneaker.Services.Encode;

import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class Base64Services {
    public String encodeBase64(String value) {
        return Base64.getEncoder().encodeToString(value.getBytes());
    }

    public String decodeBase64(String encodedValue) {
        return new String(Base64.getDecoder().decode(encodedValue));
    }
}
