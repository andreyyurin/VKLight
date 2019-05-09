package ltc.ru.feed

import com.arellomobile.mvp.InjectViewState
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import ltc.ru.base.base.BasePresenter
import ltc.ru.domain.interactor.feed.FeedInteractorImpl
import ltc.ru.domain.interactor.user.UserInteractorImpl
import ltc.ru.domain.models.VKUser
import javax.inject.Inject

@InjectViewState
internal class FeedPresenter : BasePresenter<FeedView>() {

    @Inject
    lateinit var feedInteractor: FeedInteractorImpl

    @Inject
    lateinit var userInteractor: UserInteractorImpl

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
    }

    fun getFeedPhotos() {
        GlobalScope.launch {
            feedInteractor.getPhotosFeed(viewState::setDataPhotos)
        }
    }

    fun updateFeedPhotos() {
        GlobalScope.launch {
            feedInteractor.getPhotosFeed(viewState::updateDataPhotos)
        }
    }

    fun getUsers(ids: String){
        GlobalScope.launch {
            userInteractor.getUser(viewState::loadDataUsers, ids)
        }
    }
}