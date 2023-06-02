package com.example.netflixconductor;

import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.Network;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.elasticsearch.ElasticsearchContainer;

public interface CommonContainers {

    Network network = Network.newNetwork();

    ElasticsearchContainer elasticsearch = new ElasticsearchContainer("docker.elastic.co/elasticsearch/elasticsearch:6.8.15")
            .withNetwork(network)
            .withNetworkAliases("es");

    GenericContainer<?> redis = new GenericContainer<>("redis:6.2.3-alpine")
            .withExposedPorts(6379)
            .withNetwork(network)
            .withNetworkAliases("rs");

    GenericContainer<?> conductor = new GenericContainer<>("conductor:server")
            .withExposedPorts(8080)
            .withEnv("CONFIG_PROP", "config-local.properties")
            .withNetwork(network)
            .waitingFor(Wait.forHttp("/health").forStatusCode(200));

}
