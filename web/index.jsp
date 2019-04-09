<%-- 
    Document   : index
    Created on : 06/04/2019, 15:25:19
    Author     : Tenente
--%>

<%@page import="java.io.PrintWriter"%>
<%@page import="JavaClasses.Trailler"%>
<%@page import="JavaClasses.Detalhe"%>
<%@page import="JavaClasses.Header"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.FileNotFoundException"%>
<%@page import="JavaClasses.Controle"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.FileReader"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Teste Equals</title>
        <link rel="shortcut icon" href="https://www.equals.com.br/wp-content/themes/equals-theme/assets/img/favicon.ico">
        <!-- CSS Bootstrap -->
        <link rel="stylesheet" href="CSS/style.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <!-- JS, Popper.js, e jQuery do Bootstrap -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
       
        <script src="JS/scripts.js"></script>
        
        
    </head>
    <body class="container-fluid">
        
        <%
            Controle controleDosDados = new Controle();
            //recebendo o local do diretório onde ficou salvo o arquivo de texto
            String arquivoEquals = request.getAttribute("equalsAplication.caminho").toString();
            // Essa linha irá referenciar uma linha por vez
            String linha = null;

            try {
                // FileReader reads text files in the default encoding.
                FileReader leitorDeArquivos = new FileReader(arquivoEquals);

                // Always wrap FileReader in BufferedReader.
                BufferedReader bufferedReader = new BufferedReader(leitorDeArquivos);

                while((linha = bufferedReader.readLine()) != null) {
                    try{
                        controleDosDados.setLinha(linha);
                    }catch(Exception e){
                       out.println("Arquivo nao se encontra nos padrões de leitura especificados.<br>");
                       out.println("Erro: "+e.getMessage());
                       return;
                    }
                    
                }   
                // Fecha o arquivo
                bufferedReader.close();         
            }
            catch(FileNotFoundException ex) {
                System.out.println("Nao foi possivel abrir o arquivo '" + arquivoEquals + "'");                
            }
            catch(IOException ex) {
                System.out.println("Erro na leitura do arquivo '" + arquivoEquals + "'");                  
            }
        %>
        
        <div class="logo">
            <a href="https://www.equals.com.br">
                 <img src="https://www.equals.com.br/wp-content/themes/equals-theme/assets/img/logo_equals.png">
            </a>
        </div>
        <br>
        
        <div id="registroHeader" class="navbar navbar-light bg-light scrollDivider" >
            <table class="table table-bordered table-hover table-sm">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">Tipo de registro</th>
                        <th scope="col">Estabelecimento</th>
                        <th scope="col">Data de Processamento</th>
                        <th scope="col">Período Inicial</th>
                        <th scope="col">Período Final</th>
                        <th scope="col">Sequência</th>
                        <th scope="col">Empresa Adquirente</th>
                        <th scope="col">Tipo de extrato</th>
                        <th scope="col">Filler</th>
                        <th scope="col">Versão Layout</th>
                        <th scope="col">Versão Release</th>
                        <th scope="col">Reservado para uso futuro</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        String html="";
                        for(int i=0;i<controleDosDados.getListaRegistros().size();i++){
                            if(controleDosDados.getListaRegistros().get(i) instanceof Header){
                                Header obj =((Header)controleDosDados.getListaRegistros().get(i));
                                html +="<tr>";
                                html +="<td>"+obj.getTipoRegistro()+"</td>";
                                html +="<td>"+obj.getEstabelecimento()+"</td>";
                                html +="<td>"+obj.getDatadeProcessamento()+"</td>";
                                html +="<td>"+obj.getPeriodoInicial()+"</td>";
                                html +="<td>"+obj.getPeriodoFinal()+"</td>";
                                html +="<td>"+obj.getSequencia()+"</td>";
                                html +="<td>"+obj.getEmpresaAdquirinte()+"</td>";
                                html +="<td>"+obj.getTipoDeEstrato()+"</td>";
                                html +="<td>"+obj.getFiller()+"</td>";
                                html +="<td>"+obj.getVersaoLayout()+"</td>";
                                html +="<td>"+obj.getVersaoRelease()+"</td>";
                                html +="<td>"+obj.getReservado()+"</td>";
                                html +="</tr>";
                            }
                        }
                    %>
                    <%=html%>
                </tbody>
            </table>    
            
        </div>
        <br>
        <div class="form-group navbar navbar-light bg-light">
            <table >
                <tbody>
                    <tr>
                        <td>
                            <label for="inputDataEvento">Pesquisar data do evento: </label>
                            <input class="form-control" type="number" placeholder="dd/mm/yyyy" id="inputDataEvento" onkeyup="dataEvento('inputDataEvento')" size="30px !important" />
                        </td>
                        <td>
                            <label for="inputBandeira">Pesquisar pela bandeira: </label>
                            <input class="form-control" type="text" placeholder="Ex.:Visa, Mastercard" id="inputBandeira" onkeyup="dataEvento('inputBandeira')" size="30px !important" />
                        </td>
                        <td>
                            <label for="inputNSU">Pesquisar pelo NSU </label>
                            <input class="form-control" type="number" placeholder="xxxxxxxxxx" id="inputNSU" onkeyup="dataEvento('inputNSU')" size="30px !important" />
                        </td>
                    </tr>
                </tbody>
            </table>
   
        </div>
        <div id="registroDetalhes" class=" navbar navbar-light bg-light scrollDivider" style="display:block!important; margin-top: -20px">
            <table class=" table table-bordered table-hover table-sm" id="tableDetalhes">
                <thead class="thead-dark">
                    <tr>
                        <th>Tipo de registro</th>
                        <th>Estabelecimento</th>
                        <th>Data inicial da transação</th>
                        <th>Data do evento</th>
                        <th>Hora do evento</th>
                        <th>Tipo de evento </th>
                        <th>Tipo de transação</th>
                        <th>Número de série do leitor</th>
                        <th>Código da transação</th>
                        <th>Código do pedido</th>
                        <th>Valor total da transação</th>
                        <th>Valor da parcela ou total</th>
                        <th>Pagamento</th>
                        <th>Plano</th>
                        <th>Parcela</th>
                        <th>Qtd de parcelas da transação</th>
                        <th>Data prevista de pagamento</th>
                        <th>Taxa de parcelamento comprador</th>
                        <th>Tarifa boleto comprador</th>
                        <th>Valor original da transação</th>
                        <th>Taxa de parcelamento vendedor</th>
                        <th>Taxa de intermediação</th>
                        <th>Tarifa de intermediação</th>
                        <th>Tarifa boleto vendedor</th>
                        <th>Repasse aplicação</th>
                        <th>Valor líquido da transação</th>
                        <th>Status do pagamento</th>
                        <th>Filler</th>
                        <th>Meio de pagamento</th>
                        <th>Instituição financeira/bandeira</th>
                        <th>Canal de entrada</th>
                        <th>Leitor</th>
                        <th>Meio de captura</th>
                        <th>Número lógico </th>
                        <th>NSU</th>
                        <th>Filler</th>
                        <th>Cartão Bin</th>
                        <th>Cartão Holder</th>
                        <th>Código de Autorização</th>
                        <th>Código do CV</th>
                        <th>Reservado para futuros</th>
                    </tr>
                </thead>
                <tbody >
                    <% 
                        //Limpa a String da Tabela para reaproveitar a variavel
                        html ="";
                        //Funçao percorre todo array de Registros buscando os registros do tipo Detalhe
                        //E concatena os dados do objeto na string para formular o HTML
                        html = controleDosDados.criaLinhasDaTabela("");
                    %>
                    <%=html%>
                </tbody>
            </table>
        </div>
        <div class="navbar navbar-light bg-light scrollDivider">
            <table class="table table-bordered table-hover table-sm">
                <thead class="thead-dark">
                    <tr>
                        <th>Tipo de registro</th>
                        <th>Total de registro</th>
                        <th>Reservado para futuro</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        // Limpa a String da Tabela para reaproveitar a variavel
                        html="";
                        for(int i=0;i<controleDosDados.getListaRegistros().size();i++){
                            if(controleDosDados.getListaRegistros().get(i) instanceof Trailler){
                                Trailler obj =((Trailler)controleDosDados.getListaRegistros().get(i));
                                html +="<tr>";
                                html +="<td>"+obj.getTipoRegistro()+"</td>";
                                html +="<td>"+obj.getTotalRegistro()+"</td>";
                                html +="<td>"+obj.getReservadoParaFuturo()+"</td>";
                                html +="</tr>";
                            }
                        }
                    %>
                    <%=html%>
                </tbody>
            </table>
        </div>
    </body>
</html>
