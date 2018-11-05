package com.fpuna;

public class Mapa {

    Cell [] mapa;
    Integer numberFeatures;

    public Mapa(Integer numCell, Integer numFeatures){
        numberFeatures = numFeatures;
        mapa = new Cell[numCell];
        for(int i= 0; i<numCell; i++){
            mapa[i] = new Cell(numFeatures);
        }
    }

    public void loadCell(Integer numBits){

        for(int i = 0; i< mapa.length ;i++)
        {
            for(int j = 0; j < numBits; j++)
            {
                int val = mapa.length * j + i;
                int ret = (1 & (val >>> j));
                mapa[i].features[j] = ret;
                mapa[i].setEmpty(true);
            }
        }
    }

    public void printMap(){
        for(int i = 0; i< mapa.length ;i++){
            System.out.print("\nCell "+ i +": ");
            for(int j = 0; j < numberFeatures; j++){
                System.out.print(mapa[i].features[j]+ " ");
            }
        }
    }

    /**
     * Gets map
     *
     * @return value of map
     */
    public Cell[] getMap() {
        return mapa;
    }

    /**
     * Set map
     *
     * @param map
     */
    public void setMap(Cell[] map) {
        this.mapa = map;
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
}
