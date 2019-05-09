package ltc.ru.domain.models

import com.google.gson.annotations.SerializedName

data class VKUser(
    val response: List<ResponseUser>
)

data class SizeUser(
    val height: Float,
    val type: String,
    val url: String,
    val width: Float
)

data class ResponseUser(
    val about: String,
    val activities: String,
    val bdate: String,
    val blacklisted: Int,
    @SerializedName("blacklisted_by_me") val blacklistedByMe: Int,
    val books: String,
    @SerializedName("can_access_closed") val canAccessClosed: Boolean,
    @SerializedName("can_post") val canPost: Int,
    @SerializedName("can_see_all_posts") val canSeeAllPosts: Int,
    @SerializedName("can_see_audio") val canSeeAudio: Int,
    @SerializedName("can_send_friend_request") val canSendFriendRequest: Int,
    @SerializedName("can_write_private_message") val canWritePrivateMessage: Int,
    val career: List<Any>,
    val city: CityUser,
    @SerializedName("common_count") val commonCount: Int,
    val country: CountryUser,
    @SerializedName("crop_photo") val cropPhoto: CropPhotoUser,
    val domain: String,
    val faculty: Int,
    @SerializedName("faculty_name") val facultyName: String,
    @SerializedName("first_name") val firstName: String,
    @SerializedName("followers_count") val followersCount: Int,
    @SerializedName("friend_status") val friendStatus: Int,
    val games: String,
    val graduation: Int,
    @SerializedName("has_mobile") val hasMobile: Int,
    @SerializedName("has_photo") val hasPhoto: Int,
    @SerializedName("home_phone") val homePhone: String,
    @SerializedName("home_town") val homeTown: String,
    val id: Int,
    val interests: String,
    @SerializedName("is_closed") val isClosed: Boolean,
    @SerializedName("is_favorite") val isFavorite: Int,
    @SerializedName("is_friend") val isFriend: Int,
    @SerializedName("is_hidden_from_feed") val isHiddenFromFeed: Int,
    @SerializedName("last_name") val lastName: String,
    @SerializedName("last_seen") val lastSeen: LastSeenUser,
    @SerializedName("maiden_name") val maidenName: String,
    val military: List<Any>,
    @SerializedName("mobile_phone") val mobilePhone: String,
    val movies: String,
    val music: String,
    val nickname: String,
    val online: Int,
    val personal: PersonalUser,
    @SerializedName("photo_100") val photo100: String,
    @SerializedName("photo_200") val photo200: String,
    @SerializedName("photo_200_orig") val photo200orig: String,
    @SerializedName("photo_400_orig") val photo400orig: String,
    @SerializedName("photo_50") val photo50: String,
    @SerializedName("photo_id") val photoId: String,
    @SerializedName("photo_max") val photoMax: String,
    @SerializedName("photo_max_orig") val photoMaxOrig: String,
    val quotes: String,
    val relation: Int,
    val relatives: List<Any>,
    val schools: List<Any>,
    @SerializedName("screen_name") val screenName: String,
    val sex: Int,
    val site: String,
    val status: String,
    val tv: String,
    val universities: List<Any>,
    val university: Int,
    @SerializedName("university_name") val universityName: String,
    val verified: Int
)

data class CityUser(
    val id: Int,
    val title: String
)

data class CountryUser(
    val id: Int,
    val title: String
)

data class CropUser(
    val x: Float,
    val x2: Float,
    val y: Float,
    val y2: Float
)

data class CropPhotoUser(
    val crop: CropUser,
    val photo: PhotoUser,
    val rect: RectUser
)

data class LastSeenUser(
    val platform: Int,
    val time: Int
)

data class PersonalUser(
    val alcohol: Int,
    @SerializedName("inspired_by") val inspiredBy: String,
    @SerializedName("life_main") val lifeMain: Int,
    @SerializedName("people_main") val peopleMain: Int,
    val religion: String,
    @SerializedName("religion_id") val religionId: Int,
    val smoking: Int
)

data class PhotoUser(
    @SerializedName("album_id") val albumId: Int,
    val date: Int,
    val id: Int,
    @SerializedName("owner_id") val ownerId: Int,
    @SerializedName("post_id") val postId: Int,
    val sizes: List<SizeUser>,
    val text: String
)

data class RectUser(
    val x: Float,
    val x2: Float,
    val y: Float,
    val y2: Float
)