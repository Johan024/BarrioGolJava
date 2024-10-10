package vista;

import controlador.controller;

import javax.swing.*;

public class view {
    public int menu(){
        int opcion=0;
        while (opcion<1|| opcion>6){
            try {
                String men="--menu--\n1.agregar\n2.buscar\n3.Ver Lista\n4.Ver De mayor a menor\n5.Ver de menor a mayor\n6.Salir";
                opcion=Integer.parseInt(JOptionPane.showInputDialog(men));
            }
            catch (java.util.InputMismatchException e){
                JOptionPane.showMessageDialog(null,"numero invalido");
            }
        }
        return opcion;
    }
    public String Referencia(){
        String referencia=JOptionPane.showInputDialog("ingrese Referencia:");
        return referencia;
    }
    public String Nombre(){
        String Nombre=JOptionPane.showInputDialog("ingrese Nombre:");
        return Nombre;
    }
    public float precio(){
        float precio=Float.parseFloat(JOptionPane.showInputDialog(null,"ingrese precio: "));
        return precio;
    }
    public int categoria(){
        int precio=Integer.parseInt(JOptionPane.showInputDialog(null,"ingrese categoria: "));
        return precio;
    }
    public String mensaje(String mensaje){
        JOptionPane.showMessageDialog(null,mensaje);
        return mensaje;
    }
    public  void conectar(){
        controller contr= new controller();
        contr.control();
    }





}
