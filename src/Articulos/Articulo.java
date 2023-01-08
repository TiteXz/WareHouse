package Articulos;

public abstract class Articulo implements Comparable<Articulo> {
	private String codigo;
	private String tipo;
	private String nombre;
	private String marca;
	private int capacidadBotella;
	private double precio;
	private int stock;

	public Articulo(String codigo, String tipo, String nombre, String marca, int capacidadBotella, double precio,
			int stock) {
		
		this.codigo = codigo;
		this.tipo = tipo;
		this.nombre = nombre;
		this.marca = marca;
		this.capacidadBotella = capacidadBotella;
		this.precio = precio;
		this.stock = stock;
	}

	public Articulo() {

	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getCapacidadBotella() {
		return capacidadBotella;
	}

	public void setCapacidadBotella(int capacidadBotella) {
		this.capacidadBotella = capacidadBotella;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public void incrementarStock(int cantidad) {
		this.stock = this.stock + cantidad;
	}

	public void disminuirStock(int cantidad) {
		if (this.stock < cantidad || this.stock == 0) {
			System.out.println("No hay suficiente stock");
		} else {
			this.stock = this.stock - cantidad;
		}
	}

	public abstract void visualizarArticulo();

	public abstract boolean saludable();

	public abstract void precioTotal();

	@Override
	public String toString() {
		return "codigo:" + codigo + ", nombre:" + nombre + ", marca:" + marca + ", capacidadBotella:" + capacidadBotella
				+ ", precio:" + precio + ", stock:" + stock;
	}

	@Override
	public int compareTo(Articulo o) {
		if (this.getPrecio() < o.getPrecio()) {
			return -1;
		} else {
			if (this.getPrecio() > o.getPrecio()) {
				return 1;
			} else {
				return 0;
			}
		}
	}

}