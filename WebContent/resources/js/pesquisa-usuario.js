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