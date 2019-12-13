
(function ($) {
    "use strict";

    /*==================================================================
    [ Focus Contact2 ]*/
    $('.input100').each(function(){
        $(this).on('blur', function(){
            if($(this).val().trim() != "") {
                $(this).addClass('has-val');
            }
            else {
                $(this).removeClass('has-val');
            }
        })    
    })

    /*==================================================================
    [ Validate ]*/
    var input = $('.validate-input .input100');

    $('.validate-form').on('submit',function(){
        var check = true;

        for(var i=0; i<input.length; i++) {
            if(validate(input[i]) == false){
                showValidate(input[i]);
                check=false;
            }
        }

        return check;
    });


    $('.validate-form .input100').each(function(){
        $(this).focus(function(){
           hideValidate(this);
        });
    });

    function validate (input) {
        if($(input).attr('type') == 'email' || $(input).attr('name') == 'email') {
            if($(input).val().trim().match(/^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{1,5}|[0-9]{1,3})(\]?)$/) == null) {
                return false;
            }
        }
        else {
            if($(input).val().trim() == ''){
                return false;
            }
        }
    }

    function showValidate(input) {
        var thisAlert = $(input).parent();

        $(thisAlert).addClass('alert-validate');
    }

    function hideValidate(input) {
        var thisAlert = $(input).parent();

        $(thisAlert).removeClass('alert-validate');
    }
    

})(jQuery);


$(document).on('click','.texto-esqueceu',function(){
	$('.login100-form-btn').css("display","none");
	$('.input-checkbox100, .label-checkbox100, .texto-esqueceu, #caixa-senha').fadeOut('slow', function(){
		$('.iptSenha').val("1");
		$('.mensagem, .enviar-email, .voltar').fadeIn();
		$(".formulario-titulo-1").text("Recuperar senha");
		$(".formulario-titulo-1").css("margin-left", "14%");
		$(".user").text("Email");
	});
});

$(document).on('click','.voltar',function(){
	$('.mensagem, .enviar-email, .voltar').fadeOut('slow', function(){
		$('.iptSenha').val("");
		$('.label-checkbox100, .texto-esqueceu, #caixa-senha, .login100-form-btn').fadeIn();
		$(".formulario-titulo-1").text("Login");
		$(".formulario-titulo-1").css("margin-left", "");
		$(".user").text("Email/User");
	});
});

$( ".lupa" ).hover(function() {
	$('.pesquisar-objetos').fadeIn('slow');
});

$( ".lupa" ).mouseout(function() {
	$('.pesquisar-objetos').delay(1200).fadeOut('slow');
});

	$(document).on('click','.login',function(){
		//Criação do cookie
//		event.preventDefault();
		console.log($('.input100').val());
		$.cookie("email-usuario", $('.input100').val(), { expires: 5 });
	});

	
	//Depois pegar na tela de cadastro do usuario eu pego e seto num campo esse valor
	