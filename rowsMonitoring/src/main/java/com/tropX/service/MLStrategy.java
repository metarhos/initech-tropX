package com.tropX.service;

import com.tropX.MotionDTO;
import com.tropX.SpecificationDTO;
import com.tropX.api.IStrategy;
import org.springframework.stereotype.Service;

@Service("ML")
public class MLStrategy implements IStrategy {
    @Override
    public boolean is_correct(MotionDTO motionDTO, SpecificationDTO specificationDTO) {
        //Not implemented yet
        return false;
    }
}
