package com.tropX.documents;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;

@Document(collection = "specification")
public class Specification {

    @Indexed(unique=true)
    private String exerciseName;
    @Indexed(unique=true)
    private int idSensor;
    private String strategy;
    private double[][] specMatrix;

    public Specification(String exerciseName, int idSensor, String strategy, double[][] specMatrix) {
        this.exerciseName = exerciseName;
        this.idSensor = idSensor;
        this.strategy = strategy;
        this.specMatrix = specMatrix;
    }

    public Specification() {
    }

    @Override
    public String toString() {
        return "Specification{" +
                "exerciseName=" + exerciseName +
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
