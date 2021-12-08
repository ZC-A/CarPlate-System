package com.example.utils;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class syntaxExam {

      public static boolean isvaildnum(String enginenumber){

          Pattern p=Pattern.compile("^[0-9A-Z]{17}$");
          Matcher m=p.matcher(enginenumber);     //

          return m.matches();
      }
}
