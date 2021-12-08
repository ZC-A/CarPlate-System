package com.example.Controller;
import com.example.service.carservice;
import com.example.utils.syntaxExam;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;

import static com.example.utils.syntaxExam.isvaildnum;

@Controller
@RequestMapping("/")
public class registercontroller {

    @Resource
    private carservice cs;

    @RequestMapping(value = "/")
    public String Index() {
        return "html/index";
    }

    @PostMapping(value = "/")
    public String requestsubmit(@RequestParam("enginenum")String enginenumber, RedirectAttributes attr) {

          if(!isvaildnum(enginenumber)){
               return "html/failed";
          }

          attr.addFlashAttribute("Em",enginenumber);
          return "redirect:/success";

    }
}
