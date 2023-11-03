package tarealp;

public abstract class Zona {
	private boolean completada;
	
	/**
     * public Zona(): Constructor de la clase Zona.  Inicializa el estado de la zona como no completada al crear una nueva instancia.
     */
	public Zona() {
        this.completada = false;
    }
	
	/**
     *public boolean isCompletada(): Verifica si la zona ha sido completada.
     *
     * @return: True si la zona ha sido completada, false en caso contrario (boolean).
     */
	public boolean isCompletada() {
		return completada;
	}
	
	 /**
     * public void setCompletada(): Establece el estado de completada de la zona.
     *
     * @param completada: True si se completa la zona, false en caso contrario (boolean).
     */
	public void setCompletada(boolean completada) {
		this.completada = completada;
	}
	
	 /**
     * public abstract void interactuar(): Método abstracto para interactuar con la zona. 
     *
     * @param pikinimA: El Pikinim de tipo Amarillo (Pikinim).
     * @param pikinimC: El Pikinim de tipo Cyan (Pikinim).
     * @param pikinimM: El Pikinim de tipo Magenta (Pikinim).
     */
    public abstract void interactuar(Pikinim pikinimA, Pikinim pikinimC, Pikinim pikinimM);

}

interface ILevantable {
	
	/**
     * void levantar(): Método para levantar un objeto y realizar una acción específica.
     *
     * @param pikinimA: El Pikinim de tipo Amarillo (Pikinim).
     * @param pikinimC: El Pikinim de tipo Cyan (Pikinim).
     * @param pikinimM: El Pikinim de tipo Magenta (Pikinim).
     */
    void levantar(Pikinim pikinimA, Pikinim pikinimC, Pikinim pikinimM);
}