function Pessoa(nome){
	this.nome = nome;
}

Pessoa.prototype.dizOi = function(){
	console.log('Olá, meu nome é', this.nome);
}

Pessoa.prototype.dizTchau = function(){
	console.log('Tchauuu !!');
}

function Funcionario(nome, cargo){
	Pessoa.call(this, nome);
	this.cargo = cargo;
}

Funcionario.prototype = new Pessoa;
Funcionario.prototype.constructor = Funcionario;

Funcionario.prototype.dizOi = function(){
	console.log('Olá, me chamo', this.nome, 'e trabalho no cargo', this.cargo);
}

var pedro = new Pessoa('Pedro');

pedro.dizOi();
pedro.dizTchau();

var joao = new Funcionario('João', 'estagiário');
joao.dizOi();
joao.dizTchau();

console.log('João é instancia de Pessoa', joao instanceof Pessoa);
console.log('João é instancia de Funcionario', joao instanceof Funcionario);
console.log('Pedro é instancia de Pessoa', pedro instanceof Pessoa);
console.log('Pedro é instancia de Funcionario', pedro instanceof Funcionario);