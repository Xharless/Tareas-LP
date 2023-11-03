package tarealp;

public class Amarillo extends Pikinim {
	/**
     * public Amarillo(): Constructor de la clase Amarillo inicializando sus valores.
     * 
     */
	public Amarillo() {
		super(1, 3);
	}
	
	
	/**
     * public void multiplicar(): Multiplica la cantidad de Pikinim Amarillos por un valor dado y lo actualiza.
     *
     * @param cantidad: El valor por el cual se multiplicará la cantidad de Amarillo (int).
     */
	public void multiplicar(int cantidad) {

		setCantidad(getCantidad() + (int) Math.ceil(cantidad * 1.5 ));
    }
	
	
}