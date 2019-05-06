package ltc.ru.domain.repository.data

interface FeedRestRepositoryImpl{
    suspend fun getUser(func: (String) -> Unit)
}