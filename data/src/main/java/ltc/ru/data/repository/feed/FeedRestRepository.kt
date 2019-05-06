package ltc.ru.data.repository.feed

import ltc.ru.domain.models.VKPhotoFeed
import ltc.ru.domain.repository.data.FeedRestRepositoryImpl

class FeedRestRepository : FeedRestRepositoryImpl {
    private val service: FeedService by lazy {
        FeedService()
    }

    override suspend fun getFeedPhotos(func: (VKPhotoFeed) -> Unit) {
        return service.getFeedPhotos(func)
    }
}