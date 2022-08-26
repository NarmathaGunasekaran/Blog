package service;

import Utils.PlaceUtils;
import Utils.UserUtils;
import Utils.CarUtils;
import model.Car;
import model.Place;
import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu  {
    private PlaceUtils placeUtils;
    private CarUtils carUtils;
    private Auth auth;

    private UserUtils userUtils;

    public MainMenu(PlaceUtils placeUtils, Auth auth, UserUtils userUtils) {
        this.auth = auth;
        this.placeUtils = placeUtils;
        this.userUtils = userUtils;
    }

    public void printMenu() {
        System.out.println("1. Book Car");
        System.out.println("2. View Booking");
        System.out.println("3. Logout");
        System.out.println("Enter your choice");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();


        if (choice == 1) {
            ArrayList<Place> places = placeUtils.getPlace();

            places.forEach(place -> {
                System.out.println(place.getId() + ". " + place.getPlace());
            });

            System.out.println("Enter your choice:");
            int placeChoice = scanner.nextInt();

            if (placeChoice <= places.size()) {
                Place selectedPlaces = places.get(placeChoice - 1);

                ArrayList<Car> cars = selectedPlaces.getCars();

                cars.forEach(car -> {
                    System.out.println(car.getId() + ". " + car.getName());
                });
                System.out.println("Enter your choice:");
                int carChoice = scanner.nextInt();
                if (carChoice <= cars.size()) {
                    Car selectedCar = cars.get(carChoice - 1);
                    System.out.println("Are you sure you wanna book " +
                            selectedCar.getId() + " . " + selectedCar.getName());


        }
    }
}