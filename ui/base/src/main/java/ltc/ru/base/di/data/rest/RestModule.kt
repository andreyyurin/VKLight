package ltc.ru.base.di.data.rest

import dagger.Module
import dagger.Provides
import ltc.ru.base.di.ProjectScope
import ltc.ru.base.di.qualifiers.Rest
import ltc.ru.data.repository.feed.FeedRestRepository
import ltc.ru.domain.repository.data.FeedRestRepositoryImpl
import retrofit2.Retrofit

@Module(includes = [RetrofitModule::class])
internal class RestModule{
    @Rest
    @ProjectScope
    @Provides
    fun provideFeedRestRepository(): FeedRestRepositoryImpl{
        return FeedRestRepository()
    }
}