package Modelo;

import java.util.ArrayList;

import Interfaz.Producto;

public class Combo implements Producto{

	private double descuento;
	private String nombreCombo;
	
	private static ArrayList<Producto> itemsCombo  = new ArrayList<>();
	
	//Constructor
	public Combo(double elDescuento, String elNombreCombo) {
		this.nombreCombo = elNombreCombo;
		this.descuento= elDescuento;
	}
	
	//Metodos
	public static void agregarItemACombo(Producto itemCombo) {
		itemsCombo.add(itemCombo);
	}

	@Override
	public int getPrecio() {
		// TODO Auto-generated method stub
		int total = 0;
		for (Producto item : itemsCombo) {
			total += item.getPrecio();
		} 
		double precio = total*descuento;
		int precioF =  (int)precio;
		return precioF;
	}

	@Override
	public String generarTextoFactura() {
		// TODO Auto-generated method stub
		String texto= "Combo: " + nombreCombo + " Precio: " + String.valueOf(getPrecio());
		return texto;
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return nombreCombo;
	}
}

