# Ejercicio 7

## Parte 1: Instrucciones de uso de las clases para medición

### Clases principales

#### `Medible<Data>`
Es una clase abstracta base para las mediciones.  
Contiene los métodos:

- `medir(int repeticiones, Data data)`
- `ejecutar(int repeticiones, Data data)`
- `getObjetoAMedirMemoria()`

Su función es ejecutar una operación, medir su tiempo de ejecución y registrar la memoria consumida por la estructura medida.

---

#### `Medicion`
Es la clase que guarda el resultado de la medición.  
Contiene:

- el nombre de la medición,
- el consumo de memoria,
- el tiempo de ejecución.

Además, permite mostrar el resultado por consola o exportarlo a CSV.

---

#### Clases concretas de medición
Son las clases que extienden `Medible<List<String>>` y realizan la medición de búsqueda sobre cada estructura de datos.

Ejemplo:

- `MedicionBuscarLinkedList`
- `MedicionBuscarArrayList`
- `MedicionBuscarTTrie`
- `MedicionBuscarHashMap`
- `MedicionBuscarTreeMap`

---

### Uso general

1. Se crea la estructura a medir.
2. Se cargan los datos.
3. Se instancia la clase de medición correspondiente.
4. Se llama a `medir(...)`.
5. Se imprime o guarda el resultado.

Ejemplo:

```java
Medible<List<String>> medible = new MedicionBuscarLinkedList(linkedList);
Medicion resultado = medible.medir(100, palabrasParaBuscar);
resultado.print();
```
## Parte 4: Medición de busqueda
| Estructura | Consumo de memoria | Tiempo de ejecución |
|------------|--------------------|---------------------|
| MedicionBuscarArrayList | 937,27 kB | 669,72 ms |
| MedicionBuscarLinkedList | 937,26 kB | 1030,00 ms |
| MedicionBuscarHashMap | 1,33 MB | 0,81 ms |
| MedicionBuscarTreeMap | 1,33 MB | 2,30 ms |
| MedicionBuscarTTrie | 12,50 MB | 2,29 ms |

## Parte 5: Medición de predecir
| Estructura | Consumo de memoria | Tiempo de ejecución |
|------------|--------------------|---------------------|
| MedicionPredecirLinkedList | 937,26 kB | 12,33 ms |
| MedicionPredecirHashMap | 1,33 MB | 25,25 ms |
| MedicionPredecirTrie | 12,50 MB | 1,42 ms |