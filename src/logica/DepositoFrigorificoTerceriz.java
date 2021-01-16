	package logica;

public class DepositoFrigorificoTerceriz extends Deposito{

	private double capacidadMaxima, costoTonelada;
	
	
	public DepositoFrigorificoTerceriz(Integer capacidadMax,  double costoPorTonelada) {
		super(capacidadMax, false, true);
		
		capacidadMaxima = capacidadMax;
		costoTonelada=costoPorTonelada;
		numeroDeDeposito=0;
		
	}
	
	@Override
	public void setNumeroDeDeposito(int nro) {
		this.numeroDeDeposito = nro;
	}
	
	@Override
	public double getCapacidadMaxima() {
		return capacidadMaxima;
	}

	@Override
	public boolean isFrigorifico() {
		return true;
	}

	public double getCostoTonelada() {
		return costoTonelada;
	}

	@Override
	public String toString() {
		return "DepositoFrigorificoTerceriz [capacidadMaxima=" + capacidadMaxima + ", costoTonelada=" + costoTonelada + "numero de deposito = " + numeroDeDeposito
				+ "]";
	}
	
	
}
