package com.fpuna;

public class Mapa {

    Cell [] cells;
    Integer numberFeatures;
    Integer numberBitsKey;

    /**
     * Crea el mapa de celdas con celdas que contienen vectores
     * del tamaño de la cantidad de features.
     * @param numCell
     * @param numFeatures
     * @param numBitsKey
     */
    public Mapa(Integer numCell, Integer numFeatures, Integer numBitsKey){
        numberFeatures = numFeatures;
        numberBitsKey = numBitsKey;
        cells = new Cell[numCell];
        for(int i= 0; i<numCell; i++){
            cells[i] = new Cell(numFeatures);
        }
    }

    /**
     * Inicializa las celdas cargando ya los bits necesarios para
     * identificar la celda.
     */
    public void loadCell(){

        for(int i = 0; i< cells.length ; i++)
        {
            for(int j = 0; j < numberBitsKey; j++)
            {
                int val = cells.length * j + i;
                int ret = (1 & (val >>> j));
                cells[i].features[j] = ret;
            }
            cells[i].setEmpty(true);
            cells[i].setKey(numberBitsKey);
        }
    }

    /**
     * Imprime el mapa de celdas
     */
    public void printMap(){
        for(int i = 0; i< cells.length ; i++){
            System.out.print("\nCell "+ i +": ");
            for(int j = 0; j < numberFeatures; j++){
                System.out.print(cells[i].features[j]+ " ");
            }
            System.out.print("\t    Accuracy:  "+ cells[i].getAccuracy());
        }
    }

    /**
     * Gets map
     *
     * @return value of map
     */
    public Cell[] getCells() {
        return cells;
    }

    /**
     * Set map
     *
     * @param cells
     */
    public void setCells(Cell[] cells) {
        this.cells = cells;
    }

    /**
     * Gets numberFeatures
     *
     * @return value of numberFeatures
     */
    public Integer getNumberFeatures() {
        return numberFeatures;
    }

    /**
     * Set numberFeatures
     *
     * @param numberFeatures
     */
    public void setNumberFeatures(Integer numberFeatures) {
        this.numberFeatures = numberFeatures;
    }

    /**
     * Gets numberBitsKey
     *
     * @return value of numberBitsKey
     */
    public Integer getNumberBitsKey() {
        return numberBitsKey;
    }

    /**
     * Set numberBitsKey
     *
     * @param numberBitsKey
     */
    public void setNumberBitsKey(Integer numberBitsKey) {
        this.numberBitsKey = numberBitsKey;
    }
}
