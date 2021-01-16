package logica;

public class MegaTrailer extends Transporte {
	
	private double seguroCarga;
	private double costoFijado; 
	private double comidA;
	private double cargaMaxima;
	private double capacidadMaxima;
	private boolean frigorificoo;

	
	public MegaTrailer( double cargaMax, double capacidadMax, boolean frigorifico,  double costoKM,
			double segCarga, double costoFijo, double comida) {
		super( frigorifico, cargaMax, capacidadMax, costoKM);

	cargaMaxima =cargaMax;
	seguroCarga=segCarga;
	costoFijado=costoFijo;
	comidA=comida;
	capacidadMaxima=capacidadMax;
	frigorificoo=frigorifico;
	costoKmPorViaje= costoKM;
	}


	

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj instanceof MegaTrailer == false){
			return false;
		}
		MegaTrailer mt = (MegaTrailer)obj;
		return  this.getCarga() == mt.getCarga() && this.getDestino().equals(mt.getDestino() );
	}

	public double getSeguroCarga() {
		return seguroCarga;
	}

	public double getCostoFijado() {
		return costoFijado;
	}

	public double getComidA() {
		return comidA;
	}





	@Override
	public String toString() {
		return "MegaTrailer [seguroCarga=" + seguroCarga + ", costoFijado=" + costoFijado + ", comidA=" + comidA
				+ ", cargaMaxima=" + cargaMaxima + ", capacidadMaxima=" + capacidadMaxima + ", frigorificoo="
				+ frigorificoo + "]";
	}

	
	
	
	
}
