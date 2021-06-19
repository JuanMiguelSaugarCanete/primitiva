
package primitiva;

import java.util.ArrayList;
import java.util.Collections;


public class primitiva {
    public static void main(String[] args) {
        int complementario = numerosaleatorios();
        ArrayList<Integer> combinacion = new ArrayList<Integer>();
        
        
        combinacion = combinacion();
        MostrarCombinacion(combinacion, complementario);
        MostrarPareseImpares(combinacion);
        System.out.println("Mensaje Secreto: "+ MensajeSecreto(combinacion,complementario));
        
        
    }
    public static int numerosaleatorios(){
        return (int)(Math.random()*49);
    }
    public static ArrayList<Integer> combinacion(){
        int numeros[] = new int[6];
        ArrayList<Integer> combinacionfinal = new ArrayList<Integer>();
        
        //Para insertar elementos en el array
        for (int i = 0; i < 6; i++) {
            numeros[i] = numerosaleatorios();
        }
        //Cambiar elementos repetidos
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if( i != j){
                    if(numeros[i] == numeros[j]){
                        numeros[i] = numerosaleatorios();
                        i = 0;
                        j = 0;
                    }else{

                    }
                }else{

                }
            }
        }
        //Ordenarlos de menor a mayor
        for (int i = 0; i < 6; i++) {
            combinacionfinal.add(numeros[i]);
        }
        Collections.sort(combinacionfinal);
        
        return combinacionfinal;
    }
    private static String SepararCadenas(ArrayList<Integer> combinacion){
        String CadenaSeparada = "";
        for (int i = 0; i < combinacion.size(); i++) {
            if(i==0){
                CadenaSeparada = CadenaSeparada+""+combinacion.get(i);
            }else{
                CadenaSeparada = CadenaSeparada+"-"+combinacion.get(i);
            }
            
        }
        
        return CadenaSeparada;
    }
    
    public static void MostrarCombinacion(ArrayList<Integer> combinacion,int numeroc) {
        
        System.out.println("COMBINACIÓN GANADORA\t\t\t\t\tCOMPLEMENTARIO");
        System.out.println("--------------------------------------------\t-----------------------------");
        for (int i = 0; i < combinacion.size(); i++) {
            if(i < (combinacion.size() -1)){
                System.out.print(combinacion.get(i)+"-");
            }else{
                System.out.print(combinacion.get(i) + "\t\t\t\t\t"+numeroc);
            }
            
            
        }
        System.out.println("");
    }
    
    
    public static void MostrarPareseImpares(ArrayList<Integer> combinacion) {
        ArrayList<Integer> pares = new ArrayList<Integer>();
        ArrayList<Integer> impares = new ArrayList<Integer>();
        int modulo;

        for (int i = 0; i < combinacion.size(); i++) {
            modulo = combinacion.get(i)%2;
            
            if(modulo == 0){
                    pares.add(combinacion.get(i));
            }else{
                impares.add(combinacion.get(i));
            }
            
        }
        System.out.println("pares = "+SepararCadenas(pares));
        System.out.println("Impares = "+SepararCadenas(impares));
    }
    
    private static String MensajeSecreto(ArrayList<Integer> combinacion, int complementario){
        char caracter;
        String mensaje = "";
        int numero;
        
        for (int i = 0; i < combinacion.size(); i++) {
            numero = combinacion.get(i);
            caracter = (char) numero;
            mensaje = mensaje+" "+caracter;
        }
        mensaje = mensaje + "\t\t Complementario: "+((char) complementario);
        return mensaje;
    }
    
}
