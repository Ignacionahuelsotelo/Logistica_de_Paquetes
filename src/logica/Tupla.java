package logica;



public class Tupla < P,V,T>{
	
	private P primerElem;
	private V segundoElem;
	private T tercerElem;
		
	public Tupla (P primer, V segundo, T tercero) {
		primerElem=primer;
		segundoElem=segundo;
		tercerElem = tercero;
		}


	public P getPrimerElem() {
		return primerElem;
	}

	public void setPrimerElem(P primerElem) {
		this.primerElem = primerElem;
	}

	public V getSegundoElem() {
		return segundoElem;
	}

	public void setSegundoElem(V segundoElem) {
		this.segundoElem = segundoElem;
	}

	public T getTercerElem() {
		return tercerElem;
	}

	public void setTercerElem(T tercerElem) {
		this.tercerElem = tercerElem;
	}

	@Override
	public String toString() {
		return " [primerElem=" + primerElem + ", segundoElem=" + segundoElem + ", tercerElem=" + tercerElem + "]";
	}
	
	
	}


