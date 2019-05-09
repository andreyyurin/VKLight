package ltc.ru.data.request

import com.google.gson.Gson
import com.vk.api.sdk.requests.VKRequest
import ltc.ru.domain.models.VKUser
import org.json.JSONObject

class VKUserRequest : VKRequest<VKUser> {
    constructor() : super("users.get")

    override fun parse(r: JSONObject): VKUser {
        val gson = Gson()
        val result = gson.fromJson(r.toString(), VKUser::class.java)
        return result
    }
}