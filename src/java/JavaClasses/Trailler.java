/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaClasses;

public class Trailler extends Registro{
    private final int totalRegistro;
    private final String reservadoParaFuturo;
    
    public Trailler(String linha){
        //Constante “9”: identifica o tipo de registro trailer.
        super(9);
        
        /* Desmembramento da String para 
                *  coletar os dados e valores nelas contido. */
        char[] totalRegistro = new char[10];
        linha.getChars(1, 11, totalRegistro, 0);
        this.totalRegistro = Integer.parseInt(String.valueOf(totalRegistro));
        
        char[] reserva = new char[518];
        linha.getChars(12, 517, reserva, 0);
        this.reservadoParaFuturo = String.valueOf(reserva);
        
    }

    public int getTipoRegistro() {
        return super.getTipoRegistro();
    }
    public int getTotalRegistro() {
        return totalRegistro;
    }
    public String getReservadoParaFuturo() {
        return reservadoParaFuturo;
    }
    
    
    
    
    
}
