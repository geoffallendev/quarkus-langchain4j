package io.quarkiverse.langchain4j.weaviate.deployment;

import static io.quarkus.runtime.annotations.ConfigPhase.BUILD_TIME;

import java.util.Map;
import java.util.OptionalInt;

import io.quarkus.runtime.annotations.ConfigGroup;
import io.quarkus.runtime.annotations.ConfigRoot;
import io.smallrye.config.ConfigMapping;
import io.smallrye.config.WithDefault;

@ConfigRoot(phase = BUILD_TIME)
@ConfigMapping(prefix = "quarkus.langchain4j.weaviate")
public interface WeaviateBuildConfig {

    /**
     * Configuration for DevServices. DevServices allows Quarkus to automatically start a database in dev and test mode.
     */
    WeaviateDevServicesBuildTimeConfig devservices();

    @ConfigGroup
    interface WeaviateDevServicesBuildTimeConfig {

        /**
         * If DevServices has been explicitly enabled or disabled. DevServices is generally enabled
         * by default, unless there is an existing configuration present.
         * <p>
         * When DevServices is enabled Quarkus will attempt to automatically configure and start
         * a database when running in Dev or Test mode and when Docker is running.
         */
        @WithDefault("true")
        boolean enabled();

        /**
         * The container image name to use, for container based DevServices providers.
         * If you want to use Redis Stack modules (bloom, graph, search...), use:
         * {@code redis/redis-stack:latest}.
         */
        @WithDefault("cr.weaviate.io/semitechnologies/weaviate:1.25.5")
        String imageName();

        /**
         * Optional fixed port the dev service will listen to.
         * <p>
         * If not defined, the port will be chosen randomly.
         */
        OptionalInt port();

        /**
         * Indicates if the Redis server managed by Quarkus Dev Services is shared.
         * When shared, Quarkus looks for running containers using label-based service discovery.
         * If a matching container is found, it is used, and so a second one is not started.
         * Otherwise, Dev Services for Redis starts a new container.
         * <p>
         * The discovery uses the {@code quarkus-dev-service-weaviate} label.
         * The value is configured using the {@code service-name} property.
         * <p>
         * Container sharing is only used in dev mode.
         */
        @WithDefault("true")
        boolean shared();

        /**
         * The value of the {@code quarkus-dev-service-weaviate} label attached to the started container.
         * This property is used when {@code shared} is set to {@code true}.
         * In this case, before starting a container, Dev Services for Redis looks for a container with the
         * {@code quarkus-dev-service-weaviate} label
         * set to the configured value. If found, it will use this container instead of starting a new one. Otherwise, it
         * starts a new container with the {@code quarkus-dev-service-weaviate} label set to the specified value.
         * <p>
         * This property is used when you need multiple shared Weaviate servers.
         */
        @WithDefault("weaviate")
        String serviceName();

        /**
         * Environment variables that are passed to the container.
         */
        Map<String, String> containerEnv();
    }
}
