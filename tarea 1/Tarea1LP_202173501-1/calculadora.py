import re
ANS_value = None

def verificar_division_por_cero(expresion):
    '''
    ***
    * expresion : str
    ***
    Verifica si la expresión contiene una división por cero. Retorna True si no hay división por cero y False si hay.
    '''
    partes = expresion.split()
    for i, parte in enumerate(partes):
        if parte == '//':
            if i + 1 < len(partes):
                operando_derecho = partes[i + 1]
                if operando_derecho[0] == '0':
                    return False
    return True

def parentesis(elemento):
    '''
    ***
    * elemento : str
    ***
    Verifica si hay los parentesis estan correctos. Retorna True si están bien y False si no lo está.
    '''
    buscador = re.findall(r'\(|\)', elemento)
    pila = []
    for parentesis in buscador:
        if parentesis == "(":
            pila.append("(")
        elif not pila:
            return False 
        else:
            pila.pop()
    return not pila

def espacios(elemento):
    '''
    ***
    * elemento : str
    ***
    Verifica si hay espacios a los lados de los operadores. Retorna True si esta correcto y False si no esta bien.
    '''
    signo_mas = elemento.find("+")
    signo_menos = elemento.find("-")
    signo_mul = elemento.find("*")
    signo_div = elemento.find("//")

    if signo_mas != -1:
        adelante = elemento[signo_mas+1]
        atras = elemento[signo_mas-1]
        if adelante == " " and atras == " ":
            return True
        else:
            return False
        
    elif signo_menos != -1:
        adelante = elemento[signo_menos+1]
        atras = elemento[signo_menos-1]
        if adelante == " " and atras == " ":
            return True
        else:
            return False
    
    elif signo_mul != -1:
        adelante = elemento[signo_mul+1]
        atras = elemento[signo_mul-1]
        if adelante == " " and atras == " ":
            return True
        else:
            return False
        
    elif signo_div != -1:
        adelante = elemento[signo_div+2]
        atras = elemento[signo_div-1]
        if adelante == " " and atras == " ":
            return True
        else:
            return False

def extraer_contenido_parentesis(expresion):
    '''
    ***
    * expresion : str
    ***
    Saca el contedido que se encuentra dentro de los parentesis en una expresion. Retorna una lista del contenido entre los paréntesis.
    '''
    contenido_parentesis = []
    stack = []

    for i, char in enumerate(expresion):
        if char == '(':
            stack.append(i)
        elif char == ')':
            if stack:
                start = stack.pop()
                contenido_parentesis.append(expresion[start + 1:i])
    
    return contenido_parentesis

def resolver_expresion(expresion):
    '''
    ***
    * expresion : str
    ***
    Resuelve una expresión calculando los paréntesis primero. Retorna el resultado de la expresión.
    '''
    while '(' in expresion:
        inicio = expresion.rfind('(')
        fin = expresion.find(')', inicio)
        subexpresion = expresion[inicio + 1:fin]
        resultado_subexpresion = str(calcular_expresion(subexpresion))
        expresion = expresion[:inicio] + resultado_subexpresion + expresion[fin + 1:]
    
    return calcular_expresion(expresion)

def calcular_expresion(expresion):
    '''
    ***
    * expresion : str
    ***
    Calcula el resultado de la expresion matematicamente. Retorna el resultado.
    '''
    operandos = []
    operadores = []
    prioridades = {'+': 1, '-': 1, '*': 2, '//': 2}
    i = 0
    while i < len(expresion):
        if expresion[i].isdigit() or (i < len(expresion) - 1 and expresion[i] == '-' and expresion[i + 1].isdigit()):
            j = i
            while j < len(expresion) and (expresion[j].isdigit() or expresion[j] == '.'):
                j += 1
            operandos.append(int(expresion[i:j]))
            i = j
        elif expresion[i] in ['+', '-', '*', '//']:
            while operadores and operadores[-1] != '(' and prioridades[operadores[-1]] >= prioridades[expresion[i]]:
                operador = operadores.pop()
                operando2 = operandos.pop()
                operando1 = operandos.pop()
                resultado = aplicar_operador(operando1, operador, operando2)
                operandos.append(resultado)
            operadores.append(expresion[i])
            i += 1
        elif expresion[i] == '(':
            operadores.append('(')
            i += 1
        elif expresion[i] == ')':
            while operadores[-1] != '(':
                operador = operadores.pop()
                operando2 = operandos.pop()
                operando1 = operandos.pop()
                resultado = aplicar_operador(operando1, operador, operando2)
                operandos.append(resultado)
            operadores.pop()
            i += 1
        else:
            i += 1
    while operadores:
        operador = operadores.pop()
        operando2 = operandos.pop()
        operando1 = operandos.pop()
        resultado = aplicar_operador(operando1, operador, operando2)
        operandos.append(resultado)
    return operandos[0]

def aplicar_operador(operando1, operador, operando2):
    '''
    ***
    * operando1 : float
    * operador : str
    * operando2 : float
    ***
    Aplica el operador especificado .Retorna el resultado de la operación.
    '''
    if operador == '+':
        return operando1 + operando2
    elif operador == '-':
        return operando1 - operando2
    elif operador == '*':
        return operando1 * operando2
    elif operador == '//':
        return operando1 // operando2
    
