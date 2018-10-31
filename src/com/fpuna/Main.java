package com.fpuna;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Pedimos los datos que necesitamos.
        System.out.print("Ingresa la cantidad de features del dataset: ");
        Integer numFeatures = Integer.parseInt(scanner.nextLine());
        System.out.print("Ingresa la cantidad de celdas(Debe ser un número con base 2): ");
        Integer numCell = Integer.parseInt(scanner.nextLine());;

        //Calculo de bits fijos
        Double cantBitsFijos = (Math.log10(numCell) / Math.log10(2));

        System.out.print("\nNúmero de bits fijos: "+ cantBitsFijos.intValue());

        //Creamos el mapa
        Map map = new Map(numCell, numFeatures);
        //Cargamos los bits fijos en las celdas
        map.loadCell(cantBitsFijos.intValue());
        //Imprimimos el mapa
        map.printMap();
    }
}
