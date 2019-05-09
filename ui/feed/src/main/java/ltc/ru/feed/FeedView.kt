package ltc.ru.feed

import ltc.ru.base.base.BaseView
import ltc.ru.domain.models.VKPhotoFeed
import ltc.ru.domain.models.VKUser

internal interface FeedView : BaseView {
    fun setDataPhotos(res: VKPhotoFeed)

    fun updateDataPhotos(res: VKPhotoFeed)

    fun loadDataUsers(res: VKUser)
}