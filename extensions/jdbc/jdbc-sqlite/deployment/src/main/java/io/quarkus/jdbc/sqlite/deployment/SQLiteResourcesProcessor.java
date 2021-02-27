package io.quarkus.jdbc.sqlite.deployment;

import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.builditem.nativeimage.NativeImageResourcePatternsBuildItem;

public class SQLiteResourcesProcessor {

    @BuildStep
    NativeImageResourcePatternsBuildItem nativeImageResourcePatternsBuildItem() {
        return NativeImageResourcePatternsBuildItem.builder()
                .includePattern("db/.*")
                .includePattern("static/.*")
                .includePattern("templates/.*")
                .includePattern(".*.yml")
                .includePattern(".*.xml")
                .includePattern(".*/org/sqlite/.*")
                .includePattern("org/sqlite/.*")
                .build();
    }
}
