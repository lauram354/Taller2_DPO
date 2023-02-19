package Consola;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import Modelo.Pedido;
import Modelo.Restaurante;

public class Aplicacion {
	
	private static Restaurante restaurante;

	public static void ejecutarAplicacion()
	{
		System.out.println("Bienvenido al Restaurante :)\n");
		boolean continuar = true;
		while (continuar)
		{
			try
			{
				mostrarMenu();
				int id = 0;
				int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
				if (opcion_seleccionada == 1)
					mostrarMenu();
				else if (opcion_seleccionada == 2) {
					String cliente = input("Ingrese su nombre: ");
					String direccion = input("Ingrese su direccion: ");
					ejecutarIniciarPedido(cliente, direccion);
				}
					
				else if (opcion_seleccionada == 3)
				{
					String producto = input("Ingrese el producto que desea: ");
					
					//Restaurante.getPedidoEnCurso();
				}
				else if (opcion_seleccionada == 4)
					Restaurante.cerrarYGuardarPedido();
				else if (opcion_seleccionada == 5)
				{
					id = Integer.parseInt(input("Ingrese el ID del pedido a consultar: "));
					ejecutarBuscarId(id);
				}
				else if (opcion_seleccionada == 6)
				{
					System.out.println("Saliendo de la aplicación ...");
					continuar = false;
				}
				else
				{
					System.out.println("Por favor seleccione una opción válida.");
				}
			}
			catch (NumberFormatException e)
			{
				System.out.println("Debe seleccionar uno de los números de las opciones.");
			}
			}
		}
	
		
	public static void mostrarMenu()
		{
			System.out.println("\nOpciones de la aplicación\n");
			System.out.println("1. Mostrar Menú");
			System.out.println("2. Iniciar Pedido");
			System.out.println("3. Agregar Elemento a Pedido");
			System.out.println("4. Cerrar Pedido y Guardarlo");
			System.out.println("5. Consultar Pedido por ID");
			System.out.println("6. Salir");
		}
	public static void ejecutarBuscarId(int id) {
		Pedido pedido = Restaurante.getPedidoID(id);
		if (pedido != null){
			System.out.println(pedido);
		}
		else {
			System.out.println("No hay ningún pedido con ese ID");
		}
		
	}
	
	public static void ejecutarIniciarPedido(String cliente, String direccion) {
		Restaurante.iniciarPedido(cliente, direccion);
		Pedido actual = Restaurante.getPedidoEnCurso();
		String id = String.valueOf(actual.getIdPedido());
		System.out.println("pedido:"+ id);
		Pedido pedido = Restaurante.getPedidoID(actual.getIdPedido());
		System.out.println(pedido);
	}

	public static String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args){
		try {
		File archivoingre = new File("C:\\Users\\PERSONAL\\Documents\\Tareas S\\U\\4 SEMESTRE\\DPO\\Eclipse\\Taller2\\data\\ingredientes.txt");
		File archivomenu = new File("C:\\Users\\PERSONAL\\Documents\\Tareas S\\U\\4 SEMESTRE\\DPO\\Eclipse\\Taller2\\data\\menu.txt");
		File archivocombo = new File("C:\\Users\\PERSONAL\\Documents\\Tareas S\\U\\4 SEMESTRE\\DPO\\Eclipse\\Taller2\\data\\combos.txt");
		
		Restaurante.cargarInformacionRestaurante(archivoingre, archivomenu, archivocombo);
		}
		catch (FileNotFoundException e)
		{
			System.out.println("ERROR: el archivo indicado no se encontró.");
		}
		catch (IOException e)
		{
			System.out.println("ERROR: hubo un problema leyendo el archivo.");
			System.out.println(e.getMessage());
		}

		ejecutarAplicacion();
	
}
	

}
