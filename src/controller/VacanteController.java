package controller;

import entity.Coder;
import model.ModelCoder;
import model.VacanteModel;
import entity.Vacante;
import entity.Empresa;

import javax.swing.*;

public class VacanteController {
    public static String getAllEmpresa() {
        VacanteModel model = new VacanteModel();
        String listaEmpresa = "Lista de empresas \n";

        for (Object iterador : model.findEmpresa()) {
            Empresa obj = (Empresa) iterador;
            listaEmpresa += obj.toString() + "\n";
        }
        return listaEmpresa;


    }

    public static void insert() {
        VacanteModel objmodel = new VacanteModel();
        String listaEmpresas = getAllEmpresa();
        int id = Integer.parseInt(JOptionPane.showInputDialog("ingrese el id de la empresa " + listaEmpresas));
        String titulo = JOptionPane.showInputDialog("Ingrese el titulo");
        String descripcion = JOptionPane.showInputDialog("Ingrese la descripcion");
        String duracion = JOptionPane.showInputDialog("Ingrese la duracion");
        String estado = "activo";
        String tecnologia = JOptionPane.showInputDialog("Ingrese la tecnologia");
        Vacante objvacante = new Vacante();
        objvacante.setId_empresa(id);
        objvacante.setTitulo(titulo);
        objvacante.setDescripcion(descripcion);
        objvacante.setDuracion(duracion);
        objvacante.setEstado(estado);
        objvacante.setTecnologia(tecnologia);
        objmodel.insert(objvacante);


    }

    public static void findAll() {
        VacanteModel model = new VacanteModel();
        String ListVaca = "Lista de Vacantes  \n";
        for (Object iterador : model.findAll()) {
            Vacante obj = (Vacante) iterador;
            ListVaca += obj.toString() + "\n";


        }
        JOptionPane.showMessageDialog(null, ListVaca);


    }

    public static String getAllstring() {
        VacanteModel model = new VacanteModel();
        String ListVaca = "Lista de Vacantes  \n";
        for (Object iterador : model.findAll()) {
            Vacante obj = (Vacante) iterador;
            ListVaca += obj.toString() + "\n";


        }

        return ListVaca;

    }

    public static void update() {
        VacanteModel vacante = new VacanteModel();
        String estado = "";
        String listEmpresas = getAllEmpresa();
        String listVacante = getAllstring();
        int id = Integer.parseInt(JOptionPane.showInputDialog(listVacante, "ingrese el id a modificar"));
        Vacante objvacante = vacante.findByid(id);
        if (objvacante == null) {
            JOptionPane.showMessageDialog(null, "no se encontro vacante con ese id");
        } else {
            int id_vacante = Integer.parseInt(JOptionPane.showInputDialog("ingrese el id de la empresa" + listEmpresas));
            String titulo = JOptionPane.showInputDialog("Ingrese el nuevo titulo", objvacante.getTitulo());
            String descripcion = JOptionPane.showInputDialog("Ingrese la nueva descripcion", objvacante.getDescripcion());
            String duracion = JOptionPane.showInputDialog("Ingrese la nueva duracion", objvacante.getDuracion());
            int confirm = 1;
            JOptionPane.showMessageDialog(null, "Esta vacante se encuentra en este estado" + objvacante.getEstado());
            confirm = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea Cambiar el estado de la vacante?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                if (objvacante.getEstado().equals("inactivo")) {
                    estado = "activo";


                } else {

                    estado = "inactivo";
                }
            }
            String tecnologia = JOptionPane.showInputDialog("Ingrese la nueva tecnologia ", objvacante.getTecnologia());
            objvacante.setId_empresa(id_vacante);
            objvacante.setTitulo(titulo);
            objvacante.setDescripcion(descripcion);
            objvacante.setDuracion(duracion);
            objvacante.setEstado(estado);
            objvacante.setTecnologia(tecnologia);
            vacante.update(objvacante);


        }


    }

    public static void delete() {
        VacanteModel vacante = new VacanteModel();
        String lista = getAllstring();
        int confirmar = 1;
        int id = Integer.parseInt(JOptionPane.showInputDialog(lista, "ingrese el id a eliminar"));
        Vacante objvacante = vacante.findByid(id);
        if (objvacante == null) {
            JOptionPane.showMessageDialog(null, "no se encontro vacante con ese id");
        } else {
            confirmar = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar esta vacante ?");
            if (confirmar == JOptionPane.YES_OPTION) {
                vacante.delete(objvacante);

            }

        }

    }

    public static void findx() {
        VacanteModel model = new VacanteModel();
        String name = JOptionPane.showInputDialog(null, "ingrese buscar por (titulo) o (tecnologia)");
        String lista = "lista de Vacantes filtrados por" + name;
        if (name.equals("titulo")) {
            String titulo = JOptionPane.showInputDialog("Ingrese el titulo de la vacante a filtrar");
            if (model.findx(name,titulo).isEmpty()) {
                JOptionPane.showMessageDialog(null, "No hay ninguna vacante con ese nombre");


            } else {
                for (Object iterador : model.findx(name, titulo)) {
                    Vacante obj = (Vacante) iterador;
                    lista += obj.toString() + "\n";

                }
                JOptionPane.showMessageDialog(null, lista);

            }

        } else if (name.equals("tecnologia")) {
            String tecnologia = JOptionPane.showInputDialog(null, "Ingrese el nombre de la tecnologia a buscar");
            if (model.findx(name, tecnologia).isEmpty()) {
                JOptionPane.showMessageDialog(null, "No hay ninguna vacante con ese tecnologia");
            } else {
                for (Object iterador : model.findx(name, tecnologia)) {
                    Vacante obj = (Vacante) iterador;
                    lista += obj.toString() + "\n";

                }
                JOptionPane.showMessageDialog(null, lista);
            }

        }


    }
    public static String findstado(){
       VacanteModel model = new VacanteModel();
       String lista ="Vacantes activas \n";
       for (Object iterador : model.findx("estado","activo")) {
           Vacante obj= (Vacante) iterador;
           lista += obj.toString() + "\n";


       }
        return lista;


    }

}







