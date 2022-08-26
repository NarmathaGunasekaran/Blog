package Utils;

import model.Car;

import java.util.ArrayList;

public class CarUtils {
    private ArrayList<Car> cars = new ArrayList<>();

    public ArrayList<Car> getCars() {
        return cars;
    }

    public void loadCar() {
        Car car = new Car();
        System.out.println("Car Details");
        cars.add(new Car(1, "Hyundai", "Altis", "SJC2456", 500));
        cars.add(new Car(2, "Toyota", "Vellfire", "SJGH458", 500));
        cars.add(new Car(3, "Mahindra", "Altis", "TN2256", 500));
        cars.add(new Car(4, "Tata Motors", "Altis", "TNC2456", 500));
        cars.add(new Car(5, "Maruti Suzuki", "Altis", "TN2778D", 500));
        cars.add(car);
    }
}
