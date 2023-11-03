package tarealp;

public class Magenta extends Pikinim {
	/**
     * public Magenta(): Constructor de la clase Magenta inicializando sus valores.
     * 
     */
	public Magenta() {
		super(2, 1);
	}
	
	/**
     * public void multiplicar: Multiplica la cantidad de Pikinim Magenta por un valor dado y actualiza la cantidad.
     * 
     * @param cantidad: El valor por el cual se multiplicará la cantidad de Magenta (int).
     */
	public void multiplicar(int cantidad) {
		setCantidad(getCantidad() + (cantidad * getAtaque()));
	}
	
}
