package ltc.ru.feed

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import ltc.ru.base.base.BasePresenter
import ltc.ru.base.navigation.GlobalScreenKeys
import ltc.ru.domain.interactor.feed.FeedInteractorImpl
import ltc.ru.feed.FeedView
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
internal class FeedPresenter : BasePresenter<FeedView>(){

    @Inject
    lateinit var interactor: FeedInteractorImpl

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        //sendData()
    }

    fun sendData(){
        GlobalScope.launch{
            interactor.getProfile(viewState::setData)
        }
    }
}