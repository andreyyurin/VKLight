package ltc.ru.domain.models

import com.google.gson.annotations.SerializedName


data class VKPhotoFeed(
    val response: ResponseFeedPhotos
)

data class ResponseFeedPhotos(
    val groups: List<Any>,
    val items: List<ItemFeedPhotos>,
    @SerializedName("next_from") val nextFrom: String,
    val profiles: List<ProfileFeedPhotos>
)

data class CommentsFeedPhotos(
    val count: Int
)

data class ItemFeedPhotos(
    val date: Long,
    val photos: PhotosFeedPhotos?,
    @SerializedName("photo_tags") val photoTags: PhotosFeedPhotos?,
    @SerializedName("post_id") val postId: Int,
    @SerializedName("source_id") val sourceId: Int,
    val type: String
)

data class ItemXFeedPhotos(
    @SerializedName("access_key") val accessKey: String,
    @SerializedName("album_id") val albumId: Int,
    @SerializedName("can_comment") val canComment: Int,
    @SerializedName("can_repost") val canRepost: Int,
    val comments: CommentsFeedPhotos,
    val date: Long,
    val id: Int,
    val likes: LikesFeedPhotos,
    @SerializedName("owner_id") val ownerId: Int,
    val reposts: RepostsFeedPhotos,
    val sizes: List<SizeFeedPhotos>,
    val text: String
)

data class LikesFeedPhotos(
    val count: Int,
    @SerializedName("user_likes") val userLikes: Int
)

data class PhotosFeedPhotos(
    val count: Int,
    val items: List<ItemXFeedPhotos>
)

data class ProfileFeedPhotos(
    @SerializedName("can_access_closed") val canAccessClosed: Boolean,
    @SerializedName("first_name") val firstName: String,
    val id: Int,
    @SerializedName("is_closed") val isClosed: Boolean,
    @SerializedName("last_name") val lastName: String,
    val online: Int,
    @SerializedName("photo_100") val photo100: String,
    @SerializedName("photo_50") val photo50: String,
    @SerializedName("screen_name") val screenName: String,
    val sex: Int
)

data class RepostsFeedPhotos(
    val count: Int,
    @SerializedName("user_reposted") val userReposted: Int
)

data class SizeFeedPhotos(
    val height: Int,
    val type: String,
    val url: String,
    val width: Int
)