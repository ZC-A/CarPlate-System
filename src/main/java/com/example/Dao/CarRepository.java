package com.example.Dao;
import com.example.entity.car;
import org.apache.catalina.startup.ClassLoaderFactory;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.*;

@Component
@Transactional
@Repository
public interface CarRepository extends JpaRepository<car, Long> {

       public List<car> findByEngineNumber(String engineNumber);
       public List<car> findByCarPlate(String carPlate);

       @Transactional
       @Modifying
       @Query(value = "update carsystem c set c.car_plate=?2 where c.engine_number=?1",nativeQuery = true)
       public  void updateCarPlateByEngineNumber(@Param("engineNumber")String engineNumber,@Param("carPlate")String carPlate);

       @Transactional
       @Modifying
       public void deleteByEngineNumber(@Param("engineNumber")String engineNumber);

}
