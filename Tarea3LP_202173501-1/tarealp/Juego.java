package tarealp;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Juego {
	
	/**
     * public static void main(): Se inicializa el mapa del juego con sus casillas, maneja el flujo del juego solicitando al usuario las acciones que quiere hacer
     * 
     * @param args: Argumentos de linea de comandos (String[])
     */
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
		Zona[] mapa = new Zona[11];
		mapa[0] = new Pieza(50);
		mapa[1] = new Enemigo(130,20,25, scanner);
		mapa[2] = new Enemigo(50,10,15, scanner);
		mapa[3] = new Pildora(25, scanner);
		mapa[4] = new Muralla(50);
		mapa[5] = new Pieza(100);
		mapa[6] = new Enemigo(45,8,10, scanner);
		mapa[7] = new Pieza(35);
		mapa[8] = new Pildora(15, scanner);
		mapa[9] = new Enemigo(75,15,20, scanner);
		mapa[10] = new Muralla(150);
		
		int cant_Max_piezas = 3;
		
		Pikinim PikinimA = new Amarillo();
		Pikinim PikinimC = new Cyan();
		Pikinim PikinimM = new Magenta();
		
		int posicionJugador = 5;
		
		PikinimA.setCantidad(10);
		PikinimC.setCantidad(10);
		PikinimM.setCantidad(10);
		int eleccion = 0;
		boolean ganar = false;
		boolean perder = false;
		
		for(int turno = 1; turno <= 30; turno++) {
			int cantidadPiezas = Pieza.getCantidadPiezas();
            if (cantidadPiezas == cant_Max_piezas) {
            	System.out.println("¡HAS GANADO! Has recuperado todas las piezas de la nave :D ");
            	ganar = true;
            	break;	
            }
            
            if (PikinimC.getCantidad()<=0 && PikinimA.getCantidad()<=0 && PikinimM.getCantidad()<=0) {
				System.out.println("¡HAS PERDIDO! Lo siento pero has perdido todos tus pikinim :c ");
				perder = true;
				break;
            }
            
			Zona zonaActual = mapa[posicionJugador];
			System.out.printf("%n-------------------------------------------%n");
			if (PikinimC.getCantidad()<=0) {
				PikinimC.setCantidad(0);
			}
			if (PikinimA.getCantidad()<=0) {
				PikinimA.setCantidad(0);
			}
			if (PikinimM.getCantidad()<=0) {
				PikinimM.setCantidad(0);
			}
			
			
			
			System.out.printf("Turno %s (Cyan - %d, Amarillo - %s, Magenta - %d)%n", turno, PikinimC.getCantidad(), PikinimA.getCantidad(), PikinimM.getCantidad());
			if(zonaActual instanceof Pieza) {
				Pieza pieza = (Pieza) zonaActual;
				if (pieza.getPeso()<=0) {
					System.out.printf("Zona actual: %s (Ya recogiste esta pieza...)%n", mapa[posicionJugador].getClass().getSimpleName());
				} else {
					System.out.printf("Zona actual: %s (peso - %d)%n", mapa[posicionJugador].getClass().getSimpleName(), pieza.getPeso());
				}
			} else if (zonaActual instanceof Muralla) {
				Muralla muralla = (Muralla) zonaActual;
				if (muralla.getVida() <= 0) {
					System.out.printf("Zona actual: %s (Ya derrumbaste esta muralla...)%n", mapa[posicionJugador].getClass().getSimpleName());

				} else {
					System.out.printf("Zona actual: %s (vida - %d)%n", mapa[posicionJugador].getClass().getSimpleName(), muralla.getVida());
				}
			} else if (zonaActual instanceof Enemigo) {
				System.out.printf("Zona actual: %s %n", mapa[posicionJugador].getClass().getSimpleName());

			} else if (zonaActual instanceof Pildora) {
				Pildora pildora = (Pildora) zonaActual;
				System.out.printf("Zona actual: %s (cantidad - %d)%n", mapa[posicionJugador].getClass().getSimpleName(), pildora.getCantidad());

			}
			System.out.println("Opciones:");
			Zona zonaIzquierda = (posicionJugador > 0) ? mapa[posicionJugador - 1] : null;
			Zona zonaDerecha = (posicionJugador < mapa.length - 1) ? mapa[posicionJugador + 1] : null;
			if (zonaIzquierda != null) {
				System.out.printf("1. Mover a la izquierda ( %s )%n", zonaIzquierda.getClass().getSimpleName());
			} else {
				System.out.println("Has llegado al borde del mapa");
			}
			if (zonaDerecha != null) {
				System.out.printf("2. Mover a la derecha ( %s )%n", zonaDerecha.getClass().getSimpleName());
			} else {
				System.out.println("Has llegado al borde del mapa");
			}
            System.out.println("3. Quedarse en el mismo lugar ");
            System.out.println("4. Salir(s)");
            System.out.print("Elige una acción: ");
            
            try {
            	eleccion = scanner.nextInt();
                scanner.nextLine();
                
                if (eleccion == 1 && posicionJugador >= 0) {
                	 if (zonaActual instanceof Muralla) {
                    	Muralla murallaAct = (Muralla) zonaActual;
                    	if (!murallaAct.isDestruida()) {
                    		if (murallaAct.puedeDevolverse()) {
                    			posicionJugador++;
                    		} else {
                    			posicionJugador--;
                    		}
                    		System.out.println("No puedes avanzar. La muralla no está destruida.");
                    		continue;
                    	} else {
                    		posicionJugador--;
                    	}
                	 } else {
                    	posicionJugador--;
                	 }
                } else if (eleccion == 2 && posicionJugador <= mapa.length - 1) {
                	if(zonaActual instanceof Muralla) {
                    	Muralla murallaAct = (Muralla) zonaActual;
                    	if (!murallaAct.isDestruida()) {
                    		if (murallaAct.puedeDevolverse()) {
                    			posicionJugador--;
                    		} else {
                    			posicionJugador++;
                    		}
                			System.out.println("No puedes avanzar. La muralla no está destruida.");
                    		continue;
                    	} else {
                    		posicionJugador++;
                    	}
                	} else {
                		posicionJugador++;
                	}
                } else if (eleccion == 3) {
                    continue;
                } else if (eleccion == 4) {
                	break;
                } else {
                    System.out.println("Opción no válida.");
                    continue;
                }

                mapa[posicionJugador].interactuar(PikinimA, PikinimC, PikinimM);

            } catch (InputMismatchException e) {
                System.out.println("Ingresa un número válido.");
                scanner.nextLine(); 
            }
        } 
		if (!ganar && !perder) {
			System.out.println("¡HAS PERDIDO! Lo siento pero te has quedado sin turnos :c ");
		}
		

	}

}
