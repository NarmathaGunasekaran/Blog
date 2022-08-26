package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class BokkingHistory {
    private int id;
    private int totalPrice;
    private ArrayList<Product> products = new ArrayList<>();
}