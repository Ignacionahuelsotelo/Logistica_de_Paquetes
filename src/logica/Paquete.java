package logica;

public class Paquete {
	private double peso, volumen;
	private String destino;
	private boolean frio;
	private double  costoTonelada;
	private boolean dondeSeGuardo;
	
	
	public Paquete(String destinO, double pesO, double volumeN, boolean nesecitaFrio) {
	
		peso= pesO;
		volumen= volumeN;
		destino= destinO;
		frio=nesecitaFrio;
		costoTonelada =0;
		dondeSeGuardo = false;
			}

	

	
	public void setCosto(  double costo  ) {  
		this.costoTonelada = costo ;
	}
	public double getCosto() {
		return this.costoTonelada;
	}
	public boolean getDondeSeGuardo() {
		return dondeSeGuardo;
	}
	
	public void setDondeSeGuardo(boolean b) {   // va a ser Verdadero cuando el paquete se guarde en un DepositoFrigorificoTerceriz
		this.dondeSeGuardo = b;
		
	}



	@Override
	public String toString() {
		return "Paquete [peso=" + peso + ", volumen=" + volumen + ", destino=" + destino + ", frio=" + frio + "]";
	}


	public double getPeso() {
		return peso;
	}


	public double getVolumen() {
		return volumen;
	}
	
	public String getDestino() {
		return destino;
	}

	public boolean isFrio() {
		return frio;
	}


	public void setFrio(boolean frio) {
		this.frio = frio;
	}


}
