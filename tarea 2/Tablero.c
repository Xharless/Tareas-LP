#include "Tierra.h"
#include "Tablero.h"
#include "Bomba.h"
#include <stddef.h>

void IniciarTablero(int n){
    srand(time(NULL));
    dimension = n;

    tablero = (void***)malloc(n * sizeof(void**));
    for (int i = 0; i < n; i++) {
        tablero[i] = (void**)malloc(n * sizeof(void*));
        for (int j = 0; j < n; j++) {
            tablero[i][j] = (Tierra*)malloc(sizeof(Tierra));
            ((Tierra*)tablero[i][j])->vida = rand() % 3 + 1;
            ((Tierra*)tablero[i][j])->es_tesoro = (rand() % 20 == 0);
        }
    }
}




void PasarTurno(){
    for (int i = 0; i < dimension; i++) {
        for (int j = 0; j < dimension; j++) {
            Bomba* b = (Bomba*)tablero[i][j];
            if (b != NULL) {
                b->contador_turnos--;
                if (b->contador_turnos == 0) {
                    b->explotar(i, j);
                }
            }
        }
    }
}


void ColocarBomba(Bomba* b, int fila, int columna){
    tablero[fila][columna] = b;
    b->tierra_debajo = (Tierra*)tablero[fila][columna];
}


void MostrarTablero(){
   for (int i = 0; i < dimension; i++) {
        for (int j = 0; j < dimension; j++) {
            if (((Tierra*)tablero[i][j])->vida == 0) {
                printf("* | ");
            } else {
                printf("%d | ", ((Tierra*)tablero[i][j])->vida);
            }
        }
        printf("\n");
    }
}


void MostrarBombas(){
    for (int i = 0; i < dimension; i++) {
        for (int j = 0; j < dimension; j++) {
            Bomba* b = (Bomba*)tablero[i][j];
            if (b != NULL) {
                printf("Turnos para explotar: %d\n", b->contador_turnos);
                printf("Coordenada: %d %d\n", i + 1, j + 1); // Sumamos 1 para que coincida con las coordenadas del enunciado
                if (b->explotar == ExplosionPunto) {
                    printf("Forma Explosión: ExplosionPunto\n");
                } else if (b->explotar == ExplosionX) {
                    printf("Forma Explosión: ExplosionX\n");
                }
                printf("Vida de Tierra Debajo: %d\n\n", b->tierra_debajo->vida);
            }
        }
    }
}


void VerTesoros(){
    printf("Tesoros\n");
    for (int i = 0; i < dimension; i++) {
        for (int j = 0; j < dimension; j++) {
            if (((Tierra*)tablero[i][j])->es_tesoro) {
                if (((Tierra*)tablero[i][j])->vida == 0) {
                    printf("* ");
                } else {
                    printf("%d ", ((Tierra*)tablero[i][j])->vida);
                }
            } else {
                printf("  ");
            }
            if (j < dimension - 1) {
                printf("| ");
            }
        }
        printf("\n");
        if (i < dimension - 1) {
            for (int k = 0; k < dimension; k++) {
                printf("- ");
                if (k < dimension - 1) {
                    printf("+ ");
                }
            }
            printf("\n");
        }
    }
}


void BorrarTablero(){
      for (int i = 0; i < dimension; i++) {
        for (int j = 0; j < dimension; j++) {
            free(tablero[i][j]);
        }
        free(tablero[i]);
    }
    free(tablero);
}