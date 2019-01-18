package com.randomkanji.service;

import com.randomkanji.domain.JlptLevel;
import com.randomkanji.domain.Kanji;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.SampleOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class KanjiService {
    private final MongoTemplate mongoTemplate;

    public Kanji getKanjiBycategories(List<JlptLevel> jlptLevels) {
        List<String> jlptCategories = jlptLevels.stream().map(jlptLevel -> jlptLevel.toString()).collect(Collectors.toList());
        SampleOperation matchStage = Aggregation.sample(1);
        MatchOperation inStage = Aggregation.match(new Criteria("category").in(jlptCategories));
        Aggregation aggregation = Aggregation.newAggregation(inStage, matchStage);
        AggregationResults<Kanji> output = mongoTemplate.aggregate(aggregation, "kanji", Kanji.class);
        log.info("Generate kanji: {}", output.getUniqueMappedResult());
        return output.getUniqueMappedResult();
    }

}
