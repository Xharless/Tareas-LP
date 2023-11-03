package tarealp;

public class Pieza extends Zona implements ILevantable {
	private int peso;
	private static int cantidadRecogida = 0;
	
	/**
     * public static int getCantidadPiezas(): Obtiene la cantidad total de piezas recogidas por el jugador.
     *
     * @return: La cantidad total de piezas recogidas (int).
     */
	public static int getCantidadPiezas() {
		return cantidadRecogida;
	}
	
	/**
     * public Pieza(): Constructor de la clase Pieza.
     *
     * @param peso: El peso de la pieza (int).
     */
	public Pieza(int peso) {
		this.peso = peso;
	}
	
	/**
     * public int getPeso(): Obtiene el peso de la pieza.
     *
     * @return: El peso de la pieza (int).
     */
	public int getPeso() {
		return peso;
	}
	
	/**
     * public void setPeso(): Establece el peso de la pieza (int).
     *
     * @param peso: El peso de la pieza a establecer.
     */
	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	/**
     * public void interactuar(): Interactúa con la pieza, intentando levantarla con los Pikinim del jugador.
     *
     * @param pikinimA: El Pikinim de tipo Amarillo (Pikinim).
     * @param pikinimC: El Pikinim de tipo Cyan (Pikinim).
     * @param pikinimM: El Pikinim de tipo Magenta (Pikinim).
     */
	public void interactuar(Pikinim pikinimA, Pikinim pikinimC, Pikinim pikinimM) {
		if (!isCompletada()) {
			levantar(pikinimA, pikinimC, pikinimM);
		}
		else {
            System.out.println("No queda nada que hacer aquí.");
        }
    }
	
	/**
     * public void levantar(): Intenta levantar la pieza utilizando los Pikinim del jugador.
     *
     * @param pikinimA: El Pikinim de tipo Amarillo (Pikinim).
     * @param pikinimC: El Pikinim de tipo Cyan (Pikinim).
     * @param pikinimM: El Pikinim de tipo Magenta (Pikinim).
     */
	public void levantar(Pikinim pikinimA, Pikinim pikinimC, Pikinim pikinimM) {
		int sumaCapacidades = (pikinimA.getCantidad() * pikinimA.getCapacidad()) +
                (pikinimC.getCantidad() * pikinimC.getCapacidad()) +
                (pikinimM.getCantidad() * pikinimM.getCapacidad());
		
		if (sumaCapacidades >= peso) {
			setCompletada(true);
            System.out.println("Has recuperado una pieza de la nave.");
            cantidadRecogida++;
            peso = 0;
		}
		else {
			System.out.println("No tienes suficiente capacidad para levantar la pieza.");
		}
    }
		
	
}
