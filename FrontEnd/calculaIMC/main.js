var calculaIMC = require('./calculaIMC');

var nome = document.getElementById('nome');
var peso = document.getElementById('peso');
var altura = document.getElementById('altura');

var btn = document.getElementById('calcula');

btn.onclick = function(){
    calculaIMC(nome.value, peso.value, altura.value, document.querySelector('#saida'));
}