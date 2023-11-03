
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "Tierra.h"
#include "Tablero.h"
#include "Bomba.h"


int main(int argc, char const *argv[]){
    (void)argc;
    (void)argv;
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
    int turno = 1;
    IniciarTablero(tamano);
    printf("Empezando el juego... ¡Listo!\n");
    printf("\nTablero (Turno %d)\n",turno);
    MostrarTablero();
    turno++;
    while (1){
        int accion;
        printf("\nSeleccione una opcion:\n");
        printf("1. Colocar Bomba\n");
        printf("2. Mostrar Bomba\n");
        printf("3. Mostrar Tesoro\n");
        printf("4. Salir\n");
        printf("Ingrese su opcion: ");
        scanf("%d", &accion);

        if (accion == 1){
            int fila, columna;
            char forma_explosion;
            printf("Indique coordenadas de la bomba\n");
            printf("Fila: ");
            scanf("%d", &fila);
            printf("Columna: ");
            scanf("%d", &columna);
            getchar();
            printf("Seleccione tipo de explosion:\n");
            printf("1. En punto\n");
            printf("2. En X\n");
            printf("Ingrese su opcion: ");
            scanf("%c", &forma_explosion);

            Bomba nueva_bomba;
            nueva_bomba.contador_turnos = 1;
            if(forma_explosion == '1'){
                nueva_bomba.explotar = ExplosionPunto;
            } else if (forma_explosion == '2'){
                nueva_bomba.explotar = ExplosionX;
            } else {
                printf("Opcion no valida");
                continue;
            }

            ColocarBomba(&nueva_bomba,fila-1,columna-1);
            printf("\nTablero (Turno %d)\n",turno);
            MostrarTablero();
            turno++;

        } else if (accion == 2){
            MostrarBombas();
        }else if (accion == 3){
            VerTesoros();
        } else if (accion == 4){
            BorrarTablero();
            break;
        } else {
            printf("Opcion no valida");
            continue;
        }
    }
    
    printf("Juego terminado. ¡Hasta luego!\n");
    return 0;
}
