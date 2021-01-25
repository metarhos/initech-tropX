package com.tropX.repo;

import org.slf4j.LoggerFactory;

public class MongoAdditionalOperationsImpl implements MongoAdditionalOperations{
    static org.slf4j.Logger LOG = LoggerFactory.getLogger(MongoAdditionalOperationsImpl.class);

    @Override
    public long getSecurityExceptionsCount() {
//      MatchOperation matchOperation = Aggregation.match(Criteria.where("exceptionType").in("AUTHENTICATION_EXCEPTION","AUTHORIZATION_EXCEPTION"));
//        GroupOperation groupOperation = Aggregation.group("exceptionType").count().as("count");
//        Aggregation pipeline = Aggregation.newAggregation(matchOperation, groupOperation);
//        AggregationResults<Document> result =  mongoTemplate.aggregate(pipeline, Logger.class, Document.class);
//        return result.getMappedResults().stream().map(d -> d.getInteger("count"))
//                .reduce(0,(a, b) -> a + b);
        return 0000;
    }




}
