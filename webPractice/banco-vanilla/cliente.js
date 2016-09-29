(function() { // on load
  calcularSaldoMaximo();
  console.log('\n');
  calcularSaldoMinimo();
  console.log('\n');
})();

function mostrarInfoCliente(nombreCliente) {
  let clientes = document.getElementsByClassName('info-cliente');
  for (let i = 0; i < clientes.length; i++) {
    if (clientes[i].classList.contains(nombreCliente)) {
      clientes[i].removeClass('none');
      break;
    }
  }

}

function mostrarInfoCuenta(nombreCuenta) {

}

function calcularSaldoMaximo() {

  let saldos = document.getElementsByClassName('saldo');
  let saldoMaximo = 0;

  for (let i = 0; i < saldos.length; i++) {
  	let saldo = saldos[i].innerHTML;
  	console.log('saldo: ' + saldo + ' > maximo: ' + saldoMaximo);
  	if (saldo > saldoMaximo) {
  		console.log('actualizo saldo');
  		saldoMaximo = saldo;
  	}
  }

  console.log(saldoMaximo);
}

function calcularSaldoMinimo() {

  let saldos = document.getElementsByClassName('saldo');
  let saldoMinimo = Number.MAX_SAFE_INTEGER;

  for (let i = 0; i < saldos.length; i++) {
  	let saldo = saldos[i].innerHTML;
  	console.log('saldo: ' + saldo + ' < minimo: ' + saldoMinimo);
  	if (saldo < saldoMinimo) {
  		console.log('actualizo saldo');
  		saldoMinimo = saldo;
  	}
  }

  console.log(saldoMinimo);

}
