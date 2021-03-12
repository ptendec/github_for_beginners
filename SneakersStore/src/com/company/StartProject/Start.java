package com.company.StartProject;

import com.company.Sneakers;
import com.company.StorePanel;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Start {
    //    Creating variables
    private StorePanel controller;
    private Scanner scanner;
    private ArrayList<Integer> basket;
    private List<Sneakers> sneakers;
    private double cost;
    //Creating controller for the application
    public Start(StorePanel controller){
        this.controller = controller;
        scanner = new Scanner(System.in);
        this.basket = new ArrayList<Integer>();
    }

    //    Creating gender
     private String gender;

    public Start(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void start(){
//        Creating visual name of our application (Sneaker store)

        while(true){
            System.out.println("Your basket: ");
            //            basket system in order to save the shoes that you want to buy
            cost = 0;
            for(int id:basket){
                for(Sneakers s:sneakers){
                    if(s.getId() == id){
                        System.out.println(s.toString());
                        cost+=s.getPrice();
                    }
                }
            }
            System.out.println("Total cost is " + cost);
            System.out.println("Enter your gender(male, female or kids)");
            //            basic scanner
            Scanner sc = new Scanner(System.in);
            //            Condition for checking the input
            boolean flag = true;
            while(flag){
                gender = sc.next();
                if(!gender.equals("male") && !gender.equals("female") && !gender.equals("kids")){
                    System.out.println("Please input 'male', 'female' or 'kids'");
                }else{
                    flag = false;
                }
            }


            //            OPTIONS LIST
            System.out.println("Select option: (0-4)");
            System.out.println("1. View all sneakers");
            System.out.println("2. Select Sneaker by brand");
            System.out.println("3. Select Sneaker by name");
            System.out.println("4. Select Sneaker by price");
            System.out.println("5. Select Sneaker by size");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.println("Enter the option: (0-4)");
                int option = scanner.nextInt();
                if(option==1){
                    getAllSneakersMenu();
                }
                else if(option ==2){
                    getSneakersByBrandMenu();
                }
                else if(option == 3){
                    getSneakersByNameMenu();
                }
                else if(option == 4){
                    getSneakersByPriceMenu();
                }
                else if(option == 5){
                    getSneakersBySizeMenu();
                }

                else{
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input must be integer");
                scanner.nextLine();
            } catch (Exception e){
                System.out.println(e.getMessage());
            }

            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }
    }



    public void getAllSneakersMenu(){
        sneakers = controller.getAllSneakers(gender);
        System.out.println(sneakers.toString());
    }
    public void getSneakersByPriceMenu(){
        System.out.println("Please enter the range(from price #1 - to price #2)");
        System.out.println("Please enter price #1");
        double price1 = scanner.nextDouble();
        System.out.println("Please enter price #2");
        double price2 = scanner.nextDouble();
        String response = controller.getSneakersByPrice(price1, price2,gender);
        System.out.println(response);
        System.out.println("If you want to add this sneaker to basket please enter id");
        int ans = scanner.nextInt();
        basket.add(ans);
        sneakers = controller.getAllSneakers(gender);
    }


    public void getSneakersByNameMenu(){
        System.out.println("Please enter name");
        scanner.nextLine();
        String name = scanner.nextLine();
        String response = controller.getSneakersByName(name,gender);
        System.out.println(response);
        System.out.println("If you want to add this sneaker to basket please enter id");
        int ans = scanner.nextInt();
        basket.add(ans);
        sneakers = controller.getAllSneakers(gender);
    }
    public void getSneakersBySizeMenu(){
        System.out.println("Please enter size");
        int size = scanner.nextInt();
        String response = controller.getSneakersBySize(size,gender);
        System.out.println(response);
        System.out.println("Select id");
        int ans = scanner.nextInt();
        basket.add(ans);
        sneakers = controller.getAllSneakers(gender);
    }
    public void getSneakersByBrandMenu(){
        System.out.println("Please enter brand");
        String brand = scanner.next();
        String response = controller.getSneakersByBrand(brand,gender);
        System.out.println(response);
        System.out.println("Select id");
        int ans = scanner.nextInt();
        basket.add(ans);
        sneakers = controller.getAllSneakers(gender);
    }


}