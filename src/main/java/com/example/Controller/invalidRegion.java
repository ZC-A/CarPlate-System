package com.example.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/invalidRegion")
public class invalidRegion {

     @RequestMapping("")
     public String invalid(){
           return "html/invalidRegion";
     }

}
