$( ".adicionar, .pesquisar" ).click(function( event ) {
  event.preventDefault();
}); 

function iniciaModal(modalID) {
        const modal = document.getElementById(modalID);
        modal.classList.add('mostrar');
        modal.addEventListener('click', (e) => {
            if(e.target.className == 'fechar-modal') {
                modal.classList.remove('mostrar');
            }
        });
    }

    const cadastrar = document.querySelector('.cadastro #botao2');
    cadastrar.addEventListener('click', () => iniciaModal('modal-principal'));