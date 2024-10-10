package controlador;

import modelo.clase_principal;
import modelo.model;
import vista.view;

public class controller {
    model modelo=new model();
    view view=new view();
    public void control(){
        boolean control=true;
        while (control){
            int opcion=view.menu();
            switch (opcion){
                case 1:
                    view.mensaje(modelo.agregar(new clase_principal(view.Referencia(), view.Nombre(), view.precio(), view.categoria())));
                    break;

                case 2:
                    view.mensaje(modelo.esta(view.Referencia()));
                    break;

                    case 3:
                        view.mensaje(modelo.obtenerTodosLosProductos());
                        break;

                        case 4:
                            view.mensaje(modelo.Mayor_menor());
                            break;
                            case 5:
                                view.mensaje(modelo.menor_mayor());
                                break;
                        case 6:
                            view.mensaje("Adios");
                            control=false;
                            break;


            }
        }
    }
}
