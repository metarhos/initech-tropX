package com.tropX.service;

import com.tropX.MotionDTO;
import com.tropX.SpecificationDTO;
import com.tropX.api.IStrategy;
import org.springframework.stereotype.Service;

@Service("Range")
public class RangeStrategy implements IStrategy {
    @Override
    public boolean is_correct(MotionDTO motionDTO, SpecificationDTO specificationDTO) {

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

    }

