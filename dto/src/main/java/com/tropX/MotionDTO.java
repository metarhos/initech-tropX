package com.tropX;


import java.util.Arrays;

public class MotionDTO {
    private String exerciseName;
    private int idSensor;
    private double[][] motionMatrix;

    public MotionDTO() {
    }

    public MotionDTO(String exerciseName, int idSensor, double[][] motionMatrix) {
        this.exerciseName = exerciseName;
        this.idSensor = idSensor;
        this.motionMatrix = motionMatrix;
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



    @Override
    public String toString() {
        return "Motion{" +
                "exerciseName=" + exerciseName +
                ", idSensor=" + idSensor +
                ", motionMatrix=" + Arrays.toString(motionMatrix) +
                '}';
    }
}
