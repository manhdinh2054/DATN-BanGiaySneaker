package org.example.baitapbuoi3.bangiaythethaosneaker.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FixErrorCodeController {
    @RequestMapping("/403")
    public String handle403() {
        return "403";
    }
}
