package logica;

public class Flete extends Transporte{
	
	private double acompañante ;
	private double costoAcompañante;
	private String destino;
	
	public Flete( double cargaMax, double capacidadMax, double acompañantE, double costoKM, double costoPorAcom) {
		super(false, cargaMax, capacidadMax, costoKM);
	
		
	cargaMaxima =cargaMax;
	capacidadMaxima=capacidadMax;
	costoKmPorViaje= costoKM;
	acompañante = acompañantE;	
	costoAcompañante=costoPorAcom;
	
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj instanceof Flete == false){
			return false;
		}
		Flete f = (Flete)obj;
		return this.getCarga() == f.getCarga() && this.getDestino().equals(f.getDestino()) ; // && this.getDestino().equals(f.getDestino()
	}

	public double getAcompañante() {
		return acompañante;
	}


	public double getCostoAcompañante() {
		return costoAcompañante;
	}
	
	public String getDestino() {
		return destino;
	}
	
	@Override
	public void setDestino(String destino) {
		this.destino = destino;
	}

	public void setAcompañante(double acompañante) {
		this.acompañante = acompañante;
	}

	@Override
	public String toString() {
		return "cargaMaxima=" + cargaMaxima + ", capacidadMaxima=" + capacidadMaxima
				+ ", refrigeracion=" + refrigeracion + ", costoKmPorViaje=" + costoKmPorViaje +  " ]";
	}
	
	
}
