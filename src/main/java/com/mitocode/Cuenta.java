package com.mitocode;

public class Cuenta implements ICuenta {

	private double monto;
	private static final double MONTO_MINIMO = 0.10;

	public Cuenta(double amount) {
		this.monto = amount;
	}

	@Override
	public boolean tranferencia(Cuenta cuentaDestino, double montoTransferencia) throws CuentaException {

		if (!verificaSaldoSuficiente(montoTransferencia)) {
			throw new CuentaException("Saldo insuficiente");
		} else if (!verificaMontoMinimo(montoTransferencia)) {
			throw new CuentaException("Cantidad minima no permitida");
		} else {
			this.retirar(montoTransferencia);
			cuentaDestino.monto += montoTransferencia;
			return true;
		}
	}

	@Override
	public boolean verificaSaldoSuficiente(double montoTransferencia) {
		return montoTransferencia <= this.monto;
	}

	@Override
	public boolean verificaMontoMinimo(double montoTransferencia) {
		return montoTransferencia >= MONTO_MINIMO;
	}

	@Override
	public void retirar(double montoTransferencia) {
		this.monto -= montoTransferencia;
	}

	@Override
	public String toString() {
		return "Cuenta [monto=" + monto + "]";
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

}
