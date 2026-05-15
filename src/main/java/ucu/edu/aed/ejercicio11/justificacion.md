# Selección de clases de la API de colecciones de Java

- **`HashMap<String, Integer>`**

## Justificación

### 1. Relación clave-valor
En este problema necesitamos asociar:

- una **palabra** como clave (`String`)
- su **frecuencia de aparición** como valor (`Integer`)

Por ejemplo:

- `"casa" -> 12`
- `"libro" -> 8`
- `"río" -> 5`

El tipo `HashMap<String, Integer>` permite representar esa relación.

---

### 2. Eficiencia
`HashMap` es la opción más eficiente para este caso porque permite:

- insertar palabras nuevas
- buscar si una palabra ya fue registrada
- actualizar su contador

en tiempo promedio **O(1)**.

---

### 3. Comparación con otras colecciones

#### `ArrayList`
No es la mejor opción porque para saber si una palabra ya existe habría que recorrer toda la lista cada vez, lo que tiene costo **O(n)**.

#### `TreeMap`
También podría usarse, pero ordena por clave y sus operaciones son **O(log n)**.  
Sirve si se necesita orden alfabético, pero no es la alternativa más eficiente para contar frecuencias.

#### `HashSet`
Sirve para almacenar elementos únicos, pero no para contar cuántas veces aparece cada palabra.

---

### 4. Estructuras adicionales
Además de `HashMap`, para mostrar las 10 palabras más frecuentes vamos a usar:

- **`ArrayList<Map.Entry<String, Integer>>`**

Esta lista permite ordenar las palabras por frecuencia de forma descendente.

---

## Conclusión

La mejor elección para esta aplicación es:

- **`HashMap<String, Integer>`** para contar frecuencias
- **`ArrayList<Map.Entry<String, Integer>>`** para ordenar y obtener las 10 palabras más frecuentes

