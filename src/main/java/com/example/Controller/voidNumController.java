package com.example.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/voidnum")
public class voidNumController {

        @RequestMapping("")
        public String voidPage(){
              return "html/voidnum";
        }
}
