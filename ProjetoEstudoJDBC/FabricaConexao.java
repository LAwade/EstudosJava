package estudojava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {

    private static final String driver = "org.postgresql.Driver";
    private static final String url = "jdbc:postgresql://IP:5432/DATABASE";
    private static final String usuarioBD = "postgres";
    private static final String senha = "SENHA DB";

    public static Connection conectBD() {
        Connection conexao = null;
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url,usuarioBD,senha);
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver não foi encontrado: "+ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Banco de dados não foi conectado: "+ex.getMessage());
        }
                
        return conexao;
    }
}
