%Definiciones de las combinaciones
cifrado([0, 0], a).
cifrado([0, 1], g).
cifrado([1, 0], c).
cifrado([1, 1], t).


%Funcion para descifrar una lista de combinaciones de bits
%Entradas:
%        -Lista de combinaciones de bits: [B1, B2, B3,...]
%
%Salida:
%        -Lista de letras descifradas: [Letra1, Letra2, Letra3, ...]
%
descifrar([], []).
descifrar([B1, B2 | RestoMensaje], [Base | RestoRespuesta]) :-
    cifrado([B1, B2], Base),
    descifrar(RestoMensaje, RestoRespuesta).

