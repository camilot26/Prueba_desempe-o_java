package controller;

import entity.Coder;
import entity.RelacionContratacion;
import entity.Vacante;
import model.ContratacionModel;
import controller.VacanteController;
import model.VacanteModel;
import model.ModelCoder;
import entity.Contratacion;

import javax.swing.*;

public class ContratacionController {
    public static void insert() {
        ContratacionModel model = new ContratacionModel();
        VacanteModel vacante = new VacanteModel();
        ModelCoder modelCoder = new ModelCoder();
        String lista = VacanteController.findstado();
        String ListaCoder=CoderController.getAllString();
        int id_coder=Integer.parseInt(JOptionPane.showInputDialog("ingrese el id del coder a validar"+ListaCoder));
        int id_vacante = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id de la vacante" + lista));
        Coder coder=modelCoder.findByid(id_coder);
        Vacante vacante1=vacante.findByid(id_vacante);
        if(!vacante1.getTecnologia().equals(coder.getTecnologia_coder())){
            JOptionPane.showMessageDialog(null,"LO SENTIMOS EL CODER NO CUMPLE CON LOS REQUISITOS DE TECNOLOGIA");



        }else {
            String estado1="inactivo";
            Contratacion contratacion = new Contratacion();
            String estado="activo";
            double salario= Double.parseDouble(JOptionPane.showInputDialog("ingrese el salario"));
            contratacion.setId_coder(id_coder);
            contratacion.setId_vacante(id_vacante);
            contratacion.setEstado(estado);
            contratacion.setSalario(salario);
            model.insert(contratacion);
            vacante1.setEstado(estado1);
            vacante.cambioEstado(vacante1);

            String Resultado = find();
            JOptionPane.showMessageDialog(null, Resultado);
        }



    }
    public static void findAll() {
        ContratacionModel contratacion = new ContratacionModel();
        String ListContratacion = "Lista de contrataciones  \n";
        for (Object iterador : contratacion.findAll()) {
            Contratacion obj = (Contratacion) iterador;
            ListContratacion += obj.toString() + "\n";


        }
        JOptionPane.showMessageDialog(null, ListContratacion);


    }
    public static String find(){
        ContratacionModel contratacion = new ContratacionModel();
        String listaContratacion = "lista de contrataciones \n";
        for(Object iterador:contratacion.find()){
            RelacionContratacion obj = (RelacionContratacion) iterador;
            listaContratacion += obj.toString() + "\n";


        }

        return listaContratacion;

    }


}
