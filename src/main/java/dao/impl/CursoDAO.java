package dao.impl;

import dao.IBaseDAO;
import entities.Curso;
import utils.DBConnection;

import java.sql.*;
import java.util.*;

public class CursoDAO implements IBaseDAO<Curso> {

    @Override
    public void insertar(Curso c) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO curso(nombre, creditos) VALUES(?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, c.getNombre());
            stmt.setInt(2, c.getCreditos());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void actualizar(Curso c) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "UPDATE curso SET nombre=?, creditos=? WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, c.getNombre());
            stmt.setInt(2, c.getCreditos());
            stmt.setInt(3, c.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "DELETE FROM curso WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Curso obtenerPorId(int id) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM curso WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Curso(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getInt("creditos")
                );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Curso> obtenerTodos() {
        List<Curso> lista = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM curso";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                lista.add(new Curso(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getInt("creditos")
                ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }
}
