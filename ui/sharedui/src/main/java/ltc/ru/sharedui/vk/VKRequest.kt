package ltc.ru.sharedui.vk

import android.widget.TextView
import com.vk.api.sdk.VK
import com.vk.api.sdk.VKApiCallback
import com.vk.api.sdk.exceptions.VKApiExecutionException
import ltc.ru.sharedui.vk.models.VKProfile

class VKRequest {

    fun getUserInfo(viewState: TextView){
        VK.execute(VKProfileRequest(), object : VKApiCallback<VKProfile> {
            override fun success(result: VKProfile) {
                viewState.text = result.response.firstName
            }

            override fun fail(error: VKApiExecutionException) {

            }
        })
    }
}

