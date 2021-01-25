package com.tropX.motion;


import com.tropX.MotionDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Supplier;

@Component
public class RowsMotion {
    @Bean
    Supplier<MotionDTO> supplier() {
        return this::sendDTO;
    }

    private MotionDTO sendDTO() {
        double[][] motionMatrix = new double[20][3];
        for(double[]a:motionMatrix){
            a[0] = Math.random();
            a[1] = Math.random();
            a[2] = Math.random();
        }

        return new MotionDTO("pushups",1, motionMatrix);
    }

}
