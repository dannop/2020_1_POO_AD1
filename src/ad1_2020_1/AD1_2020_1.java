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
    static Cartao[] cartoes;
    public Fase(){
        cartoes = new Cartao[10];
    }
    
    public void adiciona(Cartao c){
        int i = 0;
        while(i < 10 && cartoes[i] != null){
            i++;
        }
        
        if (cartoes[i] == null){
            cartoes[i] = c;
        }    
    }
    
    public void remove(Cartao c){
        int i = 0;
        while(i < 10 && cartoes[i] != c){
            i++;
        }
        
        if (cartoes[i] == c){
            cartoes[i] = null;
        }
    }
    
    @Override
    public String toString() {
        String saida = "";
        for (int i=0; i<10; i++){
            saida += cartoes[i].getNome() + "\n"; 
        }
        return saida;
    }
}

class Cartao {
    static String nome;
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
