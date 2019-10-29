package controle;

import modelo.DevolucaoObjeto;
import util_pdf.gerarPdf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import DAO.DevolucaoObjetoDAO;
import DAO.ObjetoDAO;

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
		gerarPdf pdf = new gerarPdf();
		
		//colocar um campo para a pessoa dizer ou nao se quer gerar pdf
		if(objeto.getStatus().equals("Devolvido")) {
			pdf.geraPdf(objeto.getNomeDono(), objeto.getNomeDono(), objeto.getDataDevolucao());
		}
		
	}
	
	public void atualizaDevolucaoObjeto() {
		devObjetoDAO.update(objeto);
	}
	
	public void pesquisaDevolucaoObjeto() {

	}
}
