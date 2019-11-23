  package lembretehibernate.infra;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import lembretehibernate.modelo.Lembrete;

/**
 *
 * @author mello
 */
public class LembreteDAO implements ILembreteDAO {

    private ConnectionFactory cf = new ConnectionFactory();

    @Override
    public void salvar(Lembrete lembrete) {
        String sql = "INSERT INTO lembrete (titulo, descricao) VALUES (?, ?);";

        try (Connection conn = cf.getConnection();
                PreparedStatement stam = conn.prepareStatement(sql)) {

            stam.setString(1, lembrete.getTitulo());
            stam.setString(2, lembrete.getDescricao());
            stam.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void alterar(Lembrete l) {
        String sql = "UPDATE lembrete SET titulo = ?, descricao = ? WHERE id = ?;";

        try (Connection con = cf.getConnection();
                PreparedStatement stam = con.prepareStatement(sql)) {

            stam.setString(1, l.getTitulo());
            stam.setString(2, l.getDescricao());
            stam.setInt(3, (int) l.getId());

            stam.executeUpdate();
            stam.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void excluir(Lembrete l) {
        String sql = "DELETE FROM lembrete WHERE id = ?;";
        try (Connection con = cf.getConnection();
                PreparedStatement stam = con.prepareStatement(sql)) {

            stam.setInt(1, (int) l.getId());
            stam.executeUpdate();
            stam.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Lembrete> recuperarTodos() {
        List lembretes = new ArrayList();
        String sql = "SELECT * FROM lembrete;";
        try (Connection conn = cf.getConnection();
                PreparedStatement stam = conn.prepareStatement(sql)) {

            ResultSet rs = stam.executeQuery();
            while (rs.next()) {
                Lembrete c = new Lembrete();
                c.setId(rs.getInt("id"));
                c.setTitulo(rs.getString("titulo"));
                c.setDescricao(rs.getString("descricao"));
                lembretes.add(c);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lembretes;
    }

    @Override
    public Lembrete recuperaByID(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Lembrete> recuperaByTitulo(String Titulo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
