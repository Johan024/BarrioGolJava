package modelo;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class conexion {
    public String base_de_datos="productos";
    public String url="jdbc:mysql://localhost:3306/"+base_de_datos;
    public  String user="root";
    public String contraseña="231219";
    Connection conect=null;
    public  Connection conecta(){
        try{
            conect= DriverManager.getConnection(url,user,contraseña);
            System.out.println("conexion estabecida bro");
        }catch (Exception e){
            System.out.println("no se establecio"+e);
        }
        return conect;
    }
}
