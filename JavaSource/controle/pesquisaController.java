package controle;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import DAO.CategoriaDAO;
import DAO.ObjetoDAO;
import modelo.Objeto;

@ManagedBean
@SessionScoped
public class pesquisaController {

	private List<Objeto> objetoList;
	private Objeto objeto;
	private ObjetoDAO objDAO = ObjetoDAO.getInstance();
	private CategoriaDAO categoriaDAO = CategoriaDAO.getInstance();
	private List<String> categoriaList;
	
	public pesquisaController() {
		objeto = new Objeto();
		carregaCombo();
	}

	
	public List<Objeto> getObjetoList() {
		return objetoList;
	}


	public void setObjetoList(List<Objeto> objetoList) {
		this.objetoList = objetoList;
	}


	public Objeto getObjeto() {
		return objeto;
	}

	public void setObjeto(Objeto objeto) {
		this.objeto = objeto;
	}
	
	public List<String> getCategoriaList() {
		return categoriaList;
	}

	public void setCategoriaList(List<String> categoriaList) {
		this.categoriaList = categoriaList;
	}
	
	public void pesquisaObjeto() {
	
		if(objeto.getCor().length() > 0 && objeto.getCategoria().length() > 0 
				&& objeto.getDataEncontro().length() > 0 ) {
			String[] datas = formataDatas(objeto.getDataEncontro(), objeto.getDataAuxiliar());
			objetoList = objDAO.pesquisaObjeto(objeto.getCor(), objeto.getCategoria(), datas[0], datas[1]);
		}
	}
	
	public void carregaCombo() {
		categoriaList = categoriaDAO.buscaCategoriaCombo();
	}
	
	public String[] formataDatas(String dtIn, String dtFim) {
		String[] datas = new String[2];
		
		if(dtIn == null && dtFim == null || dtIn == "" && dtFim == "") {
			datas[0] = "";
			datas[1] = "";
			return datas;
		}
		
        datas[0] = dtIn.substring(6, 10) + "-" + dtIn.substring(3, 5) + "-"
                        + dtIn.substring(0, 2);

        datas[1] = dtFim.substring(6, 10) + "-" + dtFim.substring(3, 5) + "-"
                      + dtFim.substring(0, 2);
        return datas;
	}
}
