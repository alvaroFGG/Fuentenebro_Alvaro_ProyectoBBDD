/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

/**
 *
 * @author alvar
 */
import entidades.Cliente;
import clientesDAO.ClientesDAO;
import java.util.Scanner;
public class Main {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        Cliente cliente = new Cliente();
        ClientesDAO clientes = new ClientesDAO();
        
        System.out.println("Estos son los 10 primeros clientes:");
        visualizarClientes();
        
        //despuesd de visualizar los 10 primeros clientes se mostrara el menu
        mostrarMenu();
        
    }
    
    public static void visualizarClientes(){
        Cliente cliente = new Cliente();
        ClientesDAO clientes = new ClientesDAO();
        for(Cliente e:clientes.listarClientes(0)){
            System.out.println(e);
        }
    }
    
    
    public static void mostrarMenu(){
        boolean parar = false;
        Integer siguientes = 0;
        while(!parar){
            Scanner in = new Scanner(System.in);
            System.out.println("---------------------------------");
            System.out.println("1- Mostrar los 10 siguientes");
            System.out.println("2- Mostrar los 10 anteriores");
            System.out.println("---------------------------------");
            Integer opcion = in.nextInt();
            switch(opcion){
                case 1:
                    siguientes+=10;
                    mostrarSiguientes(siguientes);
                    break;
                case 2:
                    
                    siguientes=comprobar(siguientes);;
                    
                    mostrarSiguientes(siguientes);
                    break;
                case 0:
                    System.out.println("Saliendo del menu...");
                    parar = true;
                    break;
                default:
                    System.out.println("Introduce los numeros permitidos:");
            }
        }
    }
    
    
    public static void mostrarSiguientes(Integer siguientes){
        Cliente cliente = new Cliente();
        ClientesDAO clientes = new ClientesDAO();
        
        System.out.println("Visualizando los 10 siguientes Clientes");
        for(Cliente e: clientes.listarClientes(siguientes)){
            System.out.println(e);
        }
    }
    
    public static Integer comprobar(Integer siguientes){
        Cliente cliente = new Cliente();
        ClientesDAO clientes = new ClientesDAO();
        if(siguientes==0){
            siguientes=80;
        }else{
            siguientes-=10;
        }
        return siguientes;
    }
}
