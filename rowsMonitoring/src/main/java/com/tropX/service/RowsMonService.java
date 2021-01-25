package com.tropX.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tropX.MotionDTO;
import com.tropX.SpecificationDTO;
import com.tropX.api.IStrategy;
import com.tropX.documents.Motion;
import com.tropX.documents.Specification;
import com.tropX.repo.MotionRepository;
import com.tropX.repo.SpecificationRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Map;
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

    @Autowired
    Map<String, IStrategy> strategies;

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

        Specification actualSpecification = specificationRepository.findByidExampleAndidSensor(motionDTO.getExerciseName(),motionDTO.getIdSensor());
        SpecificationDTO actualSpecificationDTO = convertSpecificationToDTO(actualSpecification);

        IStrategy strategy = strategies.get(actualSpecification.getStrategy());
        boolean result = strategy.is_correct(motionDTO, actualSpecificationDTO);

        LOG.info("-----Motions compliance with {} specification: {}",actualSpecificationDTO.getStrategy(),result);

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



}
