package ltc.ru.data.repository.feed

import ltc.ru.domain.models.VKProfile
import ltc.ru.domain.repository.data.FeedRestRepositoryImpl

class FeedRestRepository(): FeedRestRepositoryImpl{
    private val service: FeedService by lazy {
        FeedService()
    }

    override suspend fun getUser(func: (String) -> Unit) {
        return service.getUserInfo(func)
    }
}