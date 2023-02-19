package Modelo;

import Interfaz.Producto;

public class ProductoMenu implements Producto{
	// Atributos
		private String nombre;
		private int precioBase;
		
		//Constructor
		public ProductoMenu(String elNombre, int elPrecioBase) {
			this.nombre = elNombre;
			this.precioBase = elPrecioBase;
		}
		
		//Metodos
		public String getNombre(){
			return nombre;
		}
		
		public int getPrecio(){
			return precioBase;
		}

		@Override
		public String generarTextoFactura() {
			// TODO Auto-generated method stub
			String texto= "Productos Menu: " + nombre + " Precio: " + precioBase;
			return texto;
		}
		
			
		
	}
