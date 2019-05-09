package ltc.ru.domain.interactor.user

import ltc.ru.domain.models.VKUser
import ltc.ru.domain.repository.data.UserRestRepositoryImpl

class UserInteractor(private val userRestRep: UserRestRepositoryImpl): UserInteractorImpl{
    override suspend fun getUser(func: (VKUser) -> Unit, id: String) {
        return userRestRep.getUserInfo(func, id)
    }
}