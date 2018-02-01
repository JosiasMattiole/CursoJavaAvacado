angular.module('app').controller('CalculoIMCController', CalculoIMCController)

function CalculoIMCController(){
    var vm = this;
    vm.titulo = 'Calcuma IMC';
    vm.pessoa = {};

    vm.submit = function(){
        alert('Ola, ' + vm.pessoa.nome + 
                'seu IMC é ' + (vm.pessoa.peso / (vm.pessoa.altura * vm.pessoa.altura)));
    }
}