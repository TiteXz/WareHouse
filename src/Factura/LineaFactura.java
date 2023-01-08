package Factura;

import Articulos.*;

public class LineaFactura {
	private int numero;
	private Articulo articulo;
	private int cantidad;

	public LineaFactura(int numero, Articulo articulo, int cantidad) {

		this.numero = numero;
		this.articulo = articulo;
		this.cantidad = cantidad;
	}

	public LineaFactura() {

	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Articulo getArticulo() {
		return articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double precioTotal() {
		double precioTotal = 0.0;
		precioTotal = cantidad * articulo.getPrecio();
		return precioTotal;
	}

	public String formatoFichero() {
		String formato = this.numero + ";" + this.articulo.getNombre() + ";" + this.cantidad;
		return formato;
	}

	@Override
	public String toString() {
		return "LineaFactura: numero:" + numero + ", articulo:" + articulo + ", cantidad:" + cantidad;
	}

}