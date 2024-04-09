package model;

import database.CRUD;
import database.ConfigDB;
import entity.Coder;
import entity.Empresa;
import entity.Vacante;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VacanteModel implements CRUD {


    @Override
    public Object insert(Object obj) {
        Connection connection = ConfigDB.openConnection();
        Vacante vacante = (Vacante) obj;
        try {
            String sql = "INSERT INTO vacante (id_empresa, titulo, descripcion, duracion, estado, tecnologia) VALUES (?,?,?,?,?,?)";
            PreparedStatement prepare = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            prepare.setInt(1, vacante.getId_empresa());
            prepare.setString(2, vacante.getTitulo());
            prepare.setString(3, vacante.getDescripcion());
            prepare.setString(4, vacante.getDuracion());
            prepare.setString(5, vacante.getEstado());
            prepare.setString(6, vacante.getTecnologia());
            prepare.execute();
            ResultSet rs = prepare.getGeneratedKeys();
            while (rs.next()) {
                vacante.setId_vacante(rs.getInt(1));
            }


        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {

            ConfigDB.closeConnection();
        }


        return vacante;
    }

    @Override
    public boolean update(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Vacante vacante = (Vacante) obj;
        boolean updated = false;
        try {
            String sql = "update vacante set id_empresa=?, titulo=?,  descripcion=?, duracion=?, estado=? where id_vacante=?;";
            PreparedStatement objprepare = objConnection.prepareStatement(sql);
            objprepare.setInt(1, vacante.getId_empresa());
            objprepare.setString(2, vacante.getTitulo());
            objprepare.setString(3, vacante.getDescripcion());
            objprepare.setString(4, vacante.getDuracion());
            objprepare.setString(5, vacante.getEstado());
            objprepare.setInt(6, vacante.getId_vacante());
            int arrow = objprepare.executeUpdate();
            if (arrow > 0) {
                JOptionPane.showMessageDialog(null, "actualizado correctamente");
                updated = true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        } finally {
            ConfigDB.closeConnection();
        }


        return updated;
    }

    @Override
    public boolean delete(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Vacante objVacante = (Vacante) obj;
        try {
            String sql = "delete from vacante where id_vacante=?;";
            PreparedStatement objprepare = objConnection.prepareStatement(sql);
            objprepare.setInt(1, objVacante.getId_vacante());
            int totalArrow = objprepare.executeUpdate();
            if (totalArrow > 0) {
                JOptionPane.showMessageDialog(null, "eliminado correctamente");
                return true;
            }


        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage());

        } finally {
            ConfigDB.closeConnection();
        }


        return false;
    }

    @Override
    public List<Object> findAll() {
        Connection objconection = ConfigDB.openConnection();
        List<Object> listVacante = new ArrayList<Object>();
        try {
            String sql = "select * from vacante";
            PreparedStatement objprepare = objconection.prepareStatement(sql);
            ResultSet objresult = objprepare.executeQuery();
            while (objresult.next()) {
                Vacante objvacante = new Vacante();
                objvacante.setId_vacante(objresult.getInt(1));
                objvacante.setId_empresa(objresult.getInt(2));
                objvacante.setTitulo(objresult.getString(3));
                objvacante.setDescripcion(objresult.getString(4));
                objvacante.setDuracion(objresult.getString(5));
                objvacante.setEstado(objresult.getString(6));
                objvacante.setTecnologia(objresult.getString(7));
                listVacante.add(objvacante);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }


        return listVacante;
    }

    public Vacante findByid(int id) {
        Connection conn = ConfigDB.openConnection();
        Vacante objvacante = null;
        try {
            String sql = "SELECT * FROM vacante WHERE id_vacante=?";
            PreparedStatement objprepare = conn.prepareStatement(sql);
            objprepare.setInt(1, id);
            ResultSet objresult = objprepare.executeQuery();
            while (objresult.next()) {
                objvacante = new Vacante();
                objvacante.setId_vacante(objresult.getInt(1));
                objvacante.setId_empresa(objresult.getInt(2));
                objvacante.setTitulo(objresult.getString(3));
                objvacante.setDescripcion(objresult.getString(4));
                objvacante.setDuracion(objresult.getString(5));
                objvacante.setEstado(objresult.getString(6));
                objvacante.setTecnologia(objresult.getString(7));


            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            List<Object> listCoder = new ArrayList<Object>();

        }

        return objvacante;
    }

    public List<Object> findEmpresa() {

        List<Object> listEmpresa = new ArrayList<Object>();
        Connection objconection = ConfigDB.openConnection();
        try {
            String sql = "SELECT * FROM empresa;";
            PreparedStatement objprepare = objconection.prepareStatement(sql);
            ResultSet objresult = objprepare.executeQuery();
            while (objresult.next()) {
                Empresa obj = new Empresa();
                obj.setId_empresa(objresult.getInt(1));
                obj.setNombre(objresult.getString(2));
                obj.setSector(objresult.getString(3));
                obj.setUbicacion(objresult.getString(4));
                obj.setContacto(objresult.getString(5));
                listEmpresa.add(obj);
            }


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());


        } finally {
            ConfigDB.closeConnection();
        }


        return listEmpresa;
    }

    public List<Object> findx(String name, String desc) {

        Connection objConnection = ConfigDB.openConnection();
        List<Object> lista = new ArrayList<>();


        try {
            String sql = "";
            if (name.equals("titulo")) {
                sql = "select * from vacante where titulo like ?;";

            } else if (name.equals("tecnologia")) {
                sql = "select * from vacante where tecnologia like ?;";

            } else if (name.equals("estado")) {
                sql = "select * from vacante where estado like ?;";
            }
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setString(1, "%" + desc + "%");
            ResultSet rs = objPrepare.executeQuery();
            while (rs.next()) {
                Vacante vacante = new Vacante();
                vacante.setId_vacante(rs.getInt(1));
                vacante.setId_empresa(rs.getInt(2));
                vacante.setTitulo(rs.getString(3));
                vacante.setDescripcion(rs.getString(4));
                vacante.setDuracion(rs.getString(5));
                vacante.setEstado(rs.getString(6));
                vacante.setTecnologia(rs.getString(7));
                lista.add(vacante);

            }
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e.getMessage());

        }
        ConfigDB.closeConnection();
        return lista;
    }
    public boolean cambioEstado(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Vacante objcoder = (Vacante) obj;
        boolean Isuptaded = false;
        try {
            String sql = "update vacante set estado=? where id_vacante=?;";
            PreparedStatement objprepare = objConnection.prepareStatement(sql);
            objprepare.setString(1, objcoder.getEstado());
            int arrow = objprepare.executeUpdate();
            if (arrow > 0) {
                JOptionPane.showMessageDialog(null, "actualizado correctamente");
                Isuptaded = true;

            }


        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ConfigDB.closeConnection();
        }
        return Isuptaded;
    }

}
