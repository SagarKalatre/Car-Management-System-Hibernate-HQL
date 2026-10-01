package com.car.Car;

import java.util.Scanner;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@Table(name = "cars")
@Entity
@NoArgsConstructor 
@AllArgsConstructor 

public class Car {
    @Id
    private int car_id;
    private String car_name;
    private double car_price;
    private String car_color;
    private String car_brand;
    private String car_model;
    private String car_fuel;


    public void acceptCar() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Car ID : ");
        setCar_id(sc.nextInt());
        sc.nextLine();

        System.out.println("Enter Car Name : ");
        setCar_name(sc.nextLine());
        
        System.out.println("Enter Car Price : ");
        setCar_price(sc.nextDouble());
        sc.nextLine();

        System.out.println("Enter Car Color : ");
        setCar_color(sc.nextLine());

        System.out.println("Enter Car Brand : ");
        setCar_brand(sc.nextLine());

        System.out.println("Enter Car Model : ");
        setCar_model(sc.nextLine());

        System.out.println("Enter Car Fuel : ");
        setCar_fuel(sc.nextLine());
    }

}
