package com.example.entity;
import javax.persistence.*;

@Entity
@Table(name="carsystem")
public class car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="engineNumber")
    private String engineNumber;

    @Column(name="carPlate")
    private String carPlate;

    public String getEngineNumber(){
        return engineNumber;
    }

    public  void setEngineNumber(String newenginenumber){
        engineNumber=newenginenumber;
    }

    public  String getCarPlate(){
          return carPlate;
    }

    public void setCarPlate(String carP){
         carPlate=carP;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

}
