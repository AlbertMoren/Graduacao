package banco_de_dados_in_java;
import java.sql.SQLException;

import banco_de_dados_in_java.models.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        //buscando todos Produtos
        ProdutosDAO produtos = new ProdutosDAO();
        for (Produtos prod : produtos.obterTodos()) { 
            System.out.println("ID: " + prod.getId() + ", Nome: " + prod.getNome() + ", quantidade: " + prod.getQuantidade() + ", preço: " + prod.getPreco()); 
        }
        System.err.println("=========================================================");
        
        //buscando um unico produto
        Produtos prod = produtos.obter(1);
        System.out.println("ID: " + prod.getId() + ", Nome: " + prod.getNome() + ", quantidade: " + prod.getQuantidade() + ", preço: " + prod.getPreco());

        //inserido um novo produto
        //System.out.println(produtos.inserir("Fone sem fio",5,15.99));

        //atualizando uma categoria existente
        //System.out.println(produtos.atualizar(5,"fone com fio",2,10.00));

        //removendo um produto
        //System.out.println(produtos.remover(1));
    }
}