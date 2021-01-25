package com.tropX.repo;

import com.tropX.documents.Motion;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface MotionRepository extends MongoRepository<Motion, ObjectId>, MongoAdditionalOperations {

	@Query("{$and:[{dateTime:{$gte:?0,$lte:?1}},{className:?2},{methodName:?3}]}")
	List<Motion> findMotionByIdExample(LocalDateTime from, LocalDateTime to, String className, String methodName);


}
