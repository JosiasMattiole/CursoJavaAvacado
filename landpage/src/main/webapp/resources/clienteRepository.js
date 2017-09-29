$(function () {
     $('#btnSalvar').click(function () {
        salvar();
    });
});


function salvar() {
    if (validar()) {
        $.post('clientes', $('form').serialize(), function (registro) {
            $('form').each(function() {
                this.reset();
            });
        });
    }
}

function validar() {
    $('input[name=nome]').closest('.form-group').removeClass('has-error');
    if (!$('input[name=nome]').val()) {
        $('input[name=nome]').closest('.form-group').addClass('has-error');
        return false;
    }
    return true;
}