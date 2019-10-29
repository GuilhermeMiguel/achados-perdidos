package modelo;

public class mesesGraficoDashboard {

	private String[] mesesPerdidos = new String[12];
	private String[] mesesDevolvidos = new String[12];
	private String janeiro;
	
	
	public String[] getMesesPerdidos() {
		return mesesPerdidos;
	}
	
	public void setMesesPerdidos(String[] mesesPerdidos) {
		this.mesesPerdidos = mesesPerdidos;
	}
	public String[] getMesesDevolvidos() {
		return mesesDevolvidos;
	}
	public void setMesesDevolvidos(String[] mesesDevolvidos) {
		this.mesesDevolvidos = mesesDevolvidos;
	}

	public String getJaneiro() {
		return janeiro;
	}

	public void setJaneiro(String janeiro) {
		this.janeiro = janeiro;
	}
	
	
}
