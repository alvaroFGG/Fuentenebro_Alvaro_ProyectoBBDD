/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientesDAO;

import entidades.Cliente;
import java.sql.Connection;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author alvar
 */
public class ClientesDAOTest {
    
    public ClientesDAOTest() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }
    
    
    /**
     * Test of getConexion method, of class ClientesDAO.
     */
    @org.junit.jupiter.api.Test
    public void testGetConexion() {
        System.out.println("getConexion");
        ClientesDAO instance = new ClientesDAO();
        Connection expResult = null;
        Connection result = instance.getConexion();
        assertNotEquals(expResult, result);
        
    }

    /**
     * Test of listarClientes method, of class ClientesDAO.
     */
    @org.junit.jupiter.api.Test
    public void testListarClientes() {
        System.out.println("readVarios");
        Integer start = 9;
        ClientesDAO instance = new ClientesDAO();
        ArrayList<Cliente> expResult = new ArrayList<>();
        Cliente cliente = new Cliente(10,"BOTTM","Bottom-Dollar Markets","Elizabeth Lincoln","Gerente de contabilidad","23 Tsawassen Blvd.","Tsawassen","BC","T2F 8M4","Canadá","((604) 555-4729","(604) 555-3745");
        expResult.add(cliente); 
        ArrayList<Cliente> result = instance.listarClientes(start);
        assertEquals(result.get(0).getIdCliente(), cliente.getIdCliente());
    }

    /**
     * Test of read method, of class ClientesDAO.
     */
    @org.junit.jupiter.api.Test
    public void testRead() {
        System.out.println("read");
        // Funciona
        Integer id = 1;
        ClientesDAO instance = new ClientesDAO();
        Cliente expResult = new Cliente(1,"ALFKI","Alfreds Futterkiste","Maria Anders","Representante de ventas","Obere Str. 57","Berlín",null,"12209","Alemania","030-0074321","030-0076545");
        Cliente result = instance.read(id);
        assertEquals(expResult.getIdCliente(), result.getIdCliente());
        
    }

    /**
     * Test of insert method, of class ClientesDAO.
     */
    @org.junit.jupiter.api.Test
    public void testInsert() {
        System.out.println("insert");
        Cliente cliente = new Cliente(100,"","","","","","","","","","","");
        ClientesDAO instance = new ClientesDAO();
        Boolean expResult = true;
        Boolean result = instance.insert(cliente);
        assertEquals(expResult, result);
    }

    /**
     * Test of delete method, of class ClientesDAO.
     */
    @org.junit.jupiter.api.Test
    public void testDelete() {
        System.out.println("delete");
        Integer id = 92;
        ClientesDAO instance = new ClientesDAO();
        Boolean expResult = false;
        Boolean result = instance.delete(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of update method, of class ClientesDAO.
     */
    @org.junit.jupiter.api.Test
    public void testUpdate() {
        System.out.println("update");
        Cliente cliente = null;
        ClientesDAO instance = new ClientesDAO();
        Boolean expResult = false;
        Boolean result = instance.update(cliente);
        assertEquals(expResult, result);
    }

  
    
}
