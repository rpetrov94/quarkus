package io.quarkus.jdbc.sqlite.deployment;

import io.quarkus.deployment.annotations.BuildProducer;
import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.builditem.nativeimage.ReflectiveClassBuildItem;

public class SQLiteReflections {

    @BuildStep
    void build(BuildProducer<ReflectiveClassBuildItem> reflectiveClass) {
        final String driverName = "org.sqlite.JDBC";
        reflectiveClass.produce(new ReflectiveClassBuildItem(false, false, driverName));
    }
}
