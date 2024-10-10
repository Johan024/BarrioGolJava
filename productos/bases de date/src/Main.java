import modelo.clase_principal;
import modelo.conexion;
import modelo.model;
import vista.view;

public class Main {
    public static void main(String[] args) {
//        conexion conect=new conexion();
//        conect.conecta();
//        model model=new model();
//        if (model.agregar(new clase_principal("1","SEBAS",100,2)));
//        if (model.buscar_referencia("1")==null){
//            System.out.println("producto no encontrado");
//        }
//        else {
//
//            System.out.println(model.buscar_referencia("1").toString() +"\nse encontro correctamente");
//        }
        view vista= new view();
        vista.conectar();
    }
}