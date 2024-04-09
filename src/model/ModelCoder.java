package model;

import database.CRUD;
import database.ConfigDB;
import entity.Coder;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ModelCoder implements CRUD {
    @Override
    public Object insert(Object obj) {
        Connection objconection = ConfigDB.openConnection();
        Coder coder = (Coder) obj;
        try {
            String sql = "INSERT INTO coder (nombre, apellidos, documento, clan, cohorte, cv,tecnologia) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement prepare = objconection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            prepare.setString(1, coder.getNombre());
            prepare.setString(2, coder.getApellidos());
            prepare.setString(3, coder.getDocumento());
            prepare.setString(4, coder.getClan());
            prepare.setInt(5, coder.getCohorte());
            prepare.setString(6, coder.getCv());
            prepare.setString(7, coder.getTecnologia_coder());
            prepare.execute();
            ResultSet resultado = prepare.getGeneratedKeys();
            while (resultado.next()) {
                coder.setId_coder(resultado.getInt(1));


            }
            JOptionPane.showMessageDialog(null, "creado correctamente");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage());
        }


        return coder;
    }

    @Override
    public boolean update(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Coder objcoder = (Coder) obj;
        boolean Isuptaded = false;
        try {
            String sql = "update coder set nombre=?,  apellidos=?,  documento=?, cohorte=?, cv=?, clan=? tecnologia=?where id_coder=?;";
            PreparedStatement objprepare = objConnection.prepareStatement(sql);
            objprepare.setString(1, objcoder.getNombre());
            objprepare.setString(2, objcoder.getApellidos());
            objprepare.setString(3, objcoder.getDocumento());
            objprepare.setInt(4, objcoder.getCohorte());
            objprepare.setString(5, objcoder.getCv());
            objprepare.setString(6, objcoder.getClan());
            objprepare.setString(7, objcoder.getTecnologia_coder());
            objprepare.setInt(8, objcoder.getId_coder());
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

    @Override
    public boolean delete(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Coder objCoder = (Coder) obj;
        try {
            String sql = "delete from coder where id_coder=?;";
            PreparedStatement objprepare = objConnection.prepareStatement(sql);
            objprepare.setInt(1, objCoder.getId_coder());
            ;
            int totalArrow = objprepare.executeUpdate();
            if (totalArrow > 0) {
                JOptionPane.showMessageDialog(null, "se ha eliminado correctamente el coder");
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
        List<Object> listCoder = new ArrayList<Object>();
        Connection objconection = ConfigDB.openConnection();
        try {
            String sql = "SELECT * FROM coder;";
            PreparedStatement objprepare = objconection.prepareStatement(sql);
            ResultSet objresult = objprepare.executeQuery();
            while (objresult.next()) {
                Coder objcoder = new Coder();
                objcoder.setId_coder(objresult.getInt(1));
                objcoder.setNombre(objresult.getString(2));
                objcoder.setApellidos(objresult.getString(3));
                objcoder.setDocumento(objresult.getString(4));
                objcoder.setCohorte(objresult.getInt(5));
                objcoder.setCv(objresult.getString(6));
                objcoder.setClan(objresult.getString(7));
                objcoder.setTecnologia_coder(objresult.getString(8));

                listCoder.add(objcoder);

            }


        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage());

        } finally {
            ConfigDB.closeConnection();
        }

        return listCoder;


    }

    public Coder findByid(int id) {
        Connection conn = ConfigDB.openConnection();
        Coder objcoder = null;
        try {
            String sql = "SELECT * FROM coder WHERE id_coder=?";
            PreparedStatement objprepare = conn.prepareStatement(sql);
            objprepare.setInt(1, id);
            ResultSet objresult = objprepare.executeQuery();
            while (objresult.next()) {
                objcoder = new Coder();
                objcoder.setId_coder(objresult.getInt(1));
                objcoder.setNombre(objresult.getString(2));
                objcoder.setApellidos(objresult.getString(3));
                objcoder.setDocumento(objresult.getString(4));
                objcoder.setCohorte(objresult.getInt(5));
                objcoder.setCv(objresult.getString(6));
                objcoder.setClan(objresult.getString(7));
                objcoder.setTecnologia_coder(objresult.getString(8));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());


        }

        return objcoder;
    }
    public List<Object> findx(String name, String desc) {

        Connection objConnection = ConfigDB.openConnection();
        List<Object> lista = new ArrayList<>();


        try {
            String sql = "select * from coder where ? like ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setString(1, "%" + name + "%");
            objPrepare.setString(2, "%" + desc + "%");
            ResultSet rs = objPrepare.executeQuery();
            while (rs.next()) {
                Coder coder = new Coder();
                coder.setId_coder(rs.getInt(1));
                coder.setNombre(rs.getString(2));
                coder.setApellidos(rs.getString(3));
                coder.setDocumento(rs.getString(4));
                coder.setCohorte(rs.getInt(5));
                coder.setCv(rs.getString(6));
                coder.setClan(rs.getString(7));
                coder.setTecnologia_coder(rs.getString(8));
                lista.add(coder);


            }
        } catch ( SQLException e) {

            JOptionPane.showMessageDialog(null, e.getMessage());

        }
        ConfigDB.closeConnection();
        return lista;
    }

    public boolean updatecv(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Coder objcoder = (Coder) obj;
        boolean Isuptaded = false;
        try {
            String sql = "update coder set cv=? where id_coder=?;";
            PreparedStatement objprepare = objConnection.prepareStatement(sql);
            objprepare.setString(1, objcoder.getCv());
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
