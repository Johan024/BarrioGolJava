package modelo;

import java.sql.*;
import java.util.ArrayList;

public class model {
    conexion conexion=new conexion();
    Connection conect=conexion.conecta();
    PreparedStatement ps = null;
    Statement st= null;
    ResultSet sr=null;
    ArrayList<clase_principal>productos=new ArrayList<>();


    public String agregar(clase_principal cla){
        String resultado2="";
        boolean resultado=false;
        clase_principal producto=buscar_referencia(cla.getReferencia());
        try{
            if (producto == null) {
                String sql = "INSERT INTO productos (referencia, nombre, precios, categoria) VALUES (?, ?, ?, ?)";
                ps = conect.prepareStatement(sql);
                ps.setString(1, cla.getReferencia());
                ps.setString(2, cla.getNombre());
                ps.setFloat(3, cla.getPrecios());
                ps.setInt(4, cla.getCategoria());
                resultado = ps.executeUpdate() > 0;
                resultado2 = "Se agregó correctamente";
            }

            if (resultado){
                resultado2 += "Producto agregado correctamente:\n" +
                        "Referencia: " + cla.getReferencia() + "\n" +
                        "Nombre: " + cla.getNombre() + "\n" +
                        "Precio: " + cla.getPrecios() + "\n" +
                        "Categoría: " + cla.getCategoria();
            }
        }catch (SQLException e){
            resultado2= "error al insertar"+e;
        }
        return resultado2;
    }





    public clase_principal buscar_referencia(String ref){
        clase_principal clase=null;
        try{
            String sql="select * from productos where Referencia=?";
            ps=conect.prepareStatement(sql);
            ps.setString(1,ref);
            sr=ps.executeQuery();
            while (sr.next()){
                clase=new clase_principal(sr.getString(1),sr.getString(2),sr.getFloat(3),sr.getInt(4));
            }
        }catch (SQLException e){
            System.out.println("");
        }
        return clase;
    }



    public String esta(String ref) {
        String resultado="";
        String Resultado2="";
        clase_principal clase = null;
        try {
            String sql = "SELECT * FROM productos WHERE referencia=?";
            ps = conect.prepareStatement(sql);
            ps.setString(1, ref);
            sr = ps.executeQuery();

            while (sr.next()) {
                // Obtener los valores de acuerdo al esquema de la tabla
                int id = sr.getInt("id");
                String referencia = sr.getString("referencia");
                String nombre = sr.getString("nombre");
                float precios = sr.getFloat("precios");
                int categoria = sr.getInt("categoria");
                resultado+=referencia+"\n"+nombre+"\n"+precios+"\n"+categoria;
                Resultado2+=resultado;
            }
        } catch (SQLException e) {
            return "Error al buscar: " + e.getMessage();
        }
        if (resultado.isEmpty()){
            return "No se encontro la referencia";
        }
        else {
            return "Si está: " + Resultado2;
        }


    }



    public String obtenerTodosLosProductos() {
        String resultado = "";
        try {
            String sql = "SELECT * FROM productos";
            ps = conect.prepareStatement(sql);
            sr = ps.executeQuery();

            while (sr.next()) {

                int id = sr.getInt("id");
                String referencia = sr.getString("referencia");
                String nombre = sr.getString("nombre");
                float precios = sr.getFloat("precios");
                int categoria = sr.getInt("categoria");

                resultado += "ID: " + id + "\n" +
                        "Referencia: " + referencia + "\n" +
                        "Nombre: " + nombre + "\n" +
                        "Precios: " + precios + "\n" +
                        "Categoría: " + categoria + "\n\n";
            }

            if (resultado.isEmpty()) {
                return "No hay productos en la base de datos.";
            } else {
                return "Productos:\n" + resultado;
            }
        } catch (SQLException e) {
            return "Error al obtener productos: " + e.getMessage();
        }
    }


    public String Mayor_menor(){
        String resultado="";
        String sql = "SELECT * FROM productos WHERE precios>=? order by precios desc";
        try{
            ps = conect.prepareStatement(sql);
            ps.setFloat(1,1);
            sr = ps.executeQuery();

            while (sr.next()){
                resultado+="referencia" + sr.getString("referencia")+ "\n" +
                        "Nombre" + sr.getString("nombre") + "\n"+
                        "Precio" + sr.getFloat("precios") + "\n"+
                        "Categoria" + sr.getInt("categoria") + "\n"+ "\n\n";
            }
        }catch (SQLException e){
            resultado = "Error al obtener productos: " + e;
        }
        return resultado;
    }


    public String menor_mayor(){
        String resultado="";
        String sql = "SELECT * FROM productos WHERE precios>=? order by precios asc ";
        try{
            ps = conect.prepareStatement(sql);
            ps.setFloat(1,1);
            sr = ps.executeQuery();

            while (sr.next()){
                resultado+="referencia" + sr.getString("referencia")+ "\n" +
                        "Nombre" + sr.getString("nombre") + "\n"+
                        "Precio" + sr.getFloat("precios") + "\n"+
                        "Categoria" + sr.getInt("categoria") + "\n"+ "\n\n";
            }
        }catch (SQLException e){
            resultado = "Error al obtener productos: " + e;
        }
        return resultado;
    }



}
