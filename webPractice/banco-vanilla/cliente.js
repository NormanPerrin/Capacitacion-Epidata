(function() { // on load
  document.getElementById('saldo-maximo').innerHTML += calcularSaldoMaximo();
  document.getElementById('saldo-minimo').innerHTML += calcularSaldoMinimo();
})();

function mostrarInfoCliente(nombreCliente) {

  let clientes = document.getElementsByClassName('info-cliente');

  for (let i = 0; i < clientes.length; i++) {
    if (clientes[i].classList.contains(nombreCliente)) {
      if (clientes[i].classList.contains('none')) {
        clientes[i].classList.remove('none');
      } else {
        clientes[i].classList.add('none');
      }
      break;
    }
  }

}

function mostrarInfoCuenta(nombreCliente, nombreCuenta) {

  let cuentas = document.getElementsByClassName('info-cuenta');

  for (let i = 0; i < cuentas.length; i++) {
    if (cuentas[i].classList.contains(nombreCliente) && cuentas[i].classList.contains(nombreCuenta)) {
      if (cuentas[i].classList.contains('none')) {
        cuentas[i].classList.remove('none');
      } else {
        cuentas[i].classList.add('none');
      }
      break;
    }
  }

}

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
