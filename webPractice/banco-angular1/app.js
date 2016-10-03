const app = angular.module('main', []);

app.controller('Controlador', ['$scope', '$http', function($scope, $http) {

  $scope.clientes = [
    {nombre: 'Norman', edad: 22},
    {nombre: 'Camila', edad: 33},
    {nombre: 'Sofia', edad: 32}
  ];

  $scope.cuentas = [
    {nombre: 'Cuenta Saldo', numero: 7641782, saldo: 6222, clientes: ['Norman']},
    {nombre: 'Caja Ahorro', numero: 2578245, saldo: 5002, clientes: ['Norman', 'Camila']},
    {nombre: 'Cuenta Saldo', numero: 1871456, saldo: 24000, clientes: ['Camila', 'Sofia']},
    {nombre: 'Cuenta Corriente', numero: 1241426, saldo: 7600, clientes: ['Sofia']}
  ];

  // Se necesita configurar algo de CORS para que el server responda bien...
  //$http.get('http://127.0.0.1:3000/clientes.json').success(function(data) {
  //  $scope.clientes = JSON.parse(data).clientes;
  //});
  //$http.get('http://127.0.0.1:3000/cuentas.json').success(function(data) {
  //  $scope.cuentas = JSON.parse(data).cuentas;
  //});

  function actualizarCuentas(nombre) {
    $scope.listaCuentas = $scope.cuentas
      .filter(function(cta) {
        return cta.clientes.includes(nombre);
      });
  }

  $scope.mostrarCli = false;
  $scope.mostrarCliente = function(cliente) {
    $scope.mostrarCli = !$scope.mostrarCli;
    if ($scope.mostrarCli) {
      $scope.clienteMostrar = cliente;
      actualizarCuentas(cliente.nombre);
    }
  }

  $scope.mostrarCta = false;
  $scope.mostrarCuenta = function(cuenta) {
    $scope.mostrarCta = !$scope.mostrarCta;
    if ($scope.mostrarCta) {
      $scope.cuentaMostrar = cuenta;
    }
  }

}]);
