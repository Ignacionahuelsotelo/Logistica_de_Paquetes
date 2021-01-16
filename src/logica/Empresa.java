package logica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Empresa {
	
	private double  cargaPaquete;
	private String cuit, nombre;
	private int  numeroDep,numeroDepFrioTerceriz;
	
	
	private ArrayList<Deposito> depositos;
	private ArrayList<Paquete> paquetes ;
	private ArrayList<String> transportesEnViaje;
	private HashMap<String, Tupla<Transporte, String, Paquete>> transportes;
	private HashMap<String, Integer> destinosAgregados;
//------------------------------------------------------------------------CONSTRUCTOR--------------------------------------------	
	
	public Empresa(String cuiT, String nombrE) {
		
		cuit= cuiT;
		nombre=nombrE;
		numeroDep=0;
		numeroDepFrioTerceriz=0;
		
		paquetes = new ArrayList<Paquete>();
		transportesEnViaje= new ArrayList<String>();
		depositos = new ArrayList<Deposito>();
		transportes = new HashMap<String,Tupla<Transporte, String, Paquete>>();
		destinosAgregados= new HashMap<String, Integer>();
	
	}	

		
		
		
//----------------------------------------------------------AGREGA DEPOSITOS--------------------------------		
		
	public int agregarDeposito(Integer capacidad, boolean frigorifico, boolean propio) {
			Deposito d = new Deposito(capacidad,propio,frigorifico);
			depositos.add(d);
			numeroDep = numeroDep +1;
			d.setNumeroDeDeposito(numeroDep);
			System.out.println("Numero de Deposito = " + numeroDep);
			return d.getNumeroDeDeposito() ;
		}


	public int agregarDepTercerizFrio(Integer capacidad,double costoPorTonelada) {
		DepositoFrigorificoTerceriz d = new  DepositoFrigorificoTerceriz(capacidad, costoPorTonelada);
		depositos.add(d);
		numeroDepFrioTerceriz = numeroDepFrioTerceriz +1;
		d.setNumeroDeDeposito(numeroDepFrioTerceriz);
		System.out.println("Numero de Deposito Frigorifico Tercerizado = " + numeroDepFrioTerceriz);
		return d.getNumeroDeDeposito() ;
	}
	
 //---------------------------------------------------------------------AGREGA DESTINOS------------------------------------------
	public void agregarDestino(String destinO, Integer km) {

		destinosAgregados.put(destinO, km);
		
	}
//// -----------------------------------------------------------------------------AGREGA TRANSPORTES--------------------------------------------	
	public void agregarFlete(String idTransp, double cargaMax, double capacidad, double
			costoKm, int acomp, double costoPorAcom) {
		
		Flete flete = new Flete(cargaMax, capacidad, acomp, costoKm, costoPorAcom);
		Tupla<Transporte, String, Paquete> tupla = new Tupla<Transporte, String, Paquete>(flete,null,null);
		transportes.put(idTransp, tupla);                                                                                             
	}
	
	
	public  void agregarTrailer(String idTransp, double cargaMax, double capacidad, int acompañante,
			boolean frigorifico, double costoKm, double segCarga) {
		
		TrailerComun trailer = new TrailerComun(cargaMax, capacidad, acompañante, costoKm, frigorifico, segCarga);
		Tupla<Transporte, String, Paquete> tupla = new Tupla<Transporte, String, Paquete>(trailer,null,null);
		transportes.put(idTransp, tupla);                                      // lo agrego al AArrayList de transportes tambien para usar el obtenerTransporteIgual
	}
	
	public void agregarMegaTrailer(String idTransp, double cargaMax, double capacidad,
			boolean frigorifico, double costoKm, double segCarga, double costoFijo, double
			comida) {
		
		MegaTrailer mTrailer = new MegaTrailer(cargaMax, capacidad, frigorifico, costoKm, segCarga, costoFijo, comida);
		Tupla<Transporte, String, Paquete> tupla = new Tupla<Transporte, String, Paquete>(mTrailer,null,null);
		transportes.put(idTransp, tupla);
		
	}	

// -----------------------------------------------------------------------AGREGA PAQUETES A DEPOSITOS------------------------------------------------
	
	public boolean incorporarPaquete(String destino, double peso, double volumen, boolean frio) { 															
		
		Paquete p = new Paquete(destino,peso,volumen,frio);
		if (depositos.size() == 0 ) {
			return false;
		}
		else {
			for (int i = 0; i<depositos.size();i++) {
				if (frio == true) {
					if (cargaPaquete < depositos.get(i).getCapacidadMaxima() && depositos.get(i).isFrigorifico() == true) {
						
						if (depositos.get(i) instanceof DepositoFrigorificoTerceriz) {
							DepositoFrigorificoTerceriz d = (DepositoFrigorificoTerceriz) depositos.get(i);
							p.setDondeSeGuardo(true);
							p.setCosto(d.getCostoTonelada());
						}
					
						
						paquetes.add(p);
						cargaPaquete = cargaPaquete + p.getVolumen();
						return true; 
					
					}
				}
				else {
					if (cargaPaquete < depositos.get(i).getCapacidadMaxima() && depositos.get(i).isFrigorifico() == false) {
						
						paquetes.add(p);
						cargaPaquete = cargaPaquete + p.getVolumen();
						return true;
					}
				}
			}
		}
	return false;
	}

	
// ----------------------------------------------------------------------ASIGNA DESTINO Y CARGA EL TRANSPORTE ----------------------------------------------

	
	public void asignarDestino (String idTransp, String destino) { 
	
		for (Entry<String, Tupla<Transporte, String, Paquete>> entry : transportes.entrySet()) {
				if (entry.getKey().equals(idTransp)  ) {
					for (String s : destinosAgregados.keySet())
						if (s.equals(destino))
							entry.getValue().setSegundoElem(destino);
							entry.getValue().getPrimerElem().setDestino(destino);
			}
		}
	}

	public double cargarTransporte(String idTransp) {
		StringBuilder sb = new StringBuilder();
		double cargaGuardada =0;
			for (Entry<String, Tupla<Transporte, String, Paquete>> entry : transportes.entrySet()) {
				if (entry.getKey() == idTransp && transportesEnViaje.contains(idTransp)== false ) { 
					if (paquetes.isEmpty() ) {												
						sb.append("No hay paquetes para cargar");
						System.out.println (sb.toString());
					}
					else { 
						Iterator<Paquete>  it = paquetes.iterator();
						while (it.hasNext() && entry.getValue().getSegundoElem() != null ) {					
							Paquete p = it.next();
							
							if (entry.getValue().getPrimerElem().getCargaMaxima() >= cargaGuardada && cargaGuardada 
								+ p.getVolumen() <= entry.getValue().getPrimerElem().getCargaMaxima() 
								&& entry.getValue().getSegundoElem().equals(p.getDestino()) && entry.getValue().getPrimerElem().isRefrigeracion() == p.isFrio()) {
								
								cargaGuardada = cargaGuardada + p.getVolumen();
								entry.getValue().setTercerElem(p);
								it.remove();
						}		
					}
					}
					entry.getValue().getPrimerElem().setCarga(cargaGuardada);
				}
				else if (transportesEnViaje.contains(idTransp) == true) {
					sb.append("El transporte con ID : ").append(idTransp).append("esta en viaje");
					System.out.println(sb.toString() ); 
					return 0;
				}
				
			}
			return cargaGuardada;
			
			
	}
	

//-----------------------------------------------------------------VIAJES----------------------------------------------------------------	
	public void iniciarViaje(String idTransp) {
		for (Entry<String, Tupla<Transporte, String, Paquete>> entry : transportes.entrySet()) {
			if (entry.getKey().equals(idTransp) && entry.getValue().getSegundoElem() != null &&  entry.getValue().getTercerElem() != null) {
				transportesEnViaje.add(entry.getKey());   
				System.out.println("Comenzo el viaje del transporte con ID " + idTransp);
				return;
			}
		}
		System.out.println("El transporte con ID :" + idTransp +" no pudo iniciar su viaje, revisar que se le haya asignado una carga o un destino");
	}
	
	public void finalizarViaje(String idTransp) {
		for (Entry<String, Tupla<Transporte, String, Paquete>> entry : transportes.entrySet()) {
			if (entry.getKey().equals(idTransp)) {
				entry.getValue().setSegundoElem(null);
				entry.getValue().setTercerElem(null);
			}	
			}
		Iterator <String> it = transportesEnViaje.iterator();
		while (it.hasNext()) {
			String s = it.next();
			if(s.equals(idTransp)) {
				it.remove();
			}
		}
		System.out.println("Finalizo el viaje del transporte con ID : "+ idTransp);	
		return ;
		
}


	public Integer dameKm (String destino ) {
		for (Entry <String, Integer> entry : destinosAgregados.entrySet()) {
			if (entry.getKey().equals(destino)) {
				return entry.getValue();
			}
		}
		return 0;
	}
	
	public double obtenerCostoViaje(String idTransp) {  
		for (Entry<String, Tupla<Transporte, String, Paquete>> entry : transportes.entrySet()) {
			
			if (entry.getValue().getPrimerElem() instanceof Flete && entry.getKey().equals(idTransp) && entry.getValue().getSegundoElem() != null && entry.getValue().getTercerElem() !=null) {
				
				Flete f = (Flete)entry.getValue().getPrimerElem();
				
				if (entry.getValue().getTercerElem().getDondeSeGuardo() == true) { // si es True quiere decir que se guardo en un DepositoFrigorificoTerceriz
				
					return (f.getAcompañante()*f.getCostoAcompañante()) + (f.getCostoKmPorViaje()* dameKm(entry.getValue().getSegundoElem())) + 
							((entry.getValue().getTercerElem().getCosto() * f.getCargaMaxima()) / 1000);
				
				}
				
				return f.getAcompañante()*f.getCostoAcompañante()+ (f.getCostoKmPorViaje()* dameKm(entry.getValue().getSegundoElem())) ;
			}
			if (entry.getValue().getPrimerElem() instanceof TrailerComun && entry.getKey().equals(idTransp) && entry.getValue().getSegundoElem() != null && entry.getValue().getTercerElem() !=null) {
				
				TrailerComun tc = (TrailerComun)entry.getValue().getPrimerElem();
				
				if (entry.getValue().getTercerElem().getDondeSeGuardo() == true) {
					
					return  ((entry.getValue().getTercerElem().getCosto() * tc.getCargaMaxima() ) /1000) 
							+ tc.getSeguroCarga() +  (dameKm(entry.getValue().getSegundoElem()) * tc.getCostoKmPorViaje()) ;
				}
				
					return tc.getSeguroCarga()+ (tc.getCostoKmPorViaje()* dameKm(entry.getValue().getSegundoElem()));
			}
			
			if (entry.getValue().getPrimerElem() instanceof MegaTrailer && entry.getKey().equals(idTransp) && entry.getValue().getSegundoElem() != null && entry.getValue().getTercerElem() !=null) {
				
				MegaTrailer mg = (MegaTrailer) entry.getValue().getPrimerElem();
				
				if (entry.getValue().getTercerElem().getDondeSeGuardo() == true) {
					return mg.getCostoFijado() + mg.getSeguroCarga() + ((entry.getValue().getTercerElem().getCosto() * mg.getCargaMaxima()) / 1000) + 
							(dameKm(entry.getValue().getSegundoElem()) * mg.getCostoKmPorViaje()) + mg.getComidA();
				}
				return mg.getSeguroCarga()+ (dameKm(entry.getValue().getSegundoElem()) * mg.getCostoKmPorViaje()) 
						+ mg.getComidA()+mg.getCostoFijado(); 
			}
			
	}
		return 0;
	}

	
	
// ------------------------------------------------------------------------ OBTENER TRANSPORTES IGUAL -------------------------------------------------------	
	public String obtenerTransporteIgual(String idTransp) {
		for (Entry<String, Tupla<Transporte, String, Paquete>> entry : transportes.entrySet()) {
			if (entry.getKey().equals(idTransp)) {
				for (Entry<String, Tupla<Transporte, String, Paquete>> entry2 : transportes.entrySet()) {
					if (entry.getValue().getPrimerElem().equals(entry2.getValue().getPrimerElem()) && 
							entry.getKey().equals(entry2.getKey()) == false) {
							return entry2.getKey();
					}
		
				}
				System.out.println("No hay un transporte igual al " +  idTransp );
			}
		}
		return null;
	}

//-------------------------------------------------------------TO STRING -------------------------------------------------------------------------	
	@Override
	public String toString() {
		return "Empresa [cuit=" + cuit + ", nombre=" + nombre + ", depositos="
				+ depositos  + ", paquetes=" + paquetes + " destinos=" + destinosAgregados.toString()
				+  ", Ids con sus transportes, destinos y paquetes asignados" + transportes.toString()
				+ ", transportesEnViaje= " + transportesEnViaje + " ] "; 
	}


//---------------------------------------------------------FIN----------------------------------------------------------------------

}





