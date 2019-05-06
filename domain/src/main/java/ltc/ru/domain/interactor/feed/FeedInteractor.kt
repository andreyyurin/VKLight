package ltc.ru.domain.interactor.feed

import ltc.ru.domain.models.VKPhotoFeed
import ltc.ru.domain.repository.data.FeedRestRepositoryImpl

class FeedInteractor(private val feedRestRep: FeedRestRepositoryImpl): FeedInteractorImpl{
    override suspend fun getPhotosFeed(func: (VKPhotoFeed) -> Unit) {
        return feedRestRep.getFeedPhotos(func)
    }
}