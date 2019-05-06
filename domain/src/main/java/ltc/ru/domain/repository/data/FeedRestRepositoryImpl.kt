package ltc.ru.domain.repository.data

import ltc.ru.domain.models.VKPhotoFeed

interface FeedRestRepositoryImpl{
    suspend fun getFeedPhotos(func: (VKPhotoFeed) -> Unit)
}