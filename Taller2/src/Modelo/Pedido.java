package Modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import Interfaz.Producto;

public class Pedido {
	
		private ArrayList<Producto> itemsPedido  = new ArrayList<>();
	// Atributos
		private String nombreCliente;
		private String direccionCliente;
		private int numeroPedidos;
		private int idPedido;
		
		//Constructor
		public Pedido(String elNombreCliente, String laDireccionCliente) {
			this.nombreCliente = elNombreCliente;
			this.direccionCliente = laDireccionCliente;
		}
		
		//Metodos
		public int getIdPedido(){
			return idPedido;
		}
		
		public void agregarProducto(Producto nuevoItem){
			itemsPedido.add(nuevoItem);
		}
		
		private int getPrecioNetoPedido() {
			int neto = 0;
			for (Producto item : itemsPedido) {
				neto += item.getPrecio();
			}
			return neto;
		}
		
		private int getPrecioTotalPedido() {
			int neto = getPrecioNetoPedido();
			int iva = getPrecioIVAPedido();
			int total = neto + iva;
			return total;
			
		}	
		private int getPrecioIVAPedido() {
			int neto = getPrecioNetoPedido();
			double valorNeto = neto;
			double iva = valorNeto *(0.19);
			int ivaFinal = (int)iva;
			return ivaFinal;
		}
		
		private String generarTextoFactura() {
			String texto = "Factura ";
			String id = String.valueOf(idPedido);
			String nombre = nombreCliente;
			String direccion = direccionCliente;
			String items = "Productos: ";
			for (Producto item : itemsPedido) {
				items.concat(" ").concat(item.getNombre());
			}
			String neto = String.valueOf(getPrecioNetoPedido());
			String iva = String.valueOf(getPrecioIVAPedido());
			String total = String.valueOf(getPrecioTotalPedido());
			
			texto = texto +" ID: " + id + " Cliente: " + nombre + " Direccion:  " + direccion + " " + items + " Precio Neto: " + neto
						+ " IVA: " + iva + " Precio Total: " + total;
			return texto;
		}
		
		public void guardarFactura(File archivo) {
			String texto = generarTextoFactura();
			  try {
		          BufferedWriter archivoNuevo=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(archivo,true), "utf-8"));
		          archivoNuevo.write(texto + "\r\n");
		          archivoNuevo.close();
		       } catch (Exception ex) {
		          System.out.println(ex.getMessage());
		       } 
		}
}
		
		

