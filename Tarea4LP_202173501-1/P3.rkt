#lang scheme
; ; Esta función toma una lista como parámetro y devuelve la cantidad de elementos en la lista.
; ;
; ; lista : Es la lista de elementos que se van a contar.
(define (contar lista)
  (if (null? lista)
      0
      (+ 1 (contar (cdr lista)))))

; ; Esta función toma un stock como parámetro y devuelve una nueva lista.
; ;
; ; stock : Es la lista de elementos que se van a procesar para armar la nueva lista.
(define (armar_lista stock)
  (filter (lambda (x) (not (null? x)))
          (map (lambda (item)
                 (let ((cant_necesaria (car item))
                       (lista (cadr item)))
                   (let ((cant_actual (contar lista)))
                     (if (> cant_necesaria cant_actual)
                         (list (- cant_necesaria cant_actual) (car lista))
                         '()))))
               stock)))
