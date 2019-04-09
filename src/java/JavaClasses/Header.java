package JavaClasses;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.management.Query.value;

public class Header extends Registro {
    
    //Atributos como final para nao poderem serem mudados, e manter consistência dos dados
   
    private final int estabelecimento;
    private final String datadeProcessamento;
    private final String periodoInicial;
    private final String periodoFinal;
    private final int sequencia;
    private final String empresaAdquirinte;
    private final int tipoDeEstrato;
    private final String filler;
    private final String versaoLayout;
    private final String versaoRelease;
    private final String reservado;


    public Header(String linha) {
        //Constante “0” identifica o tipo de registro header.
        super(0);
        
        /* Desmembramento da String para 
                *  coletar os dados e valores nelas contido. */
        
        char[] estabelecimento = new char[10];
        linha.getChars(1, 11, estabelecimento, 0);
        this.estabelecimento = Integer.parseInt(String.valueOf(estabelecimento));  
        
        char[] dataProcessamento = new char[8];
        linha.getChars(11, 19, dataProcessamento, 0);
        this.datadeProcessamento = String.valueOf(dataProcessamento);
        
        char[] pInicial = new char[8];
        linha.getChars(19, 27, pInicial, 0);
        this.periodoInicial = String.valueOf(pInicial);
        
        char[] pFinal = new char[8];
        linha.getChars(27, 35, pFinal, 0);
        this.periodoFinal = String.valueOf(pFinal);
        
        char[] sequencia = new char[7];
        linha.getChars(35, 42, sequencia, 0);
        this.sequencia = Integer.parseInt(String.valueOf(sequencia));
        
        char[] empresaAdquirinte = new char[5];
        linha.getChars(42, 47, empresaAdquirinte, 0);
        this.empresaAdquirinte = String.valueOf(empresaAdquirinte);
        
        char[] tipoExtrato = new char[2];
        linha.getChars(47, 49, tipoExtrato, 0);
        this.tipoDeEstrato = Integer.parseInt(String.valueOf(tipoExtrato));
        
        char[] filler = new char[21];
        linha.getChars(49, 70, filler, 0);
        this.filler = String.valueOf(filler);
        
        char[] vLayout = new char[3];
        linha.getChars(70, 73, vLayout, 0);
        this.versaoLayout = String.valueOf(vLayout);
        
        char[] vRelease = new char[5];
        linha.getChars(73, 78, vRelease, 0);
        this.versaoRelease = String.valueOf(vRelease);
        
        char[] reserva = new char[453];
        linha.getChars(78, 452, reserva, 0);
        this.reservado = String.valueOf(reserva);
        
        System.out.println("Tipo de registro: "+super.getTipoRegistro());
        System.out.println("Estabelecimento: "+this.estabelecimento);
        System.out.println("Data de processamento :"+this.datadeProcessamento);
        System.out.println("Periodo Inicial: "+this.periodoInicial);
        System.out.println("Periodo Final: "+this.periodoFinal);
        System.out.println("Sequencia: "+this.sequencia);
        System.out.println("Empresa Adquirinte: "+this.empresaAdquirinte);
        System.out.println("Tipo de Extrato: "+this.tipoDeEstrato);
        System.out.println("Filler: "+this.filler);
        System.out.println("Versao Layout: "+this.versaoLayout);
        System.out.println("Versao Release: "+this.versaoRelease);
        System.out.println("Valor Reservado: "+this.reservado);
        
    }

    
    //Metodos de get
    public int getTipoDeRegistro() {
        return super.getTipoRegistro();
    }
    public int getEstabelecimento() {
        return estabelecimento;
    }
    public String getDatadeProcessamento() throws ParseException{
        
        /*Conversão do valor para formato de data*/
        SimpleDateFormat originalFormat = new SimpleDateFormat("yyyyMMdd");
        Date date = originalFormat.parse(this.datadeProcessamento);
        SimpleDateFormat newFormat = new SimpleDateFormat("dd/MM/yyyy");
        String formatedDate = newFormat.format(date);
        
        return formatedDate;
    }
    public String getPeriodoInicial() throws ParseException {
        
        /*Conversão do valor para formato de data*/
        SimpleDateFormat originalFormat = new SimpleDateFormat("yyyyMMdd");
        Date date = originalFormat.parse(this.periodoInicial);
        SimpleDateFormat newFormat = new SimpleDateFormat("dd/MM/yyyy");
        String formatedDate = newFormat.format(date);
        
        return formatedDate;
    }
    public String getPeriodoFinal() throws ParseException {
        
        /*Conversão do valor para formato de data*/
        SimpleDateFormat originalFormat = new SimpleDateFormat("yyyyMMdd");
        Date date = originalFormat.parse(this.periodoFinal);
        SimpleDateFormat newFormat = new SimpleDateFormat("dd/MM/yyyy");
        String formatedDate = newFormat.format(date);
        
        return formatedDate;
    }
    public int getSequencia() {
        return sequencia;
    }
    public String getEmpresaAdquirinte() {
        return empresaAdquirinte;
    }
    public int getTipoDeEstrato() {
        return tipoDeEstrato;
    }
    public String getFiller() {
        return filler;
    }
    public String getVersaoLayout() {
        return versaoLayout;
    }
    public String getVersaoRelease() {
        return versaoRelease;
    }
    public String getReservado() {
        return reservado;
    }
    
    
}
