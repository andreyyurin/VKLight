package ltc.ru.data.repository.feed

import com.vk.api.sdk.VK
import com.vk.api.sdk.VKApiCallback
import com.vk.api.sdk.exceptions.VKApiExecutionException
import ltc.ru.data.request.VKProfileRequest
import ltc.ru.domain.models.VKProfile

class FeedService{
    fun getUserInfo(func: (String) -> Unit){
        VK.execute(VKProfileRequest(), object : VKApiCallback<VKProfile> {
            override fun success(result: VKProfile){
                func.invoke(result.response.firstName)
            }

            override fun fail(error: VKApiExecutionException) {

            }
        })
    }
}
