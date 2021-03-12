package com.company.Repositories;

import com.company.Sneakers;

import java.util.List;
//Basic interface for methods
public interface Interface {
    Sneakers getSneakersByBrand(String brand,String gender);
    Sneakers getSneakersBySize(int size, String gender);
    Sneakers getSneakersByName(String name, String gender);
    List<Sneakers> getSneakersByPrice(double price1, double price2,String gender);
    List<Sneakers> getAllSneakers(String gender);
}
