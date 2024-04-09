package model;

import database.CRUD;
import database.ConfigDB;
import entity.Coder;
import entity.Contratacion;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.RelacionContratacion;

public class ContratacionModel implements CRUD {
    @Override
    public Object insert(Object obj) {
        Connection conn = ConfigDB.openConnection();
        Contratacion contratacion = (Contratacion) obj;
        try {
            String sql = "INSERT INTO contratacion(id_vacante,id_coder,estado,salario) VALUES(?,?,?,?);";
            PreparedStatement prepare = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            prepare.setInt(1, contratacion.getId_vacante());
            prepare.setInt(2, contratacion.getId_coder());
            prepare.setString(3, contratacion.getEstado());
            prepare.setDouble(4, contratacion.getSalario());
            prepare.execute();
            ResultSet resultado = prepare.getGeneratedKeys();
            while (resultado.next()) {
                contratacion.setId_contratacion(resultado.getInt(1));

            }
            JOptionPane.showMessageDialog(null, "contratacion creada correctamente");


        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage());
        }


        return contratacion;
    }

    @Override
    public boolean update(Object obj) {
        return false;
    }

    @Override
    public boolean delete(Object obj) {





        return false;
    }

    @Override
    public List<Object> findAll() {
        Connection conn = ConfigDB.openConnection();
        List<Object> listContratacion = new ArrayList<Object>();
        try {
            String sql = "select * from contratacion";
            PreparedStatement prepare = conn.prepareStatement(sql);
            ResultSet resultado = prepare.executeQuery();
            while (resultado.next()) {
                Contratacion contratacion = new Contratacion();
                contratacion.setId_contratacion(resultado.getInt(1));
                contratacion.setId_vacante(resultado.getInt(2));
                contratacion.setId_coder(resultado.getInt(3));
                contratacion.setFecha_aplicacion(resultado.getString(4));
                contratacion.setEstado(resultado.getString(5));
                contratacion.setSalario(resultado.getDouble(6));
                listContratacion.add(contratacion);

            }


        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage());
        }


        return listContratacion;
    }

    public List<Object> find() {
        Connection conn = ConfigDB.openConnection();
        List<Object> listContratacion = new ArrayList<Object>();
        try {
            String sql = """
                    Select DISTINCT
                    coder.nombre,
                    coder.apellidos,
                    coder.documento,
                    coder.tecnologia,
                    contratacion.salario,
                    vacante.titulo,
                    vacante.descripcion,
                    empresa.nombre,
                    empresa.ubicacion
                    from contratacion
                    inner join coder on
                    contratacion.id_coder=coder.id_coder
                    inner join vacante on
                    vacante.id_vacante = contratacion.id_vacante
                    inner join empresa on
                    empresa.id_empresa = vacante.id_empresa;
                                    
                    """;
            PreparedStatement prepare = conn.prepareStatement(sql);
            ResultSet resultado = prepare.executeQuery();
            while (resultado.next()) {
                RelacionContratacion objrelacion = new RelacionContratacion();
                objrelacion.setId_contratacion(resultado.getInt("id_contratacion"));
                objrelacion.setNombre(resultado.getString("nombre"));
                objrelacion.setApellidos(resultado.getString("apellidos"));

                objrelacion.setSalario(resultado.getDouble("salario"));
                objrelacion.setTitulo(resultado.getString("titulo"));
                objrelacion.setDescripcion(resultado.getString("descripcion"));
                objrelacion.setNombre_empresa(resultado.getString("nombre_empresa"));
                objrelacion.setUbicacion(resultado.getString("ubicacion"));
                listContratacion.add(objrelacion);

            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ConfigDB.closeConnection();
        }


        return listContratacion;

    }
}
