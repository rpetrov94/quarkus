package io.quarkus.jdbc.sqlite.deployment;

import org.sqlite.BusyHandler;
import org.sqlite.Function;
import org.sqlite.ProgressHandler;
import org.sqlite.core.NativeDB;

import io.quarkus.deployment.annotations.BuildProducer;
import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.builditem.nativeimage.JniRuntimeAccessBuildItem;

public class SQLiteJniProcessor {

    @BuildStep
    void produce(BuildProducer<JniRuntimeAccessBuildItem> jniRuntimeAccessibleClasses) {
        jniRuntimeAccessibleClasses
                .produce(new JniRuntimeAccessBuildItem(true, true, true,
                        org.sqlite.core.DB.class,
                        NativeDB.class,
                        BusyHandler.class,
                        Function.class,
                        ProgressHandler.class,
                        Function.Aggregate.class,
                        Function.Window.class,
                        org.sqlite.core.DB.ProgressObserver.class,
                        Throwable.class));
    }
}
