package tarealp;
import java.util.Scanner;


public class Pildora extends Zona{
	private int cantidad;
	private Scanner scanner;
	
	/**
     * public Pildora(): Constructor de la clase Pildora.
     *
     * @param cantidad: La cantidad de aumento en la capacidad de los Pikinim (int).
     * @param scanner: Un objeto Scanner para recibir la entrada del jugador (Scanner).
     */
	public Pildora(int cantidad, Scanner scanner) {
		this.setCantidad(cantidad);
		this.scanner = scanner;
	}
	
	/**
     * public int getCantidad(): Obtiene la cantidad de aumento en la capacidad de los Pikinim.
     *
     * @return: La cantidad de aumento (int).
     */
	public int getCantidad() {
		return cantidad;
	}
	
	/**
     * public void setCantidad(): Establece la cantidad de aumento en la capacidad de los Pikinim.
     *
     * @param cantidad: La cantidad de aumento a establecer (int).
     */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
	/**
     * public void interactuar(): Interactúa con la zona de la Pildora, lo que permite al jugador aumentar la capacidad de uno de sus Pikinim.
     *
     * @param pikinimA: El Pikinim de tipo Amarillo (Pikinim).
     * @param pikinimC: El Pikinim de tipo Cyan (Pikinim).
     * @param pikinimM: El Pikinim de tipo Magenta (Pikinim).
     */
	public void interactuar(Pikinim pikinimA, Pikinim pikinimC, Pikinim pikinimM) {
		
        if(!isCompletada()) {
        	System.out.println("Vaya... Creo que has pisado algo misterioso que ayuda al aumento de tus pikinim");
        	System.out.println("¿A quien quieres aumentar su capacidad?: ");
            System.out.println("1. Amarillo ");
            System.out.println("2. Magenta ");
            System.out.println("3. Cyan ");
            System.out.print("Elige tu opcion: ");
            int opcion = scanner.nextInt();
            String color = "";
        	if(opcion == 1) {
            	pikinimA.multiplicar(cantidad);
            	color = "Amarillo";
            }
        	else if(opcion == 3) {
            	pikinimC.multiplicar(cantidad);
            	color = "Cyan";
            }
        	else if(opcion == 2) {
            	pikinimM.multiplicar(cantidad);
            	color = "Magenta";
            }
        	setCompletada(true);
        	System.out.println("Has aumentado la cantidad de Pikinim " + color);

        }
        else {
        	System.out.println("No queda nada que hacer aqui.");
        }

    }
}