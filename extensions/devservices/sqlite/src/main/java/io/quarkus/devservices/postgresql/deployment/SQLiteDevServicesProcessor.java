package io.quarkus.devservices.postgresql.deployment;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;

import io.quarkus.datasource.common.runtime.DatabaseKind;
import io.quarkus.datasource.deployment.devservices.DevServicesDatasourceProviderBuildItem;
import io.quarkus.datasource.deployment.spi.DevServicesDatasourceProvider;
import io.quarkus.deployment.annotations.BuildStep;

public class SQLiteDevServicesProcessor {

    @BuildStep
    DevServicesDatasourceProviderBuildItem setupSQLite() {
        return new DevServicesDatasourceProviderBuildItem(DatabaseKind.SQLITE, new DevServicesDatasourceProvider() {
            @Override
            public RunningDevServicesDatasource startDatabase(Optional<String> username, Optional<String> password,
                    Optional<String> datasourceName, Optional<String> imageName, Map<String, String> additionalProperties) {
                String connectionUrl = "jdbc:sqlite:" + datasourceName.orElse("dev.db");
                return new RunningDevServicesDatasource(
                        connectionUrl,
                        "",
                        "",
                        new Closeable() {
                            @Override
                            public void close() throws IOException {
                                new File(datasourceName.orElse("dev.db")).deleteOnExit();
                            }
                        });
            }
        });
    }
}
