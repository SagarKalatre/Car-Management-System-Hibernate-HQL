package com.car.CarDAO;

import com.car.Car.Car;

public interface CarDAO {
    public void showAllCarData();

    public Car getCarDataById(int car_id);

    public Car insertNewCar(Car car);

    public void updateCarData(Car car);

    public void deleteCarData(int car_id);



    public void displayAllCar();
    public void displayCarName();
    public void displayCarNameAndPrice();
    public void displayCarById(int car_id);
    public void findCarColor(String color);
    public void findCarBrand(String car_brand);
    public void findCarModel(String car_model);
    public void findCarFuel(String car_fuel);
    public void findCarAbovePrice(double price);
    public void findCarBetweenPrice(double minPrice, double maxPrice);
}
