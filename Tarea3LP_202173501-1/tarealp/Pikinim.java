package tarealp;

public abstract class Pikinim {
	private int ataque;
	private int capacidad;
	private int cantidad;
	
	/**
     * public Pikinim(): Constructor de la clase Pikinim.
     *
     * @param ataque: El valor de ataque del Pikinim (int).
     * @param capacidad: La capacidad del Pikinim para transportar objetos (int).
     */
	public Pikinim(int ataque, int capacidad) {
		this.ataque = ataque;
		this.capacidad = capacidad;
		this.cantidad = 0;
	}
	
	/**
     * public int getAtaque(): Obtiene el valor de ataque del Pikinim.
     *
     * @return: El valor de ataque del Pikinim (int).
     */
	public int getAtaque() {
		return ataque;
	}
	
	/**
     * public void setAtaque(): Establece el valor de ataque del Pikinim.
     *
     * @param ataque: El valor de ataque del Pikinim a establecer (int).
     */
	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}
	
	/**
     * public int getCapacidad(): Obtiene la capacidad del Pikinim para transportar objetos.
     *
     * @return: La capacidad del Pikinim (int).
     */
	public int getCapacidad() {
		return capacidad;
	}
	
	/**
     * public void setCapacidad(): Establece la capacidad del Pikinim para transportar objetos.
     *
     * @param capacidad: La capacidad del Pikinim a establecer (int).
     */
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	
	/**
     * public int getCantidad(): Obtiene la cantidad de Pikinim disponibles.
     *
     * @return: La cantidad de Pikinim disponibles (int).
     */
	public int getCantidad() {
		return cantidad;
	}
	
	/**
     * public void setCantidad(): Establece la cantidad de Pikinim disponibles.
     *
     * @param cantidad: La cantidad de Pikinim a establecer (int).
     */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	/**
     * public void disminuir(): Disminuye la cantidad de Pikinim disponibles en la cantidad especificada.
     *
     * @param cantidad: La cantidad en la que se debe disminuir la cantidad de Pikinim (int).
     */
	public void disminuir (int cantidad) {
		this.cantidad -= cantidad;
	}
	
	/**
     * public abstract void multiplicar(): Método abstracto que permite multiplicar la cantidad de Pikinim.
     *
     * @param cantidad: La cantidad por la cual multiplicar los Pikinim (int).
     */
	public abstract void multiplicar(int cantidad);
	
}
