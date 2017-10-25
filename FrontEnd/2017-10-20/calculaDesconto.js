desconto = function(valor, desconto){
	desconto = desconto || 25;
    return (valor * desconto) / 100;
}

console.log("Desconto: ", desconto(100, 10));