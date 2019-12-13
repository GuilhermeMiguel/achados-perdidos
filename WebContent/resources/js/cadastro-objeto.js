$( ".adicionar" ).click(function( event ) {
  event.preventDefault();
}); 

	function iniciaModal(modalID) {
	      const modal = document.getElementById(modalID);
	      modal.classList.add('mostrar');
	      modal.addEventListener('click', (e) => {
	        if (e.target.className == 'fechar-modal') {
	          modal.classList.remove('mostrar');
	          $('.iptDocumento').val("");
	          $('.iptDocEntregador').val("");
	          $('.iptValor').val("");
	        	$('.iptNome').val("");
	        	$('.iptTelefone').val("");
	        	$('.iptTurmaEntregador').val("");
	        	$('.iptTurnoEntregador').val("");
	        	
	        	 $('.iptCor').val("");
		          $('.iptTamanho').val("");
		          $('.iptLocal').val("");
		        	$('.iptTurno').val("");
		        	$('.iptData').val("");
		        	$('.iptInfo').val("");
	        }
	      });
	    }

	    const cadastrar = document.querySelector('.cadastro #botao2');
	    cadastrar.addEventListener('click', () => iniciaModal('modal-principal'));

	   
// const pesquisar = document.querySelector('.cadastro #botao1');
// pesquisar.addEventListener('click', () => iniciaModal('modal-secundario'));

	    $(document).on('click','.editar-entregador',function(){
		$('.identificacao, .acoes-entregador, .area-botao-salvar').fadeOut('slow', function(){
	    $('.objetos-modal').css("height","556px");
			$('.cadastro-entregador, .entregador-cadastrado, .area-botao-salvar-entregador, .caixa-funcionario').fadeIn();
		});
	});

	    $(document).on('click','.cadastrar-entregador',function(){
		$('.identificacao, .acoes-entregador, .area-botao-salvar').fadeOut('slow', function(){
	    $('.objetos-modal').css("height","556px");
			$('.cadastro-entregador, .entregador-cadastrado, .area-botao-salvar-entregador, .caixa-funcionario').fadeIn();
		});
	});

	$(document).on('click','.texto-entregador-cadastrado',function(){
		$('.cadastro-entregador, .entregador-cadastrado, .area-botao-salvar-entregador, .caixa-funcionario').fadeOut('slow', function(){
	    $('.objetos-modal').css("height","492px");
			$('.identificacao, .acoes-entregador, .area-botao-salvar').fadeIn();
		});
	});
	
	// Importa-se o arquivo jquery de mascara no html e depois se faz uma funcao
	// setando o campo e se faz assim
    $(document).ready(function(){
        $('.iptData').mask('00/00/0000');
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

    	$('.iptDocumento').mask(MaskDoc, Options);
    	
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
    
//    	$('.iptDocumento').keyup(function(){
//    		$('.iptDocEntregador').val($(this).val());
//    	});
    	
    	
    	// Aplicar mascara ao if quando o combobox for data
    	$('.combobox-tamanho').change(function (){
    		if($('.combobox-tamanho option:selected').val()== 'Data'){
    			$('.iptPesquisa').mask('00/00/0000');
    		}
    		else if($('.combobox-tamanho option:selected').val()== 'Doc Entregador'){
    			$('.iptPesquisa').mask(MaskDoc, Options);
    		}
    	});
    	
    	

    	// Aplicar mascara ao if quando o combobox for data
    	$('.combobox-pesquisa').change(function (){
    		if($('.combobox-pesquisa option:selected').val()== 'Data'){
    			$('.iptPesquisa').mask('00/00/0000');
    		}
    		else if($('.combobox-pesquisa option:selected').val()== 'Doc Entregador'){
    			$('.iptPesquisa').mask(MaskDoc, Options);
    		}
    	});
    	
    	/* Segundo Modal */
    	 $(document).ready(function(){
    	        $('.iptFixo').mask('(00) 0000-0000');
    	     });
    	 
    	 
    	 $(document).ready(function(){
 	        $('.iptCelular').mask('(00) 00000-0000');
 	     });
    	 
    	 
    	 $(document).on("click", ".pesquisar-entregador", function(){
    		event.preventDefault();
 	        var documento1 = "27.730.305-9";
 	        var documento2 = "26.180.309-8";
 	        var sobrenome1 = "Assunção";
 	        var sobrenome2 = "Barros";
 	        var escolha = $('.iptValor').val();
 	        
 	        if(escolha == documento1){
 	        	$('.iptDocumento').val(documento1);
 	        	$('.iptDocEntregador').val(documento1);
 	        	$('.iptNome').val("Otávio Assunção");
 	        	$('.iptTelefone').val("(11) 98996-5553");
 	        	$('.iptTurmaEntregador').val("6º ADS");
 	        	$('.iptTurnoEntregador').val("Noite");
 	        }
 	        else if (escolha == documento2){
 	        	$('.iptDocumento').val(documento2);
 	        	$('.iptDocEntregador').val(documento2);
 	        	$('.iptNome').val("Arthur Vinicius Barros");
 	        	$('.iptTelefone').val("(84) 3925-1094");
 	        	$('.iptTurmaEntregador').val("3º ADS");
 	        	$('.iptTurnoEntregador').val("Tarde");
 	        }
 	       else if (escolha == sobrenome1){
 	    	   	$('.iptDocumento').val(documento1);
 	    	   $('.iptDocEntregador').val(documento2);
	        	$('.iptNome').val("Otávio Assunção");
	        	$('.iptTelefone').val("(11) 98996-5553");
	        	$('.iptTurmaEntregador').val("6º ADS");
	        	$('.iptTurnoEntregador').val("Noite");
	        }
 	      else if (escolha == sobrenome2){
 	    	 $('.iptDocumento').val(documento2);
 	    	$('.iptDocEntregador').val(documento2);
	        	$('.iptNome').val("Arthur Vinicius Barros");
	        	$('.iptTelefone').val("(84) 3925-1094");
	        	$('.iptTurmaEntregador').val("3º ADS");
	        	$('.iptTurnoEntregador').val("Tarde");
	        }
 	    });
    	 
    	 /* Editar - dar uma atenção nesses metodos js para a tabela*/
    	 
    	 $(document).on("click", ".editar", function(){
    	        var idObjeto = $(this).closest('tr').find(".idObjeto").text();
    	        var categoria = $(this).closest('tr').find(".categoria").text();
    	        var cor = $(this).closest('tr').find(".cor").text();
    	        var tamanho = $(this).closest('tr').find(".tamanho").text();
    	        var local = $(this).closest('tr').find(".local").text();
    	        var turno = $(this).closest('tr').find(".turno").text();
    	        var data = $(this).closest('tr').find(".data").text();
    	        var info = $(this).closest('tr').find(".informacoes").text();
    	        var doc = $(this).closest('tr').find(".entregador").text();
//    	        alert(idObjeto);
    	        $('.iptId').val(idObjeto);
    	        $('.combobox-categoria').val(categoria);
    	        $('.iptCor').val(cor);
    	        $('.iptTamanho').val(tamanho);
    	        $('.iptLocal').val(local);
    	        $('.iptTurno').val(turno);
    	        $('.iptData').val(data);
    	        $('.iptInfo').val(info);
    	        $('.iptDocEntregador').val(doc);
    	        iniciaModal('modal-principal');
    	    });
    	 
    	 
    	 $(document).on("click", ".devolver", function(){
    	        var id = $(this).closest('tr').find(".idObjeto").text();
//    	        alert('objetoDevolvido');
    	        $('.iptIdObjeto').val(id);
    	        //Talvez fazer um metodo que procura o objeto de acordo com o id, então eu crio um botao
    	     //que quando clicado chama a funcao que fazer essa pesquisa e seta esses valores dentro do modal
    	         iniciaModal('modal-secundario');
    	    });
    	 
    	 
    	 $(document).on("click", ".desabilitar", function(){
 	        var id = $(this).closest('tr').find(".idObjeto").text();
 	        alert('objeto desabilitada');
 	        $('.iptIdObjeto').val(id);
 	        // iniciaModal('modal-principal');
 	        $('.btn-desabilitar').click();
 	    });
    	 
    	 $(".chkProfessor").change(function() {
    	 if( $(".chkProfessor").is(":checked") == true){
    		 $('.iptTurmaEntregador').val("func");
   	         $('.iptTurnoEntregador').val("func");
   	         console.log($('.iptTurmaEntregador').val() +
   	         $('.iptTurnoEntregador').val())
    		 
   	         $('.texto-iptEntregador, .iptTurmaEntregador, .iptTurnoEntregador').css("opacity", "0");
    	 }
    	 else {
    		 $('.iptTurmaEntregador').val("");
   	         $('.iptTurnoEntregador').val("");
   	         $('.texto-iptEntregador, .iptTurmaEntregador, .iptTurnoEntregador').css("opacity", "1");
   	         console.log($('.iptTurmaEntregador').val() +
   	   	         $('.iptTurnoEntregador').val())
    	 }
    });
    	 
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