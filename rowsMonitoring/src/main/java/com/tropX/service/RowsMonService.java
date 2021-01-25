package com.tropX.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tropX.MotionDTO;
import com.tropX.SpecificationDTO;
import com.tropX.documents.Motion;
import com.tropX.documents.Specification;
import com.tropX.repo.MotionRepository;
import com.tropX.repo.SpecificationRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Service

public class RowsMonService {
    static org.slf4j.Logger LOG = LoggerFactory.getLogger(RowsMonService.class);

    public MotionDTO getMotionDTO() {
        return motionDTO;
    }

    MotionDTO motionDTO;
    SpecificationDTO specificationDTO;

    @Autowired
    MotionRepository motionRepository;

    @Autowired
    SpecificationRepository specificationRepository;

    ObjectMapper mapper = new ObjectMapper();

    public void addSpecification(String specification) {
        Specification spec = null;
        try {
            spec = convertToSpecification(specification);
        } catch (JsonProcessingException e) {
            System.out.println( e.getMessage());
        }
        specificationRepository.save(spec);
    }

    public void addMotion(Motion motion) {
        motionRepository.save(motion);
    }

    @Bean
    Consumer<MotionDTO> consumer(){

        return this::processMessage;
    }
    void processMessage(MotionDTO motionDTO) {
        Motion motion = convertToMotion(motionDTO);
        this.motionDTO = motionDTO;
        addMotion(motion);
        compare(motionDTO);
    }

    private void compare(MotionDTO motionDTO) {
        Specification actualSpecification = specificationRepository.findByidExampleAndidSensor(motionDTO.getExerciseName(),motionDTO.getIdSensor());

        if(actualSpecification!=null && actualSpecification.getStrategy().equals("Range")){
            boolean result = range(motionDTO,convertSpecificationToDTO(actualSpecification));
            LOG.info("-----Motions compliance with Range specification: {}",result);
            //   System.out.println("Motions compliance with Range specification: "+result);
        }if(actualSpecification!=null && actualSpecification.getStrategy().equals("ML")) {
            boolean result = is_correct(motionDTO, convertSpecificationToDTO(actualSpecification));
            LOG.info("-----Motions compliance with ML specification: {}",result);
            //   System.out.println("Motions compliance with ML specification: "+result);
        }

    }

    private boolean is_correct(MotionDTO motionDTO, SpecificationDTO specification) {
        //TODO add external library
        return false;
    }

    private SpecificationDTO convertSpecificationToDTO(Specification specification) {
    return new SpecificationDTO(specification.getExerciseName(),specification.getIdSensor(),
            specification.getStrategy(), specification.getSpecMatrix());
    }

    private Specification convertToSpecification(String specification) throws JsonProcessingException {
        specificationDTO = this.mapper.readValue(specification, SpecificationDTO.class);
        return new Specification(specificationDTO.getExerciseName(), specificationDTO.getIdSensor(),
                specificationDTO.getStrategy(), specificationDTO.getSpecMatrix());
    }

    private Motion convertToMotion(MotionDTO motionDTO) {
        return new Motion(motionDTO.getExerciseName(), motionDTO.getIdSensor(), motionDTO.getMotionMatrix());
    }


    // range strategy
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

}
