package ltc.ru.data.repository.user

import ltc.ru.domain.models.VKUser
import ltc.ru.domain.repository.data.UserRestRepositoryImpl

class UserRestRepository : UserRestRepositoryImpl {
    private val service = UserService()

    override suspend fun getUserInfo(func: (VKUser) -> Unit, id: String) {
        return service.getUserInfo(func, id)
    }
}