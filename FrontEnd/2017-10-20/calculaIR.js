function calculaDescontoIRRF(funcionario){
    var aliquota = 0

    if (funcionario.salario > 4664.68){
        aliquota = .275
    }else if (funcionario.salario > 3751.05){
        aliquota = .225
    }else if (funcionario.salario > 2826.65){
        aliquota = .15
    }else if (funcionario.salario > 1903.98){
        aliquota = .075
    }

    funcionario.irrf = funcionario.salario * aliquota

    return funcionario
}

console.log(calculaDescontoIRRF({
    nome: 'Joao da Silva',
    cargo: 'Diretor',
    salario: 7500
}))