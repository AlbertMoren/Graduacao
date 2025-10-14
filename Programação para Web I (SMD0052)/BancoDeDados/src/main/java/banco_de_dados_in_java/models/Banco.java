package banco_de_dados_in_java.models;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Banco {
    
    public List<Categoria> obterTodos() throws SQLException{
        List<Categoria> resultado = new ArrayList<>();
        try {
            
            Class.forName("org.postgresql.Driver");
            String postgresSQLURL ="jdbc:postgresql://localhost:5432/meubanco?encoding=UTF8";
            String user = "postgres";
            String senha = "maniaxxi";
            Connection con = DriverManager.getConnection(postgresSQLURL,user,senha);
            Statement stmt = con.createStatement();
            String querySQL = "SELECT * FROM categorias";
            ResultSet resultSet = stmt.executeQuery(querySQL);
            
            while (resultSet.next()) {
                Categoria categoria = new Categoria();
                categoria.setId(resultSet.getInt("id"));
                categoria.setnome(resultSet.getString("nome"));
                resultado.add(categoria);
            }
            
            resultSet.close();
            stmt.close();   
            con.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Erro ao carregar Driver");
        }
        return resultado;
    }
            

}
