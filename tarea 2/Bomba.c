#include "Tierra.h"
#include "Tablero.h"
#include "Bomba.h"

void TryExplotar(int fila, int columna){
    Bomba* b = (Bomba*)tablero[fila][columna];
    if (b != NULL) {
        b->contador_turnos--;
        if (b->contador_turnos == 0) {
            b->explotar(fila, columna);
        }
    }
}

void BorrarBomba(int fila, int columna){
    Bomba* b = (Bomba*)tablero[fila][columna];
    if (b != NULL) {
        tablero[fila][columna] = b->tierra_debajo; // Devolver la Tierra al tablero
        free(b); // Liberar la memoria de la Bomba
    }
}

void ExplosionPunto(int fila, int columna){
    Tierra* tierraDebajo = ((Bomba*)tablero[fila][columna])->tierra_debajo;
    tierraDebajo->vida -= 3;

    if (tierraDebajo->vida < 0) {
        tierraDebajo->vida = 0;
    }

    ((Bomba*)tablero[fila][columna])->contador_turnos = 0; // Establecer contador_turnos a 0 para que explote inmediatamente
    BorrarBomba(fila, columna); // Borramos la bomba ya que explotó
}


void ExplosionX(int fila, int columna){
    Tierra* tierraDebajo = ((Bomba*)tablero[fila][columna])->tierra_debajo;
    for (int i = fila - 1; i <= fila + 1; i++) {
        for (int j = columna - 1; j <= columna + 1; j++) {
            if (i >= 0 && i < dimension && j >= 0 && j < dimension) {
                if (i == fila || j == columna) {
                    Tierra* tierra = (Tierra*)tablero[i][j];
                    if (tierra != NULL) {
                        tierra->vida -= 1;
                        if (tierra->vida < 0) {
                            tierra->vida = 0;
                        }
                    }
                }
            }
        }
    }

    ((Bomba*)tablero[fila][columna])->contador_turnos = 0; // Establecer contador_turnos a 0 para que explote inmediatamente
    BorrarBomba(fila, columna); 
}
