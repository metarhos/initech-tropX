package com.tropX.repo;

import com.tropX.documents.Specification;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface SpecificationRepository extends MongoRepository<Specification, ObjectId>, MongoAdditionalOperations {

    @Query("{$and:[{dateTime:{$gte:?0,$lte:?1}},{className:?2},{methodName:?3}]}")
    List<Specification> findSpecificationByIdExample(LocalDateTime from, LocalDateTime to, String className, String methodName);

    @Query("{$and:[{exerciseName:?0},{idSensor:?1}]}")
    Specification findByidExampleAndidSensor(String exerciseName, int idSensor);

}