package ltc.ru.domain.models


import com.google.gson.annotations.SerializedName

data class VKProfile(val response: Response)

data class Response(
    @SerializedName("first_name") val firstName: String,
    @SerializedName("last_name") val lastName: String = "",
    @SerializedName("screen_name") val screenName: String = "",
    val sex: Int = 0,
    val relation: Int = 0,
    @SerializedName("relation_partner") val relationPartner: User,
    @SerializedName("relation_pending") val relationPending: Int,
    val bdate: String,
    @SerializedName("bdate_visibility") val bdateVisibility: Int = 0,
    @SerializedName("home_town") val homeTown: String,
    val country: CountryObject,
    val city: CityObject,
    @SerializedName("name_request") val nameRequest: List<User>,
    val status: String,
    val phone: String
)

data class CountryObject(
    val id: Int,
    val title: String
)

data class CityObject(
    val id: Int,
    val title: String
)

data class User(
    val id: Int,
    @SerializedName("first_name") val firstName: String,
    @SerializedName("last_name") val lastName: String,
    val deactivated: String,
    @SerializedName("is_closed") val isClosed: Boolean,
    @SerializedName("can_access_closed") val canAccessClosed: Boolean
)