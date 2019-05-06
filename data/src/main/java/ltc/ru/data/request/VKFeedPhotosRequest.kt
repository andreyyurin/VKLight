package ltc.ru.data.request

import com.google.gson.Gson
import com.vk.api.sdk.requests.VKRequest
import ltc.ru.domain.models.VKPhotoFeed
import ltc.ru.domain.models.VKProfile
import org.json.JSONObject

class VKFeedPhotosRequest : VKRequest<VKPhotoFeed> {
    constructor() : super("newsfeed.get")

    override fun parse(r: JSONObject): VKPhotoFeed {
        val gson = Gson()
        val result = gson.fromJson(r.toString(), VKPhotoFeed::class.java)
        return result
    }
}

