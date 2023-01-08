package Almacen;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;
import Articulos.*;
public class GestorAlmacenApp {

	public static void run() throws IOException, ParseException {
		final int VER_ARTICULOS_SALUDABLES=1;
		final int VER_ARTICULO_MAS_CARO=2;
		final int VER_ARTICULO_CON_MENOS_STOCK=3;
		final int SALIR=0;
		
		Scanner sc=new Scanner(System.in);
		Almacen almacen=new Almacen();
		int opcion_menu=0;
		
		almacen.cargarDatos();
		do {
			System.out.println("----------MENU----------");
			System.out.println(VER_ARTICULOS_SALUDABLES+". ver articulos saludables");
			System.out.println(VER_ARTICULO_MAS_CARO+". ver articulo mas caro");
			System.out.println(VER_ARTICULO_CON_MENOS_STOCK+". ver articulo con menos stock que el indicado");
			System.out.println(SALIR+". salir");
			System.out.println("Escoge la opcion que quieras:");
			opcion_menu=Integer.parseInt(sc.nextLine());
			switch(opcion_menu) {
				case VER_ARTICULOS_SALUDABLES:
					for(Articulo art: almacen.articuloList) {
						if(art.saludable()) {
							System.out.println(art);
						}
					}
					break;
				case VER_ARTICULO_MAS_CARO:
					almacen.elMasCaro();
					break;
				case VER_ARTICULO_CON_MENOS_STOCK:
					Articulo min=almacen.articuloList.get(0);
					for(Articulo art: almacen.articuloList) {
						if(art.getStock()<min.getStock()) {
							min=art;
						}
					}
					System.out.println(min);
					break;
				case SALIR:
					break;
				default:
					break;
			}
		}while(opcion_menu!=SALIR);
		sc.close();
	}
	
	


}