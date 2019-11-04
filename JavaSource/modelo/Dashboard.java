package modelo;

public class Dashboard {

	private int quantDevolvidos;
    private int quantPerdidos;
    private String quantLocal;
    private int quantReciclados;
    private int quantDoados;
    
    private String quantCategoria;
        
    private String dataInicio;
    private String dataFim;
    
	public int getQuantDevolvidos() {
		return quantDevolvidos;
	}
	public void setQuantDevolvidos(int quantDevolvidos) {
		this.quantDevolvidos = quantDevolvidos;
	}
	public int getQuantPerdidos() {
		return quantPerdidos;
	}
	public void setQuantPerdidos(int quantPerdidos) {
		this.quantPerdidos = quantPerdidos;
	}
	
	public String getQuantLocal() {
		return quantLocal;
	}
	public void setQuantLocal(String quantLocal) {
		this.quantLocal = quantLocal;
	}
	public int getQuantReciclados() {
		return quantReciclados;
	}
	public void setQuantReciclados(int quantReciclados) {
		this.quantReciclados = quantReciclados;
	}
	public int getQuantDoados() {
		return quantDoados;
	}
	public void setQuantDoados(int quantDoados) {
		this.quantDoados = quantDoados;
	}
	public String getQuantCategoria() {
		return quantCategoria;
	}
	public void setQuantCategoria(String quantCategoria) {
		this.quantCategoria = quantCategoria;
	}
	
	public String getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}
	
	public String getDataFim() {
		return dataFim;
	}
	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}  
}
