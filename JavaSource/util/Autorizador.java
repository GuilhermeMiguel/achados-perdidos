package util;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import modelo.Funcionario;


public class Autorizador implements PhaseListener {

	private static final long serialVersionUID = 1L;
	
	@Override
	public void afterPhase(PhaseEvent event) {
		
		FacesContext context = event.getFacesContext();
		
		
		String nomePagina = context.getViewRoot().getViewId();
		
		System.out.println(nomePagina);
	
		if("/index.xhtml".equals(nomePagina)) {
			return;
		}
		
		if("/cadastro.xhtml".equals(nomePagina)) {
			return;
		}
		
		if("/pesquisa-objetos.xhtml".equals(nomePagina)) {
			return;
		}
		
		Funcionario usuarioLogado = (Funcionario) context.getExternalContext().getSessionMap().get("funcionarioLogado");
		
		if(usuarioLogado != null) {
			return; //continua normalmente a execução
		}
		
		//redirecionamento para a página de login.xhtml caso o usuário não esteja logado
		NavigationHandler handler = context.getApplication().getNavigationHandler();
		handler.handleNavigation(context, null, "/index?faces-redirect=true");
		context.renderResponse();
	}

	@Override
	public void beforePhase(PhaseEvent event) {
		
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}
