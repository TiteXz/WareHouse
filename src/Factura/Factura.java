package Factura;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class Factura {
	public static int IVA = 21;
	private int numero;
	private String nombreEmpresa;
	private Date fecha;
	private String concepto;
	private ArrayList<LineaFactura> lineaList;

	public Factura(int numero, String nombreEmpresa, Date fecha, String concepto, ArrayList<LineaFactura> lineaList) {

		this.numero = numero;
		this.nombreEmpresa = nombreEmpresa;
		this.fecha = fecha;
		this.concepto = concepto;
		lineaList = new ArrayList<LineaFactura>();
	}

	public Factura() {
		lineaList = new ArrayList<LineaFactura>();
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public ArrayList<LineaFactura> getLineaList() {
		return lineaList;
	}

	public void setLineaList(ArrayList<LineaFactura> lineaList) {
		this.lineaList = lineaList;
	}

	public static int getIva() {
		return IVA;
	}

	public void addLinea(LineaFactura linea) {
		boolean estar = false;
		Iterator<LineaFactura> donde = lineaList.iterator();
		while (donde.hasNext() && !estar) {
			LineaFactura lineaExiste = (LineaFactura) donde.next();
			if (lineaExiste.equals(linea)) {
				System.out.println("La linea ya esta en la lista");
				estar = true;
			}
			donde.next();
		}
		if (!estar) {
			lineaList.add(linea);
		}
	}

	public void eliminarLinea(int numeroLinea) {
		boolean estar = false;
		Iterator<LineaFactura> donde = lineaList.iterator();
		while (donde.hasNext() && !estar) {
			LineaFactura lineaExiste = (LineaFactura) donde.next();
			if (lineaExiste.getNumero() == numeroLinea) {
				System.out.println("A continuación se borrara la linea");
				estar = true;
				donde.remove();
			}
			donde.next();
		}
	}

	public double precioTotal() {
		double precioTotal = 0.0;
		for (LineaFactura linea : lineaList) {
			precioTotal = precioTotal + linea.precioTotal();
		}
		return precioTotal;
	}

	public void mostrarEnPantalla() {
		System.out.println(this.toString());
		for (LineaFactura linea : lineaList) {
			System.out.println(linea.toString());
		}

	}

	public void guardarEnFichero() throws IOException {
		String fichero = numero + "_" + fecha + "_factura.txt";
		PrintWriter write = new PrintWriter("Facturas/" + fichero);
		write.println("Factura: \n IVA: " + Factura.IVA + ", numero: " + this.numero + ", nombre de empresa: "
				+ this.nombreEmpresa + ", fecha: " + this.fecha + ", concepto: " + this.concepto);
		for (LineaFactura factu : lineaList) {
			write.println(factu.formatoFichero());
		}
		write.close();

	}

	@Override
	public String toString() {
		return "Factura: numero:" + numero + ", nombreEmpresa:" + nombreEmpresa + ", fecha:" + fecha + ", concepto:"
				+ concepto + ", lineaList:" + lineaList;
	}

}
