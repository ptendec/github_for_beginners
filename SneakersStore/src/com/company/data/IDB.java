package com.company.data;

import java.sql.Connection;
import java.sql.SQLException;

public interface IDB {
    //    Interface of DB connection
    Connection getConnection() throws SQLException, ClassNotFoundException;
}
