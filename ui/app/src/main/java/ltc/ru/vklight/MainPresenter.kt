package ltc.ru.vklight

import com.arellomobile.mvp.InjectViewState
import ltc.ru.base.base.BasePresenter
import ltc.ru.base.navigation.GlobalScreenKeys
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
internal class MainPresenter : BasePresenter<MainView>() {

    @Inject
    lateinit var router: Router

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
    }

//    fun onMyTasksClick(){
//        router.replaceScreen(GlobalScreenKeys.MY_TASKS_SCREEN)
//    }
//
//    fun onPeopleTasksClick(){
//        router.replaceScreen(GlobalScreenKeys.PEOPLE_TASKS_SCREEN)
//    }
//
//    fun onMoreClick(){
//        router.replaceScreen(GlobalScreenKeys.MORE_SCREEN)
//    }
//
    fun openAuthScreen() {
        router.replaceScreen(GlobalScreenKeys.AUTHORIZATION_SCREEN)
    }
//
//    fun openMyTasksScreen() {
//        router.newRootScreen(GlobalScreenKeys.MY_TASKS_SCREEN)
//    }

    fun onFragmentChanged(isShowBottomMenu: Boolean){
        viewState.showBottomMenu(isShowBottomMenu)
    }


}