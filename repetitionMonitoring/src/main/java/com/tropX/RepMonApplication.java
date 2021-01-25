package com.tropX;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class RepMonApplication {
    public static void main(String[] args) {
        SpringApplication.run(RepMonApplication.class, args);

        double[] continousExercise;
        double[] velocityValue;
        ArrayList<double[]> exerciseRepetitions = new ArrayList<>();


        continousExercise = new double[]{3, 3, 2, 1, 0, 0, 1, 2, 3, 3, 2, 1, 0, 0, 1, 2, 3, 3, 2, 1, 0, 0};
//        continousExercise = new double[]{3, 3, 2, 1, 0, 0, 1, 2, 3};

        velocityValue = new double[]{-3, 0, 3, 3, 2, 0, -2, -3, -3, 0, 3, 3, 2, 0, -2, -3, -3, 0, 3, 3, 2, 0};
//        velocityValue = new double[]{-3, 0, 3, 3, 2, 0, -2, -3, -3};

        if (continousExercise.length == velocityValue.length) {
            System.out.println("test data length correct");
        }
        for (int i = 0; i < velocityValue.length-1; i++) {

                if (velocityValue[i] == 0 && velocityValue[i + 1] > 0) {
                    for (int j = i; j < velocityValue.length; j++) {

                            if (velocityValue[j] < 0 && continousExercise[i]==continousExercise[j]) {
                                exerciseRepetitions.add(Arrays.copyOfRange(continousExercise, i, j + 1));
                                i = j;
                                break;
                            }
                    }
                }
            }
        printResult(exerciseRepetitions);

            }

    private static void printResult(ArrayList<double[]> exerciseRepetitions) {
        System.out.println("Exercise end. Count of repetition: " + exerciseRepetitions.size());
        exerciseRepetitions.forEach(element-> {
                    for (int p = 0; p < element.length; p++) {
                        System.out.printf(" %s", element[p]);
                    }
                    System.out.println();
                }
        );
    }
}


