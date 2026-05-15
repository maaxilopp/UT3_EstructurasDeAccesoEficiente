
## 1) Atributo que determina la identidad lógica de un libro

El atributo que debería determinar la identidad lógica de un libro es el ISBN.

### Justificación
- El ISBN es unico a cada edicion de un libro.
- titulo, autor y anio pueden repetirse en distintos libros o ediciones, por lo que no son suficientes por sí solos para identificarlo de forma única.

---

## 3) ¿Qué pasa si equals compara libros usando ISBN pero hashCode se calcula usando título?

Aparece un error porque se rompe el contrato entre equals y hashCode.

Si dos objetos son iguales según equals, entonces deben tener el mismo hashCode.

Si no se cumple entonces dos libros con el mismo ISBN podrían ser considerados iguales, pero tener códigos hash distintos si sus títulos cambian o no coinciden exactamente.

### Consecuencia
Estructuras como HashSet y HashMap pueden comportarse mal:
- no detectar duplicados correctamente
- no encontrar elementos que sí deberían existir

---

## 5) ¿Qué debería ocurrir en ese HashSet si equals y hashCode están correctamente implementados?

- dos objetos distintos que representen el mismo libro deben considerarse iguales
- al insertarlos en un HashSet, solo uno debe quedar almacenado
- el conjunto no debe permitir duplicados lógicos

