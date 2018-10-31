package com.fpuna;

public class Map {

    Cell [] map;
    Integer numberFeatures;

    public Map(Integer numCell, Integer numFeatures){
        numberFeatures = numFeatures;
        map = new Cell[numCell];
        for(int i= 0; i<numCell; i++){
            map[i] = new Cell(numFeatures);
        }
    }

    public void loadCell(Integer numBits){

        for(int i = 0; i< map.length ;i++)
        {
            for(int j = 0; j < numBits; j++)
            {
                int val = map.length * j + i;
                int ret = (1 & (val >>> j));
                map[i].features[j] = ret;
            }
        }
    }

    public void printMap(){
        for(int i = 0; i< map.length ;i++){
            System.out.print("\nCell "+ i +": ");
            for(int j = 0; j < numberFeatures; j++){
                System.out.print(map[i].features[j]+ " ");
            }
        }
    }

    /**
     * Gets map
     *
     * @return value of map
     */
    public Cell[] getMap() {
        return map;
    }

    /**
     * Set map
     *
     * @param map
     */
    public void setMap(Cell[] map) {
        this.map = map;
    }
}
