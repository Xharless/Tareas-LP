#lang scheme
; ; Función para verificar si la cantidad de elementos en una lista es igual a un número dado
; ;
; ; cantidad : Número de elementos que se espera que tenga la lista
; ; lista : Lista de elementos a verificar
(define (checkear cantidad lista)
  (if (= cantidad 0)
      (null? lista)
      (if (null? lista)
          #f
          (checkear (- cantidad 1) (cdr lista)))))
