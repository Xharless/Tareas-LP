#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "Tierra.h"
#include "Tablero.h"
#include "Bomba.h"

int main(int argc, char const *argv[]){
    srand(time(NULL));
    int opcion;
    printf("Seleccione el tamaño del tablero:\n");
    printf("1. 7x7\n");
    printf("2. 10x10\n");
    printf("3. 12x12\n");
    printf("Ingrese el número de la opción: ");
    scanf("%d", &opcion);
    
    int tamano;
    switch (opcion) {
        case 1:
            tamano = 7;
            break;
        case 2:
            tamano = 10;
            break;
        case 3:
            tamano = 12;
            break;
        default:
            printf("Opción no válida\n");
            return 1;
    }

    IniciarTablero(tamano);

    return 0;
}

/* EJEMPLOS DE RANDOM PARA FACILITAR SU USO.
*
*   srand(time(0)); // Setea la seed del random.
*   int ejemplo_vida = (rand() % 3) + 1; // Obtiene al azar la vida de Tierra a asignar.
*/