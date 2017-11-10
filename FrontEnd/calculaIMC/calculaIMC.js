export default (nome, peso, altura, elemento) => {
    var result = peso / (altura**2);

    elemento.innerText = 'Olá, ' + nome + '. Seu IMC é ' + result;
}