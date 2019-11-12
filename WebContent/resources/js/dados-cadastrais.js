      function iniciaModal(modalID) {
           const modal = document.getElementById(modalID);
           modal.classList.add('mostrar');
           modal.addEventListener('click', (e) => {
               if(e.target.className == 'fechar-modal') {
                   modal.classList.remove('mostrar');
               }
           });
       }
   
       const cadastrar = document.querySelector('.alterar-senha');
       cadastrar.addEventListener('click', () => iniciaModal('modal-principal'));
       
       
       
$(document).ready(function(){
    $('.iptNascimento').mask('00/00/0000');
});

//$(document).ready(function(){
//    $('.iptEmail').val($.cookie("email-usuario"));
// 
//});
//
//window.setTimeout(function(){
//	   document.getElementById("botao_2").click();
//	}, 8000);
//
