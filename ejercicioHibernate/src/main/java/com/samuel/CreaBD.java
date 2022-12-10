package com.samuel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * CLASE ENCARGADA DE BORRAR LA BASE DE DATOS samuel (SI EXISTE) Y/O CREARLA
 */
public class CreaBD
{
    public static void main( String[] args )
    {
        //primero me conecto a la BD de mantenimiento de postgres y ahí creo la BD samuel
        try(Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","root","root");
            Statement st = con.createStatement())
        {
            //Ya estamos dentro de la base de datos de postgres
            System.out.println("Conexión establecida con la base de datos");
            String sql = "DROP DATABASE IF EXISTS samuel;" + " CREATE DATABASE samuel;";
            st.executeUpdate(sql);
            System.out.println("Base de datos samuel creada");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
