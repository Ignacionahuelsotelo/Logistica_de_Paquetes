package logica;

import java.util.ArrayList;

public class Deposito {
	protected Integer capacidadMaxima;
	protected Boolean propio, frigorifico;
	protected Integer numeroDeDeposito;

	
	public Deposito(Integer capacidadMax, boolean esPropio, boolean esFrigorifico ) {
		
		capacidadMaxima = capacidadMax;
		propio= esPropio;
		frigorifico= esFrigorifico;
		numeroDeDeposito =0;
		
	}
	


	@Override
	public String toString() {
		return "Deposito [capacidadMaxima=" + capacidadMaxima + ", propio=" + propio + ", frigorifico=" + frigorifico
				+ ", numeroDeDeposito=" + numeroDeDeposito + "]";
	}


	public double getCapacidadMaxima() {
		return capacidadMaxima;
	}
	
	public boolean isPropio() {
		return propio;
	}

	public boolean isFrigorifico() {
		return frigorifico;
	}
	
	public int getNumeroDeDeposito() {
		return numeroDeDeposito;
	}
	public void setNumeroDeDeposito(int nro) {
		this.numeroDeDeposito = nro;
	}

}
