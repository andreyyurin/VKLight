package ltc.ru.data.repository.user

import android.util.Log
import com.vk.api.sdk.VK
import com.vk.api.sdk.VKApiCallback
import com.vk.api.sdk.exceptions.VKApiExecutionException
import ltc.ru.data.request.VKUserRequest
import ltc.ru.domain.models.VKUser

class UserService {
    fun getUserInfo(func: (VKUser) -> Unit, id: String) {
        val request = VKUserRequest()
            .addParam("user_ids", id)
            .addParam("fields", "photo_id, verified, sex, bdate, city, country, home_town, has_photo, photo_50, photo_100, photo_200_orig, photo_200, photo_400_orig, photo_max, photo_max_orig, online, domain, has_mobile, contacts, site, education, universities, schools, status, last_seen, followers_count, common_count, occupation, nickname, relatives, relation, personal, connections, exports, activities, interests, music, movies, tv, books, games, about, quotes, can_post, can_see_all_posts, can_see_audio, can_write_private_message, can_send_friend_request, is_favorite, is_hidden_from_feed, timezone, screen_name, maiden_name, crop_photo, is_friend, friend_status, career, military, blacklisted, blacklisted_by_me")
            .addParam("name_case", "Nom")
        VK.execute(request, object : VKApiCallback<VKUser> {
            override fun success(result: VKUser) {
                Log.d("xyi-err", id)
                func.invoke(result)
            }

            override fun fail(error: VKApiExecutionException) {
            }
        })
    }
}
