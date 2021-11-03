package com.mitocode;

public interface ICuenta {

	boolean tranferencia(Cuenta cuentaDestino, double montoTransferencia) throws CuentaException;

	boolean verificaSaldoSuficiente(double montoTransferencia);
	
	boolean verificaMontoMinimo(double montoTransferencia);
	
	void retirar(double montoTransferencia);
}

