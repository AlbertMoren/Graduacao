/**
 * Função verificar se um campo é vazio ou com texto
 * @param {*} texto 
 * @returns 
 */
function validarCampoObrigatorio(texto) {
    var dados = document.getElementById(texto);
    if(dados == null){
        alert("O campo é de preenchimento obrigatorio");
        return false;
    }
    if(dados.value.trim() === ""){
        alert("O campo nao pode esta vazio")
        return false;
    }
    alert("Deu certo pow")
    return true
}

/**
 * Função responsavel por verificar se a string está do tamanho correto
 * @param {*} texto 
 * @returns 
 */
function validarStringPorTamanho(texto) {
    var text = document.getElementById(texto);
    if (text == null) {
        alert("O elemento não existe");
        return false;
    }
    var valor = text.value.trim();
    var tamanho = valor.length;
    if (tamanho < 1 || tamanho > 10) {
        alert("valor está com o tamanho incorreto");
        return false;
    }
    alert("Deu certo");
    return true
}

/**
 * Função responsavel por verificar se tem inteiros na string informada
 * @param {*} texto 
 * @returns 
 */
function verificarSeTemInteiro(texto) {
    var campo = document.getElementById(texto);
    if(campo == null){
        alert("O elemento nao existe");
        return false;
    }
    campo = campo.value.trim();

    var contemNumero = /\d/.test(campo);

    if(contemNumero){
        alert("Contem inteiros no valor informado");
    }
    alert("Deu certo");
    return true
}

/**
 * Verifica se um opção especifica do select está selecionada
 * @param {*} selecionado 
 * @returns 
 */
function verificaSeEstaSelecionado(selecionado) {
    var estaSelecionado = document.getElementById(selecionado);

    if(estaSelecionado == null){
        alert("Não esta selecionado");
        return false;
    }
    if(estaSelecionado.value === "Selecionado"){
        alert("Está selecionado ;)");
        return true;
    }else{
        alert("Selecione uma opção");
        return false;
    }
}

/**
 * Função responsavel por verificar se um unico checkbox foi selecionado
 * @param {*} campo 
 * @returns 
 */
function varificaSeCheckboxEstaSelecionado(campo) {
    var checkbox = document.getElementById(campo);
    if (checkbox == null) {
        alert("Não esta marcado");
        return false;
    }
    if (checkbox.checked) {
        alert("Está selecionado :D");
        return true;
    }else{
        alert("Marca ai");
        return false;
    }
}

/**
 * Função respónsavel por fazer o somatorio de checkbox selecionados
 * @returns 
 */
function somaCheckboxSelecionados() {
    var checkbox = document.querySelectorAll('input[type="checkbox"]');
    var cont = 0;

    for (let index = 0; index < checkbox.length; index++) {
        if (checkbox[index].checked) {
            cont++;
        }
    }
    if(cont == 0){
        alert("Nenhum elemento selecionado");
        return false;
    }
    alert(`Sucesso! ${cont} checkbox(s) selecionado(s).`)
    return true;
}

/**
 * Função respónsavel por fazer o somatorio de radions selecionados
 * @returns 
 */
function somaRadionsSelecionados(){
    var radions = document.querySelectorAll('input[type="radio"]');
    var cont = 0;

    for (let index = 0; index < radions.length; index++) {
        if (radions[index].checked) {
            cont++;
        }
    }
    if(cont == 0){
        alert("Nenhum elemento selecionado");
        return false;
    }
    alert(`Sucesso! ${cont} radio(s) selecionado(s).`)
    return true;
}

/**
 * Função responsavel por validar campos especificos
 * @param {*} campo 
 * @param {*} nomeDoCampo 
 * @returns 
 */
function validarCampoEspecifoco(campo,nomeDoCampo) {
    if(campo == null){
        alert(`O campo ${nomeDoCampo} é de preenchimento obrigatorio`);
        return false;
    }
    if(campo.value.trim() === ""){
        alert(`O campo  ${nomeDoCampo} nao pode esta vazio`)
        return false;
    }
    return true
}

function validarSenha(senha){
    var senhaValor = senha.value.trim();
    if (senhaValor.value == "") {
        alert("O campo senha esta vazio");
        return false;
    }
    if (senhaValor.length < 4) {
        alert("O campo senha está menor do que o permitido");
        return false;
    }
    var regexMinuscula = /[a-z]/;
    if (!regexMinuscula.test(senhaValor)) {
        alert("A senha deve conter pelo menos um caracteter maiusculo");
        return false;
    }
    var regexMaiuscula = /[A-Z]/;
    if (!regexMaiuscula.test(senhaValor)) {
        alert("A senha deve conter pelo menos um caracteter Maiuscula");
        return false;
    }
    var regexEspecial = /[!@#$%^&*]/; 
    if (!regexEspecial.test(senhaValor)) {
        alert("A senha deve conter pelo menos um caractere especial (!@#$%^&*).");
        return false;
    }
    return true;
}
function validarCredenciais(nome,login,senha){
    var campoName = document.getElementById(nome);
    var campoLogin = document.getElementById(login);
    var senha = document.getElementById(senha);
    if (!validarCampoEspecifoco(campoName, nome)) {
        return false;
    }
    if (!validarCampoEspecifoco(campoLogin,login)) {
        return false;
    }
    if (!validarSenha(senha)) {
        return false;
    }
    alert("Todas as credenciais foram validadas com sucesso!");
    return true;
}