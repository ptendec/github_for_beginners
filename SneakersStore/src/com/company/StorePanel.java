package com.company;

import com.company.Repositories.Interface;

import java.util.List;

public class StorePanel {
    //    The store panel was created to make the options logically correct
    private final Interface repo;

    public StorePanel(Interface repo){this.repo=repo;}

    public  String getSneakersByName(String name, String gender){
        Sneakers sneakers = repo.getSneakersByName(name,gender);

        return (sneakers == null ? "Sneakers was not found!" : sneakers.toString());
    }

    public List <Sneakers> getAllSneakers(String gender){
        List <Sneakers> sneakers = repo.getAllSneakers(gender);
        return sneakers;
    }


    public  String getSneakersByBrand(String brand, String gender){
        Sneakers sneakers = repo.getSneakersByBrand(brand, gender);

        return (sneakers == null ? "Sneakers was not found!" : sneakers.toString());
    }

    public String getSneakersBySize(int size, String gender){
        Sneakers sneakers = repo.getSneakersBySize(size, gender);

        return (sneakers == null ? "Sneakers was not found!" : sneakers.toString());
    }
    public String getSneakersByPrice(double price1, double price2, String gender){
        List <Sneakers> sneakers = repo.getSneakersByPrice(price1, price2, gender);

        return sneakers.toString();
    }
}