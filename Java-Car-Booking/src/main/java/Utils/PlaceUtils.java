package Utils;

import model.Car;
import model.Place;

import java.util.ArrayList;

public class PlaceUtils {
        private ArrayList<Place> places = new ArrayList<>();

        public ArrayList<Place> getPlace() {
            return places;
        }

        public void loadPlace() {
            ArrayList<Place> places = new ArrayList<>();
            Place place = new Place();
            System.out.println("Places");
            places.add(new Place(1, "Chennai"));
            places.add(new Place(2, "Tiruvallur"));
            places.add(new Place(3, "Chengapattu"));
            places.add(new Place(4, "Kanchipuram"));
            places.add(place);
        }
    }


