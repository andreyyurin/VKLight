package ltc.ru.base.di

import dagger.BindsInstance
import dagger.Component
import ltc.ru.base.app.ProjectApplication
import ltc.ru.base.base.BaseActivity
import ltc.ru.base.di.data.DataDependencies
import ltc.ru.base.di.data.DataModule
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router

@ProjectScope
@Component(modules = [DataModule::class])
interface ProjectComponent : ProjectDependencies, DataDependencies {
    fun inject(activity: BaseActivity)
    @Component.Builder
    interface Builder {
        fun build(): ProjectComponent

        @BindsInstance
        fun provideApplication(application: ProjectApplication): Builder

        @BindsInstance
        fun provideCiceroneRouter(router: Router): Builder

        @BindsInstance
        fun provideCiceroneNavigationHolder(navigationHolder: NavigatorHolder): Builder
    }
}

