package modelo;

public class Objeto {

	private int Id;
	private String docEntregador;
	private String categoria;
	private String cor;
	private Double tamanho;
	private String local;
	private String turno;
	private String infoComplementares;
	private String status;
	private String dataEncontro;
	private String campo;
	private String valor;
	
	//Data auxiliar para a tela de pesquisa do usuario
	private String dataAuxiliar;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
		
	public String getDocEntregador() {
		return docEntregador;
	}
	public void setDocEntregador(String docEntregador) {
		this.docEntregador = docEntregador;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDataEncontro() {
		return dataEncontro;
	}
	public void setDataEncontro(String dataEncontro) {
		this.dataEncontro = dataEncontro;
	}
	public String getCampo() {
		return campo;
	}
	public void setCampo(String campo) {
		this.campo = campo;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getDataAuxiliar() {
		return dataAuxiliar;
	}
	public void setDataAuxiliar(String dataAuxiliar) {
		this.dataAuxiliar = dataAuxiliar;
	}
	
}
