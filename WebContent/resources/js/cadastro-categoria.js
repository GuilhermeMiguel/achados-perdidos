$( ".adicionar" ).click(function( event ) {
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
    
    
    
    $(document).on("click", ".editar", function(){
        var id = $(this).closest('tr').find(".id").text();
        var descricao = $(this).closest('tr').find(".descricao").text();
        alert(id);
        $('.inputId').val(id);
        $('.inputCategoria').val(descricao);
        iniciaModal('modal-principal');
    });
    
    $(document).on("click", ".desabilitar", function(){
        var id = $(this).closest('tr').find(".id").text();
        alert('categoria desabilitada');
        $('.inputId').val(id);
        //iniciaModal('modal-principal');
        $('.btn-desabilitar').click();
    });