package com.car.CarDAOIMP;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.car.Car.Car;
import com.car.CarDAO.CarDAO;

public class CarDAOIMP implements CarDAO {
    
    public static Session getSession() {
        Session session = new Configuration()
                    .configure()
                    .buildSessionFactory()
                    .openSession();

        return session;
    }   

    @Override 
    public void showAllCarData() {
        Session session = CarDAOIMP.getSession();

        String hql = "FROM Car";
        Query<Car> query = session.createQuery(hql, Car.class);

        List<Car> car_list = query.getResultList();

        for (Car car : car_list) {
            System.out.println(car);
        }

        session.clear();
    }

    @Override 
    public Car getCarDataById(int car_id) {
        Session session = CarDAOIMP.getSession();
        Car car = session.get(Car.class, car_id);
        session.close();
        return car;
    }

    @Override 
    public Car insertNewCar(Car car) {
        Session session = CarDAOIMP.getSession();
        Transaction transaction = session.beginTransaction();

        session.save(car);
        transaction.commit();
        session.close();

        System.out.println("Car Data Inserted Successfully...!");
        return car;
    }
    
    @Override 
    public void updateCarData(Car car) {
        Session session = CarDAOIMP.getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "UPDATE Car SET "
                + "car_name = :name, "
                + "car_price = :price, "
                + "car_color = :color, "
                + "car_brand = :brand, "
                + "car_model = :model, "
                + "car_fuel = :fuel "
                + "WHERE car_id = :id";

        Query query = session.createQuery(hql);

        query.setParameter("name", car.getCar_name());
        query.setParameter("price", car.getCar_price());
        query.setParameter("color", car.getCar_color());
        query.setParameter("brand", car.getCar_brand());
        query.setParameter("model", car.getCar_model());
        query.setParameter("fuel", car.getCar_fuel());
        query.setParameter("id", car.getCar_id());

        query.executeUpdate();
        transaction.commit();
        session.close();

        System.out.println("Car Data Uodated Successfully...!");
    }

    @Override 
    public void deleteCarData(int car_id) {
        Session session = CarDAOIMP.getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "DELETE FROM Car WHERE car_id = :id";

        Query query = session.createQuery(hql);
        query.setParameter("id", car_id);
        int result = query.executeUpdate();

        if (result > 0) {
            transaction.commit();
            System.out.println("Car Data Deleted Successfully...!");
        } else {
            transaction.rollback();
            System.out.println("Car Id " + car_id +", Not Fount...!");
        }
    }

    public void displayAllCar() {
        Session session = CarDAOIMP.getSession();
        String hql = "FROM Car";

        Query<Car> query = session.createQuery(hql, Car.class);
        List<Car> car_list = query.getResultList();

        for (Car car : car_list) {
            System.out.println(car);
        }

        session.close();
    }
    
    public void displayCarName() {
        Session session = CarDAOIMP.getSession();
        String hql = "SELECT car_name FROM Car";

        Query<String> query = session.createQuery(hql, String.class);
        List<String> car_name = query.getResultList();

        for (String name : car_name) {
            System.out.println("Car Name : " + name);
        }

        session.close();
    }
    
    public void displayCarNameAndPrice() {
        Session session = CarDAOIMP.getSession();
        String hql = "SELECT car_name, car_price FROM Car";

        Query<Object[]> query = session.createQuery(hql, Object[].class);
        List<Object[]> car_list = query.getResultList();

        for (Object[] car : car_list) {
            System.out.println("Car Name : " + car[0] + " | Price : ₹" + car[1]);
        }
        session.clear();
    }
    
    public void displayCarById(int car_id) {
        Session session = CarDAOIMP.getSession();
        String hql = "FROM Car WHERE car_id = :id";

        Query<Car> query = session.createQuery(hql, Car.class);
        query.setParameter("id", car_id);

        Car car = query.uniqueResult();

        if (car != null) {
            System.out.println(car);
        } else {
            System.out.println("Car Id : " + car_id + ", Not Found...!");
        }

        session.close();
    }
    
    public void findCarColor(String car_color) {
        Session session = CarDAOIMP.getSession();
        String hql = "FROM Car WHERE car_color LIKE :color";

        Query<Car> query = session.createQuery(hql, Car.class);
        query.setParameter("color", "%" + car_color + "%");
        List<Car> car_List = query.getResultList();

        for (Car car : car_List) {
            System.out.println(car);
        }

        session.close();
    }
    
    public void findCarBrand(String car_brand) {
        Session session = CarDAOIMP.getSession();
        String hql = "FROM Car WHERE car_brand = :brand";

        Query<Car> query = session.createQuery(hql, Car.class);
        query.setParameter("brand", car_brand);
        List<Car> car_List = query.getResultList();

        for (Car car : car_List) {
            System.out.println(car);
        }

        session.clear();
    }
    
    public void findCarModel(String car_model) {
        Session session = CarDAOIMP.getSession();
        String hql = "FROM Car WHERE car_model = :model";

        Query<Car> query = session.createQuery(hql, Car.class);
        query.setParameter("model", car_model);
        List<Car> car_List = query.getResultList();

        for (Car car : car_List) {
            System.out.println(car);
        }

        session.close();
    }
    
    public void findCarFuel(String car_fuel) {
        Session session = CarDAOIMP.getSession();
        String hql = "FROM Car WHERE car_fuel = :fuel";
    
        Query<Car> query = session.createQuery(hql, Car.class);
        query.setParameter("fuel", car_fuel);
        List<Car> car_List = query.getResultList();

        for (Car car : car_List) {
            System.out.println(car);
        }

        session.close();
    }
    
    public void findCarAbovePrice(double price) {
        Session session = CarDAOIMP.getSession();
        String hql = "FROM Car WHERE car_price > :price";

        Query<Car> query = session.createQuery(hql, Car.class);
        query.setParameter("price", price);
        List<Car> car_List = query.getResultList();

        for (Car car : car_List) {
            System.out.println(car);
        }

        session.close();
    }
    
    public void findCarBetweenPrice(double minPrice, double maxPrice) {
        Session session = CarDAOIMP.getSession();
        String hql = "FROM Car WHERE car_price BETWEEN :minPrice AND :maxPrice";

        Query<Car> query = session.createQuery(hql, Car.class);
        query.setParameter("minPrice", minPrice);
        query.setParameter("maxPrice", maxPrice);
        List<Car> car_List = query.getResultList();

        for (Car car : car_List) {
            System.out.println(car);
        }

        session.close();
    }
}
