package controller;

import model.ModelCoder;
import entity.Coder;

import javax.swing.*;

public class CoderController {
    public static void insert() {
        ModelCoder coderModel = new ModelCoder();
        String nombre = JOptionPane.showInputDialog("Ingrese nombre");
        String apellidos = JOptionPane.showInputDialog("Ingrese apellidos");
        String documento = JOptionPane.showInputDialog("Ingrese documento");
        String clan = JOptionPane.showInputDialog("Ingrese clan");
        int cohorte = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cohorte"));
        String cv = JOptionPane.showInputDialog("Ingrese cv");
        String tecnologia = JOptionPane.showInputDialog("Ingrese tecnologia");
        Coder coder = new Coder();
        coder.setNombre(nombre);
        coder.setApellidos(apellidos);
        coder.setDocumento(documento);
        coder.setClan(clan);
        coder.setCohorte(cohorte);
        coder.setCv(cv);
        coder.setTecnologia_coder(tecnologia);
        coderModel.insert(coder);
        JOptionPane.showMessageDialog(null, coder.toString());


    }

    public static void findAll() {
        ModelCoder coder = new ModelCoder();
        String ListCoder = "Lista de coders  \n";
        for (Object iterador : coder.findAll()) {
            Coder obj = (Coder) iterador;
            ListCoder += obj.toString() + "\n";


        }
        JOptionPane.showMessageDialog(null, ListCoder);


    }

    public static String getAllString() {
        ModelCoder coderModel = new ModelCoder();
        String ListCoder = "lista de Coders \n";
        for (Object iterador : coderModel.findAll()) {
            Coder obj = (Coder) iterador;
            ListCoder += obj.toString() + "\n";


        }
        return ListCoder;
    }

    public static void update() {
        ModelCoder coder = new ModelCoder();
        String listcoder = getAllString();
        int id = Integer.parseInt(JOptionPane.showInputDialog(listcoder, "ingrese el id a modificar"));
        Coder objcoder = coder.findByid(id);
        if (objcoder == null) {
            JOptionPane.showMessageDialog(null, "no se encontro coder con ese id");

        } else {
            String nombre = JOptionPane.showInputDialog("ingrese el nuevo nombrel del coder", objcoder.getNombre());
            String apellidos = JOptionPane.showInputDialog("ingrese el nuevo apellidos del coder", objcoder.getApellidos());
            String documento = JOptionPane.showInputDialog("ingrese el nuevo documento del coder", objcoder.getDocumento());
            String clan = JOptionPane.showInputDialog("ingrese el nuevo clan del coder", objcoder.getClan());
            String tecnologia = JOptionPane.showInputDialog("ingrese la nueva tecnologia del coder",objcoder.getTecnologia_coder());
            int cohorte = Integer.parseInt(JOptionPane.showInputDialog("ingrese el nuevo cohorte del coder", objcoder.getCohorte()));
            String cv = JOptionPane.showInputDialog("ingrese el nuevo cv del coder", objcoder.getCv());
            objcoder.setNombre(nombre);
            objcoder.setApellidos(apellidos);
            objcoder.setDocumento(documento);
            objcoder.setClan(clan);
            objcoder.setCohorte(cohorte);
            objcoder.setCv(cv);
            objcoder.setTecnologia_coder(tecnologia);
            coder.update(objcoder);
        }


    }

    public static void delete() {
        ModelCoder coder = new ModelCoder();
        String listcoder = getAllString();
        int id = Integer.parseInt(JOptionPane.showInputDialog(listcoder, "ingrese el id a eliminar"));
        Coder objcoder = coder.findByid(id);
        int confirm = 1;
        if (objcoder == null) {
            JOptionPane.showMessageDialog(null, "no se encontro coder con ese id");
        } else {
            confirm = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea eliminar el coder?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                coder.delete(objcoder);

            }
        }

    }

    public static void findx() {
        ModelCoder coder = new ModelCoder();


        String name = JOptionPane.showInputDialog(null, "ingrese buscar por clan o cohorte ");
        String listcoder = "lista de coders filtrada";
        if (name.equals("clan")) {
            String clan = JOptionPane.showInputDialog(null, "ingrese nombre del clan");
            if (coder.findx(name, clan).isEmpty()) {
                JOptionPane.showMessageDialog(null, "no se encontro coder con ese clan");

            } else {

                for (Object iterador : coder.findx(name, clan)) {
                    Coder obj = (Coder) iterador;
                    listcoder += obj.toString() + "\n";
                }
            }
            JOptionPane.showMessageDialog(null, listcoder);
        } else if (name.equals("cohorte")) {
            String cohorte = JOptionPane.showInputDialog(null, "ingrese el numero del cohorte");
            if (coder.findx(name, cohorte).isEmpty()) {

                JOptionPane.showMessageDialog(null, "no se encontro coder con ese numero de cohorte");
            } else {
                for (Object iterador : coder.findx(name, cohorte)) {
                    Coder obj = (Coder) iterador;
                    listcoder += obj.toString() + "\n";

                }

            }

            JOptionPane.showMessageDialog(null, listcoder);
        }


    }
public static void udpatecv(){
        ModelCoder coder = new ModelCoder();
        String listcoder = getAllString();
        int id = Integer.parseInt(JOptionPane.showInputDialog(listcoder, "ingrese el id del cv a modificar"));
        Coder coderobj= coder.findByid(id);
        if(coderobj==null){
            JOptionPane.showMessageDialog(null, "no se encontro coder con ese id");

        }else{
            String cv = JOptionPane.showInputDialog("ingrese la nueva hoja de vida",coderobj.getCv());
            coderobj.setCv(cv);
            coder.updatecv(coderobj);


        }




}

}
