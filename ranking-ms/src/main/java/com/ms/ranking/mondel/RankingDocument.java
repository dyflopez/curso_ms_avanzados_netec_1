package com.ms.ranking.mondel;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("rankings")
public class RankingDocument {

    @Id
    private String id;

    private String userId;

    private String hotelId;

    private int starts ;

    private int observations;
}
