package banco_de_dados_in_java.models;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static banco_de_dados_in_java.config.config.*;

/**
 * @author Albert Moren Paulino
 * 
 * Classe que implementa o padrão DAO para a entidade categoria
 */
public class CategoriaDAO {

    /**
     * Método utilizado para obter todas as categorias existentes
     * @return
     * @throws SQLException
     */
    public List<Categoria> obterTodos() throws SQLException{//equivalente ao get
        List<Categoria> resultado = new ArrayList<>();

        try {
            Class.forName(BD_DRIVER);
        }catch(ClassNotFoundException e){
            System.out.println("Erro ao carregar o drive");
            return resultado;
        } 
        String querySQL = "SELECT * FROM categorias";
        
        try (Connection con = DriverManager.getConnection(BD_URL,BD_USUARIO,BD_SENHA);
            Statement stmt = con.createStatement();
            ResultSet resultSet = stmt.executeQuery(querySQL)) {
            
                while (resultSet.next()) {
                Categoria categoria = new Categoria();
                categoria.setId(resultSet.getInt("id"));
                categoria.setnome(resultSet.getString("nome"));
                resultado.add(categoria);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao acessar o banco de dados: " + ex.getMessage());
            ex.printStackTrace();
        }
            
        return resultado;
    }
    
    /**
     * Função para restorna uma categoria especifica pelo ID
     * @param id
     * @return
     */
    public Categoria obter(int id){
        Categoria categoria = null;
        try {
            Class.forName(BD_DRIVER);
        }catch(ClassNotFoundException e){
            System.out.println("Erro ao carregar o drive");
            return categoria;
        } 
        String querySQL = "SELECT C.id,C.nome FROM categorias C WHERE C.id=?";

        try (Connection con = DriverManager.getConnection(BD_URL,BD_USUARIO,BD_SENHA);
            PreparedStatement pstmt = con.prepareStatement(querySQL);) {

            pstmt.setInt(1, id);
            
            try(ResultSet resultSet = pstmt.executeQuery()){
                if (resultSet.next()) {
                    categoria = new Categoria();
                    categoria.setId(resultSet.getInt("id"));
                    categoria.setnome(resultSet.getString("nome"));
                    return categoria;
                }
            }
        }catch ( SQLException ex) {
            return null;
        }
        return null;
    }

    /**
     * Inserir uma nova categoria
     * @param nome
     * @return
     */
    public boolean inserir(String nome){
        boolean sucesso = false;

        try {
            Class.forName(BD_DRIVER);
        }catch(ClassNotFoundException e){
            System.out.println("Erro ao carregar o drive");
            return sucesso;
        } 

        String querySQL = "INSERT INTO categorias  (nome) VALUES (?)";

        try (Connection con = DriverManager.getConnection(BD_URL,BD_USUARIO,BD_SENHA);
            PreparedStatement pstmt = con.prepareStatement(querySQL);) {
            pstmt.setString(1, nome);
            sucesso = (pstmt.executeUpdate() == 1);
        } catch (SQLException ex) {
            System.out.println("deu exception");
            return false;
        }
        return sucesso;
    }

    /**
     * Atualizar o nome de uma categoria já existente pelo ID
     * @param nome
     * @param id
     * @return
     */
    public boolean atualizar(String nome, int id){
        Boolean sucesso = false;
        try {
            Class.forName(BD_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("Erro ao carregar o drive");
            return sucesso;
        }

        String querySQL = "UPDATE categorias SET nome = ? WHERE id = ?";

        try (Connection con = DriverManager.getConnection(BD_URL,BD_USUARIO,BD_SENHA);
            PreparedStatement pstmt = con.prepareStatement(querySQL);) {

            pstmt.setString(1, nome);
            pstmt.setInt(2, id);

            sucesso = (pstmt.executeUpdate() == 1);

            
        } catch (SQLException ex) {
            System.out.println("deu exception");
            return false;
        }
        return sucesso;
    }

    /**
     * Remove uma categoria pelo ID
     * @param id
     * @return
     */
    public boolean remover(int id){
        Boolean sucesso = false;
        try {
            Class.forName(BD_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("Erro ao carregar o drive");
            return sucesso;
        }

        String querySQL = "DELETE FROM categorias WHERE id = ?";

        try (Connection con = DriverManager.getConnection(BD_URL,BD_USUARIO,BD_SENHA);
            PreparedStatement pstmt = con.prepareStatement(querySQL);) {
            
            pstmt.setInt(1, id);
            sucesso = (pstmt.executeUpdate() == 1);

        } catch (SQLException ex) {
            System.out.println("deu exception");
            return false;
        }
        return sucesso;
    }
}
