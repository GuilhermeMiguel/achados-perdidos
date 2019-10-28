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
     
   //Condição no combobox para aparecer os inputs corretos para pesquisam, ou entao só trocar os nomes e tamanhos deles
 	$('.combobox-tamanho').change(function (){
 		if($('.combobox-categoria option:selected').val()== 'Documento' ||
 			'.combobox-categoria option:selected').val()== 'RG' 
 				|| '.combobox-categoria option:selected').val()== 'CPF'
 					|| '.combobox-categoria option:selected').val()== 'RA'){
 				
 				$('.iptCor, .lblCor').fadeOut('slow', function(){
 					$('.iptDocumento, .lblDocumento').fadeIn();
 				});
 				
 				$('.iptDocumento').mask(MaskDoc, Options);
 		}
 		else {
 			$('.iptDocumento, .lblDocumento').fadeOut('slow', function(){
					$(' .iptCor, .lblCor').fadeIn();
					});	
 			 }
 	});