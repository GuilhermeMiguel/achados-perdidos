	var ctx = document.getElementsByClassName("line-chart");

			var chartGraph = new Chart(ctx, {
				type : 'line',
				data : {
					labels : [ "Jan", "Fev", "Mar", "Abr", "Mai", "Jun", "Jul",
							"Ago", "Set", "Out", "Nov", "Dez" ],
					datasets : [
							{
								label : "TAXA DE PERDIDOS - 2019",
								data : [ 5, 10, 5, 14, 20, 15, 6, 14, 8, 12,
										15, 5, 10 ],
								borderWidth : 6,
								borderColor : 'rgba(54,84,99, 1)',
								backgroundColor : 'transparent',
							},

							{
								label : "TAXA DE DEVOLVIDOS - 2020",
								data : [ 10, 15, 20, 30, 44, 55, 11, 2, 8, 12,
										20, 6, 13 ],
								borderWidth : 6,
								borderColor : '#694077',
								backgroundColor : 'transparent',
							}, ]
				},
				options : {
					title : {
						display : true,
						fontSize : 20,
						text : "OBJETOS PERDIDOS vs DEVOLVIDOS"
					},
					labels : {
						fontStyle : 'bold'
					}
				}
			});
			
			
			  //Importa-se o arquivo jquery de mascara no html e depois se faz uma funcao setando o campo e se faz assim
		    $(document).ready(function(){
		        $('.input-data').mask('00/00/0000');
		     });