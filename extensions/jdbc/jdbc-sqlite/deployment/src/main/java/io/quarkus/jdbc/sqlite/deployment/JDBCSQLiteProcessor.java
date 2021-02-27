package io.quarkus.jdbc.sqlite.deployment;

import io.quarkus.agroal.spi.JdbcDriverBuildItem;
import io.quarkus.arc.deployment.AdditionalBeanBuildItem;
import io.quarkus.arc.processor.BuiltinScope;
import io.quarkus.datasource.common.runtime.DatabaseKind;
import io.quarkus.datasource.deployment.spi.DevServicesDatasourceConfigurationHandlerBuildItem;
import io.quarkus.deployment.Capabilities;
import io.quarkus.deployment.Capability;
import io.quarkus.deployment.Feature;
import io.quarkus.deployment.annotations.BuildProducer;
import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.builditem.FeatureBuildItem;
import io.quarkus.jdbc.sqlite.runtime.SQLiteAgroalConnectionConfigurer;

public class JDBCSQLiteProcessor {

    @BuildStep
    FeatureBuildItem feature() {
        return new FeatureBuildItem(Feature.JDBC_SQLITE);
    }

    @BuildStep
    void registerDriver(BuildProducer<JdbcDriverBuildItem> jdbcDriver) {
        jdbcDriver.produce(new JdbcDriverBuildItem(DatabaseKind.SQLITE, "org.sqlite.JDBC"));
    }

    @BuildStep
    DevServicesDatasourceConfigurationHandlerBuildItem devDbHandler() {
        return DevServicesDatasourceConfigurationHandlerBuildItem.jdbc(DatabaseKind.SQLITE);
    }

    @BuildStep
    void configureAgroalConnection(BuildProducer<AdditionalBeanBuildItem> additionalBeans,
            Capabilities capabilities) {
        if (capabilities.isPresent(Capability.AGROAL)) {
            additionalBeans
                    .produce(new AdditionalBeanBuildItem.Builder().addBeanClass(SQLiteAgroalConnectionConfigurer.class)
                            .setDefaultScope(BuiltinScope.APPLICATION.getName())
                            .setUnremovable()
                            .build());
        }
    }
}
