let id = 0;

document.querySelector('body').onload = function constructBoard() {
  const board = document.getElementById('quadro');

  const div = document.createElement('div');
  div.classList.add('carta');

  const img = document.createElement('img');
  img.classList.add('carta-imagem');
  img.setAttribute('id', id++);
  img.setAttribute('src', '../images/human-head.png');
  img.setAttribute('alt', 'funcionario');

  const p = document.createElement('p');
  p.textContent = "Name";

  div.appendChild(img);
  div.appendChild(p);
  board.appendChild(div);
}