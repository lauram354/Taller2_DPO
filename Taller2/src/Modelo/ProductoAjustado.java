package Modelo;

import java.util.ArrayList;

import Interfaz.Producto;

public class ProductoAjustado implements Producto {
	
	private ProductoMenu base; 
	private ArrayList<Ingrediente> agregados  = new ArrayList<>();
	private ArrayList<Ingrediente> eliminados  = new ArrayList<>();
	
	private String NombreFinal;
	private int PrecioFinal;
	
	//Constructor
	public ProductoAjustado(ProductoMenu Base) {
		String nombre = base.getNombre();
		int precio = base.getPrecio();
		for (Ingrediente agrega : agregados) {
			nombre = nombre + " con " + agrega.getNombre();
			precio = precio + agrega.getCostoAdicional();
		}
		for (Ingrediente elimina : eliminados) {
			nombre = nombre + " sin " + elimina.getNombre();
			precio = precio - elimina.getCostoAdicional();
		}
		
		this.NombreFinal = nombre;
		this.PrecioFinal = precio;	
	
	}
	
	//Metodos
	
	@Override
	public int getPrecio() {
		// TODO Auto-generated method stub
		return PrecioFinal;
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return NombreFinal;
	}

	@Override
	public String generarTextoFactura() {
		// TODO Auto-generated method stub
		String ajustados= "Productos ajustados: " + NombreFinal + " Precio: " + PrecioFinal;
		return ajustados;
	}
	
	
	
	
}