/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientesDAO;

/**
 *
 * @author alvar
 */
import entidades.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class ClientesDAO {
    
    private Connection conexion = null;

    public ClientesDAO() {
        try{
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/neptuno", "root", "");
        }catch(SQLException e){
            System.out.println("Conexion incorrecta: "+e.getMessage());
        }
    }

    public Connection getConexion() {
        return conexion;
    }
    
    public ArrayList<Cliente> listarClientes(Integer siguientes){
        Cliente cliente = null;
        ArrayList<Cliente> lista = new ArrayList<>();
        PreparedStatement stmt = null;
        
        if(this.getConexion()==null){
            return null;
        }
        
        
        try{
            String select = "SELECT * FROM `clientes` LIMIT 10 OFFSET ?";
            stmt = conexion.prepareStatement(select);
            stmt.setInt(1, siguientes);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                cliente = new Cliente(
                        rs.getInt("id"),
                        rs.getString("codigo"),
                        rs.getString("empresa"),
                        rs.getString("contacto"),
                        rs.getString("cargo_contacto"),
                        rs.getString("direccion"),
                        rs.getString("ciudad"),
                        rs.getString("region"),
                        rs.getString("cp"),
                        rs.getString("pais"),
                        rs.getString("telefono"),
                        rs.getString("fax")
                );
                lista.add(cliente);
            }
        }catch(SQLException e){
            System.out.println("Sentencia incorrecta: "+e.getMessage());
        }
        
        return lista;
        
    }
    
    
}
