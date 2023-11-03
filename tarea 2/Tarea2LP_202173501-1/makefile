CC = gcc
CFLAGS = -Wall -Wextra -g

TreasureFinder: TreasureFinder.o Tablero.o Bomba.o
TreasureFinder.o: TreasureFinder.c Tablero.h Bomba.h
Tablero.o: Tablero.c Tablero.h
Bomba.o: Bomba.c Bomba.h

run: TreasureFinder
	./TreasureFinder

clean:
	rm -f TreasureFinder *.o
