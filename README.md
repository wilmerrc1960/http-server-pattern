# http-server-pattern
Http server from scratch

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
* **RFC**
* **Internet**


To implement HTTP, we only care about 4th Layer: Transport Layer.
HTTP/1.1 →Initially it is RFC 2616 but later replaced by RFC 7230, RFC 7231, RFC 7232, RFC 7233, RFC 7234, RFC 7235. So, we need to read from RFC 7230 to RFC 7235 to implement basic workings of HTTP.

Implementing TCP:
First we need to implement the Transport Layer of HTTP which is TCP.
To implement TCP, we have to learn TCP socket programming.

# HTTP Request Proccess
![alt text](http://www.aosabook.org/en/500L/web-server-images/http-cycle.png)

![alt text](https://cdn-images-1.medium.com/max/1000/1*JSnJtHpU7cWUnWIgGupu7w.png)

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
