package com.example.service;
import com.example.Dao.CarRepository;
import com.example.entity.car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class carservice {

    @Resource
    private  CarRepository cr;

    public static List<String>Platelist= Collections.synchronizedList(new ArrayList<String>());


       public car save(car c){

           return cr.save(c);
       }

       public boolean exs(String carPlate){

              return cr.findByCarPlate(carPlate).isEmpty()?false:true;
       }

       public String findcarPlate(String engineNumber){
            List<car> carList=cr.findByEngineNumber(engineNumber);
            if(carList.isEmpty()){
                 return "";
            }
            return carList.get(0).getCarPlate();
       }

       public void updateCarPlate(String engineNumber,String carPlate){
             cr.updateCarPlateByEngineNumber(engineNumber,carPlate);
       }

       public void deleteCarPlate(String engineNumber){
            cr.deleteByEngineNumber(engineNumber);
       }


}
