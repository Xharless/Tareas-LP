package tarealp;

import java.util.Random;
import java.util.Scanner;

public class Enemigo extends Zona implements ILevantable {
    private int vida;
    private int peso;
    private int ataque;
	private Scanner scanner;

	/**
     * public Enemigo(): Constructor de la clase Enemigo.
     * 
     * @param vida: La vida del enemigo (int)
     * @param peso: El peso del enemigo (int)
     * @param ataque: El ataque del enemigo (int)
     * @param scanner: El objeto Scanner para entrada de usuario (Scanner)
     */
    public Enemigo(int vida, int peso, int ataque, Scanner scanner) {
        this.setVida(vida);
        this.setPeso(peso);
        this.setAtaque(ataque);
		this.scanner = scanner;

    }
    
    /**
     * public int getVida(): Obtiene la vida del enemigo.
     * 
     * @return: La vida del enemigo (int)
     */
    public int getVida() {
		return vida;
	}
    
    /**
     * public void setVida(): Establece la vida del enemigo.
     * 
     * @param vida: La nueva vida del enemigo (int)
     */
	public void setVida(int vida) {
		this.vida = vida;
	}

	/**
	 * public int getPeso(): Obtiene el peso del enemigo.
	 * 
	 * @return: El peso del enemigo (int)
	 */
	public int getPeso() {
		return peso;
	}
	
	/**
	 * public void setPeso(): Establece el peso del enemigo.
	 * 
	 * @param peso: El nuevo peso del enemigo (int)
	 */
	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	/**
	 * public int getAtaque(): Obtiene el ataque del enemigo.
	 * 
	 * @return: El ataque del enemigo (int)
	 */
	public int getAtaque() {
		return ataque;
	}
	
