package ltc.ru.data.request

import com.google.gson.Gson
import com.vk.api.sdk.requests.VKRequest
import ltc.ru.domain.models.VKProfile
import org.json.JSONObject

class VKProfileRequest : VKRequest<VKProfile> {
    constructor() : super("account.getProfileInfo")

    override fun parse(r: JSONObject): VKProfile {
        val gson = Gson()
        val result = gson.fromJson(r.toString(), VKProfile::class.java)
        return result
    }
}