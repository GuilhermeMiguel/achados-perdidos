 // Mascara Telefone
    	var SPMaskTelefone = function (val) {
    		  return val.replace(/\D/g, '').length === 11 ? '(00) 00000-0000' : '(00) 0000-00009';
    		},
    		spOptions = {
    		  onKeyPress: function(val, e, field, options) {
    		      field.mask(SPMaskTelefone.apply({}, arguments), options);
    		    }
    		};

    		$('.iptTelefone').mask(SPMaskTelefone, spOptions);

//Verificar se a tela está sendo limpa quando é carregada
$(document).ready(function(){
        $('.iptTelefone').val("");
        $('.iptEmail').val("");
        $('.iptNome').val("");
        $('.iptUsuario').val("");
        $('.iptSenha').val("");
        $('.combobox-tamanho').val("");
        $('.iptSexo').val("");
 });


	