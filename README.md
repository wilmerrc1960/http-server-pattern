# http-server-pattern


# Objetivo
Construir servidor HTTP desde cero teniendo en cuenta los lineamientos del protocolo HTTP /1.1 especificado en el RFC, y entender el comportamiento interno de un servidor HTTP.

# Requisitos


# Implementación:
con la implementación de sockets y teniendo en cuenta las estructuras definidas para el cuerpo del mensaje enviado por el cliente (user agent) y la respuesta del server (origin server).

# Pruebas:

# Instrucciones de uso:

# Decisiones de realización

| Definición | Contexto |
| ------ | ------ |
| Tema | Definición lenguaje de programa para desarrollar el servidor HTTP|
| Descripción del Problema | Debido a la necesidad que se tiene de realizar la construcción del servidor, se debe considerar en que lenguaje de programación se debe realizar esta construcción.  |
| Decisión | Se considera la opción de realizar la implementación de este servidor en los lenguaje de Python o Node.js ya que los integrantes de este grupo, tienen conocimiento sobre estos  lenguajes, sin embargo aun no se define en cual de los dos será el escogido ya que se realizaran pruebas de concepto para la definición del lenguaje a utilizar. |
| Implicaciones | Usar libreria de sockets en python |
| Lenguaje de programación     | Python      |
| Arquitectura  | Cliente - Servidor (Stateless) |


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

