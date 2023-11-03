
#include "Tierra.h"
#include "Tablero.h"
#include "Bomba.h"
#include <stdlib.h>


/*
void TryExplotar: Intenta explotar una bomba en una posicion del tablero
    Paramertos:
        fila (int): La fila en la que se encuentra la bomba
        columna (int): La columna en la que se encuentra la bomba
    Retorno:
*/
void TryExplotar(int fila, int columna){
    Bomba* b = (Bomba*)tablero[fila][columna];
    if (b != NULL) {
        b->contador_turnos--;
        if (b->contador_turnos == 0) {
            b->explotar(fila, columna);
        }
    }   
}
//------------------------------------------------------------------------

/*
void BorrarBomba: Borrar una bomba del tablero en una posicion especifica
    Paramertos:
        fila (int): La fila en la que se encuentra la bomba
        columna (int): La columna en la que se encuentra la bomba
    Retorno:
*/

void BorrarBomba(int fila, int columna){
    if (fila >= 0 && fila < dimension && columna >= 0 && columna < dimension) {
        Bomba* b = (Bomba*)tablero[fila][columna];
        if (b != NULL) {
            free(b); 
            tablero[fila][columna] = NULL;
        }
    }
}

//------------------------------------------------------------------------

/*
void ExplosionPunto: Realiza una explosion en forma de punto en una posicion del tablero, afectando la tierra debajo de la bomba
    Paramertos:
        fila (int): La fila en la que se encuentra la bomba
        columna (int): La columna en la que se encuentra la bomba
    Retorno:
*/

void ExplosionPunto(int fila, int columna){
    if (fila >= 0 && fila <dimension && columna>= 0 && columna<dimension){
        Tierra* tierra_debajo = (Tierra*)tablero[fila][columna];
        if (tierra_debajo != NULL){
            tierra_debajo->vida -=3;
            if (tierra_debajo->vida < 0){
                tierra_debajo->vida = 0;
            }
        }
    }
}

//------------------------------------------------------------------------

/*
void ExplosionX: Realiza una explosion en forma de X en una posicion del tablero, afectando la tierra a los lados de la bomba
    Paramertos:
        fila (int): La fila en la que se encuentra la bomba
        columna (int): La columna en la que se encuentra la bomba
    Retorno:
*/

void ExplosionX(int fila, int columna){
    //Tierra* tierraDebajo = ((Bomba*)tablero[fila][columna])->tierra_debajo;
    for (int i = fila - 1; i <= fila + 1; i++) {
        for (int j = columna - 1; j <= columna + 1; j++) {
            if (i >= 0 && i < dimension && j >= 0 && j < dimension) {
                if (i == fila || j == columna) {
                    Tierra* tierra = (Tierra*)tablero[i][j];
                    if (tierra != NULL) {
                        tierra->vida -= 1;
                        if (tierra->vida <= 0) {
                            tierra->vida = 0;
                        }
                    }
                }
            }
        }
    }
    ((Bomba*)tablero[fila][columna])->contador_turnos = 0; 
    BorrarBomba(fila, columna);
}