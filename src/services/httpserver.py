import os
import mimetypes
from services.tcpserver import TCPServer
from services.httprequest import HTTPRequest

class HTTPServer(TCPServer):
    headers = {
        'Server': 'CrudeServer',
        'Content-Type': 'text/html',
    }
    status_codes = {
        200: 'OK',
        404: 'Not Found',
        501: 'Not Implemented',
    }

    def handle_request(self, data):
        request = HTTPRequest(data)

        try:
            handler = getattr(self, 'handle_%s' % request.method)
        except AttributeError:
            handler = self.HTTP_501_handler

        response = handler(request)

        return response

    def HTTP_501_handler(self, request):
        response_line = self.response_line(status_code=501)

        response_headers = self.response_headers()

        blank_line = "\r\n"

        response_body = "<h1>501 Not Implemented</h1>"

        return "%s%s%s%s" % (
                response_line, 
                response_headers, 
                blank_line, 
                response_body
            )

    def response_line(self, status_code):
        """Returns response line"""
        reason = self.status_codes[status_code]
        return "HTTP/1.1 %s %s\r\n" % (status_code, reason)

    def response_headers(self, extra_headers=None):
        """Returns headers
        The `extra_headers` can be a dict for sending 
        extra headers for the current response
        """
        headers_copy = self.headers.copy() # make a local copy of headers

        if extra_headers:
            headers_copy.update(extra_headers)

        headers = ""

        for h in self.headers:
            headers += "%s: %s\r\n" % (h, self.headers[h])
        return headers

    def handle_OPTIONS(self, request):
        response_line = self.response_line(200)

        extra_headers = {'Allow': 'OPTIONS, GET'}
        response_headers = self.response_headers(extra_headers)

        blank_line = "\r\n"

        return "%s%s%s" % (
                response_line, 
                response_headers,
                blank_line
            )

    def handle_GET(self, request):
        filename = request.uri.strip('/') # remove the slash from URI

        if os.path.exists('views/'+filename):
            response_line = self.response_line(200)

             # find out a file's MIME type
            # if nothing is found, just send `text/html`
            content_type = mimetypes.guess_type(filename)[0] or 'text/html'

            extra_headers = {'Content-Type': content_type}
            response_headers = self.response_headers(extra_headers)

            with open('views/'+filename) as f:
                response_body = f.read()
        else:
            response_line = self.response_line(404)
            response_headers = self.response_headers()
            response_body = "<h1>404 Not Found</h1>"

        blank_line = "\r\n"

        return "%s%s%s%s" % (
                response_line, 
                response_headers, 
                blank_line, 
                response_body
            )