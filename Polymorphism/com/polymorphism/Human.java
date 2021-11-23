package com.polymorphism;
import java.time.LocalDate;

public class Human {
    private String name;
    private LocalDate dateOfBirth;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Human(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void Eat(SolidFood food){
        System.out.println("Chewing the food");
    }

    public void Eat(LiquidFood food){
        System.out.println("Drinking the food");
    }
}
