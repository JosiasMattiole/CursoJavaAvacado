media = function(){
    var soma = 0;
    
    for(var item in arguments){
    	soma += arguments[item];
    }

    console.log("Média:", soma/arguments.length);
}

media (25, 25, 40);