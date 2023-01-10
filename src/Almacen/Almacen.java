package Almacen;
import Articulos.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import java.util.Iterator;
public class Almacen {
	ArrayList<Articulo> articuloList;
	public Almacen(){
		articuloList=new ArrayList<Articulo>();
	}
	
	public void cargarDatos() throws FileNotFoundException {
		File file=new File("Datos/articulos.txt");
		Scanner scan=new Scanner(file);
		String[] partes;
		while(scan.hasNextLine()) {
			partes=scan.nextLine().split(";");
			if(partes[2].toLowerCase().equals("refresco")) {
				Refresco refres=new Refresco(partes[0], partes[1], partes[2], partes[3],Integer.parseInt(partes[4]), Double.parseDouble(partes[5]), Integer.parseInt(partes[6]), partes[7], Boolean.parseBoolean(partes[8]), Boolean.parseBoolean(partes[9]),Integer.parseInt(partes[10]));
				articuloList.add(refres);
			}else if(partes[2].toLowerCase().equals("vino")) {
				Vino vin=new Vino(partes[0], partes[1], partes[2], partes[3],Integer.parseInt(partes[4]), Double.parseDouble(partes[5]), Integer.parseInt(partes[6]), partes[7], partes[8], Integer.parseInt(partes[9]), partes[10], Double.parseDouble(partes[11]));
				articuloList.add(vin);
			}else if(partes[2].toLowerCase().equals("cerveza")){
				Cerveza cerv=new Cerveza(partes[0], partes[1], partes[2], partes[3],Integer.parseInt(partes[4]), Double.parseDouble(partes[5]), Integer.parseInt(partes[6]), partes[7], partes[8], Double.parseDouble(partes[9]));
				articuloList.add(cerv);
			}
		}
		scan.close();
	}
	
	public Articulo elMasCaro() {
		double precio=0.0;
		Articulo caro = null;
		for(Articulo art:articuloList) {
			if(art.getPrecio()>precio) {
				precio=art.getPrecio();
				caro=art;
			}
		}
		return caro;
	}
	public double precio(String codigoProducto) {
		double precio=0.0;
		Iterator<Articulo> here=articuloList.iterator();
		boolean encontrado=false;
		while(here.hasNext()||!encontrado) {
			Articulo art=(Articulo) here.next();
			if(art.getCodigo().equals(codigoProducto)) {
				precio=art.getPrecio();
				encontrado=true;
			}
			here.next();
		}
		return precio;
	}
	
	public boolean hayStock(String codigoProducto) {
		boolean stock=false;
		Iterator<Articulo> here=articuloList.iterator();
		boolean encontrado=false;
		while(here.hasNext()||!encontrado) {
			Articulo art=(Articulo) here.next();
			if(art.getCodigo().equals(codigoProducto) && art.getStock()>0) {
				encontrado=true;
				stock=true;
			}
			here.next();
		}
		return stock;
	}
	
	public ArrayList<Articulo> stockJusto(int stock){
		ArrayList<Articulo> stockJusto=new ArrayList<Articulo>();
		for(Articulo art:articuloList) {
			if(art.getStock()==stock) {
				stockJusto.add(art);
			}
		}
		return stockJusto;
	}
	
	public Articulo articulo(String codigoProducto) {
		boolean encontrado=false;
		Articulo artic=null;
		Iterator<Articulo> here=articuloList.iterator();
		while(here.hasNext()||!encontrado) {
			Articulo art=(Articulo) here.next();
			if(art.getCodigo().equals(codigoProducto)) {
				encontrado=true;
				artic=art;
			}
			here.next();
		}
		return artic;
	}
	
	public boolean disponibilidad(int cantidad, String codigoProducto) {
		boolean encontrado=false;
		boolean disponible= false;
		Iterator<Articulo> here=articuloList.iterator();
		while(here.hasNext()||!encontrado) {
			Articulo art=(Articulo) here.next();
			if(art.getCodigo().equals(codigoProducto) && art.getStock()>cantidad) {
				disponible=true;
				encontrado=true;
			}
			here.next();
		}
		return disponible;
	}
	
	public ArrayList<Articulo> equivalente(Articulo articulo){
		ArrayList<Articulo> equivalente=new ArrayList<Articulo>();
		Double dif;
		for(Articulo art:articuloList) {
			if(art.getTipo().equals(articulo.getTipo())){
				if(art.getPrecio()>articulo.getPrecio()) {
					dif=art.getPrecio()-articulo.getPrecio();
				}
				else {
					dif=articulo.getPrecio()-art.getPrecio();
				}
				if(dif<=0.2 ) {
					equivalente.add(art);
				}
			}
		}
		return equivalente;
	}
	
	public ArrayList<Articulo> ordenarPorPrecio(String orden){
		if(orden.equals("d")) {
			Collections.sort(articuloList);
		}
		else if(orden.equals("a")){
			Comparator <Articulo> comparador= Collections.reverseOrder();
			Collections.sort(articuloList, comparador);
		}
		return articuloList;	
	}

	
}