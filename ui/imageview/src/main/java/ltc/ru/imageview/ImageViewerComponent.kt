package ltc.ru.imageview

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
internal annotation class ImageViewerScope

@ImageViewerScope
@Component(dependencies = [ProjectComponent::class], modules = [ImageViewerModule::class])
internal interface ImageViewerComponent {
    fun inject(presenter: ImageViewerPresenter)
}

@Module
internal class ImageViewerModule(private val imageUrl: String){
    @Provides
    @ImageViewerScope
    fun provideImageUrl() = imageUrl
}