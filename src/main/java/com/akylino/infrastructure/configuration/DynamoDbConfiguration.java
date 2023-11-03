package com.akylino.infrastructure.configuration;

import com.akylino.infrastructure.dto.SecretValueDTO;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DynamoDbConfiguration {
    private final Gson gson = new Gson();
    @Autowired
    private SecretsManagerConfiguration secretsManagerConfiguration;

    @Value("${akylino.aws.dynamodb.endpoint}")
    private String amazonAWSEndpoint;

    @Value("${akylino.aws.region}")
    private String awsRegion;

    @Bean
    public DynamoDBMapper dynamoDBMapper() {
        return new DynamoDBMapper(buildAmazonDynamoDB());
    }

    private AmazonDynamoDB buildAmazonDynamoDB() {
        return AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(
                        new AwsClientBuilder.EndpointConfiguration(amazonAWSEndpoint, awsRegion))
                .withCredentials(
                        new AWSStaticCredentialsProvider(
                                new BasicAWSCredentials(secretsManager().getAccesskey(),
                                        secretsManager().getSecretAccesskey()))).build();
    }

    private SecretValueDTO secretsManager() {
        var secreteJson = secretsManagerConfiguration.getSecretValue();
        return gson.fromJson(secreteJson, SecretValueDTO.class);
    }
}
