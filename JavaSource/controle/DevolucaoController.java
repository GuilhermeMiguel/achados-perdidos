package controle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import DAO.DevolucaoObjetoDAO;
import DAO.ObjetoDAO;
import modelo.DevolucaoObjeto;

@ManagedBean
@SessionScoped
public class DevolucaoController {

	private DevolucaoObjeto objeto;
	private  DevolucaoObjetoDAO devObjetoDAO = DevolucaoObjetoDAO.getInstance();
	private  ObjetoDAO objDAO = ObjetoDAO.getInstance();

	public DevolucaoController() {
		objeto = new DevolucaoObjeto();
	}
	
	public DevolucaoObjeto getObjeto() {
		return objeto;
	}

	public void setObjeto(DevolucaoObjeto objeto) {
		this.objeto = objeto;
	}

	public void devolucaoObjeto() {
		devObjetoDAO.Devolucao(objeto);
		objDAO.alteraStatus(objeto.getStatus(), objeto.getId());
		//METODO PARA GERAR PDF
//		gerarPdf pdf = new gerarPdf();
//		
//		//colocar um campo para a pessoa dizer ou nao se quer gerar pdf
//		if(objeto.getStatus().equals("Devolvido")) {
//			pdf.geraPdf(objeto.getNomeDono(), objeto.getNomeDono(), objeto.getDataDevolucao());
//		}
		
		//https://cursos.alura.com.br/forum/topico-abrir-pdf-automaticamente-14631
		
		//https://howtodoinjava.com/library/read-generate-pdf-java-itext/
		//Posso ver como salvar o pdf numa pasta, passar o comando que executa ele (como se fosse um comando no cmd)
//e depois limpar a pasta em que ele foi salvo, pois se fizer do jeito que está ultimamente, esses pdfs seriam 
//salvos numa pasta só		
		//Ver se encotro outra maneira de implementar essa emissão do PDF.
		
	}
	
	public void atualizaDevolucaoObjeto() {
		devObjetoDAO.update(objeto);
	}
	
	public void pesquisaDevolucaoObjeto() {

	}
}
