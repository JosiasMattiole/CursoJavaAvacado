module.exports = function(nome, peso, altura, elemento){
    var result = peso / (altura*altura);

    elemento.innerText = 'Olá, ' + nome + '. Seu IMC é ' + result;
}