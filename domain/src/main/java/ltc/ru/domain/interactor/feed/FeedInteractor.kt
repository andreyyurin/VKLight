package ltc.ru.domain.interactor.feed

import ltc.ru.domain.repository.data.FeedRestRepositoryImpl

class FeedInteractor(private val feedRestRep: FeedRestRepositoryImpl): FeedInteractorImpl{
    override suspend fun getProfile(func: (String) -> Unit) {
        return feedRestRep.getUser(func)
    }
}