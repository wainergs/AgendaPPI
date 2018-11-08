function validaForm() {
    var txtNome = document.getElementById('nome').value.trim();
    var telefone = document.getElementById('telefone').value;

    var regexNome = /^[a-zA-Zá-úà-ù]{0,}$/;
    var regexTelefone = /^\d{0,}$/;

    if (!regexNome.test(txtNome) || txtNome == '') {
        alert("Favor revisar o campo nome!")

    } else if(!regexTelefone.test(telefone) || telefone == '') {
                alert("Favor revisar o campo telefone!")
    }
    else{
        document.getElementById('form1').submit();
    }
}
function validaPesquisar() {
    var txtPesquisar = document.getElementById('txtPesquisar').value.trim();
    var regexNome = /^[a-zA-Zá-úà-ù]{0,}$/;

    if (regexNome.test(txtPesquisar) && txtPesquisar != '') {
        document.getElementById('formPesquisa').submit();
    } else {
        alert("Campo pesquisar inválido")
    }
}