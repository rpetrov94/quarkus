package io.quarkus.jdbc.sqlite.runtime;

import io.agroal.api.configuration.supplier.AgroalDataSourceConfigurationSupplier;
import io.quarkus.agroal.runtime.AgroalConnectionConfigurer;
import io.quarkus.agroal.runtime.JdbcDriver;
import io.quarkus.datasource.common.runtime.DatabaseKind;

@JdbcDriver(DatabaseKind.SQLITE)
public class SQLiteAgroalConnectionConfigurer implements AgroalConnectionConfigurer {
    @Override
    public void disableSslSupport(String databaseKind, AgroalDataSourceConfigurationSupplier dataSourceConfiguration) {
        // do nothing
    }
}
