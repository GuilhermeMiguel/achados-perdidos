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