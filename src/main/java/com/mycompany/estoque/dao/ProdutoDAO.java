/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.estoque.dao;
import com.mycompany.estoque.database.Conexao;
import com.mycompany.estoque.model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author luizfkm
 */
public class ProdutoDAO {
    public void inserir(Produto p){
        String sql = "INSERT INTO produto (nome, id_categoria, estoque, preco) VALUES (?, ?, ?, ?)";
        
        try(Connection con = Conexao.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);){
            ps.setString(1, p.getNome());
            ps.setInt(2, p.getCategoria().getId());
            ps.setInt(3, p.getEstoque());
            ps.setDouble(4, p.getPreco());
            ps.executeUpdate();
        } catch(SQLException e){
            System.out.println("ERRO -> " + e);
        }
    }
}
