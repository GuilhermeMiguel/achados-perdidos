package modelo;

public class CadastroObjeto {

	private int Id;
	private int idEntregador;
	private String categoria;
	private String cor;
	private Double tamanho;
	private String local;
	private String turno;
	private String infoComplementares;

	
	
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getIdEntregador() {
		return idEntregador;
	}
	public void setIdEntregador(int idEntregador) {
		this.idEntregador = idEntregador;
	}
	
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public Double getTamanho() {
		return tamanho;
	}
	public void setTamanho(Double tamanho) {
		this.tamanho = tamanho;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}
	public String getInfoComplementares() {
		return infoComplementares;
	}
	public void setInfoComplementares(String infoComplementares) {
		this.infoComplementares = infoComplementares;
	}
	
}
