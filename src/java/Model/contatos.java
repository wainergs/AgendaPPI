/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

public class contatos{
    private int id;
    private String nome;
    private String telefone;
    
    public contatos()
    {}

    public int getId(){return id;}
    
    public String getNome(){return nome.toUpperCase();}
    
    public String getTelefone(){return telefone;}
    
    public void setId(int id){this.id = id;}
    
    public void setNome(String nome){this.nome = nome.toUpperCase();}
    
    public void setTelefone(String telefone){this.telefone = telefone;}
    
    
    
    
    
}