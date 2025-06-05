package com.onlinebookstore;

import com.onlinebookstore.config.AsyncSyncConfiguration;
import com.onlinebookstore.config.EmbeddedKafka;
import com.onlinebookstore.config.EmbeddedSQL;
import com.onlinebookstore.config.JacksonConfiguration;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Base composite annotation for integration tests.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@SpringBootTest(classes = { OnlineBookStorePlatformApp.class, JacksonConfiguration.class, AsyncSyncConfiguration.class })
@EmbeddedSQL
@EmbeddedKafka
public @interface IntegrationTest {
}
