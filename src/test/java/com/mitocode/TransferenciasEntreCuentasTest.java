package com.mitocode;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.junit.Test;

public class TransferenciasEntreCuentasTest {
	
	private final static Logger log = Logger.getLogger(TransferenciasEntreCuentasTest.class);

	private Cuenta cuentaOrigen;
	private Cuenta cuentaDestino;
	
	@Test
	public void transferenciaEntreCuentas() throws CuentaException {

		log.info("Test: Transferencia entre Cuentas con Saldo Insuficiente");
		log.info("Monto a transferir: " + 2000.00);

		cuentaOrigen = new Cuenta(5000.00);
		cuentaDestino = new Cuenta(1000.00);
		printAccounts();

		assertTrue(cuentaOrigen.tranferencia(cuentaDestino, 2000.00));
		printAccounts();

	}
	
	@Test(expected = CuentaException.class)
	public void transferenciaEntreCuentasSaldoInsuficiente() throws CuentaException {

		log.info("Test: Transferencia entre Cuentas con Saldo Insuficiente");
		log.info("Monto a transferir: " + 5001.00);

		cuentaOrigen = new Cuenta(5000.00);
		cuentaDestino = new Cuenta(1000.00);
		printAccounts();

		cuentaOrigen.tranferencia(cuentaDestino, 5001.00);
		printAccounts();
	}

	@Test(expected = CuentaException.class)
	public void transferenciaEntreCuentasCantidadMinima() throws CuentaException {
		log.info("Test: Transferencia entre Cuentas con Cantidad Minima");
		log.info("Monto a transferir: " + 0.01);

		cuentaOrigen = new Cuenta(5000.00);
		cuentaDestino = new Cuenta(1000.00);
		printAccounts();

		cuentaOrigen.tranferencia(cuentaDestino, 0.01);
		printAccounts();
	}
	
	public void printAccounts() {
		log.info(cuentaOrigen + " " + cuentaDestino);
	}

}
