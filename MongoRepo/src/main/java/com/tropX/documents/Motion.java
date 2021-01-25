package com.tropX.documents;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;

@Document(collection = "motions")
public class Motion {
    private String exerciseName;
    private int idSensor;
    private double[][] motionMatrix;

    @Override
    public String toString() {
        return "Motion{" +
                "exerciseName=" + exerciseName +
                ", idSensor=" + idSensor +
                ", motionMatrix=" + Arrays.toString(motionMatrix) +
                '}';
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public int getIdSensor() {
        return idSensor;
    }

    public double[][] getMotionMatrix() {
        return motionMatrix;
    }

    public Motion() {
    }

    public Motion(String exerciseName, int idSensor, double[][] motionMatrix) {
        this.exerciseName = exerciseName;
        this.idSensor = idSensor;
        this.motionMatrix = motionMatrix;
    }


}
