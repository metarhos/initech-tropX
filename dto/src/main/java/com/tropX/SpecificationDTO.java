package com.tropX;

import java.util.Arrays;

public class SpecificationDTO {

    private String exerciseName;
    private int idSensor;
    private String strategy;
    private double[][] specMatrix;
    public SpecificationDTO(String exerciseName, int idSensor, String strategy,double[][] specMatrix) {
        this.exerciseName = exerciseName;
        this.idSensor = idSensor;
        this.strategy = strategy;
        this.specMatrix = specMatrix;
    }

    public SpecificationDTO() {
    }

    @Override
    public String toString() {
        return "Specification{" +
                "idExample=" + exerciseName +
                ", idSensor=" + idSensor +
                ", strategy='" + strategy + '\'' +
                ", specMatrix=" + Arrays.toString(specMatrix) +
                '}';
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public int getIdSensor() {
        return idSensor;
    }

    public String getStrategy() {
        return strategy;
    }

    public double[][] getSpecMatrix() {
        return specMatrix;
    }

}
