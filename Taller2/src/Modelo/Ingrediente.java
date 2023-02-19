package Modelo;

public class Ingrediente {
	// Atributos
	private String nombre;
	private int costoAdicional;
	
	//Constructor
	public Ingrediente(String elNombre, int elCostoAdicional) {
		this.nombre = elNombre;
		this.costoAdicional = elCostoAdicional;
	}
	
	//Metodos
	public String getNombre(){
		return nombre;
	}
	
	public int getCostoAdicional(){
		return costoAdicional;
	}
}
