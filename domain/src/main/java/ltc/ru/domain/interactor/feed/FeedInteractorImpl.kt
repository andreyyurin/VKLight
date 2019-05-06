package ltc.ru.domain.interactor.feed

import ltc.ru.domain.models.VKPhotoFeed

interface FeedInteractorImpl {
    suspend fun getPhotosFeed(func: (VKPhotoFeed) -> Unit)
}