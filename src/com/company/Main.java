package com.company;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

         //-------------- Questão 1 -------------//

        System.out.println("Exercício 1 \nInsira uma lista de números com um número ímpar de elementos: \nExemplo:[2,5,6,7,8]");
        int[] array1 = getArray();
        mediana(array1);

        //-------------- Questão 2 -------------//

        System.out.println("Exercício 2 \nInsira uma lista de números inteiros \nExemplo:[2,5,6,7,8]");
        int[] array2 = getArray();
        System.out.print("Insira o valor de diferença: ");
        int x = scanner.nextInt();
        scanner.nextLine(); // Para consumir o \n que sobra
        difDePares(array2, x);

        //-------------- Questão 3 -------------//

        System.out.println("Exercício 3 \nInsira uma frase: ");
        String frase = scanner.nextLine();
        System.out.print(encriptador(frase));

    }

    public static int[] getArray(){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String aux = input.substring(1,input.length()-1).replace(",", "");

        int[] numbers = new int[aux.length()];

        for(int i =0; i<aux.length(); i++){
            numbers[i] = Character.getNumericValue(aux.charAt(i));
        }
        return numbers;
    }


    public static void mediana(int[] numbers) {
        Arrays.sort(numbers);
        int index = (int)Math.ceil(numbers.length/2);
        System.out.println("A mediana é "+numbers[index]);

    }

    public static void difDePares(int[] numbers, int x) {
        int counter = 0;

        for(int i=0; i<numbers.length; i++){
            for(int j=i+1; j<numbers.length; j++){
                if (Math.abs(numbers[i]-numbers[j])  == x){
                    counter++;
                }
            }
        }
        System.out.println(counter);
    }

    public static String encriptador(String frase) {
        String novaFrase = frase.replace(" ", "");

        double sqrt = Math.sqrt(novaFrase.length());
        int lowerValue = (int)Math.floor(sqrt);
        int biggerValue = (int)Math.ceil(sqrt);

        int linhas, colunas;
        if (lowerValue*lowerValue>= novaFrase.length()){
            linhas=lowerValue;
            colunas=lowerValue;
        }else if(lowerValue*biggerValue>= novaFrase.length()){
            linhas=lowerValue;
            colunas=biggerValue;
        }
        else{
            linhas=biggerValue;
            colunas=biggerValue;
        }

        String resultado ="";
        for(int i=1, j=0; i<=linhas; i++){
            System.out.println(resultado);

            resultado+= novaFrase.substring(j, j+colunas > novaFrase.length() ? novaFrase.length(): j+colunas) + " ";
            j+=colunas;
        }

        return resultado;

    }
}
