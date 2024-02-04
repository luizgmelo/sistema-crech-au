let id = 0;

document.querySelector('body').onload = function constructBoard() {
  const board = document.getElementById('quadro');

  const div = document.createElement('div');
  div.classList.add('carta');

  const img = document.createElement('img');
  img.classList.add('carta-imagem');
  img.setAttribute('id', id++);
  img.setAttribute('src', '../images/pet-head.png');
  img.setAttribute('alt', 'pet');

  const p = document.createElement('p');
  p.textContent = "Name";

  const footerCard = document.createElement('div');
  footerCard.classList.add('rodape');

  const spanEdit = document.createElement('span');
  spanEdit.textContent = "edit";
  spanEdit.classList.add('material-symbols-outlined');

  const spanView = document.createElement('span');
  spanView.textContent = "visibility";
  spanView.classList.add('material-symbols-outlined');

  div.appendChild(p);
  div.appendChild(img);
  div.appendChild(footerCard);
  footerCard.appendChild(spanView);
  footerCard.appendChild(spanEdit);
  board.appendChild(div);
}