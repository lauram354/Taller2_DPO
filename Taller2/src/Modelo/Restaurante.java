package Modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import Interfaz.Producto;

//import Interfaz.Producto;


public class Restaurante {
	
	private static ArrayList<Ingrediente> ingredientes = new ArrayList<>();
	private static ArrayList<ProductoMenu> menuBase = new ArrayList<>();
	private static Pedido pedidoEnCurso ; 
	private static ArrayList<Pedido> pedidos  = new ArrayList<>();
	private static ArrayList<Combo> combos  = new ArrayList<>();
	
	
	
	public static void cargarInformacionRestaurante(File archivoIngredientes, File archivoMenus ,File archivoCombos) throws FileNotFoundException, IOException
	{
		cargarIngredientes(archivoIngredientes);
		cargarMenu(archivoMenus);
		cargarCombos(archivoCombos);
		
	}

	
	private static void cargarIngredientes(File archivoIngredientes) throws FileNotFoundException, IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(archivoIngredientes));
		String linea;
        while((linea=br.readLine())!=null)
        {
			String[] partes = linea.split(";");
			String nombreIngrediente = partes[0];
			int costoAdicional = Integer.parseInt(partes[1]);
			ingredientes.add(new Ingrediente(nombreIngrediente, costoAdicional));
			
		}
        
		br.close();
	}
	
	private static void cargarMenu(File archivoMenu) throws FileNotFoundException, IOException 
	{
		BufferedReader br = new BufferedReader(new FileReader(archivoMenu));
		String linea1;
        while((linea1=br.readLine())!=null)
        {
			String[] partes = linea1.split(";");
			String nombre = partes[0];
			int precioBase = Integer.parseInt(partes[1]);
			ProductoMenu produ = new ProductoMenu(nombre, precioBase);
			menuBase.add(produ);
			
		}
		br.close();
	}
	


	private static void cargarCombos(File archivoCombos) throws FileNotFoundException, IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(archivoCombos));
		String linea2;
        while((linea2=br.readLine())!=null)
        {
       
			String[] partes = linea2.split(";");
			String nombreCombo = partes[0];
			double Descuento = Double.parseDouble(partes[1].replace("%","")) / 100;
			combos.add(new Combo(Descuento, nombreCombo));
		}
		br.close();
	}


	public static void iniciarPedido(String nombreCliente, String direccionCliente ){	
		pedidoEnCurso = new Pedido(nombreCliente, direccionCliente);
	}

	
	public static void cerrarYGuardarPedido() {
		pedidos.add(pedidoEnCurso);
		pedidoEnCurso = null;
		
	}
	
	public static Pedido getPedidoEnCurso() {
		return pedidoEnCurso;
	}
	
	public static ArrayList<ProductoMenu> getMenuBase() {
		return menuBase;
	}
	
	public static ArrayList<Ingrediente> getIngredientes() {
		return ingredientes;
	}
	
	public static Pedido getPedidoID(int id){
		int identificador = 0;
		Pedido encontrado = null;
		for (Pedido p : pedidos) {
			identificador = p.getIdPedido();
			if (identificador == id)
			{
				encontrado = p;
			}
			
		}
		return encontrado;
	}
	
	
	
}

