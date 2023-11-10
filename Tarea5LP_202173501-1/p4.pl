sigue(p1, p2).
sigue(p2, p3).
sigue(p3, p4).
sigue(p4, p5).
sigue(p5, p6).
sigue(p6, p7).
sigue(p7, p8).
sigue(p8, p1).
sigue(p7, p17).
sigue(p17, p18).
sigue(p18, p19).
sigue(p1, p15).
sigue(p15, p16).
sigue(p16, p20).
sigue(p20, p21).
sigue(p21, p22).
sigue(p1, p9).
sigue(p9, p10).
sigue(p10, p11).
sigue(p11, p12).
sigue(p12, p13).
sigue(p13, p14).

principal(Nodo, R) :-
    camino(Nodo, p1, [Nodo], Camino),
    reverse(Camino, CaminoInverso),
    writeln(CaminoInverso),
    (member(p8, Camino) -> R = "Es de la rama principal" ; R = "No es de la rama principal").

% Regla para encontrar un camino en el grafo
camino(Nodo, Nodo, Camino, Camino).
camino(NodoInicial, NodoFinal, CaminoVisitado, Camino) :-
    sigue(NodoInicial, Nodo),
    \+ member(Nodo, CaminoVisitado),
    camino(Nodo, NodoFinal, [Nodo|CaminoVisitado], Camino).
