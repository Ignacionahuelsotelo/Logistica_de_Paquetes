package logica;

import java.util.ArrayList;

public class Transporte {


	protected String ID;
	protected double cargaMaxima;
	protected double capacidadMaxima;
	protected boolean refrigeracion;
	protected double costoKmPorViaje;

	protected String destino;
	protected double carga;
	public Transporte(boolean frio, double cargaMax, double capacidadMax,double costoKM) {
		
		cargaMaxima= cargaMax;
		capacidadMaxima= capacidadMax;
		costoKmPorViaje=costoKM;
		carga=0;
		refrigeracion= frio;
		

		
	}

	public String getID() {
		return ID;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj instanceof Transporte == false){
			return false;
		}
		Transporte trans = (Transporte)obj;
		return this.getCarga() == trans.getCarga() && this.getDestino().equals(trans.getDestino()) ;
		
	}

	public double getCargaMaxima() {
		return cargaMaxima;
	}


	public double getCapacidadMaxima() {
		return capacidadMaxima;
	}


	public boolean isRefrigeracion() {
		return refrigeracion;
	}


	public double getCostoKmPorViaje() {
		return costoKmPorViaje;
	}

	public String getDestino () {
		return destino;
	}
	
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public double getCarga () {
		return carga;
	}
	public void setCarga(double cargaGuardada) {
		this.carga = cargaGuardada;
		
	}

	@Override
	public String toString() {
		return "Transporte [ID=" + ID + ", cargaMaxima=" + cargaMaxima + ", capacidadMaxima=" + capacidadMaxima
				+ ", refrigeracion=" + refrigeracion + ", costoKmPorViaje=" + costoKmPorViaje + "destino= " + this.destino + " ]";
	}

	

		
	
}
