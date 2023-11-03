package tarealp;

public class Muralla extends Zona {
    private int vida;
    private boolean destruida = false;
    private boolean devolverse = true;
    
    /**
     * public Muralla(): Constructor de la clase Muralla.
     *
     * @param vida: La cantidad de vida inicial de la muralla (int).
     */
    public Muralla(int vida) {
        this.vida = vida;
    }
    
    /**
     * public int getVida(): Obtiene la cantidad de vida actual de la muralla.
     *
     * @return: La cantidad de vida de la muralla (int).
     */
    public int getVida() {
		return vida;
	}
    
    /**
     * public void setVida(): Establece la cantidad de vida de la muralla.
     *
     * @param vida: La cantidad de vida a establecer (int).
     */
	public void setVida(int vida) {
		this.vida = vida;
	}
	
	/**
     * public boolean isDestruida(): Comprueba si la muralla ha sido destruida.
     *
     * @return: True si la muralla está destruida, false en caso contrario (boolean).
     */
	public boolean isDestruida() {
		return destruida;
	}
	
	/**
     * public void setDestruida(): Establece si la muralla ha sido destruida.
     *
     * @param destruida: True si la muralla está destruida, false en caso contrario (boolean).
     */
	public void setDestruida(boolean destruida) {
		this.destruida = destruida;
	}
	
	/**
     * public boolean puedeDevolverse(): Comprueba si es posible retroceder después de intentar avanzar.
     *
     * @return: True si se puede retroceder, false en caso contrario (boolean).
     */
	public boolean puedeDevolverse() {
		return devolverse;
	}
	
	/**
     * public void setPuedeDevolverse(): Establece si es posible retroceder después de intentar avanzar.
     *
     * @param puedeDevolverse: True si se puede retroceder, false en caso contrario (boolean).
     */
	public void setPuedeDevolverse(boolean puedeDevolverse) {
		this.devolverse = puedeDevolverse;
	}
	
	/**
     * public void interactuar(): Interactúa con la muralla, intentando romperla con los Pikinim del jugador.
     *
     * @param pikinimA: El Pikinim de tipo Amarillo (Pikinim).
     * @param pikinimC: El Pikinim de tipo Cyan (Pikinim).
     * @param pikinimM: El Pikinim de tipo Magenta (Pikinim).
     */
	public void interactuar(Pikinim pikinimA, Pikinim pikinimC, Pikinim pikinimM) {
		if(!isCompletada()) {
			if (tryRomper(pikinimA, pikinimC, pikinimM)) {
	            setCompletada(true);
	            setDestruida(true);
	        	System.out.println("La muralla se ha roto.");
	        	setPuedeDevolverse(false);
	        }
	        else {
	        	System.out.println("No tienes suficiente capacidad para romper el muro.");
	        	setDestruida(false);
	        	setPuedeDevolverse(true);
	        }
		}
		else {
			System.out.println("No queda nada que hacer aqui.");
		}
        
    }
	
	/**
     * public boolean tryRomper(): Intenta romper la muralla utilizando los Pikinim del jugador.
     *
     * @param pikinimA: El Pikinim de tipo Amarillo (Pikinim).
     * @param pikinimC: El Pikinim de tipo Cyan (Pikinim).
     * @param pikinimM: El Pikinim de tipo Magenta (Pikinim).
     * 
     * @return: True si la muralla ha sido destruida, false en caso contrario (boolean).
     */
	public boolean tryRomper(Pikinim pikinimA, Pikinim pikinimC, Pikinim pikinimM) {
	    if (!isDestruida()) {
	        int sumaAtaque = (pikinimA.getCantidad() * pikinimA.getAtaque()) +
	                         (pikinimC.getCantidad() * pikinimC.getAtaque()) +
	                         (pikinimM.getCantidad() * pikinimM.getAtaque());

	        vida -= sumaAtaque;
	        if (vida <= 0) {
	            return true;
	        } else {
	            return false;
	        }
	    } else {
	        return false; 
	    }
	}
}