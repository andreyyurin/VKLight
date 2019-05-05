package ltc.ru.authorization

import dagger.Component
import dagger.Module
import ltc.ru.base.di.ProjectComponent
import javax.inject.Scope

@Scope
internal annotation class AuthorizationScope

@AuthorizationScope
@Component(dependencies = [ProjectComponent::class], modules = [AuthorizationModule::class])
internal interface AuthorizationComponent {
    fun inject(presenter: AuthorizationPresenter)
}

@Module
internal class AuthorizationModule