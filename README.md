
# Agenda de Contactos
 
> Proyecto desarrollado en el marco de un **Hackathon de Java por Generation**, enfocado en la gestión de una agenda telefónica aplicando programación orientada a objetos.
 
---
 
## 🎯 Objetivo
 
Diseñar e implementar un sistema de gestión de contactos que permita administrar una agenda telefónica de forma eficiente, aplicando principios de **POO** (clases, encapsulamiento, colecciones) y buenas prácticas de código limpio, como parte de un ejercicio colaborativo en equipo bajo un flujo de trabajo real con Git y GitHub. Utilizando la metodología SCRUM.
 
El proyecto busca poner en práctica:
- Modelado de datos mediante clases y objetos.
- Validaciones de negocio (duplicados, campos vacíos, capacidad máxima).
- Trabajo colaborativo distribuido por funcionalidades.
- Práctica de control de versiones (ramas, Pull Requests).
---
 
## 📖 Descripción del programa
 
Cada contacto está definido por **nombre**, **apellido** y **teléfono**. Dos contactos se consideran iguales cuando comparten nombre y apellido, sin distinguir entre mayúsculas y minúsculas; el teléfono no forma parte de esa comparación.
 
La agenda puede crearse de dos formas:
- Con un **tamaño máximo personalizado**.
- Con un **tamaño por defecto de 10 contactos**.
 
## Funcionalidades
 
| Método | Descripción |
|---|---|
| `añadirContacto(Contacto c)` | Añade un contacto, validando campos vacíos, duplicados y espacio disponible. |
| `existeContacto(Contacto c)` | Verifica si un contacto ya existe en la agenda. |
| `listarContactos()` | Muestra todos los contactos ordenados alfabéticamente, en formato `Nombre Apellido - Teléfono`. |
| `buscarContacto(String nombre, String apellido)` | Busca un contacto y muestra su teléfono si existe. |
| `eliminarContacto(Contacto c)` | Elimina un contacto, informando si la operación fue exitosa. |
| `modificarTelefono(String nombre, String apellido, String nuevoTelefono)` | Modifica el teléfono de un contacto existente. |
| `agendaLlena()` | Indica si la agenda alcanzó su capacidad máxima. |
| `espaciosLibres()` | Muestra cuántos contactos más se pueden agregar. |
 
Todas estas funcionalidades pueden probarse mediante un **menú interactivo por consola**.
 
---
 
## 🏗️ Estructura del proyecto
 
```
Agenda/
├── README.md
└── src/
    ├── Main.java              # Punto de entrada — menú de consola
    ├── model/
    │   └── Contacto.java    
    └── service/
        └── Agenda.java        
```

## 🌿 Flujo de trabajo en Git
 
| Rama | Propósito |
|---|---|
| `main` | Rama estable, recibe únicamente el resultado final del hackathon. |
| `develop` | Rama de integración del equipo. |
| `nombre-integrante` | Rama individual de trabajo, con Pull origin hacia `develop`. |

 
## Colaboradores
 
Integrantes:

