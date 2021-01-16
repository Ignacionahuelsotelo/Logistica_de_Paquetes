package logica;

public class TrailerComun extends Transporte {

	
	public double acompañante;
	private double seguroCarga;
	private boolean frigorificoo;
	
	public TrailerComun( double cargaMax, double capacidadMax, double acompañantE, double costoKM,boolean frigorifico,
			double segCarga) {
		super(frigorifico, cargaMax, capacidadMax, costoKM);
	
	
	cargaMaxima=cargaMax;
	capacidadMaxima= capacidadMax;
	costoKmPorViaje = costoKM;
	acompañante = acompañantE;
	seguroCarga =segCarga;
	frigorificoo = frigorifico;
	}

	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj instanceof TrailerComun == false){
			return false;
		}
		TrailerComun tc = (TrailerComun)obj;
		return  this.getCarga() == tc.getCarga() && this.getDestino().equals(tc.getDestino());
	}

	public double getAcompañante() {
		return acompañante;
	}


	public double getSeguroCarga() {
		return seguroCarga;
	}

	public boolean isFrigorifico() {
		return this.frigorificoo;
	}


	@Override
	public String toString() {
		return "TrailerComun [acompañante=" + acompañante + ", seguroCarga=" + seguroCarga + ", frigorificoo="
				+ frigorificoo + "]";
	}

	

}
