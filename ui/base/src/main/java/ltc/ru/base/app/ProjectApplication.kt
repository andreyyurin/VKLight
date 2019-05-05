package ltc.ru.base.app

import android.app.Application
import ltc.ru.base.di.DaggerProjectComponent
import ltc.ru.base.di.ProjectComponent
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router

class ProjectApplication : Application() {

    lateinit var projectComponent: ProjectComponent

    override fun onCreate() {
        super.onCreate()
        val cicerone = Cicerone.create(Router())
        initDaggerGraph(cicerone)
    }

    private fun initDaggerGraph(cicerone: Cicerone<Router>) {
        projectComponent = DaggerProjectComponent.builder()
            .provideApplication(this)
            .provideCiceroneRouter(cicerone.router)
            .provideCiceroneNavigationHolder(cicerone.navigatorHolder)
            .build()
    }
}