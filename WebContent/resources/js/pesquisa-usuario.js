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
     
     
     $(document).ready(function(){
         $('.iptDataInicio, .iptDataFim').mask('00/00/0000');
      });
     
     
     var MaskDoc = function (val) {
   	  if(val.length >= 13 && val.indexOf("111") >= 0){
   		  return '000.000.000.0000';
   	  }
   		return val.replace(/\D/g, '').length === 11 ? '000.000.000-0099' : '00.000.000-0999';
   	},
   	Options = {
   	  onKeyPress: function(val, e, field, options) {
   	      field.mask(MaskDoc.apply({}, arguments), options);
   	    }
   	};
   	
  
   	$(document).ready(function() {
	    $('#table').DataTable( {
			"ordering": false,
			"language": {
	        "lengthMenu": "Exibindo _MENU_ resultados",
	        "sSearch": "Pesquise por qualquer um dos campos da tabela",
	        "zeroRecords" : "Não foram encontrados objetos para essa pesquisa.",
			"info" : "Exibindo _PAGE_ de _PAGES_ resultado(s)",
			"infoEmpty" : "Exibindo 0 de _PAGES_ resultado(s)",
			"infoFiltered" : "(Resultado filtrado do total de _MAX_ registros)",
	        "paginate": {
	            "previous": "Anterior",
				"next": "Próximo"
	        }
	    }
		} );
} );
   	
   	$( ".pesquisar" ).click(function( event ) {
   	  event.preventDefault();
   	  $( ".linha" ).css("opacity", "1");
   	}); 
     
//   //Condição no combobox para aparecer os inputs corretos para pesquisam, ou entao só trocar os nomes e tamanhos deles
// 	$('.combobox-categoria').change(function (){
// 		console.log('teste');
// 		if($('.combobox-categoria option:selected').val()== 'Documento' ||
// 			$('.combobox-categoria option:selected').val()== 'RG' 
// 				|| $('.combobox-categoria option:selected').val()== 'CPF'
// 					|| $('.combobox-categoria option:selected').val()== 'RA'){
// 				
// 				$('.iptCor, .lblCor').fadeOut('slow', function(){
// 					$('.iptDocumento, .lblDocumento').fadeIn();
// 				});
// 				
// 				$('.iptDocumento').mask(MaskDoc, Options);
// 		}
// 		else {
// 			$('.iptDocumento, .lblDocumento').fadeOut('slow', function(){
//					$(' .iptCor, .lblCor').fadeIn();
//					});	
// 			 }
// 	});