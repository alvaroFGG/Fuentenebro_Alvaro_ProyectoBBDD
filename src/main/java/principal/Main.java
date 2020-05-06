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
        System.out.println("id"+"\t"+"\t"+"CodigoCliente"+ "\t"+"\t"+"Empresa"+ "\t"+"\t"+"Contacto"+"\t"+"\t"+"CargoContacto");
        for(Cliente e:clientes.listarClientes(0)){
            System.out.println(e);
        }
    }
    
    
    public static void mostrarMenu(){
        boolean parar = false;
        Integer siguientes = 0;
        
        while(!parar){
            Scanner in = new Scanner(System.in);
            
            System.out.println();
            System.out.println("\t"+"****MENU****");
            System.out.println("---------------------------------");
            System.out.println("1- Mostrar los 10 siguientes");
            System.out.println("2- Mostrar los 10 anteriores");
            System.out.println("3- Mostrar un cliente por ID");
            System.out.println("4- Si desea añadir un cliente");
            System.out.println("5- Si desea eliminar un cliente");
            System.out.println("0- Si desea SALIR del menu");
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
                case 3:
                    readCliente();
                    break;
                    
                case 4:
                    introducirCliente();
                    break;
                case 5:
                    eliminarCliente();
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
        System.out.println("id"+"\t"+"\t"+"CodigoCliente"+ "\t"+"\t"+"Empresa"+ "\t"+"\t"+"Contacto"+"\t"+"\t"+"CargoContacto");
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
    
    public static Cliente existe(){
        Cliente cliente = null;
        ClientesDAO clientes = new ClientesDAO();
        Scanner in = new Scanner(System.in);
        
        System.out.println("Indique el id del cliente que desea: ");
        Integer idDeseado = in.nextInt();
        cliente = clientes.read(idDeseado);
        return cliente;
        
    }
    
    
    public static void readCliente(){
        Cliente cliente = existe();
        ClientesDAO clientes = new ClientesDAO();
        Scanner in = new Scanner(System.in);
        
        System.out.println();
        if(cliente==null){
            System.out.println("El cliente seleccionado no existe.");
        }else{
            System.out.println("El cliente que ha seleccionado es: ");
            System.out.println(cliente.toString());
        }
    }
    
    public static void introducirCliente(){
        Scanner in = new Scanner(System.in);
        Cliente cliente = new Cliente();
        ClientesDAO clientes = new ClientesDAO();
        
        System.out.println("Indique el Codigo de Cliente");
        cliente.setCodigoCliente(in.nextLine());
        
        System.out.println("Indique el nombre de la Empresa");
        cliente.setEmpresa(in.nextLine());
        
        System.out.println("Indique el Contacto");
        cliente.setContacto(in.nextLine());
        
        System.out.println("Indique el Cargo del contacto");
        cliente.setCargoContacto(in.nextLine());
        
        System.out.println("Indique la direccion");
        cliente.setDireccion(in.nextLine());
        
        System.out.println("Indique la ciudad");
        cliente.setCiudad(in.nextLine());
        
        System.out.println("Indique la Region");
        cliente.setRegion(in.nextLine());
        
        System.out.println("Indique el Codigo Postal");
        cliente.setCodigoPostal(in.nextLine());
        
        System.out.println("Indique el Pais");
        cliente.setPais(in.nextLine());
        
        System.out.println("Indiue un Telefono de contacto");
        cliente.setTlfno(in.nextLine());
        
        System.out.println("Indique un Numero de FAX");
        cliente.setFax(in.nextLine());
        
        if(clientes.insert(cliente)){
            System.out.println("El cliente con nombre de empresa: "+cliente.getEmpresa()+" y Contacto: "+cliente.getContacto()+" ha sido añadido");
            
        }else{
            System.out.println("El Cliente introducido no es valido.");
        }
        
    }
    
    public static void eliminarCliente(){
         Scanner in = new Scanner(System.in);
         Cliente cliente = existe();
         ClientesDAO clientes = new ClientesDAO();
         
         String respuesta = "";
         
         if(cliente==null){
             System.out.println("El Cliente seleccionado no existe...");
         }else{
             clientes.delete(cliente.getIdCliente());
             System.out.println("El cliente ha sido eliminado satisfacoriamente.");
         }
         
    }
}
