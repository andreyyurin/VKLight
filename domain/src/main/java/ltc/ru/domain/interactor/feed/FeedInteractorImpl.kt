package ltc.ru.domain.interactor.feed

interface FeedInteractorImpl {
    suspend fun getProfile(func: (String) -> Unit)
}