[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-7f7980b617ed060a017424585567c406b6ee15c891e84e1186181d67ecf80aa0.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=13377472)
# PRÁCTICA 2: EJERCICIOS DE PROGRAMACIÓN MULTIPROCESO

Escribe en Java los programas necesarios:

* Utiliza de manera adecuada la Programación Orientada a Objetos.
* Presta atención a las excepciones que pueda originar el código e informa al usuario. Ante la duda, controla las excepciones desde el método
* Imprime en pantalla los mensajes necesarios cuando haya que informar al usuario.
* No olvides comentar el código y documentar los métodos.

## 1. Ejercicio 1

Escribe un programa (llámalo **Ejercicio1**) que reciba como argumentos un comando del sistema operativo (ejemplo `ls –la`) para ser ejecutado.

* El programa debe crear un proceso hijo que ejecute el comando.
    * Usa el constructor [`ProcessBuilder`][ProcessBuilder] que toma [`List<String>`]([java.util.List]) como parámetro
* El programa también informa con un mensaje si ocurre un error al ejecutar el proceso hijo.
* El proceso padre espera dos segundos a que finalice el proceso hijo.
    * Imprime un mensaje si el tiempo se agota y termina.
* El padre imprime el valor de salida de la ejecución del proceso hijo. Luego:
    * Si el hijo sale con error, imprime el mensaje de error del hijo y termina.
    * Si el hijo termina normalmente, imprime el resultado de salida de la ejecución del proceso hijo y guarda el resultado en el archivo `output.txt`

## 2. Ejercicio 2

Escribe los siguientes programas:

* Crea un programa ejecutable en Java (**Reverse**) que:
    * Lea cadenas de su entrada estándar.
    * Si la cadena recibida es diferente de `"stop"`, entonces le da la vuelta a los caracteres de la entrada y lo escribe en su salida estándar. Por ejemplo, si el usuario introduce `"Hola, ¿Que tal?"` el programa escribirá `"?lat euQ¿ ,aloH"`
    * El programa finaliza cuando recibe la cadena de `"stop"` de la entrada estándar.

### Ejemplo de Ejecución

```bash
$ java -jar Reverse.jar
Hola, ¿Que tal?
?lat euQ¿ ,aloH
Hola
aloH
Programación
nóicamargorP
stop

$
```

* Cree un programa ejecutable (**Ejercicio2**) que:
    * Inicia el programa `Reverse` creado anteriormente como un proceso secundario.
    * Lee líneas de la entrada estándar del usuario. Cada línea leída se envía al subproceso (utiliza los flujos de datos de entrada / salida para comunicar el proceso principal y secundario) y, luego, imprime en la pantalla la cadenas generadas por el proceso secundario. Escribe todos las cadenas generadas en el archivo: `reverses.txt`.
    * Termina cuando recibe la cadena `"stop"`.

```bash
$ java -jar Ejercicio2.jar

A partir de ahora todas las cadenas que me introduzcas y pulses enter yo les daré la vuelta, cuando termines, escribe la cadena: stop
Hola, ¿Que tal?
La cadena dada la vuelta es: ?lat euQ¿ ,aloH
Arturo
La cadena dada la vuelta es: orutrA
stop
Encantado de haber jugado contigo, un saludo.

$

```

## Ejercicio 3

### Descripción del Ejercicio

Este ejercicio tiene como objetivo desarrollar una herramienta de scraping en Java que descargue recursos de una página web, con énfasis en la descarga de imágenes. Los estudiantes aprenderán a manejar la concurrencia en Java, ejecutando múltiples procesos en paralelo y sincronizándolos adecuadamente.

### Estructura del Proyecto

El proyecto consta de dos clases principales dentro de un subproyecto Maven:

- `App.java`: Clase principal que actúa como punto de entrada del programa.
- `DescargadorDeImagenes.java`: Clase encargada de la lógica de scraping, incluyendo la descarga del HTML de la página web, extracción de URLs de imágenes y gestión de la descarga de las imágenes.

### Tareas a Realizar

Los estudiantes tendrán que completar e implementar las siguientes funcionalidades:

1. **Descarga del HTML**:
    - Completar el método en `DescargadorDeImagenes` para descargar el HTML de la página web especificada.

2. **Extracción de URLs de Imágenes**:
    - Implementar la lógica para extraer todas las URLs de imágenes del HTML descargado.

3. **Descarga de Imágenes en Paralelo**:
    - Escribir código para descargar cada imagen identificada, creando un proceso separado para cada una.
    - Asegurarse de que el proceso principal espere a que todos los procesos de descarga finalicen.

4. **Manejo de Errores**:
    - Implementar la gestión adecuada de errores y excepciones.

5. **Sincronización de Procesos**:
    - Garantizar que todos los procesos de descarga se completen antes de que el proceso principal finalice.

### Instrucciones para la Compilación y Ejecución

1. Clone el repositorio y navegue al subproyecto correspondiente.
2. Utilice Maven para compilar el proyecto: `mvn compile`.
3. Ejecute la clase `App` con el comando: `mvn exec:java -Dexec.mainClass="org.example.App"`.

### Aspectos a Considerar

- Este ejercicio es una oportunidad para practicar el manejo de procesos y la concurrencia en Java.
- Se anima a los estudiantes a experimentar con diferentes enfoques y soluciones.
- La documentación adecuada y comentarios claros en el código son esenciales.

### Recursos Adicionales

- Documentación de Java sobre concurrencia y manejo de procesos.
- Guías y tutoriales sobre expresiones regulares en Java.
- Ejemplos de uso de `ProcessBuilder` y manejo de flujos de entrada/salida.

## 4. Referencias

1. [ProcessBuilder][ProcessBuilder]
2. [List][ProcessBuilder]

[ProcessBuilder]:https://docs.oracle.com/javase/8/docs/api/java/lang/ProcessBuilder.html
[java.util.List]:https://docs.oracle.com/javase/8/docs/api/java/util/List.html
