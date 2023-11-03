package tarealp;

public class Cyan extends Pikinim {
	/**
     * public Cyan(): Constructor de la clase Cyan inicializando sus valores.
     * 
     */
	public Cyan() {
		super(1, 1);
	}
	
	
	/**
     * public void multiplicar(): Multiplica la cantidad de Pikinim Cyan por un valor dado y actualiza la cantidad.
     * 
     * @param cantidad: El valor por el cual se multiplicará la cantidad de Cyan (int).
     */
	public void multiplicar(int cantidad) {
		setCantidad(getCantidad() + (cantidad * 3));
	}
	
}
