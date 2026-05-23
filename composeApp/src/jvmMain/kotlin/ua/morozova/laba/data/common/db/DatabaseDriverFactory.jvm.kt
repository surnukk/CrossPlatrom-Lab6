package ua.morozova.laba.data.common.db

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import ua.morozova.laba.Laba
import java.io.File

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class DatabaseDriverFactory {

    actual fun create(): SqlDriver {
        val dbPath = "${System.getProperty("user.home")}/.laba/laba.db"
        File(dbPath).parentFile?.mkdirs()
        val driver: SqlDriver = JdbcSqliteDriver("jdbc:sqlite:$dbPath")
        if (!File(dbPath).exists()) {
            Laba.Schema.create(driver)
        }
        return driver
    }
}