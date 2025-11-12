/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.estoque.dao;
import com.mycompany.estoque.database.Conexao;
import com.mycompany.estoque.model.Categoria;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author luizfkm
 */
public class CategoriaDAO {
    public void inserir(Categoria c){
        String sql = "INSERT INTO categoria (nome) VALUES (?)";
        
        
        try(Connection con = Conexao.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);){  
            ps.setString(1, c.getNome());
            ps.executeUpdate();
                
        } catch(SQLException e){
            System.out.println("Erro -> " + e);
        }
    }
    
    public List<Categoria> listar(){
        List<Categoria> lista = new ArrayList<>();
        
        String sql = "SELECT * FROM categoria ORDER BY nome";
        
        try(Connection con = Conexao.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){
            while(rs.next()){
                lista.add(new Categoria(rs.getInt("id"), rs.getString("nome")));
            }
        }catch(SQLException e){
            System.out.println("Erro -> " + e);
        }
        return lista;
    }
}
