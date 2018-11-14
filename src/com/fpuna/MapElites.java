package com.fpuna;

import java.util.Random;

public class MapElites {

    private Mapa mapa;
    private Random random;

    /**
     * Método principal del algoritmo Map Elites
     *
     * @param mapa
     * @param iteraciones
     * @return
     */
    public Mapa execute(Mapa mapa, Integer iteraciones) {

        this.mapa = mapa;

        //TODO: Como determinar el número de genomas iniciales?
        Integer numberGenomes = mapa.getCells().length * 3;

        for (int i = 0; i < iteraciones; i++) {

            //Change de seed in each iteration
            this.random = new Random(System.currentTimeMillis());

            if (i < numberGenomes) {

                //cargamos el mapa con una cantidad de genomas iniciales;
                generateRandomSolution();
            } else {

                //seleccionamos una celda aleatoriamente
                Cell selectedCell = selectionRandom();

                //realizamos la mutación del vector de features
                Integer[] child = variationRandom(selectedCell);

                //ejecutamos el clasificador para obtener el fitness de la solución
                Integer fitness = executeClassifier(child);

                //almacenamos en el mapa si corresponde
                cellMapping(child, fitness);
            }
        }

        return this.mapa;

    }


    /**
     * Selecciona una celda al azar para realizar la mutación.
     *
     * @return
     */
    private Cell selectionRandom() {
        Integer cellId = random.nextInt(mapa.getCells().length);
        return mapa.getCells()[cellId];
    }

    //TODO: Hacer random por celda?
    /**
     * Genera una solución randomica, calcula el fitness y guarda en el mapa.
     *
     */
    private void generateRandomSolution() {
        //creamos un vector vacío
        Integer[] features = new Integer[mapa.getNumberFeatures()];

        //completamos con 0 o 1 aleatoriamente.
        for (int i = 0; i < mapa.getNumberFeatures(); i++) {
            features[i] = random.nextInt(2);
        }

        //ejecutamos el clasificador para calcular el fitness
        Integer fitness = executeClassifier(features);

        //almacenamos en el mapa si corresponde
        cellMapping(features, fitness);

    }

    /**
     * Simula la ejecución del clasficador, caja negra.
     *
     * @param features
     * @return
     */
    private Integer executeClassifier(Integer[] features) {
        Integer accuracy = random.nextInt(101);
        return accuracy;
    }

    /**
     * Reliza el mapeo de la solución a una celda del mapa.
     *
     * @param features
     * @param fitness
     */
    private void cellMapping(Integer[] features, Integer fitness) {

        //obtenemos el key para buscar en el mapa
        String key = getKey(features);

        //buscamos la celda que concuerda con el key
        Integer cellId = getMappingCell(key);

        //si la celda esta vacía o el fitness calculado es mayor, almacenamos en la celda
        if (mapa.getCells()[cellId].isEmpty() ||
            (!mapa.getCells()[cellId].isEmpty() && mapa.getCells()[cellId].getAccuracy() < fitness)) {
                mapa.getCells()[cellId].setAccuracy(fitness);
                mapa.getCells()[cellId].setFeatures(features);
                mapa.getCells()[cellId].setEmpty(false);
        }
    }

    /**
     * Obtiene la celda que coincide con el key de la solución.
     *
     * @param key
     * @return
     */
    private Integer getMappingCell(String key) {
        Integer cellId = 0;
        for (Integer i = 0; i < mapa.getCells().length; i++) {
            if (mapa.getCells()[i].getKey().equals(key)) {
                cellId = i;
                break;
            }
        }
        return cellId;
    }

    /**
     * Calcula el key para una nueva solución.
     *
     * @param features
     * @return
     */
    private String getKey(Integer[] features) {
        String key = "";
        for (int j = 0; j < mapa.getNumberBitsKey(); j++) {
            key = key.concat(features[j].toString());
        }
        return key;
    }

    //TODO: Como realizar la mutación?

    /**
     * Realiza la mutación del la celda seleccionada.
     *
     * @param selectedCell
     * @return
     */
    private Integer[] variationRandom(Cell selectedCell) {
        Integer[] features = selectedCell.getFeatures();
        Integer featureId = random.nextInt(mapa.getNumberFeatures());
        if (features[featureId].equals(0)) {
            features[featureId] = 1;
        } else {
            features[featureId] = 0;
        }
        return features;
    }
}
