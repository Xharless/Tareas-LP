%Relaciones en el grafico
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

%Determina si un nodo pertenece a la rama principal del grafo
%Entrada:
%      - Nodo: Nodo que se quiere verificar
%Salida:
%      - R: Resultado de el nodo, si es que pertenece a la rama
%      principal o no
principal(Nodo, R) :-
    camino(Nodo, p1, [Nodo], Camino),
    reverse(Camino, CaminoInverso),
    writeln(CaminoInverso),
    (member(p8, Camino) -> R = "Es de la rama principal" ; R = "No es de la rama principal").

%Encuentra el camino del grafo
%Entrada:
%       -NodoInicial:Nodo de inicio
%       -NodoFinal: Nodo de destino
%       -CaminoVisitado: Lista de nodos visitados hasta el momento
%Salida:
%       -Camino: Lista que representa el camino encontrado
camino(Nodo, Nodo, Camino, Camino).
camino(NodoInicial, NodoFinal, CaminoVisitado, Camino) :-
    sigue(NodoInicial, Nodo),
    \+ member(Nodo, CaminoVisitado),
    camino(Nodo, NodoFinal, [Nodo|CaminoVisitado], Camino).
