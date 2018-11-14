package com.fpuna;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //TODO: Como determinar el número de iteraciones?
        Integer iteraciones = 50000;

        //Pedimos los datos que necesitamos.
        System.out.print("Ingresa la cantidad de features del dataset: ");
        Integer numFeatures = Integer.parseInt(scanner.nextLine());
        System.out.print("Ingresa la cantidad de celdas(Debe ser un número con base 2): ");
        Integer numCell = Integer.parseInt(scanner.nextLine());;

        //Calculo de bits fijos
        Double cantBitsFijos = (Math.log10(numCell) / Math.log10(2));

        System.out.print("\nNúmero de bits fijos: "+ cantBitsFijos.intValue());

        //Creamos las celdas
        Mapa map = new Mapa(numCell, numFeatures, cantBitsFijos.intValue());

        //Cargamos los bits fijos en las celdas
        map.loadCell();

        //Imprimimos el mapa inicialmente
        System.out.print("\n\nMapa Incial:");
        map.printMap();


        //Ejecutamos el algoritmo map-elites
        MapElites mapElites = new MapElites();
        mapElites.execute(map,iteraciones);

        //Imprimimos el mapa final
        System.out.print("\n\nMapa Final:");
        map.printMap();
    }
}
