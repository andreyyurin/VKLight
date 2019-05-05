package ltc.ru.vklight

import android.content.Context
import android.content.Intent
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.view.View
import ltc.ru.authorization.AuthorizationFragment
import ltc.ru.base.base.BaseFragment
import ltc.ru.base.navigation.GlobalScreenKeys
import ru.terrakok.cicerone.android.SupportAppNavigator
import ru.terrakok.cicerone.commands.Command
import ru.terrakok.cicerone.commands.Replace

internal class MainNavigator(activity: MainActivity,
                             containerId: Int,
                             private val bottomFragmentsMap: Map<String, BaseFragment>,
                             private val mainNavigationBottom: BottomNavigationView)
    : SupportAppNavigator(activity, containerId) {


    private val fragmentManager = activity.supportFragmentManager!!
    //private val transactionAnimations = TransitionAnimations.SLIDE

    override fun createActivityIntent(context: Context?, screenKey: String?, data: Any?): Intent? {
        // add all activities that can be launched from mainActivity or it's fragments here
        return null
    }

    override fun createFragment(screenKey: String?, data: Any?): Fragment? {
        return when (screenKey) {
//            GlobalScreenKeys.MY_TASKS_SCREEN -> MyTasksFragment()
//            GlobalScreenKeys.PEOPLE_TASKS_SCREEN -> PeopleTasksFragment()
//            GlobalScreenKeys.MORE_SCREEN -> MoreFragment()
            GlobalScreenKeys.AUTHORIZATION_SCREEN -> AuthorizationFragment()
            else -> throw IllegalStateException("Main navigator - unknown screen key: $screenKey")
        }
    }

    override fun applyCommand(command: Command?) {
        if(command is Replace && command.screenKey.equals(GlobalScreenKeys.AUTHORIZATION_SCREEN) && command.screenKey in GlobalScreenKeys.getBottomNavScreenKeys()){
            mainNavigationBottom.visibility = View.GONE
            attachFirstFragmentDetachOthers(bottomFragmentsMap[(command).screenKey]!!,
                bottomFragmentsMap.filter { it.key != command.screenKey }.values)
        }else if (command is Replace && command.screenKey in GlobalScreenKeys.getBottomNavScreenKeys()) {
            mainNavigationBottom.visibility = View.VISIBLE
            attachFirstFragmentDetachOthers(bottomFragmentsMap[(command).screenKey]!!,
                bottomFragmentsMap.filter { it.key != command.screenKey }.values
            )
        }
        else super.applyCommand(command)
    }

    private fun attachFirstFragmentDetachOthers(attachFragment: BaseFragment,
                                                detachFragments: Collection<BaseFragment>) {
        val transaction = fragmentManager.beginTransaction()
        detachFragments.forEach { transaction.detach(it) }
        transaction.attach(attachFragment)
        transaction.commitNow()
    }

}