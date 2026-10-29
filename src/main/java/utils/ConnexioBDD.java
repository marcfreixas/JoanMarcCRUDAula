package utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnexioBDD {

    public Connection getConection()
    {
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dam2","root","root");
            return connection;
        }catch(Exception e)
        {
            System.out.println(e);
        }
        return null;
    }



}
