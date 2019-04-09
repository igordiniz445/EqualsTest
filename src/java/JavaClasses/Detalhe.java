package JavaClasses;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Detalhe extends Registro {
    private final int estabelecimento;
    private final String dataInicialTransacao;
    private final String dataEvento;
    private final int horaEvento;
    private final int tipoEvento;
    private final int tipoTransacao;
    private final String numeroSerieLeitor;
    private final String codigoTransacao;
    private final String codigoPedido;
    private final int valorTotalDaTransacao;
    private final int valorParcelaOuLiquidoTotal;
    private final String pagamento;
    private final String plano;
    private final String parcela;
    private final int qtdParcelas;
    private final String dataPrevistaPagamento;
    private final int taxaParcelamentoComprador;
    private final int tarifaBoletoComprador;
    private final int valorOriginalTransacao;
    private final int taxaParcelamentoVendedor;
    private final int taxaIntermediacao;
    private final int tarifaIntermediacao;
    private final int tarifaBoletoVendedor;
    private final int repasseAplicacao;
    private final int valorLiquidoTransacao;
    private final int statusPagamento;
    private final String filler1;
    private final int meioPagamento;
    private final String instituicaoFinanceiraBandeira;
    private final String canalEntrada;
    private final int leitor;
    private final int meioDeCaptura;
    private final String numeroLogico;
    private final String nsu;
    private final String filler2;
    private final String cartaoBin;
    private final String cartaoHolder;
    private final String codigoAutorizacao;
    private final String codigoCV;
    private final String reservado;
    
    public Detalhe(String linha){
        //Constante “1”: identifica o tipo de registro detalhe.
        super(1);

        /* Desmembramento da String para 
                *  coletar os dados e valores nelas contido. */
        char[] estabelecimento = new char[10];
        linha.getChars(1, 11, estabelecimento, 0);
        this.estabelecimento = Integer.parseInt(String.valueOf(estabelecimento)); 
        
        char[] dataInicialTransacao = new char[8];
        linha.getChars(11, 19, dataInicialTransacao, 0);
        this.dataInicialTransacao = String.valueOf(dataInicialTransacao);
        
        char[] dataEvento = new char[8];
        linha.getChars(19, 27, dataEvento, 0);
        this.dataEvento = String.valueOf(dataEvento);
        
        char[] horaEvento = new char[6];
        linha.getChars(27, 33, horaEvento, 0);
        this.horaEvento = Integer.parseInt(String.valueOf(horaEvento));
        
        char[] tipoEvento = new char[2];
        linha.getChars(33, 35, tipoEvento, 0);
        this.tipoEvento = Integer.parseInt(String.valueOf(tipoEvento));
        
        char[] tipoTransacao = new char[2];
        linha.getChars(35, 37, tipoTransacao, 0);
        this.tipoTransacao = Integer.parseInt(String.valueOf(tipoTransacao));
        
        char[] numeroSerieLeitor = new char[8];
        linha.getChars(37, 45, numeroSerieLeitor, 0);
        this.numeroSerieLeitor = String.valueOf(numeroSerieLeitor);
        
        char[] codigoTransacao = new char[32];
        linha.getChars(45, 77, codigoTransacao, 0);
        this.codigoTransacao = String.valueOf(codigoTransacao);
        
        char[] codigoPedido = new char[20];
        linha.getChars(77, 97, codigoPedido, 0);
        this.codigoPedido = String.valueOf(codigoPedido);
        
        char[] valorTotalDaTransacao = new char[13];
        linha.getChars(97, 110, valorTotalDaTransacao, 0);
        this.valorTotalDaTransacao = Integer.parseInt(String.valueOf(valorTotalDaTransacao));
        
        char[] valorParcelaOuLiquidoTotal = new char[13];
        linha.getChars(110, 123, valorParcelaOuLiquidoTotal, 0);
        this.valorParcelaOuLiquidoTotal = Integer.parseInt(String.valueOf(valorParcelaOuLiquidoTotal));
        
        char[] pagamento = new char[1];
        linha.getChars(123, 124, pagamento, 0);
        this.pagamento = String.valueOf(pagamento);
        
        char[] plano = new char[2];
        linha.getChars(124, 126, plano, 0);
        this.plano = String.valueOf(plano);
        
        char[] parcela = new char[2];
        linha.getChars(126, 128, parcela, 0);
        this.parcela = String.valueOf(parcela);
        
        char[] qtdParcelas = new char[2];
        linha.getChars(128, 130, qtdParcelas, 0);
        this.qtdParcelas = Integer.parseInt(String.valueOf(qtdParcelas));
        
        char[] dataPrevistaPagamento = new char[8];
        linha.getChars(130, 138, dataPrevistaPagamento, 0);
        this.dataPrevistaPagamento = String.valueOf(dataPrevistaPagamento);
        
        char[] taxaParcelamentoComprador = new char[13];
        linha.getChars(138, 151, taxaParcelamentoComprador, 0);
        this.taxaParcelamentoComprador = Integer.parseInt(String.valueOf(taxaParcelamentoComprador));
        
        char[] tarifaBoletoComprador = new char[13];
        linha.getChars(151, 164, tarifaBoletoComprador, 0);
        this.tarifaBoletoComprador = Integer.parseInt(String.valueOf(tarifaBoletoComprador));
        
        char[] valorOriginalTransacao = new char[13];
        linha.getChars(164, 177, valorOriginalTransacao, 0);
        this.valorOriginalTransacao = Integer.parseInt(String.valueOf(valorOriginalTransacao));
        
        char[] taxaParcelamentoVendedor = new char[13];
        linha.getChars(177, 190, taxaParcelamentoVendedor, 0);
        this.taxaParcelamentoVendedor = Integer.parseInt(String.valueOf(taxaParcelamentoVendedor));
        
        char[] taxaIntermediacao = new char[13];
        linha.getChars(190, 203, taxaIntermediacao, 0);
        this.taxaIntermediacao = Integer.parseInt(String.valueOf(taxaIntermediacao));
        
        char[] tarifaIntermediacao = new char[13];
        linha.getChars(203, 216, tarifaIntermediacao, 0);
        this.tarifaIntermediacao = Integer.parseInt(String.valueOf(tarifaIntermediacao));
        
        char[] tarifaBoletoVendedor = new char[13];
        linha.getChars(216, 229, tarifaBoletoVendedor, 0);
        this.tarifaBoletoVendedor = Integer.parseInt(String.valueOf(tarifaBoletoVendedor));
        
        char[] repasseAplicacao = new char[13];
        linha.getChars(229, 242, repasseAplicacao, 0);
        this.repasseAplicacao = Integer.parseInt(String.valueOf(repasseAplicacao));
        
        char[] valorLiquidoTransacao = new char[13];
        linha.getChars(242, 255, valorLiquidoTransacao, 0);
        this.valorLiquidoTransacao = Integer.parseInt(String.valueOf(valorLiquidoTransacao));
        
        char[] statusPagamento = new char[2];
        linha.getChars(255, 257, statusPagamento, 0);
        this.statusPagamento = Integer.parseInt(String.valueOf(statusPagamento));
        
        char[] filler1 = new char[2];
        linha.getChars(257, 259, filler1, 0);
        this.filler1 = String.valueOf(filler1);
        
        char[] meioPagamento = new char[2];
        linha.getChars(259, 261, meioPagamento, 0);
        this.meioPagamento = Integer.parseInt(String.valueOf(meioPagamento));
        
        char[] instituicaoFinanceiraBandeira = new char[30];
        linha.getChars(261, 291, instituicaoFinanceiraBandeira, 0);
        this.instituicaoFinanceiraBandeira = String.valueOf(instituicaoFinanceiraBandeira);
        
        char[] canalEntrada = new char[2];
        linha.getChars(291, 293, canalEntrada, 0);
        this.canalEntrada = String.valueOf(canalEntrada);
        
        char[] leitor = new char[2];
        linha.getChars(293, 295, leitor, 0);
        this.leitor = Integer.parseInt(String.valueOf(leitor));
        
        char[] meioDeCaptura = new char[2];
        linha.getChars(295, 297, meioDeCaptura, 0);
        this.meioDeCaptura = Integer.parseInt(String.valueOf(meioDeCaptura));
        
        char[] numeroLogico = new char[32];
        linha.getChars(297, 329, numeroLogico, 0);
        this.numeroLogico = String.valueOf(numeroLogico);
        
        char[] nsu = new char[11];
        linha.getChars(329, 340, nsu, 0);
        this.nsu = String.valueOf(nsu);
        
        char[] filler2 = new char[3];
        linha.getChars(340, 343, filler2, 0);
        this.filler2 = String.valueOf(filler2);
        
        char[] cartaoBin = new char[6];
        linha.getChars(343, 349, cartaoBin, 0);
        this.cartaoBin = String.valueOf(cartaoBin);
        
        char[] cartaoHolder = new char[4];
        linha.getChars(349, 353, cartaoHolder, 0);
        this.cartaoHolder = String.valueOf(cartaoHolder);
        
        char[] codigoAutorizacao = new char[6];
        linha.getChars(353, 359, codigoAutorizacao, 0);
        this.codigoAutorizacao = String.valueOf(codigoAutorizacao);
        
        char[] codigoCV = new char[32];
        linha.getChars(359, 391, codigoCV, 0);
        this.codigoCV = String.valueOf(codigoCV);
        
        char[] reservado = new char[139];
        linha.getChars(391, 530, reservado, 0);
        this.reservado = String.valueOf(reservado);
    }

    //Métodos Getters 
    public int getEstabelecimento() {
        return estabelecimento;
    }
    public String getDataInicialTransacao() throws ParseException {
        
        /*Conversão do valor para formato de data*/
        SimpleDateFormat originalFormat = new SimpleDateFormat("yyyyMMdd");
        Date date = originalFormat.parse(this.dataInicialTransacao);
        SimpleDateFormat newFormat = new SimpleDateFormat("dd/MM/yyyy");
        String formatedDate = newFormat.format(date);
        
        return formatedDate;
    }
    public String getDataEvento() throws ParseException {
        
        /*Conversão do valor para formato de data*/
        SimpleDateFormat originalFormat = new SimpleDateFormat("yyyyMMdd");
        Date date = originalFormat.parse(this.dataEvento);
        SimpleDateFormat newFormat = new SimpleDateFormat("dd/MM/yyyy");
        String formatedDate = newFormat.format(date);
        
        return formatedDate;
    }
    public String getHoraEvento() {
        int hora = this.horaEvento/10000;
        int minutos = (this.horaEvento%10000)/100; 
        int segundos = (this.horaEvento%100000)%100; 
        String result = Integer.toString(hora);
        result += ":";
        if(minutos<10){
            result +="0"+Integer.toString(minutos);
        }else{
            result += Integer.toString(minutos);
        }
        result += ":";
        result += Integer.toString(segundos);
        
        return result;
    }
    public int getTipoEvento() {
        return tipoEvento;
    }
    public int getTipoTransacao() {
        return tipoTransacao;
    }
    public String getNumeroSerieLeitor() {
        return numeroSerieLeitor;
    }
    public String getCodigoTransacao() {
        return codigoTransacao;
    }
    public String getCodigoPedido() {
        return codigoPedido;
    }
    public int getValorTotalDaTransacao() {
        return valorTotalDaTransacao;
    }
    public int getValorParcelaOuLiquidoTotal() {
        return valorParcelaOuLiquidoTotal;
    }
    public String getPagamento() {
        return pagamento;
    }
    public String getPlano() {
        return plano;
    }
    public String getParcela() {
        return parcela;
    }
    public int getQtdParcelas() {
        return qtdParcelas;
    }
    public String getDataPrevistaPagamento() throws ParseException {
        SimpleDateFormat originalFormat = new SimpleDateFormat("yyyyMMdd");
        Date date = originalFormat.parse(this.dataPrevistaPagamento);
        SimpleDateFormat newFormat = new SimpleDateFormat("dd/MM/yyyy");
        String formatedDate = newFormat.format(date);
        
        return formatedDate;
    }
    public int getTaxaParcelamentoComprador() {
        return taxaParcelamentoComprador;
    }
    public int getTarifaBoletoComprador() {
        return tarifaBoletoComprador;
    }
    public int getValorOriginalTransacao() {
        return valorOriginalTransacao;
    }
    public int getTaxaParcelamentoVendedor() {
        return taxaParcelamentoVendedor;
    }
    public int getTaxaIntermediacao() {
        return taxaIntermediacao;
    }
    public int getTarifaIntermediacao() {
        return tarifaIntermediacao;
    }
    public int getTarifaBoletoVendedor() {
        return tarifaBoletoVendedor;
    }
    public int getRepasseAplicacao() {
        return repasseAplicacao;
    }
    public int getValorLiquidoTransacao() {
        return valorLiquidoTransacao;
    }
    public int getStatusPagamento() {
        return statusPagamento;
    }
    public String getFiller1() {
        return filler1;
    }
    public int getMeioPagamento() {
        return meioPagamento;
    }
    public String getInstituicaoFinanceiraBandeira() {
        return instituicaoFinanceiraBandeira;
    }
    public String getCanalEntrada() {
        return canalEntrada;
    }
    public int getLeitor() {
        return leitor;
    }
    public int getMeioDeCaptura() {
        return meioDeCaptura;
    }
    public String getNumeroLogico() {
        return numeroLogico;
    }
    public String getNsu() {
        return nsu;
    }
    public String getFiller2() {
        return filler2;
    }
    public String getCartaoBin() {
        return cartaoBin;
    }
    public String getCartaoHolder() {
        return cartaoHolder;
    }
    public String getCodigoAutorizacao() {
        return codigoAutorizacao;
    }
    public String getCodigoCV() {
        return codigoCV;
    }
    public String getReservado() {
        return reservado;
    }
    
    
    
}
