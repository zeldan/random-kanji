package com.randomkanji.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.SampleOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import com.randomkanji.domain.JlptLevel;
import com.randomkanji.domain.Kanji;

@Service
public class KanjiService {

    private static final Logger LOG = LoggerFactory.getLogger(KanjiService.class);

    @Autowired
    private MongoTemplate mongoTemplate;

    public Kanji getKanjiBycategories(List<JlptLevel> jlptLevels) {
        List<String> jlptCategories = new ArrayList<>();
        for (JlptLevel jlptLevel : jlptLevels) {
            jlptCategories.add(jlptLevel.toString());
        }
        SampleOperation matchStage = Aggregation.sample(1);
        MatchOperation inStage = Aggregation.match(new Criteria("category").in(jlptCategories));
        Aggregation aggregation = Aggregation.newAggregation(inStage, matchStage);
        AggregationResults<Kanji> output = mongoTemplate.aggregate(aggregation, "kanji", Kanji.class);
        LOG.info("Generate kanji: {}", output.getUniqueMappedResult());
        return output.getUniqueMappedResult();
    }

}
