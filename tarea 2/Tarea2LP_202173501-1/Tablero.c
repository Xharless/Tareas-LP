#include "Tierra.h"
#include "Tablero.h"
#include "Bomba.h"
#include <stddef.h>
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void*** tablero;
int dimension;

/*
void IniciarTablero: Inicia el tablero con tierra y tesoros
    Paramertos:
        n (int): El tamaño del tablero n x n
    Retorno:
*/

void IniciarTablero(int n){
    srand(time(NULL));
    dimension = n;
    tablero = (void***)malloc(n * sizeof(void**));
    for (int i = 0; i < n; i++) {
        tablero[i] = (void**)malloc(n * sizeof(void*));
        for (int j = 0; j < n; j++) {
            tablero[i][j] = (Tierra*)malloc(sizeof(Bomba));
            ((Tierra*)tablero[i][j])->vida = rand() % 3 + 1;
            ((Tierra*)tablero[i][j])->es_tesoro = (rand() % 20 == 0);
        }
    }
}

//------------------------------------------------------------------------

/*
void PasarTurno: Hace pasar el turno, intentando explotar todas las bombas del tablero
    Paramertos:
        
    Retorno:
*/

void PasarTurno(){
    for (int i = 0; i < dimension; i++) {
        for (int j = 0; j < dimension; j++) {
            Bomba* b = (Bomba*)tablero[i][j];
            if (b != NULL) {
                TryExplotar(i,j);
            }
        }
    }
}

//------------------------------------------------------------------------

/*
void ColocarBomba: Coloca una bomba en una posicion especifica
    Paramertos:
        b (Bomba*): Un puntero a la bomba que se va a colocar.
        fila (int): La fila en la que se colocara la bomba
        columna (int): La columna en la que se colocara la bomba
    Retorno:
*/

void ColocarBomba(Bomba* b, int fila, int columna) {
    if (fila >= 0 && fila < dimension && columna >= 0 && columna < dimension) {
        Bomba* nueva_bomba = (Bomba*)malloc(sizeof(Bomba));
        nueva_bomba->contador_turnos = b->contador_turnos;
        nueva_bomba->explotar = b->explotar;

        Tierra* tierra_debajo = (Tierra*)tablero[fila][columna]; 
        nueva_bomba->tierra_debajo = tierra_debajo; 

        tablero[fila][columna] = nueva_bomba; 
    }
}

//------------------------------------------------------------------------

/*
void MostrarTablero: Muestra el tablero por consola
    Paramertos:

    Retorno:
*/

void MostrarTablero(){
    for (int i = 0; i < dimension; i++) {
        for (int j = 0; j < dimension; j++) {
            if (j > 0) {
                printf(" | ");
            }
            Bomba* c = (Bomba*)tablero[i][j];
            if (c!=NULL){
                if ((c->explotar == ExplosionPunto) || (c->explotar == ExplosionX)){
                    printf("o");
                } else {
                    printf("%d", ((Tierra*)tablero[i][j])->vida);
                }
            }         
                
            
        }
        printf("\n");
    }
}

//------------------------------------------------------------------------

/*
void MostrarBombas: Muestra la informacion sobre las bombas que estan colocadas en el mapa
    Parametros:
    
    Retorno:
*/

void MostrarBombas(){
    for (int i = 0; i < dimension; i++) {
        for (int j = 0; j < dimension; j++) {
            Bomba* b = (Bomba*)tablero[i][j];
            if (b != NULL) {
                if ((b->explotar == ExplosionPunto) || (b->explotar == ExplosionX)){
                    printf("\nTurnos para explotar: %d\n", b->contador_turnos);
                    printf("Coordenada: %d %d\n", i + 1, j + 1); 
                    if (b->explotar == ExplosionPunto) {
                        printf("Forma Explosión: ExplosionPunto\n");
                    } else if (b->explotar == ExplosionX) {
                        printf("Forma Explosión: ExplosionX\n");
                    }
                    Tierra* tierra_debajo = (Tierra*)tablero[i][j];
                    printf("Vida de Tierra Debajo: %d\n", tierra_debajo->vida);
                    printf("\n");
                } else {
                    continue;
                }
                   
            }
        }
    }
}

//------------------------------------------------------------------------

/*
void VerTesoros: Muestra la informacion sobre los tesoros en el mapa
    Parametros:
    
    Retorno:
*/

void VerTesoros(){
    printf("\nTesoros\n");
    for (int i = 0; i < dimension; i++) {
        for (int j = 0; j < dimension; j++) {
            if (((Tierra*)tablero[i][j])->es_tesoro) {
                if (((Tierra*)tablero[i][j])->vida != 0) {
                    printf("* ");
                } else {
                    printf("%d ", ((Tierra*)tablero[i][j])->vida);
                }
            } else {
                printf("%d ", ((Tierra*)tablero[i][j])->vida);
            }
            if (j < dimension - 1) {
                printf("| ");
            }
        }
        printf("\n");
    }
}

//------------------------------------------------------------------------

/*
void BorrarTablero: Libera la memoria utilizada por el tablero y las bombas
    Parametros:
    
    Retorno:
*/

void BorrarTablero() {
    if (tablero != NULL){
        for (int i = 0; i < dimension; i++){
            for (int j = 0; j < dimension; j++){
                Bomba* b = (Bomba*)tablero[i][j];
                if (b!= NULL){
                    if ((b->explotar == ExplosionPunto) || (b->explotar == ExplosionX)){
                        free(b->tierra_debajo);
                    }
                    free(b);
                }
            }
            free(tablero[i]);
        }
        free(tablero);
        tablero = NULL;
    }
}