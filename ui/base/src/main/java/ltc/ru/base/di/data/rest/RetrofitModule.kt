package ltc.ru.base.di.data.rest

import android.util.Log
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import ltc.ru.base.BuildConfig
import ltc.ru.base.app.ProjectApplication
import ltc.ru.base.di.ProjectScope
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit

@Module
class RetrofitModule{
    private companion object {
        const val SOCKET_TIMEOUT_EXCEPTION: Long = 15
        const val DISK_CACHE_SIZE: Long = 50 * 1024 * 1024 // 50MB
        const val ENDPOINT = BuildConfig.BASE_URL
    }

    @ProjectScope
    @Provides
    fun provideRetrofit(projectApplication: ProjectApplication
    ): Retrofit {
        val file = File(projectApplication.cacheDir, "http")
        val cache = Cache(file, DISK_CACHE_SIZE)
        val loggingInterceptor = HttpLoggingInterceptor { Log.i("OKHTTP", it) }
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(SOCKET_TIMEOUT_EXCEPTION, TimeUnit.SECONDS)
            .readTimeout(SOCKET_TIMEOUT_EXCEPTION, TimeUnit.SECONDS)
            .writeTimeout(SOCKET_TIMEOUT_EXCEPTION, TimeUnit.SECONDS)
            .cache(cache)
            .addInterceptor(loggingInterceptor)
            .build()
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(ENDPOINT)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}