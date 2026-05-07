package ua.morozova.laba.di

import org.koin.dsl.module
import org.koin.plugin.module.dsl.single
import org.koin.plugin.module.dsl.viewModel
import ua.morozova.laba.data.about.AboutRepository
import ua.morozova.laba.data.about.Platform
import ua.morozova.laba.ui.about.AboutViewModel

val appModule = module {
    single<Platform>()
    single<AboutRepository>()
    viewModel<AboutViewModel>()
}