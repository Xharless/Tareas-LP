%Defincion de la cerradura
cerradura(1, 4, 5, 1, 0).

%Verifica la coincidencia entre 2 numeros
%Entradas:
%       -X: primer numero
%       -Y: segundo numero
%Salida:
%       -C: 1 si X  Y son iguales, en caso contrario es 0
coincidencia(X, Y, C) :- (X = Y -> C = 1 ; C = 0).

% Verifica la cantidad de numeros que coinciden entre una combinacion y
% la combinacion correcta
%
% Entradas:
%        -D1, D2, D3, D4, D5: Digitos de la combinacion ingresada
% Salida:
%        -Resultado: Indica si la combinacion es correcta o la
%        cantidadde digitos que estan correctos
verificar(D1, D2, D3, D4, D5, Resultado) :-
    cerradura(C1, C2, C3, C4, C5),
    coincidencia(D1, C1, C1_),
    coincidencia(D2, C2, C2_),
    coincidencia(D3, C3, C3_),
    coincidencia(D4, C4, C4_),
    coincidencia(D5, C5, C5_),
    R is C1_ + C2_ + C3_ + C4_ + C5_,
    (D1 = C1, D2 = C2, D3 = C3, D4 = C4, D5 = C5 -> Resultado = "Contraseña descubierta"; Resultado = R).
