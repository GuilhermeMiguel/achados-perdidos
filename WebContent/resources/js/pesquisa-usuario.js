 function iniciaModal(modalID) {
         const modal = document.getElementById(modalID);
         modal.classList.add('mostrar');
         modal.addEventListener('click', (e) => {
             if(e.target.id == modalID || e.target.className == 'fechar-modal') {
                 modal.classList.remove('mostrar');
             }
         });
     }
 
     const regras = document.querySelector('.regras');
     regras.addEventListener('click', () => iniciaModal('modal-principal'));
     
     
//   //Condição no combobox para aparecer os inputs corretos para pesquisam, ou entao só trocar os nomes e tamanhos deles
// 	$('.combobox-tamanho').change(function (){
// 		if($('.combobox-tamanho option:selected').val()== 'Data'){
// 			$('.iptPesquisa').mask('00/00/0000');
// 		}
// 		else if($('.combobox-tamanho option:selected').val()== 'Doc Entregador'){
// 			$('.iptPesquisa').mask(MaskDoc, Options);
// 		}
// 	});