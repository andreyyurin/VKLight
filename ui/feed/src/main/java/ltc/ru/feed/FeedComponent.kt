package ltc.ru.feed

import dagger.Component
import dagger.Module
import dagger.Provides
import ltc.ru.base.di.ProjectComponent
import ltc.ru.base.di.qualifiers.Rest
import ltc.ru.domain.interactor.feed.FeedInteractor
import ltc.ru.domain.interactor.feed.FeedInteractorImpl
import ltc.ru.domain.interactor.user.UserInteractor
import ltc.ru.domain.interactor.user.UserInteractorImpl
import ltc.ru.domain.repository.data.FeedRestRepositoryImpl
import ltc.ru.domain.repository.data.UserRestRepositoryImpl
import javax.inject.Scope

@Scope
internal annotation class FeedScope

@FeedScope
@Component(dependencies = [ProjectComponent::class], modules = [FeedModule::class])
internal interface FeedComponent {
    fun inject(presenter: FeedPresenter)
}

@Module
internal class FeedModule{
    @Provides
    fun provideFeedInteractor(@Rest feedRestRep: FeedRestRepositoryImpl): FeedInteractorImpl {
        return FeedInteractor(feedRestRep)
    }

    @Provides
    fun provideUserInteractor(@Rest userRestRep: UserRestRepositoryImpl): UserInteractorImpl {
        return UserInteractor(userRestRep)
    }
}