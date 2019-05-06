package ltc.ru.data.repository.feed

import com.vk.api.sdk.VK
import com.vk.api.sdk.VKApiCallback
import com.vk.api.sdk.exceptions.VKApiExecutionException
import ltc.ru.data.request.VKFeedPhotosRequest
import ltc.ru.domain.models.VKPhotoFeed

class FeedService {
    fun getFeedPhotos(func: (VKPhotoFeed) -> Unit) {
        val request = VKFeedPhotosRequest()
            .addParam("filters", "photo,photo_tag")
            .addParam("count", 75)
        VK.execute(request, object : VKApiCallback<VKPhotoFeed> {
            override fun success(result: VKPhotoFeed) {
                func.invoke(result)
            }

            override fun fail(error: VKApiExecutionException) {

            }
        })
    }
}
