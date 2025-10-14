package banco_de_dados_in_java.models;
import static banco_de_dados_in_java.config.config.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ProdutosDAO {
    /**
     * Função responsavel por lista todos os produtos
     * @return
     */
    public List<Produtos> obterTodos(){
        List<Produtos> resultado = new ArrayList<>();

        try {
            Class.forName(BD_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("Erro ao carregar o drive");
            return resultado;
        }

        String querySQL = "SELECT * FROM produtos P";

        try (Connection con = DriverManager.getConnection(BD_URL, BD_USUARIO, BD_SENHA);
            Statement stmt = con.createStatement();
            ResultSet rst = stmt.executeQuery(querySQL)) {
            
            while (rst.next()) {
                Produtos produtos = new Produtos();
                produtos.setId(rst.getInt("id"));
                produtos.setNome(rst.getString("nome"));
                produtos.setQuantidade(rst.getInt("quantidade"));
                produtos.setPreco(rst.getDouble("preco"));
                resultado.add(produtos);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao acessar o banco de dados: " + ex.getMessage());
            ex.printStackTrace();
        }
        return resultado;
    }

    /**
     * Função que retorna um produto pelo ID
     * @param id
     * @return
     */
    public Produtos obter(int id){
        Produtos produto = null;
        try {
            Class.forName(BD_DRIVER);
        }catch(ClassNotFoundException e){
            System.out.println("Erro ao carregar o drive");
            return produto;
        } 
        String querySQL = "SELECT P.id,P.nome,P.quantidade,P.preco FROM Produtos P WHERE P.id=?";

        try (Connection con = DriverManager.getConnection(BD_URL,BD_USUARIO,BD_SENHA);
            PreparedStatement pstmt = con.prepareStatement(querySQL);) {

            pstmt.setInt(1, id);
            
            try(ResultSet rst = pstmt.executeQuery()){
                if (rst.next()) {
                    produto = new Produtos();
                    produto.setId(rst.getInt("id"));
                    produto.setNome(rst.getString("nome"));
                    produto.setQuantidade(rst.getInt("quantidade"));
                    produto.setPreco(rst.getDouble("preco"));
                    return produto;
                }
            }
        }catch ( SQLException ex) {
            return null;
        }
        return null;
    }

    /**
     * Função que inserir um produto no banco
     * @param nome
     * @param quantidade
     * @param preco
     * @return
     */
    public boolean inserir(String nome,int quantidade,Double preco){
        boolean sucesso = false;

        try {
            Class.forName(BD_DRIVER);
        }catch(ClassNotFoundException e){
            System.out.println("Erro ao carregar o drive");
            return sucesso;
        } 

        String querySQL = "INSERT INTO produtos  (nome,quantidade,preco) VALUES (?,?,?)";

        try (Connection con = DriverManager.getConnection(BD_URL,BD_USUARIO,BD_SENHA);
            PreparedStatement pstmt = con.prepareStatement(querySQL);) {
            pstmt.setString(1, nome);
            pstmt.setInt(2, quantidade);
            pstmt.setDouble(3, preco);
            sucesso = (pstmt.executeUpdate() == 1);
        } catch (SQLException ex) {
            System.err.println("Erro SQL ao inserir: " + ex.getMessage());
            return false;
        }
        return sucesso;
    }

    /**
     * Função que atualiza um produto existente
     * @param id
     * @param nome
     * @param quantidade
     * @param preco
     * @return
     */
    public boolean atualizar(int id, String nome, int quantidade,Double preco){
        Boolean sucesso = false;
        try {
            Class.forName(BD_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("Erro ao carregar o drive");
            return sucesso;
        }

        String querySQL = "UPDATE produtos SET nome = ?,quantidade = ?,preco = ? WHERE id = ?";

        try (Connection con = DriverManager.getConnection(BD_URL,BD_USUARIO,BD_SENHA);
            PreparedStatement pstmt = con.prepareStatement(querySQL);) {

            pstmt.setString(1, nome);
            pstmt.setInt(2, quantidade);
            pstmt.setDouble(3, preco);
            pstmt.setInt(4, id);

            sucesso = (pstmt.executeUpdate() == 1);

            
        } catch (SQLException ex) {
            System.out.println("deu exception");
            return false;
        }
        return sucesso;
    }

    /**
     * Função que remove um produto existente
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

        String querySQL = "DELETE FROM produtos WHERE id = ?";

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
