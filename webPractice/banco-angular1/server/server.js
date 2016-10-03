const fs    = require('fs');
const http  = require('http');
const port  = 3000;
const host  = '127.0.0.1';

const server = http.createServer(function(req, res) {
  if ((req.url == '/clientes.json') || (req.url == '/cuentas.json')) {
    const content = fs.readFileSync('.'+req.url, 'utf8');
    const json = JSON.stringify(content);
    res.writeHead(200, {'Content-Type': 'application/json'});
    res.end(json);
  } else {
    res.writeHead(404, {'Content-type': 'text/plain'});
    res.end('Recurso no encontrado');
  }
});

server.listen(port, host, function() {
  console.log('Servidor escuchando en: ' + port);
});
