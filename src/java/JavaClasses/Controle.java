/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaClasses;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Controle {
    private String linhaAtual;
    List<Registro> listaRegistros = new ArrayList<Registro>();
    
    public void setLinha(String linha){
        this.linhaAtual = linha;
        criaRegistro();
    }
    
    public void criaRegistro(){
        char charIdentificador = this.linhaAtual.charAt(0);
        int identificador = Integer.parseInt(String.valueOf(charIdentificador));
        
        if(identificador == 0){
            Registro header = new Header(this.linhaAtual);
            this.listaRegistros.add(header);
        }if(identificador == 1){
            Registro detalhe = new Detalhe(this.linhaAtual);
            this.listaRegistros.add(detalhe);
        }if(identificador == 9){
            Registro trailler = new Trailler(this.linhaAtual);
            this.listaRegistros.add(trailler);
        }else{
            //System.out.println("Identificador do registro está incorreto");
        }
        
    }

    public List<Registro> getListaRegistros() {
        return listaRegistros;
    }
    
    
    public String criaLinhasDaTabela(String dataBusca) throws ParseException{
        String html="";
        for(int i=0;i<this.listaRegistros.size();i++){
            if(this.listaRegistros.get(i) instanceof Detalhe){
                Detalhe obj = null;
                if(dataBusca.isEmpty() || dataBusca.equals("")){
                    obj =((Detalhe)this.listaRegistros.get(i));
                }else{
                    if(((Detalhe)this.listaRegistros.get(i)).getDataEvento().equals(dataBusca)){
                        obj =((Detalhe)this.listaRegistros.get(i));
                    }
                }
                html +="<tr>\n";
                html +="    <td>"+obj.getTipoRegistro()+"</td>\n";
                html +="    <td>"+obj.getEstabelecimento()+"</td>\n";
                html +="    <td>"+obj.getDataInicialTransacao()+"</td>\n";
                html +="    <td>"+obj.getDataEvento()+"</td>\n";
                html +="    <td>"+obj.getHoraEvento()+"</td>\n";
                html +="    <td>"+obj.getTipoEvento()+"</td>\n";
                html +="    <td>"+obj.getTipoTransacao()+"</td>\n";
                html +="    <td>"+obj.getNumeroSerieLeitor()+"</td>\n";
                html +="    <td>"+obj.getCodigoTransacao()+"</td>\n";
                html +="    <td>"+obj.getCodigoPedido()+"</td>\n";
                html +="    <td>"+obj.getValorTotalDaTransacao()+"</td>\n";
                html +="    <td>"+obj.getValorParcelaOuLiquidoTotal()+"</td>\n";
                html +="    <td>"+obj.getPagamento()+"</td>\n";
                html +="    <td>"+obj.getPlano()+"</td>\n";
                html +="    <td>"+obj.getParcela()+"</td>\n";
                html +="    <td>"+obj.getQtdParcelas()+"</td>\n";
                html +="    <td>"+obj.getDataPrevistaPagamento()+"</td>\n";
                html +="    <td>"+obj.getTaxaParcelamentoComprador()+"</td>\n";
                html +="    <td>"+obj.getTarifaBoletoComprador()+"</td>\n";
                html +="    <td>"+obj.getValorOriginalTransacao()+"</td>\n";
                html +="    <td>"+obj.getTaxaParcelamentoVendedor()+"</td>\n";
                html +="    <td>"+obj.getTaxaIntermediacao()+"</td>\n";
                html +="    <td>"+obj.getTarifaIntermediacao()+"</td>\n";
                html +="    <td>"+obj.getTarifaBoletoVendedor()+"</td>\n";
                html +="    <td>"+obj.getRepasseAplicacao()+"</td>\n";
                html +="    <td>"+obj.getValorLiquidoTransacao()+"</td>\n";
                html +="    <td>"+obj.getStatusPagamento()+"</td>\n";
                html +="    <td>"+obj.getFiller1()+"</td>\n";
                html +="    <td>"+obj.getMeioPagamento()+"</td>\n";
                html +="    <td>"+obj.getInstituicaoFinanceiraBandeira()+"</td>\n";
                html +="    <td>"+obj.getCanalEntrada()+"</td>\n";
                html +="    <td>"+obj.getLeitor()+"</td>\n";
                html +="    <td>"+obj.getMeioDeCaptura()+"</td>\n";
                html +="    <td>"+obj.getNumeroLogico()+"</td>\n";
                html +="    <td>"+obj.getNsu()+"</td>\n";
                html +="    <td>"+obj.getFiller2()+"</td>\n";
                html +="    <td>"+obj.getCartaoBin()+"</td>\n";
                html +="    <td>"+obj.getCartaoHolder()+"</td>\n";
                html +="    <td>"+obj.getCodigoAutorizacao()+"</td>\n";
                html +="    <td>"+obj.getCodigoCV()+"</td>\n";
                html +="    <td>"+obj.getReservado()+"</td>\n";
                html += "</tr>\n";
            }
        }
    return html;
    }
    
}
