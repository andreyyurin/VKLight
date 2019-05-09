package ltc.ru.domain.repository.data

import ltc.ru.domain.models.VKUser

interface UserRestRepositoryImpl{
    suspend fun getUserInfo(func: (VKUser) -> Unit, id: String)
}