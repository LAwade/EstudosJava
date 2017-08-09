package estudojava;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DAO {

    Connection conexao = FabricaConexao.conectBD();
    PreparedStatement comando = null;

    public void buscarNome(String nome) {
        Connection conexao = FabricaConexao.conectBD();
        PreparedStatement comando = null;
        try {
            comando = conexao.prepareStatement("SELECT * FROM usuario WHERE nome LIKE '" + nome + "%'");
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                System.out.println("Nome: " + resultado.getString("nome"));
                System.out.println("Apelido: " + resultado.getString("apelido"));
                System.out.println("E-mail: " + resultado.getString("email"));
                System.out.println("Login: " + resultado.getString("login"));
                System.out.println("Senha: " + resultado.getString("senha"));
                System.out.println("-----------------------------------");
            }
            resultado.close();
            comando.close();
            conexao.close();
        } catch (SQLException ex) {
            System.out.println("Erro na conexão com Banco de Dados!");
        }
    }

    public void buscarApelido(String apelido) {
        try {
            comando = conexao.prepareStatement("SELECT * FROM usuario WHERE nome LIKE '" + apelido + "%'");
            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {
                System.out.println("Nome: " + resultado.getString("nome"));
                System.out.println("Apelido: " + resultado.getString("apelido"));
                System.out.println("E-mail: " + resultado.getString("email"));
                System.out.println("Login: " + resultado.getString("login"));
                System.out.println("Senha: " + resultado.getString("senha"));
                System.out.println("-----------------------------------");
            }
            resultado.close();
            comando.close();
            conexao.close();
        } catch (SQLException ex) {
            System.out.println("Erro na conexão com Banco de Dados!");
        }
    }

    public void alterarApelido(String apelido) {
        try {
            String codigo = JOptionPane.showInputDialog(null, "", "Código", 1);
            comando = conexao.prepareStatement("UPDATE usuario SET apelido = '" + apelido + "' WHERE codigo = " + codigo + "");
            ResultSet resultado = comando.executeQuery();
            System.out.println("Apelido alterado com sucesso!");
            resultado.close();
            comando.close();
            conexao.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