	/**
	 * public void setAtaque(): Establece el ataque del enemigo.
	 * 
	 * @param ataque: El nuevo ataque del enemigo (int)
	 */
	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}
	
	/**
     * public void interactuar(): Realiza una interacción con el enemigo.
     * 
     * @param pikinimA: El Pikinim de tipo Amarillo (Pikinim)
     * @param pikinimC: El Pikinim de tipo Cyan (Pikinim)
     * @param pikinimM: El Pikinim de tipo Magenta (Pikinim)
     */
	public void interactuar(Pikinim pikinimA, Pikinim pikinimC, Pikinim pikinimM) {
		if (!isCompletada()) {
			boolean derrotado = pelear(pikinimA, pikinimC, pikinimM);
	        if (derrotado) {
	            levantar(pikinimA, pikinimC, pikinimM);
	            multiplicarPeso(pikinimA, pikinimC, pikinimM);
	            System.out.println("Se ha derrotado al enemigo.");
	        }	
	        else {
	            System.out.println("No se ha podido derrotar al enemigo.");

	        }
		}
		else {
            System.out.println("No queda nada que hacer aqui.");
        }
 
    }
    
	/**
     * public void levantar(): Realiza el levantamiento del enemigo si la capacidad de los Pikinim es suficiente.
     * 
     * @param pikinimA: El Pikinim de tipo Amarillo (Pikinim)
     * @param pikinimC: El Pikinim de tipo Cyan (Pikinim)
     * @param pikinimM: El Pikinim de tipo Magenta (Pikinim)
     */
	public void levantar(Pikinim pikinimA, Pikinim pikinimC, Pikinim pikinimM) {
        int sumaCapacidades = (pikinimA.getCantidad() * pikinimA.getCapacidad()) +
                             (pikinimC.getCantidad() * pikinimC.getCapacidad()) +
                             (pikinimM.getCantidad() * pikinimM.getCapacidad());

        if (sumaCapacidades >= peso) {
            setCompletada(true);
            System.out.println("¡Lo has derrotado!.");

        }
		else {
			System.out.println("No tienes suficiente capacidad para levantar al enemigo.");
		}
        
    }
	
	/**
     * private void multiplicarPeso(): Multiplica la capacidad de un tipo de Pikinim después de derrotar al enemigo.
     * 
     * @param pikinimA: El Pikinim de tipo Amarillo (Pikinim)
     * @param pikinimC: El Pikinim de tipo Cyan (Pikinim)
     * @param pikinimM: El Pikinim de tipo Magenta (Pikinim)
     */
	private void multiplicarPeso(Pikinim pikinimA, Pikinim pikinimC, Pikinim pikinimM) {
        System.out.println("¿A quien quieres aumentar su capacidad?: ");
        System.out.println("1. Amarillo ");
        System.out.println("2. Magenta ");
        System.out.println("3. Cyan ");
        System.out.print("Elige tu opcion: ");
        int opcion = scanner.nextInt();
        String color = "";
        if(opcion == 1) {
        	int cantidad = pikinimA.getCantidad();
            int capacidad = pikinimA.getCapacidad();
            pikinimA.multiplicar(cantidad * capacidad);
            color = "Amarillo";
        } else if(opcion == 3) {
        	int cantidad = pikinimC.getCantidad();
            int capacidad = pikinimC.getCapacidad();
            pikinimC.multiplicar(cantidad * capacidad);
            color = "Cyan";
        } else if(opcion == 2) {
        	int cantidad = pikinimM.getCantidad();
            int capacidad = pikinimM.getCapacidad();
            pikinimM.multiplicar(cantidad * capacidad);
            color = "Magenta";
        }
        System.out.println("Buena opcion");
    	System.out.println("Has aumentado la capacidad de Pikinim " + color);

    }
	
	/**
	 * public boolean pelear(): Inicia una pelea entre el enemigo y los Pikinim del jugador.
	 * 
	 * @param pikinimA: El Pikinim de tipo Amarillo (Pikinim)
	 * @param pikinimC: El Pikinim de tipo Cyan (Pikinim)
	 * @param pikinimM: El Pikinim de tipo Magenta (Pikinim)
	 * 
	 * @return: True si el enemigo fue derrotado, false en caso contrario (boolean)
	 */
    public boolean pelear(Pikinim pikinimA, Pikinim pikinimC, Pikinim pikinimM) {
    	System.out.println("\n¡VAMOS QUE COMIENCE LA PELEA!, BUENA SUERTE");
    	int sumaAtaque = (pikinimA.getCantidad() * pikinimA.getAtaque()) +
                         (pikinimC.getCantidad() * pikinimC.getAtaque()) +
                         (pikinimM.getCantidad() * pikinimM.getAtaque());

        while (vida >= 0 && !(pikinimA.getCantidad() == 0 && pikinimC.getCantidad() == 0 && pikinimM.getCantidad() == 0)) {
            vida -= sumaAtaque;
            atacarAlAzar(pikinimA, pikinimC, pikinimM);
        }
        if (vida <= 0) {
        	return true;
        }
        else {
        	return false;
        }
    }
    
    /**
     * private void atacarAlAzar(): Realiza un ataque al azar contra uno de los tipos de Pikinim.
     * 
     * @param pikinimA: El Pikinim de tipo Amarillo (Pikinim)
     * @param pikinimC: El Pikinim de tipo Cyan (Pikinim)
     * @param pikinimM: El Pikinim de tipo Magenta (Pikinim)
     */
    private void atacarAlAzar(Pikinim pikinimA, Pikinim pikinimC, Pikinim pikinimM) {
        Random random = new Random();
        int numPikinim = random.nextInt(3);
        if (numPikinim == 0) {
        	if (pikinimA.getCantidad() > 0) {
        		pikinimA.disminuir(ataque);
        		System.out.printf("%n¡Oh no... El enemigo ha destruido " + ataque + " de tus Pikinims Amarillos%n");
            	System.out.println("Has quedado con " + pikinimA.getCantidad() + " Pikinims Amarillos\n");

        	}
        	else {
        		pikinimA.setCantidad(0);
        	}
        } 
        else if (numPikinim == 1) {
        	if (pikinimC.getCantidad() > 0) {
        		pikinimC.disminuir(ataque);
        		System.out.printf("%n¡Oh no... El enemigo ha destruido " + ataque + " de tus Pikinims Cyan%n");
            	System.out.println("Has quedado con " + pikinimC.getCantidad() + " Pikinims Cyanes\n");

        	}
        	else {
        		pikinimC.setCantidad(0);
        	}
        } 
        else {
        	if (pikinimM.getCantidad() > 0) {
        		pikinimM.disminuir(ataque);
        		System.out.printf("%n¡Oh no... El enemigo ha destruido " + ataque + " de tus Pikinims Magentas%n");

            	System.out.println("Has quedado con " + pikinimM.getCantidad() + " Pikinims Magentas\n");

        	}
        	else {
        		pikinimM.setCantidad(0);
        	}
        }
    }
    
}

