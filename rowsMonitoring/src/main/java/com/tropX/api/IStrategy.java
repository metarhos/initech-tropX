package com.tropX.api;

import com.tropX.MotionDTO;
import com.tropX.SpecificationDTO;

public interface IStrategy {
    boolean is_correct(MotionDTO motionDTO, SpecificationDTO specificationDTO);
}
