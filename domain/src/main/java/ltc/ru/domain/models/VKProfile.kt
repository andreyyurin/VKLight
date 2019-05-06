package ltc.ru.domain.models


import com.google.gson.annotations.SerializedName

data class VKProfile(val response: ResponseProfile)

data class ResponseProfile(
    @SerializedName("first_name") val firstName: String,
    @SerializedName("last_name") val lastName: String = "",
    @SerializedName("screen_name") val screenName: String = "",
    val sex: Int = 0,
    val relation: Int = 0,
    @SerializedName("relation_partner") val relationPartner: UserProfile,
    @SerializedName("relation_pending") val relationPending: Int,
    val bdate: String,
    @SerializedName("bdate_visibility") val bdateVisibility: Int = 0,
    @SerializedName("home_town") val homeTown: String,
    val country: CountryObjectProfile,
    val city: CityObjectProfile,
    @SerializedName("name_request") val nameRequest: List<UserProfile>,
    val status: String,
    val phone: String
)

data class CountryObjectProfile(
    val id: Int,
    val title: String
)

data class CityObjectProfile(
    val id: Int,
    val title: String
)

data class UserProfile(
    val id: Int,
    @SerializedName("first_name") val firstName: String,
    @SerializedName("last_name") val lastName: String,
    val deactivated: String,
    @SerializedName("is_closed") val isClosed: Boolean,
    @SerializedName("can_access_closed") val canAccessClosed: Boolean
)