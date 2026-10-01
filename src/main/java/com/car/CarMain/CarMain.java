package com.car.CarMain;

import java.util.Scanner;

import com.car.Car.Car;
import com.car.CarDAO.CarDAO;
import com.car.CarDAOIMP.CarDAOIMP;

public class CarMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        CarDAO carDAO = new CarDAOIMP();
        Car car = new Car();

        int choice;
        
        do {    
            System.out.println("------------------------------");
            System.out.println("        Car Management        ");
            System.out.println("------------------------------");

            System.out.println("1. Display all Car");
            System.out.println("2. Display only Car Names");
            System.out.println("3. Display Car Name and Price");
            System.out.println("4. Find Car using Car_Id");
            // System.out.println("5. Find Car using Car_Name");
            System.out.println("6. Find Car by Color");
            System.out.println("7. Find Car by Brand");
            System.out.println("8. Find car By Model");
            System.out.println("9. Find Car By Fuel");
            System.out.println("10. Find Cars Abover Price");
            System.out.println("11. Find Cars Between Price");
            
            System.out.println("12.  Show All Cars Data");
            System.out.println("13.  Get Car Data By Id");
            System.out.println("14.  Insert New Car");
            System.out.println("15.  Update Car Data");
            System.out.println("16.  Delete Car Data");
            System.out.println("17.  Exit");

            System.out.println("Enter Your Choise : ");
            choice = sc.nextInt();

            switch (choice) {

                case 1 :
                    carDAO.displayAllCar();
                    break;

                case 2 :
                    carDAO.displayCarName();
                    break;

                case 3 :
                    carDAO.displayCarNameAndPrice();
                    break;

                case 4 :
                    System.out.println("Enter Car Id : ");
                    int search_Id = sc.nextInt();

                    carDAO.displayCarById(search_Id);
                    break;

                case 6 :
                    sc.nextLine();
                    System.out.println("Enter Car Color : ");
                    String search_color = sc.nextLine();

                    carDAO.findCarColor(search_color);
                    break;

                case 7 :
                    sc.nextLine();
                    System.out.println("Enter Car Brand : ");
                    String search_Brand = sc.nextLine();

                    carDAO.findCarBrand(search_Brand);
                    break;

                case 8 : 
                    sc.nextLine();
                    System.out.println("Enter Car Model : ");
                    String search_Model = sc.nextLine();

                    carDAO.findCarModel(search_Model);
                    break;

                case 9 :
                    sc.nextLine();
                    System.out.println("Enter Car Fuel Type : ");
                    String search_fuel = sc.nextLine();

                    carDAO.findCarFuel(search_fuel);
                    break;

                case 10 :
                    sc.nextLine();
                    System.out.println("Enter Minimum Price : ");
                    double search_Price = sc.nextDouble();

                    carDAO.findCarAbovePrice(search_Price);
                    break;

                case 11 :
                    sc.nextLine();
                    System.out.println("Enter Minimum Price : ");
                    double min_Price = sc.nextDouble();
                    System.out.println("Enter Max Price : ");
                    double max_Price = sc.nextDouble();

                    carDAO.findCarBetweenPrice(min_Price, max_Price);
                    break;

                case 12 :
                    sc.nextLine();
                    carDAO.showAllCarData();
                    break;

                case 13 :
                    sc.nextLine();
                    System.out.println("Enter Car Id : ");
                    int searchId = sc.nextInt();

                    Car searchCar = carDAO.getCarDataById(searchId);
                    
                    if (searchCar != null) {
                        System.out.println(searchCar);
                    } else {
                        System.out.println("Car Id " + searchId + " Not Found...!");
                    }

                    break;

                case 14 :
                    Car newCar = new Car();
                    newCar.acceptCar();
                    carDAO.insertNewCar(newCar);
                    break;

                case 15 :
                    System.out.println("Enter Car Id To Update : ");
                    Car carUpdate = new Car();
                    carUpdate.acceptCar();
                    carDAO.updateCarData(carUpdate);
                    break;

                case 16 :
                    System.out.println("Enter Car Id To Delete : ");
                    int deleteByID = sc.nextInt();
                    carDAO.deleteCarData(deleteByID);
                    break;

                case 17 :
                    System.out.println("Thank You....");
                    System.out.println("Program Exit Successfully...!");
                    break;

                default:
                    System.out.println("Invalid Choice...!");
            }
        } while (choice != 17);

        sc.close();
    }
}
