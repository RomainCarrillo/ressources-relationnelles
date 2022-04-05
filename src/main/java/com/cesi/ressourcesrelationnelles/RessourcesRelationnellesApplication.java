package com.cesi.ressourcesrelationnelles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RessourcesRelationnellesApplication {

    public static void main(String[] args) {
        SpringApplication.run(RessourcesRelationnellesApplication.class, args);
    }

//    @Bean
//    public MongoTemplate mongoTemplate(MongoDatabaseFactory mongoDbFactory, MongoMappingContext context) {
//
//        MappingMongoConverter converter = new MappingMongoConverter(new DefaultDbRefResolver(mongoDbFactory), context);
//        converter.setTypeMapper(new DefaultMongoTypeMapper(null));
//
//        return new MongoTemplate(mongoDbFactory, converter);
//
//    }

}
