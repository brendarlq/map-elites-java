package com.fpuna;

import java.util.Random;

public class MapElites {



    public static Mapa execute(Mapa mapa, Integer iteraciones) {
        Random random;
        //TODO: Como determinar el número de genomas?
        Integer numberGenomes = mapa.getMap().length * 3;

        for (int i = 0; i < iteraciones; i++) {

            //Change de seed in each iteration
            random = new Random(System.currentTimeMillis());

            if (i < numberGenomes) {
                mapa = generateRandomSolution(mapa,random);
            } else {
                //selection a cell
                Cell selectedCell = selectionRandom(mapa, random);
                //mutation feature vector
                Integer[] child = variationRandom(selectedCell);
                //evaluate
                Integer fitness = executeClassifier(child);

                mapa = cellMapping(mapa, child, fitness);
            }
        }

        return mapa;

    }


    private static Cell selectionRandom(Mapa mapa, Random random) {
        Integer cellId = random.nextInt(mapa.getMap().length);
        return mapa.getMap()[cellId];
    }

    private static Mapa generateRandomSolution (Mapa mapa, Random random){
        Integer [] features = new Integer[mapa.getNumberFeatures()];
        for (Integer feature: features) {
            feature = random.nextInt(1);
        }

        //evaluate
        Integer fitness = executeClassifier(features);
        mapa = cellMapping(mapa, features, fitness);

        return mapa;
    }

    private static Integer executeClassifier (Integer [] features){
        Random random = new Random();
        Integer accuracy = random.nextInt(100);
        return accuracy;
    }

    private static Mapa cellMapping(Mapa mapa, Integer [] features, Integer fitness){

        Integer cellId = getMappingCell(mapa, features);
        if (mapa.getMap()[cellId].isEmpty() || mapa.getMap()[cellId].getAccuracy() < fitness) {
            mapa.getMap()[cellId].setAccuracy(fitness);
            mapa.getMap()[cellId].setFeatures(features);
            mapa.getMap()[cellId].setEmpty(false);
        }

        return mapa;
    }

    private static Integer getMappingCell(Mapa mapa, Integer [] features){
        //TODO: GetMapping
        return 0;
    }

    private static Integer [] variationRandom(Cell selectedCell){
        Integer [] features = new Integer[selectedCell.getFeatures().length];
        //TODO: Mutation
        return  features;
    }
}
