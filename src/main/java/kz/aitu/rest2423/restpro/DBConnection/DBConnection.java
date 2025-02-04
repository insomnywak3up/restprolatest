package kz.aitu.rest2423.restpro.DBConnection;

import java.sql.*;

public class DBConnection
{
    protected String url = "jdbc:postgresql://localhost:5432/school_management";
    protected String username = "postgres";
    protected String password = "12345678";

    public Connection connect() throws SQLException
    {
        Connection con = DriverManager.getConnection(url, username, password);
        System.out.println("Connection established successfully.");
        return con;
    }

    public int closeConnection(Connection con) throws SQLException
    {
        if (con != null)
        {
            con.close();
            System.out.println("Connection closed.");
            return 0;
        }
        System.out.println("Connection is already closed.");
        return 1;
    }
}

