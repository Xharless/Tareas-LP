% Definición de la cerradura
cerradura(1, 4, 5, 1, 0).

% Regla para calcular la coincidencia
coincidencia(X, Y, C) :- (X = Y -> C = 1 ; C = 0).

% Regla para verificar la combinación
verificar(D1, D2, D3, D4, D5, Resultado) :-
    cerradura(C1, C2, C3, C4, C5),
    coincidencia(D1, C1, C1_),
    coincidencia(D2, C2, C2_),
    coincidencia(D3, C3, C3_),
    coincidencia(D4, C4, C4_),
    coincidencia(D5, C5, C5_),
    R is C1_ + C2_ + C3_ + C4_ + C5_,
    (D1 = C1, D2 = C2, D3 = C3, D4 = C4, D5 = C5 -> Resultado = "Contraseña descubierta"; Resultado = R).