def calcular_expresion_2(expresion):
    '''
    ***
    * expresion : str
    ***
    Calcula el resultado de la expresión matemática y maneja "ANS" y cupones. Retorna una lista de resultados.
    '''
    global ANS_value
    partes = expresion.split(' ')
    operandos = []
    operadores = []
    prioridades = {'+': 1, '-': 1, '*': 2, '//': 2}
    resultado_enteros = []
    for i in range(len(partes)):
        if partes[i] == "ANS":
            if ANS_value is not None:
                partes[i] = str(ANS_value)
            else:
                raise ValueError("El valor de ANS no está definido.")
    i = 0
    while i < len(partes):
        parte = partes[i]
        if parte.isdigit() or ('-' in parte and parte[1:].isdigit()):
            operandos.append(float(parte))
            i += 1
        elif parte in prioridades:
            while operadores and prioridades[operadores[-1]] >= prioridades[parte]:
                operador = operadores.pop()
                operando2 = operandos.pop()
                operando1 = operandos.pop()
                if operador == '//' and operando2 == 0:
                    raise ValueError("División por cero")
                resultado = aplicar_operador(operando1, operador, operando2)
                operandos.append(resultado)
            operadores.append(parte)
            i += 1
        elif parte == '(':
            operadores.append(parte)
            i += 1
        elif parte == ')':
            while operadores[-1] != '(':
                operador = operadores.pop()
                operando2 = operandos.pop()
                operando1 = operandos.pop()
                resultado = aplicar_operador(operando1, operador, operando2)
                operandos.append(resultado)
            operadores.pop()
            i += 1
        else:
            i += 1
    while operadores:
        operador = operadores.pop()
        operando2 = operandos.pop()
        operando1 = operandos.pop()
        if operador == '//' and operando2 == 0:
            raise ValueError("División por cero")
        resultado = aplicar_operador(operando1, operador, operando2)
        operandos.append(resultado)
    for resultado in operandos:
        resultado_enteros.append(int(resultado) if resultado >= 0 else 0)
    return resultado_enteros

def cupon_funcion(match):
    '''
    ***
    * match : re.Match
    ***
    Procesa la función "CUPON" en una expresión y retorna el resultado.
    '''
    params = match.group(1).replace(" ", "").split(",")
    if len(params) == 1:
        x = float(params[0])
        return str(int(x * 0.2))
    elif len(params) == 2:
        x = float(params[0])
        y = float(params[1])
        return str(int(x * (y / 100)))
    
    return "CUPON"


def aplicar_cupon(expresiones):
    '''
    ***
    * expresiones : list
    ***
    Aplica la función "CUPON" a una lista de expresiones y retorna los resultados.
    '''
    patron = r"CUPON\((.*?)\)"
    resultados = []
    for expresion in expresiones:
        resultado = re.sub(patron, cupon_funcion, expresion)
        resultados.append(resultado)
    
    return resultados

resultados = []
resultados_finales = []
archivo_1 = open('problemas.txt','r')
archivo_2 = open('desarrollo.txt','w')
exp = []
expresiones = []
espacio = 0
sin_resolver = False
error = False
lista_de_operaciones = []
for linea in archivo_1:
    lista_de_operaciones.append(linea.strip())
    exp.append(linea.strip())
expresiones = aplicar_cupon(exp)

for expresion in expresiones:
    nueva_expresion = expresion
    if error == True:
        espacio+=1
        resultados.append("error")
        error = False
        sin_resolver = True
    elif "ANS" in expresion and espacio == 0 :
      resultados.append("error")
      espacio+=1
      sin_resolver = True

    elif expresion != '':
        espacio+=1
        ver_espacio = espacios(expresion)
        ver_parentesis = parentesis(expresion)
        if ver_espacio == True and ver_parentesis == True :
            if verificar_division_por_cero(expresion) == False:
                resultados.append("sin resolver")
            elif sin_resolver == True:
                resultados.append("error")
            else:
                while '(' in nueva_expresion:
                    inicio = nueva_expresion.rfind('(')
                    fin = nueva_expresion.find(')', inicio)
                    subexpresion = nueva_expresion[inicio + 1:fin]
                    resultado_subexpresion = str(calcular_expresion(subexpresion))
                    nueva_expresion = nueva_expresion[:inicio] + resultado_subexpresion + nueva_expresion[fin + 1:]
                resultados.append(nueva_expresion)
        
        else:
          resultados.append("sin resolver")
    else:
      siguiente = expresiones[espacio+1]
      espacio+=1
      if siguiente[0] == "A":
        error = True
      else:
        sin_resolver = False
        


for expresion_resultante in resultados:
  if expresion_resultante == "sin resolver":
    resultados_finales.append("Error")
  elif expresion_resultante == "error":
    resultados_finales.append("Sin resolver")

  else:
      try:
        resultado_final = calcular_expresion_2(expresion_resultante)
        resultados_finales.extend(resultado_final)
        ANS_value = resultado_final[-1]
      except ValueError as e:
            resultados_finales.append(str(e))

i = 0
j = 0
while i<len(lista_de_operaciones):
    if lista_de_operaciones[i] == "":
        archivo_2.write(lista_de_operaciones[i])
        archivo_2.write("\n")
        i+=1
    else:
        archivo_2.write(lista_de_operaciones[i])
        archivo_2.write(" ")
        archivo_2.write("=")
        archivo_2.write(" ")
        archivo_2.write(str(resultados_finales[j]))
        archivo_2.write("\n")
        i +=1
        j+=1
archivo_1.close()
archivo_2.close()