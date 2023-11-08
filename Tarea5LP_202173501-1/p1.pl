cifrado([0, 0], a).
cifrado([0, 1], g).
cifrado([1, 0], c).
cifrado([1, 1], t).

descifrar([], []).
descifrar([B1, B2 | RestoMensaje], [Base | RestoRespuesta]) :-
    cifrado([B1, B2], Base),
    descifrar(RestoMensaje, RestoRespuesta).

