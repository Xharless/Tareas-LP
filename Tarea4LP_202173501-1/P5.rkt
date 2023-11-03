#lang scheme
; ; Esta función toma un utensilio y un árbol como parámetros y busca el utensilio en el árbol.
; ;
; ; utensilio : Es el utensilio que se va a buscar en el árbol.
; ; arbol : Es el árbol en el que se va a buscar el utensilio.
(define buscar_utensilio
  (lambda (utensilio arbol)
    (cond ((null? arbol) '"No está.")
          ((eq? utensilio (car arbol)) (list utensilio))
          ((not (null? (cadr arbol)))
           (cons (car arbol) (buscar_utensilio utensilio (cadr arbol))))
          ((not (null? (caddr arbol)))
           (cons (car arbol) (buscar_utensilio utensilio (caddr arbol))))
          (else '()))))
