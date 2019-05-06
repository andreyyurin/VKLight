package ltc.ru.feed

import ltc.ru.base.base.BaseView

internal interface FeedView : BaseView{
    fun setData(res: String)
}