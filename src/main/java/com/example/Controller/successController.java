package com.example.Controller;
import com.example.entity.car;
import com.example.utils.randomPlate;
import com.example.service.carservice;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/success")
public class successController {

      @Resource
      private carservice cs;

      randomPlate rp=new randomPlate();

      @RequestMapping("")
      public String successPage(@ModelAttribute("Em")String enginenumber, Model model){
            if(enginenumber.equals("")){
                  return "redirect:/voidnum";
            }
            String carPlate=cs.findcarPlate(enginenumber);
            model.addAttribute("Em",enginenumber);
            model.addAttribute("Cp",carPlate);

            return "html/success";
      }

      @PostMapping("")
      public synchronized String getPost(@RequestParam("enginenum")String enginenumber,@RequestParam("carplate")String carplate,@RequestParam("province")String province,@RequestParam("city")String city, RedirectAttributes attr){

            if(province.equals("台")||(province+city).equals("粤Z")){
                   return "html/regionDeny";
            }

            if(province.equals("请选择省份")||city.equals("请选择城市")){
                   return "redirect:/invalidRegion";
            }

            List<String>candidatePlate=new ArrayList<String>();
            while(true){

                  if(candidatePlate.size()==3){
                        break;
                  }
                  String carp=rp.generatePlate(province,city);
                  if(!cs.exs(carp)&&carservice.Platelist.indexOf(carp)==-1){
                        candidatePlate.add(carp);
                        carservice.Platelist.add(carp);
                  }
            }

            attr.addFlashAttribute("Em",enginenumber);
            attr.addFlashAttribute("Cp",carplate);
            attr.addFlashAttribute("P1",candidatePlate.get(0));
            attr.addFlashAttribute("P2",candidatePlate.get(1));
            attr.addFlashAttribute("P3",candidatePlate.get(2));

            return "redirect:/choice";

      }
}
