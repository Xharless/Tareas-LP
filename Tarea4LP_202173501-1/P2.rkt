#lang scheme
; ; Función que aplica una operación dada a un valor dado
; ;
; ; operation : Operación a aplicar
; ; value : Valor al que se aplica la operación
(define (apply-operation operation value)
  (operation value))

; ; Función que aplica una lista de funciones a una base y devuelve los resultados en orden inverso, esta la hace por recursion de cola
; ;
; ; base : Valor base al que se aplican las funciones
; ; funciones : Lista de funciones a aplicar
(define (cantidades_cola base funciones)
  (define (cantidades-cola-helper base funciones resultado)
    (cond
      ((null? funciones) (reverse resultado))
      (else
       (cantidades-cola-helper
        base
        (cdr funciones)
        (cons (apply-operation (car funciones) base) resultado)))))
  (cantidades-cola-helper base funciones '()))

; ; Función que aplica una lista de funciones a una base y devuelve los resultados en el orden original, esta la hace por recusion simple
; ;
; ; base : Valor base al que se aplican las funciones
; ; funciones : Lista de funciones a aplicar
(define (cantidades_simple base funciones)
  (cond
    ((null? funciones) '())
    (else
     (cons (apply-operation (car funciones) base)
           (cantidades_simple base (cdr funciones))))))

