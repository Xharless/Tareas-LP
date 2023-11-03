#ifndef TABLERO_H
#define TABLERO_H
#include <stddef.h>
#include "Bomba.h"

void*** tablero;
int dimension; 

void IniciarTablero(int n);
void PasarTurno();
void ColocarBomba(Bomba* b, int fila, int columna);
void MostrarTablero();
void MostrarBombas();
void VerTesoros();
void BorrarTablero();
#endif