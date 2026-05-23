package ua.morozova.laba.di


import com.russhwolf.settings.ObservableSettings
import com.russhwolf.settings.Settings
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.binds
import org.koin.dsl.module
import org.koin.plugin.module.dsl.create
import org.koin.plugin.module.dsl.single
import org.koin.plugin.module.dsl.viewModel
import ua.morozova.laba.Laba
import ua.morozova.laba.data.about.AboutRepository
import ua.morozova.laba.data.about.Platform
import ua.morozova.laba.data.common.db.DatabaseDriverFactory
import ua.morozova.laba.data.common.db.DbDataSource
import ua.morozova.laba.data.common.db.LocalDataSource
import ua.morozova.laba.data.common.preferences.AppPreferences
import ua.morozova.laba.data.common.preferences.Preferences
import ua.morozova.laba.data.reminders.RemindersRepository
import ua.morozova.laba.ui.about.AboutViewModel
import ua.morozova.laba.ui.reminders.ReminderViewModel

private fun createSettings() : Settings = Settings()

private fun createDb(driver: DatabaseDriverFactory) : Laba = Laba(driver.create())

val dataModule = module {
    single { create(::createSettings) } binds arrayOf(Settings::class, ObservableSettings::class)
    singleOf(::AppPreferences) bind Preferences::class
    single<DatabaseDriverFactory>()
    single { create(::createDb) }
    singleOf(::DbDataSource) bind LocalDataSource::class
}

val appModule = module {
    includes(dataModule)
    single<Platform>()
    single<AboutRepository>()
    viewModel<AboutViewModel>()
    single<RemindersRepository>()
    viewModel<ReminderViewModel>()
}