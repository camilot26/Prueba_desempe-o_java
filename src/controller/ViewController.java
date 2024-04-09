package controller;
import controller.CoderController;
import entity.Coder;
import controller.VacanteController;
import javax.swing.*;

public class ViewController {

    public static void create(){


        String opcion=JOptionPane.showInputDialog("""
                    --Bienvenido a Create--
                    1.Gestionar Coders
                    2.Gestionar Vacante
                    3.Gestionar Contratacion
                     
                    """);

        switch(opcion){

            case "1":
                CoderController.insert();
                break;
            case "2":
                VacanteController.insert();
                break;
            case "3":
                ContratacionController.insert();
                break;


        }








    }
    public static void findAll(){

        String opcion= JOptionPane.showInputDialog("""
                  --Bienvenido a Create--
                    1.Gestionar Coders
                    2.Gestionar Vacante
                    3.Gestionar Contratacion
                """);
        switch(opcion){
            case "1":
                String opcion1=JOptionPane.showInputDialog("""
                    1.Mostrar todo los coders
                    2.Buscar por opciones
                    
                    """);
                switch(opcion1){
                    case "1":
                        CoderController.findAll();
                        break;
                    case "2":
                        CoderController.findx();
                        break;
                }
                break;
            case "2":
                String opcion2=JOptionPane.showInputDialog("""
                    1.Mostrar todas las vacantes
                    2.Buscar por opciones
                    
                    """);
                switch(opcion2){
                    case "1":
                        VacanteController.findAll();
                        break;
                    case "2":
                        VacanteController.findx();
                        break;
                }
                break;
        }
    }
    public static void update(){
        String opcion=JOptionPane.showInputDialog("""
                --Bienvenido a Update--
                1.Gestionar Coders
                2.Gestionar Vacante
                3.Gestionar Contratacion
                               ;
                """);
        switch(opcion){
            case "1":
                String opcion4=JOptionPane.showInputDialog("""
                        1.Update toda la informacion
                        2.Update solo la informacion de cv
                        """);
                switch(opcion4){
                    case "1":
                        CoderController.update();
                        break;
                    case "2":

                        CoderController.udpatecv();
                        break;
                }

                break;
            case "2":
                VacanteController.update();
                break;
            case "3":
                break;

        }
    }
    public static void delete(){
        String opcion3=JOptionPane.showInputDialog("""
                --Bienvenido a Delete--
                 1.Gestionar Coders
                 2.Gestionar Vacante
                 3.Gestionar Contratacion
                                );
                """);
        switch (opcion3){
            case "1":
                CoderController.delete();
                break;
            case "2":
                VacanteController.delete();
                break;
            case "3":
                break;

        }
    }



}


