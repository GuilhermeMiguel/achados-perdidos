package controle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import DAO.ObjetoDAO;
import modelo.Objeto;

@ManagedBean
@SessionScoped
public class ObjetoController {

	private Objeto objeto;
	private ObjetoDAO objDAO = ObjetoDAO.getInstance();
	
	
	public ObjetoController() {
		objeto = new Objeto();
	}
	
	public void cadastraObjeto() {
		if(!objDAO.objetoExiste(objeto.getId())){
			objDAO.create(objeto);
		}
		else {
			atualizaObjeto();
		}
	}
	
	public void atualizaObjeto() {
		objDAO.update(objeto);
	}
	
	public void pesquisaObjeto() {
		objDAO.pesquisaCadastroObjeto();
	}
	
}
