package dao.impl;

import dao.IBaseDAO;
import entities.Estudiante;
import utils.DBConnection;

import java.sql.*;
import java.util.*;

public class EstudianteDAO implements IBaseDAO<Estudiante> {
    @Override
    public void insertar(Estudiante e) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO estudiante(nombre, correo) VALUES(?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, e.getNombre());
            stmt.setString(2, e.getCorreo());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void actualizar(Estudiante e) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "UPDATE estudiante SET nombre=?, correo=? WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, e.getNombre());
            stmt.setString(2, e.getCorreo());
            stmt.setInt(3, e.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "DELETE FROM estudiante WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Estudiante obtenerPorId(int id) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM estudiante WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Estudiante(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("correo")
                );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Estudiante> obtenerTodos() {
        List<Estudiante> lista = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM estudiante";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                lista.add(new Estudiante(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("correo")
                ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }
}
