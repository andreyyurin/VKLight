package ltc.ru.vklight

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import ltc.ru.base.base.BaseView

internal interface MainView : BaseView{
    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showBottomMenu(show: Boolean)
}
