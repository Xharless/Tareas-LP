% Definición de la cerradura
cerradura(1, 4, 5, 1, 0).

% Regla para calcular la diferencia absoluta
diferencia(X, Y, D) :- D is abs(X - Y).

% Regla para verificar la combinación
verificar(X1, X2, X3, X4, X5, R) :-
    cerradura(C1, C2, C3, C4, C5),
    diferencia(X1, C1, D1),
    diferencia(X2, C2, D2),
    diferencia(X3, C3, D3),
    diferencia(X4, C4, D4),
    diferencia(X5, C5, D5),
    E is (D1 + D2 + D3 + D4 + D5) / 5,
    (X1 = C1, X2 = C2, X3 = C3, X4 = C4, X5 = C5 -> R = "Contraseña descubierta"; (E < 1 -> R = "Cerca" ; R = "Lejos")).
