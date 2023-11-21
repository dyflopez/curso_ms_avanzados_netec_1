package com.ms.ranking.repository;

import com.ms.ranking.mondel.RankingDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RankingRepository extends MongoRepository <RankingDocument,String>{
}
