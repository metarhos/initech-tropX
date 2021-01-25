For 1st assignment algorithm is:
private boolean range(MotionDTO motionDTO, SpecificationDTO specificationDTO) {
        int i = 0;
        for (double[] a : motionDTO.getMotionMatrix()) {
            double x = a[0];
            double y = a[1];
            double z = a[2];
            if (x >= specificationDTO.getSpecMatrix()[i][0] &&
                    x <= specificationDTO.getSpecMatrix()[i][1] &&
                    y >= specificationDTO.getSpecMatrix()[i][2] &&
                    y <= specificationDTO.getSpecMatrix()[i][3] &&
                    z >= specificationDTO.getSpecMatrix()[i][4] &&
                    z <= specificationDTO.getSpecMatrix()[i][5]) {
                i++;
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
    
    You can find it in rowsMonitoring micriservice in RowsMonService. For start application, you just need to start RowsMonApplication, wait while spring-stream bind Karafka cloud, and after that run GeneratorApplication. This project - is Maven project, note that, when you load application in your Idea/Eclipse. I implemented workable back-end application with mongo cloud, right microservices architecture, and this appl can be scalable and usable in real project. As result of compare process, you can see LOG in Run tab, such as: 2021-01-25 10:28:27.120  INFO 13616 --- [container-0-C-1] com.tropX.service.RowsMonService         : -----Motions compliance with Range specification: true
    
    For second assignment I made just an algorithm. You can start it just run RepMonApplication. Response you can see in Run tab.
     public static void main(String[] args) {
        //{3, 3, 2, 1, 0, 0, 1, 2, 3, 3, 2, 1, 0, 0, 1, 2, 3, 3, 2, 1, 0, 0}
        //{-3, 0, 3, 3, 2, 0, -2, -3, -3, 0, 3, 3, 2, 0, -2, -3, -3, 0, 3, 3, 2, 0}
        //{3, 3, 2, 1, 0, 0, 1, 2, 3}
        //{-3, 0, 3, 3, 2, 0, -2, -3, -3}

        double[] continousExercise;
        double[] velocityValue;
        ArrayList<double[]> exerciseRepetitions = new ArrayList<>();

//                                          |                       |                       |
        continousExercise = new double[]{3, 3, 2, 1, 0, 0, 1, 2, 3, 3, 2, 1, 0, 0, 1, 2, 3, 3, 2, 1, 0, 0};
//        continousExercise = new double[]{3, 3, 2, 1, 0, 0, 1, 2, 3};
//                                       |                          |                          |
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
                System.out.println("Exercise end. Count of repetition: " + exerciseRepetitions.size());
                exerciseRepetitions.forEach(element-> {
                            for (int p = 0; p < element.length; p++) {
                                System.out.printf(" %s", element[p]);
                            }
                            System.out.println();
                        }
                );
            }
