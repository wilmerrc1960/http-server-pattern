# http-server-pattern

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

# Objetivo
Construir servidor HTTP desde cero siguiendo las recomendaciones del RFC donde se define el protocolo HTTP /1.1, con la implementación de sockets y teniendo en cuenta las estructuras definidas para el cuerpo del mensaje enviado por el cliente (user agent) y la respuesta del server (origin server).

# Key Words for implement a Http Server

* **modelo OSI**
 - capa fisica
 - capa de enlace de datos
 - capa de red
 - **capa de transporte**
 - capa de sesión
 - capa de presentación
 - capa de aplicación

* **TCP/IP**
* **Sockets**
* **HTTP/1.1**
* **Web browser**
* **Web server**
* **HTTP Methods: GET, POST, DELETE, PUT**
* **RFC** => Request for Comments defined by Internet Engineering Task Force (IETF)  
* **Internet**


To implement HTTP, we only care about 4th Layer: Transport Layer.
HTTP/1.1 →Initially it is RFC 2616 but later replaced by RFC 7230, RFC 7231, RFC 7232, RFC 7233, RFC 7234, RFC 7235. So, we need to read from RFC 7230 to RFC 7235 to implement basic workings of HTTP.

Implementing TCP:
First we need to implement the Transport Layer of HTTP which is TCP.
To implement TCP, we have to learn TCP socket programming.

# HTTP Request Proccess
![alt text](http://www.aosabook.org/en/500L/web-server-images/http-cycle.png)

![alt text](https://cdn-images-1.medium.com/max/1000/1*JSnJtHpU7cWUnWIgGupu7w.png)

![alt text](https://ruslanspivak.com/lsbaws-part1/LSBAWS_HTTP_response_anatomy.png)

# HTTP Request Structure

![alt text](https://cdn-images-1.medium.com/max/1000/1*Yqq-60D9mD4NVuhFd4IoFg.png)

# Examples
- The "hello world" example using Python http server:
1. Wait for someone to connect to our server and send an HTTP request;
2. parse that request;
3. figure out what it's asking for;
4. fetch that data (or generate it dynamically);
5. format the data as HTML; and
6. send it back.
Steps 1, 2, and 6 are the same from one application to another, so the Python standard library has a module called BaseHTTPServer that does those for us. We just have to take care of steps 3-5, which we do in the little program below:

```
import BaseHTTPServer

class RequestHandler(BaseHTTPServer.BaseHTTPRequestHandler):
    '''Handle HTTP requests by returning a fixed 'page'.'''

    # Page to send back.
    Page = '''\
<html>
<body>
<p>Hello, web!</p>
</body>
</html>
'''

    # Handle a GET request.
    def do_GET(self):
        self.send_response(200)
        self.send_header("Content-Type", "text/html")
        self.send_header("Content-Length", str(len(self.Page)))
        self.end_headers()
        self.wfile.write(self.Page)

#----------------------------------------------------------------------

if __name__ == '__main__':
    serverAddress = ('', 8080)
    server = BaseHTTPServer.HTTPServer(serverAddress, RequestHandler)
    server.serve_forever()
```    

- The "hello world" example using Node's http server:
```
const http = require('http');
const server = http.createServer();
server.on('request', (req, res) => {
  console.log(`${new Date().toISOString()} - ${req.method} ${req.url}`);
  res.setHeader('Content-Type','text/plain');
  res.end('Hello World!');
});
server.listen(3000);
```
# Decisiones de realización

| Definición | Contexto |
| ------ | ------ |
| Tema | Definición lenguaje de programa para desarrollar el servidor HTTP|
| Descripción del Problema | Debido a la necesidad que se tiene de realizar la construcción del servidor, se debe considerar en que lenguaje de programación se debe realizar esta construcción.  |
| Alternativas | Realizar la implementación del servidor en los siguientes lenguajes ( C#, C, Python, Java,Node.js)|
| Decisión | Se considera la opción de realizar la implementación de este servidor en los lenguaje de Python o Node.js ya que los integrantes de este grupo, tienen conocimiento sobre estos  lenguajes, sin embargo aun no se define en cual de los dos será el escogido ya que se realizaran pruebas de concepto para la definición del lenguaje a utilizar. |
| Implicaciones | Usar libreria de sockets en python |
| Lenguaje      | Python      |
| Arquitectura  | Cliente - Servidor (Stateless) Falta definir estrategia de la solución y representación con diagramas de clases o flujo |

# Referencias
RFC HTTP/1.1,  https://tools.ietf.org/html/rfc7230

