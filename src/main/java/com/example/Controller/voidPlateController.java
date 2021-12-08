package com.example.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("voidPlate")
public class voidPlateController {

         @RequestMapping("")
         public String voidPlate(){
               return "html/voidPlate";
         }
}
