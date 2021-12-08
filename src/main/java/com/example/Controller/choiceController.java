package com.example.Controller;

import com.example.entity.car;
import com.example.service.carservice;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller
@RequestMapping("/choice")
public class choiceController {

      @Resource
      private carservice cs;

      String s1;
      String s2;
      String s3;

      @RequestMapping("")
      public String choicePage(@ModelAttribute("Em")String enginenum, @ModelAttribute("Cp")String carP, @ModelAttribute("P1")String P1, @ModelAttribute("P2")String P2, @ModelAttribute("P3")String P3, Model model){

          model.addAttribute("Em",enginenum);
          model.addAttribute("Cp",carP);
          model.addAttribute("P1",P1);
          s1=P1;
          model.addAttribute("P2",P2);
          s2=P2;
          model.addAttribute("P3",P3);
          s3=P3;

          return "html/choice";
      }

      @PostMapping("")
    public String getChoice(@RequestParam("enginenum")String enginenum,@RequestParam("carplate")String carp,@RequestParam("choicecarp")String newcarp){

          if(!carp.equals("")){

               cs.updateCarPlate(enginenum,newcarp);

          }else{
              car c=new car();
              c.setEngineNumber(enginenum);
              c.setCarPlate(newcarp);
              cs.save(c);
          }

          int index;
          index=carservice.Platelist.indexOf(s1);
          carservice.Platelist.remove(index);

          index=carservice.Platelist.indexOf(s2);
          carservice.Platelist.remove(index);

          index=carservice.Platelist.indexOf(s3);
          carservice.Platelist.remove(index);

          return "redirect:/RegisterSuccess";
      }
}
