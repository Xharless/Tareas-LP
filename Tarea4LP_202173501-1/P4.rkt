#lang scheme
; ; Esta función toma un ingrediente y una receta como parámetros y verifica si el ingrediente está en la receta.
; ;
; ; ingrediente : Es el ingrediente que se va a buscar en la receta.
; ; receta : Es la receta en la que se va a buscar el ingrediente.
(define (ingrediente-en-receta? ingrediente receta)
  (cond ((null? receta) #f)
        ((eqv? (car ingrediente) (car receta)) #t)
        (else (ingrediente-en-receta? ingrediente (cdr receta)))))


; ; Esta función toma un ingrediente y una lista de recetas como parámetros y devuelve una lista de las recetas que contienen el ingrediente.
; ;
; ; ingrediente : Es el ingrediente que se va a buscar en las recetas.
; ; lista : Es la lista de recetas en las que se va a buscar el ingrediente.
(define (buscar_recetas ingrediente lista)
  (if (null? ingrediente) '() 
      (cond ((null? lista) '())
            ((ingrediente-en-receta? ingrediente (cdr (car lista)))
             (cons (car (car lista)) (buscar_recetas ingrediente (cdr lista))))
            (else (buscar_recetas ingrediente (cdr lista))))))
