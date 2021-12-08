package com.example.Controller;

import com.example.service.carservice;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller
@RequestMapping("delete")
public class deleteController {

         @Resource
         private carservice cs;

         @PostMapping("")
         public String deletePlate(@RequestParam("enginenum")String enginenum,@RequestParam("carplate")String carplate){

                  if(enginenum.equals("")){
                       return "html/voidnum";
                  }

                  if(carplate.equals("")){
                       return "redirect:/voidPlate";
                  }

                  cs.deleteCarPlate(enginenum);

                  return "redirect:/RegisterSuccess";
         }
}
