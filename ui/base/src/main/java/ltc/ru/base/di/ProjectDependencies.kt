package ltc.ru.base.di

import ltc.ru.base.app.ProjectApplication
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router

interface ProjectDependencies {

    fun provideProjectApplication(): ProjectApplication

    // Navigation
    fun provideRouter(): Router

    fun provideNavigatorHolder(): NavigatorHolder
}