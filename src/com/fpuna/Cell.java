package com.fpuna;

public class Cell {

    Integer [] features;
    Integer accuracy;

    public Cell(Integer numFeatures){
        features = new Integer[numFeatures];
    }

    /**
     * Gets features
     *
     * @return value of features
     */
    public Integer[] getFeatures() {
        return features;
    }

    /**
     * Set features
     *
     * @param features
     */
    public void setFeatures(Integer[] features) {
        this.features = features;
    }

    /**
     * Gets accuracy
     *
     * @return value of accuracy
     */
    public Integer getAccuracy() {
        return accuracy;
    }

    /**
     * Set accuracy
     *
     * @param accuracy
     */
    public void setAccuracy(Integer accuracy) {
        this.accuracy = accuracy;
    }
}
