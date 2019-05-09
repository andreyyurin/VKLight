package ltc.ru.domain.interactor.user

import ltc.ru.domain.models.VKUser

interface UserInteractorImpl {
    suspend fun getUser(func: (VKUser) -> Unit, id: String)
}