package ltc.ru.base.di.data.rest

import ltc.ru.base.di.qualifiers.Rest
import ltc.ru.domain.repository.data.FeedRestRepositoryImpl
import ltc.ru.domain.repository.data.UserRestRepositoryImpl
import retrofit2.Retrofit

interface RestDependencies{
    fun retrofit(): Retrofit

    @Rest
    fun feedRep(): FeedRestRepositoryImpl

    @Rest
    fun userRep(): UserRestRepositoryImpl
}