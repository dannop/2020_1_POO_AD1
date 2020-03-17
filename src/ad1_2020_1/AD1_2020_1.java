/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ad1_2020_1;

/**
 *
 * @author daniel
 */

class Fase {
    Cartao[] cartoes;
    public Fase(){
        cartoes = new Cartao[0];
    }
    
    public void adiciona(Cartao c){
        Cartao[] cartoes_att = new Cartao[cartoes.length+1];
        
        System.arraycopy(cartoes, 0, cartoes_att, 0, cartoes.length);
        
        cartoes_att[cartoes.length] = c;
        this.cartoes = cartoes_att;
    }
    
    public void remove(Cartao c){
        Cartao[] cartoes_att = new Cartao[cartoes.length-1];
        int achou = 0;
        
        if(cartoes_att.length > 0){
            for(int i=0; i<cartoes_att.length; i++){
                if(achou == 0){
                    if(cartoes[i] == c){
                        cartoes_att[i] = cartoes[i+1];
                        achou++;
                    }else{
                        cartoes_att[i] = cartoes[i];
                    }
                }else{
                    cartoes_att[i] = cartoes[i+1];
                }
            }
            
            if(achou > 0){
                this.cartoes = cartoes_att;
            }
        } else {
            this.cartoes = new Cartao[0];
        }
    }
    
    @Override
    public String toString() {
        String saida = "";
        for (Cartao cartao : cartoes) {
            saida += cartao.getNome() + "\n"; 
        }
        return saida;
    }
}

class Cartao {
    String nome;
    public Cartao(String n){
        nome = n;
    }
    
    public String getNome(){
        return nome;
    }
}

class Quadro {
    static int BACKLOG = 0;
    static int TODO = 1;
    static int DOING = 2;
    static int DONE = 3;
    String labelFases[] = {"BACKLOG", "TODO", "DOING", "DONE"}; 
    Fase fase[] = new Fase[4];

    public Quadro() {
        for (int i=0; i<4; i++)
            fase[i] = new Fase(); 
    }
    public void adiciona (Cartao c) {
        fase[BACKLOG].adiciona(c);
    }
    public void prepara (Cartao c) {
        fase[BACKLOG].remove(c); 
        fase[TODO].adiciona(c);
    }
    public void inicia (Cartao c) {
        fase[TODO].remove(c); 
        fase[DOING].adiciona(c);
    }
    public void encerra (Cartao c) {
        fase[DOING].remove(c); 
        fase[DONE].adiciona(c);
    }
    @Override
    public String toString() {
        String saida = "";
        for (int i=0; i<4; i++){
            saida += labelFases[i] + "\n" + fase[i].toString() + "\n"; 
        }
        return saida;
    }
}

public class AD1_2020_1 {
    public static void main(String[] args) {
        Quadro semestre2010_1 = new Quadro(); 
        Cartao fazerAD1 = new Cartao("Fazer a AD1"); 
        semestre2010_1.adiciona(fazerAD1);
        Cartao fazerAD2 = new Cartao("Fazer a AD2"); 
        semestre2010_1.adiciona(fazerAD2); 
        System.out.println(semestre2010_1); 
        semestre2010_1.prepara(fazerAD1); 
        System.out.println(semestre2010_1); 
        semestre2010_1.inicia(fazerAD1); 
        System.out.println(semestre2010_1); 
        semestre2010_1.encerra(fazerAD1); 
        System.out.println(semestre2010_1);
    }
}