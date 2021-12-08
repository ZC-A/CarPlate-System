package com.example.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/RegisterSuccess")
public class RegisteerSuccess {

       @RequestMapping("")
       public  String successPage(){

             return "html/RegisterSuccess";
       }
}
