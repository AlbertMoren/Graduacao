package banco_de_dados_in_java;
import java.sql.SQLException;

import banco_de_dados_in_java.models.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        Banco banco = new Banco();
        for (Categoria categoria : banco.obterTodos()) { 
            System.out.println("ID: " + categoria.getId() + ", Nome: " + categoria.getnome()); 
        }
    }
}