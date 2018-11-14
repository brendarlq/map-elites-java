package com.fpuna;

/**
 * A Cell with feature vector
 */
public class Cell {

    Integer [] features;
    Integer accuracy;
    Boolean empty;
    String key;

    public Cell(Integer numFeatures){
        features = new Integer[numFeatures];
        for(int i=0; i < numFeatures; i++){
            features[i] = 0;
        }
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

    /**
     * Gets empty
     *
     * @return value of empty
     */
    public Boolean isEmpty() {
        return empty;
    }

    /**
     * Set empty
     *
     * @param empty
     */
    public void setEmpty(Boolean empty) {
        this.empty = empty;
    }

    /**
     * Gets key
     *
     * @return value of key
     */
    public String getKey() {
        return key;
    }

    /**
     * Create the key for the cell with the number of bits
     *
     * @param numBits
     */
    public void setKey(Integer numBits) {
        String key = "";
        for(int i= 0; i < numBits; i++){
            key = key.concat(features[i].toString());
        }
        this.key = key;
    }
}
