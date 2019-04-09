function dataEvento(campo) {
    // Declare variables 
    var input, filter, table, tr, td1, i, txtValue;
    input = document.getElementById(campo);
    filter = input.value.toUpperCase();
    table = document.getElementById("tableDetalhes");
    tr = table.getElementsByTagName("tr");

    // Percorre todas as linhas da tabela, e esconde as que nao sao iguais a busca digitada
    for (i = 0; i < tr.length; i++) {
        if(campo==="inputDataEvento"){
            td = tr[i].getElementsByTagName("td")[3];
            document.getElementById("inputBandeira").value="";
            document.getElementById("inputNSU").value="";
        }if(campo==="inputBandeira"){
            td = tr[i].getElementsByTagName("td")[29];
            document.getElementById("inputDataEvento").value="";
            document.getElementById("inputNSU").value="";
        }if(campo==="inputNSU"){      
            td = tr[i].getElementsByTagName("td")[34];
            document.getElementById("inputBandeira").value="";
            document.getElementById("inputDataEvento").value="";
        }  
        if (td) {
            txtValue = td.textContent || td.innerText;
            if (txtValue.toUpperCase().indexOf(filter) > -1) {
                tr[i].style.display = "";
            } else {
                tr[i].style.display = "none";
            }
        } 
    }
}



