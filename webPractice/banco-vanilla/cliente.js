function createObjInfo(_nombreClase, _cliente, _cuenta, _condicion) {
  return {
    nombreClase: _nombreClase,
    cliente: _cliente,
    cuenta: _cuenta,
    condicion: _condicion
  }
}

function mostrarInfoCliente(nombreCliente) {
  let objInfo = createObjInfo('info-cliente', nombreCliente, null, function(tag) {
    return (tag.classList.contains(this.cliente));
  });
  toggleInfo(objInfo);
}

function mostrarInfoCuenta(nombreCliente, nombreCuenta) {
  let objInfo = createObjInfo('info-cuenta', nombreCliente, nombreCuenta, function(tag) {
    return (tag.classList.contains(this.cliente) && tag.classList.contains(this.cuenta));
  });
  toggleInfo(objInfo);
}

function toggleInfo(objInfo) {
  let lista = document.getElementsByClassName(objInfo.nombreClase);

  for (let i = 0; i < lista.length; i++) {
    if (objInfo.condicion(lista[i])) {
      if (lista[i].classList.contains('none')) {
        lista[i].classList.remove('none');
      } else {
        lista[i].classList.add('none');
      }
    }
  }
}

(function() { // on load
  document.getElementById('saldo-maximo').innerHTML += calcularSaldoMaximo();
  document.getElementById('saldo-minimo').innerHTML += calcularSaldoMinimo();
})();

function calcularSaldoMaximo() {

  let saldoMaximo = 0;
  let saldos = document.getElementsByClassName('saldo');

  for (let i = 0; i < saldos.length; i++) {
  	let saldo = parseInt(saldos[i].innerHTML);
  	if (saldo > saldoMaximo) {
  		saldoMaximo = saldo;
  	}
  }

  return saldoMaximo;

}

function calcularSaldoMinimo() {

  let saldoMinimo = Number.MAX_SAFE_INTEGER;
  let saldos = document.getElementsByClassName('saldo');

  for (let i = 0; i < saldos.length; i++) {
  	let saldo = parseInt(saldos[i].innerHTML);
  	if (saldo < saldoMinimo) {
  		saldoMinimo = saldo;
  	}
  }

  return saldoMinimo;

}
