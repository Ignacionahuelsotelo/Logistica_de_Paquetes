package logica;

public class Flete extends Transporte{
	
	private double acompa�ante ;
	private double costoAcompa�ante;
	private String destino;
	
	public Flete( double cargaMax, double capacidadMax, double acompa�antE, double costoKM, double costoPorAcom) {
		super(false, cargaMax, capacidadMax, costoKM);
	
		
	cargaMaxima =cargaMax;
	capacidadMaxima=capacidadMax;
	costoKmPorViaje= costoKM;
	acompa�ante = acompa�antE;	
	costoAcompa�ante=costoPorAcom;
	
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

	public double getAcompa�ante() {
		return acompa�ante;
	}


	public double getCostoAcompa�ante() {
		return costoAcompa�ante;
	}
	
	public String getDestino() {
		return destino;
	}
	
	@Override
	public void setDestino(String destino) {
		this.destino = destino;
	}

	public void setAcompa�ante(double acompa�ante) {
		this.acompa�ante = acompa�ante;
	}

	@Override
	public String toString() {
		return "cargaMaxima=" + cargaMaxima + ", capacidadMaxima=" + capacidadMaxima
				+ ", refrigeracion=" + refrigeracion + ", costoKmPorViaje=" + costoKmPorViaje +  " ]";
	}
	
	
}
