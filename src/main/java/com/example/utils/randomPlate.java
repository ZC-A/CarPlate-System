package com.example.utils;


import java.util.Random;

public class randomPlate {

         Random random=new Random();
         String alphas="QWERTYUIPASDFGHJKLZXCVBNM1234567890";


         public String generatePlate(String province,String city){

             String Plate="";
             Plate+=province;

             if(province.equals("京")||province.equals("津")||province.equals("沪")||province.equals("渝")){

                    Plate+=alphas.charAt(random.nextInt(24));
             }
             Plate+=city;

             for(int i=0;i<5;i++){

                    Plate+=alphas.charAt(random.nextInt(34));
             }

             return Plate;
         }
}
