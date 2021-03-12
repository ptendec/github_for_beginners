package com.company.Repositories;

import com.company.data.IDB;
import com.company.Sneakers;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.LinkedList;
import java.util.List;
import java.sql.*;


public class Methods implements Interface{
    private final IDB db;
    private String gender;

    public Methods(IDB db){
        this.db=db;
    }

    //Methods list
//    Giving gender as a parameter
    public Sneakers getSneakersByName(String name, String gender) {
        this.gender = gender;
        Connection con=null;
        //        Making an SQL query for name
        try {
            con=this.db.getConnection();
            String sql= String.format("SELECT  id, brand, name, price, size FROM %s WHERE name=?", gender);
            PreparedStatement st=con.prepareStatement(sql);
            st.setString(1, name);
            ResultSet rs=st.executeQuery();

            if(rs.next()){
                Sneakers sneakers =new Sneakers(rs.getInt("id"),
                        rs.getString("brand"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("size"));
                return sneakers;

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
//SQL query for size
    public Sneakers getSneakersBySize(int size, String gender) {
        this.gender = gender;
        Connection con=null;
        try {
            con=this.db.getConnection();
            String sql= String.format("SELECT  id, brand, name, price, size FROM %s WHERE size=?", gender);
            PreparedStatement st=con.prepareStatement(sql);
            st.setInt(1, size);
            ResultSet rs=st.executeQuery();

            if(rs.next()){
                Sneakers sneakers =new Sneakers(rs.getInt("id"),
                        rs.getString("brand"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("size"));
                return sneakers;

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
    //    Making the query by brand

    public Sneakers getSneakersByBrand(String brand, String gender) {
        this.gender = gender;
        Connection con=null;
        try {
            con=this.db.getConnection();
            String sql= String.format("SELECT  id, brand, name, price, size FROM male WHERE brand=?", gender);
            PreparedStatement st=con.prepareStatement(sql);
            st.setString(1, brand);
            ResultSet rs=st.executeQuery();

            if(rs.next()){
                Sneakers sneakers =new Sneakers(rs.getInt("id"),
                        rs.getString("brand"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("size"));
                return sneakers;

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
//Query for getting all Sneakers list
    public List<Sneakers> getAllSneakers(String gender) {
        this.gender = gender;
        Connection con= null;
        try {
            con=db.getConnection();
            String sql= String.format("SELECT  id, brand, name, price, size FROM %s", gender);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            List<Sneakers> sneakers = new LinkedList<>();
            while (rs.next()){
                Sneakers sneakers1 =new Sneakers(rs.getInt("id"),
                        rs.getString("brand"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("size"));
                sneakers.add(sneakers1);
            }
            return sneakers;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
//Making query for taking the sneakers by special price range
    public List<Sneakers> getSneakersByPrice(double price1, double price2, String gender) {
        this.gender = gender;
        Connection con=null;
        try {
            con = db.getConnection();
            String sql = String.format("SELECT id, brand, name, price, size FROM %s WHERE price BETWEEN '" + price1 + "' AND '" + price2 + "'", gender);
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Sneakers> sneakers = new LinkedList<>();
            while (rs.next()){
                Sneakers sneakers1 =new Sneakers(rs.getInt("id"),
                        rs.getString("brand"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("size"));
                sneakers.add(sneakers1);
            }
            return sneakers;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }


}
