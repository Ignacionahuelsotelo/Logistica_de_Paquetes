package logica;

public class TrailerComun extends Transporte {

	
	public double acompaņante;
	private double seguroCarga;
	private boolean frigorificoo;
	
	public TrailerComun( double cargaMax, double capacidadMax, double acompaņantE, double costoKM,boolean frigorifico,
			double segCarga) {
		super(frigorifico, cargaMax, capacidadMax, costoKM);
	
	
	cargaMaxima=cargaMax;
	capacidadMaxima= capacidadMax;
	costoKmPorViaje = costoKM;
	acompaņante = acompaņantE;
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

	public double getAcompaņante() {
		return acompaņante;
	}


	public double getSeguroCarga() {
		return seguroCarga;
	}

	public boolean isFrigorifico() {
		return this.frigorificoo;
	}


	@Override
	public String toString() {
		return "TrailerComun [acompaņante=" + acompaņante + ", seguroCarga=" + seguroCarga + ", frigorificoo="
				+ frigorificoo + "]";
	}

	

}
