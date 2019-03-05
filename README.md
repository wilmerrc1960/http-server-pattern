# http-server-pattern


# Objetivo
Construir servidor HTTP desde cero teniendo en cuenta los lineamientos del protocolo HTTP /1.1 especificado en el RFC, y entender el comportamiento interno de un servidor HTTP.

# Requisitos
* Implementar la atención de peticiones http. 
* Realizar traza de todas las peticiones que se le realicen aL servidor escribiendo cada petición recibida en un archivo de log.
* Implementar proyecto de pruebas, donde estén definidos los comportamientos esperados.

# Implementación:
La metodología usada para el desarrollo del servidor HTTP es BDD (Behavior Driven Development), donde primero se establecieron los comportamientos esperados de la aplicación, para posteriormente desarrollar cada escenario esperado.

# Diagrama de Clases
![alt text](https://github.com/edtiko/http-server-pattern/blob/master/class-diagram.png)


# Herramientas
* El lenguaje usado para la implementación fue Python 3 y para el proyecto de pruebas Java.
* Visual Studio Code para realizar la implementación en Python.
* Eclipse para realizar el proyecto de pruebas usando Cucumber como dependencia.
* Git para el control de versiones de los dos proyectos.
* Junit para pruebas unitarias
* Cucumber para pruebas de integración y comportamiento
* RestAssured para pruebas del servicio HTTPServer


# Pruebas:
Se implementó un proyecto de pruebas en Java con Cucumber para cubrir los comportamientos esperados del servidor HTTP desarrollado, los escenarios planteados son:
  
//Escenario 1
* Dado el nombre de un recurso index.html 
* Cuando el userAgent realice una petición GET al servidor http 
* Entonces el servidor debe responder código 200
* y con el body de index.html

//Escenario 2
* Dado el nombre de un recurso desconocido 
* Cuando el userAgent realice una petición GET al servidor http 
* Entonces el servidor debe responder código 404
* y con el body de error

//Escenario 3
* Dado el nombre de un recurso index.html 
* Cuando el userAgent realice una petición POST al servidor http 
* Entonces el servidor debe responder código 501
* y con el body de error

# Instrucciones de uso:

1. Instalar Python 3: https://www.python.org/downloads/
2. Instalar JDK Java: https://www.oracle.com/technetwork/es/java/javase/downloads/index.html
3. Instalar IDE Visual Studio Code
4. Instalar Eclipse o Intellij
5. Instalar Git
6. Clonar repositorio: https://github.com/edtiko/http-server-pattern.git
7. Abrir consola e ir a la raíz del proyecto /http-server
8. Ejecutar comando para iniciar el servidor: py main.py
9. En la consola debe aparecer "Listening socket on 127.0.0.0:8888"
10. Abrir navegador o Postman para poder realizar peticiones como:
 - HTTP 1.1 GET 127.0.0.0:8888/index.html
11. Para ejecutar el proyecto de pruebas es necesario realizar lo siguiente:
 - En el mismo repositorio se encuentra el proyecto /http-server-test
 - Importar como proyecto Maven en Eclipse
 - Ejecutar clase CucumberTest.java
 - Ver resultado de los pasos definidos cómo escenarios 
 - Ejecutar HttpServerTest.java con Junit para validar respuesta del servicio (httpServer)
    

# Decisiones de realización

| Definición | Contexto |
| ------ | ------ |
| Tema | Definición lenguaje de programa para desarrollar el servidor HTTP|
| Descripción del Problema | Debido a la necesidad que se tiene de realizar la construcción del servidor, se debe considerar en que lenguaje de programación se debe realizar esta construcción.  |
| Decisión | Se considera la opción de realizar la implementación de este servidor en los lenguaje de Python o Node.js ya que los integrantes de este grupo, tienen conocimiento sobre estos  lenguajes, sin embargo aun no se define en cual de los dos será el escogido ya que se realizaran pruebas de concepto para la definición del lenguaje a utilizar. |
| Implicaciones | Usar libreria de sockets en python |
| Lenguaje de programación     | Python      |
| Arquitectura  | Cliente - Servidor (Stateless) |

# Funcionamiento de un HTTP Server
Cuando se realiza una petición por HTTP (http request) por un navegador o cualquier software capaz de hacer peticiones http:
1. Se necesita establecer una conexión TCP (por medio de sockets entre el cliente y el server)
  - create socket
  - bind
  - listen
  - accept
  - connected socket
  The Web server creates a listening socket and starts accepting new connections in a loop. 
 
 2. The client sends HTTP Request to the server =>
  GET    /hello   HTTP/1.1
  (Http method,   Path,  HTTP Version)
 
 3. The server reads the request line =>
   - prints "Hello World"
   - return the proper HTTP response to the client:
     HTTP/1.1  200   OK (HTTP version, HTTP status code, HTTP status code reason) 
	 Hello, World!  (HTTP response body displays on your browser)

To sum it up: The Web server creates a listening socket and starts accepting new connections in a loop. 
The client initiates a TCP connection and, after successfully establishing it, 
the client sends an HTTP request to the server and the server responds with an HTTP response that gets displayed to the user.
To establish a TCP connection both clients and servers use sockets.

# Referencias
RFC HTTP/1.1,  https://tools.ietf.org/html/rfc7230

