package com.linkedinlearning.reactivespring.config;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.ReactiveMongoDatabaseFactory;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.SimpleReactiveMongoDatabaseFactory;


@Configuration
@Profile(value = "local")
@Import(EmbeddedMongoAutoConfiguration.class)
public class MongoConfig {
  public static final String DATABASE_NAME = "app";

  @Bean
  public MongoClient mongoClient() {
    return MongoClients.create();
  }

  @Bean
  public ReactiveMongoDatabaseFactory reactiveMongoDatabaseFactory(MongoClient mongoClient) {
    return new SimpleReactiveMongoDatabaseFactory(mongoClient, DATABASE_NAME);
  }

  @Bean
  public ReactiveMongoOperations reactiveMongoTemplate(ReactiveMongoDatabaseFactory mongoDatabaseFactory) {
    return new ReactiveMongoTemplate(mongoDatabaseFactory);
  }
}
