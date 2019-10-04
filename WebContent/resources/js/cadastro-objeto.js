$( ".adicionar, .pesquisar" ).click(function( event ) {
  event.preventDefault();
}); 

function iniciaModal(modalID) {
	      const modal = document.getElementById(modalID);
	      modal.classList.add('mostrar');
	      modal.addEventListener('click', (e) => {
	        if (e.target.className == 'fechar-modal') {
	          modal.classList.remove('mostrar');
	        }
	      });
	    }

	    const cadastrar = document.querySelector('.cadastro #botao2');
	    cadastrar.addEventListener('click', () => iniciaModal('modal-principal'));

	    const pesquisar = document.querySelector('.cadastro #botao1');
	    pesquisar.addEventListener('click', () => iniciaModal('modal-secundario'));

	    $(document).on('click','.editar-entregador',function(){
		$('.identificacao, .acoes-entregador, .area-botao-salvar').fadeOut('slow', function(){
	    $('.objetos-modal').css("height","556px");
			$('.cadastro-entregador, .entregador-cadastrado, .area-botao-salvar-entregador').fadeIn();
		});
	});

	    $(document).on('click','.cadastrar-entregador',function(){
		$('.identificacao, .acoes-entregador, .area-botao-salvar').fadeOut('slow', function(){
	    $('.objetos-modal').css("height","556px");
			$('.cadastro-entregador, .entregador-cadastrado, .area-botao-salvar-entregador').fadeIn();
		});
	});

	$(document).on('click','.texto-entregador-cadastrado',function(){
		$('.cadastro-entregador, .entregador-cadastrado, .area-botao-salvar-entregador').fadeOut('slow', function(){
	    $('.objetos-modal').css("height","492px");
			$('.identificacao, .acoes-entregador, .area-botao-salvar').fadeIn();
		});
	});