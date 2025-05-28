package dao.impl;

import dao.IBaseDAO;
import entities.Matricula;
import utils.DBConnection;

import java.sql.*;
import java.util.*;

public class MatriculaDAO implements IBaseDAO<Matricula> {

    @Override
    public void insertar(Matricula m) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO matricula(id_estudiante, id_curso) VALUES(?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, m.getIdEstudiante());
            stmt.setInt(2, m.getIdCurso());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void actualizar(Matricula m) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "UPDATE matricula SET id_estudiante=?, id_curso=? WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, m.getIdEstudiante());
            stmt.setInt(2, m.getIdCurso());
            stmt.setInt(3, m.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "DELETE FROM matricula WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Matricula obtenerPorId(int id) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM matricula WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Matricula(
                    rs.getInt("id"),
                    rs.getInt("id_estudiante"),
                    rs.getInt("id_curso")
                );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Matricula> obtenerTodos() {
        List<Matricula> lista = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM matricula";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                lista.add(new Matricula(
                    rs.getInt("id"),
                    rs.getInt("id_estudiante"),
                    rs.getInt("id_curso")
                ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }
}
