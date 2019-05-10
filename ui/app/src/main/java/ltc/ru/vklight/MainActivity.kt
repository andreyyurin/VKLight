package ltc.ru.vklight

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.facebook.drawee.backends.pipeline.Fresco
import com.vk.api.sdk.VK
import com.vk.api.sdk.VKTokenExpiredHandler
import com.vk.api.sdk.auth.VKAccessToken
import com.vk.api.sdk.auth.VKAuthCallback
import kotlinx.android.synthetic.main.activity_main.*
import ltc.ru.authorization.AuthorizationFragment
import ltc.ru.base.base.BaseActivity
import ltc.ru.base.base.BaseFragment
import ltc.ru.base.di.ProjectComponent
import ltc.ru.base.navigation.GlobalScreenKeys
import ltc.ru.feed.FeedFragment
import ltc.ru.taskhelper.R
import ru.terrakok.cicerone.Navigator

class MainActivity : BaseActivity(), MainView {
    @InjectPresenter
    internal lateinit var presenter: MainPresenter

    override lateinit var navigator: Navigator

    override fun layoutId(): Int = R.layout.activity_main

    override fun createComponent(projectComponent: ProjectComponent) {
        val component = DaggerMainComponent.builder()
            .projectComponent(projectComponent)
            .mainModule(MainModule())
            .build()
        component.inject(presenter)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initNavigator()
        initBottomNavView(savedInstanceState)
        initBackStackChangeListener()
        checkLogin()
        initTokenHandler()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val callback = VKAuthCallback()
        if (data == null || !VK.onActivityResult(requestCode, resultCode, data, callback)) {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

    private fun VKAuthCallback() = object : VKAuthCallback {
        override fun onLogin(token: VKAccessToken) {
            presenter.onFeedClick()
            testInfo()
        }

        override fun onLoginFailed(errorCode: Int) {
        }
    }

    private fun checkLogin() {
        if (VK.isLoggedIn()) {
            presenter.onFeedClick()
        } else {
            presenter.openAuthScreen()
        }

    }

    private fun initTokenHandler() {
        VK.addTokenExpiredHandler(tokenTracker)
    }

    private val tokenTracker = object : VKTokenExpiredHandler {
        override fun onTokenExpired() {
            // token expired
        }
    }

    private fun testInfo() {

    }

    private fun initNavigator() {
        navigator = MainNavigator(
            this, R.id.main_fragment_container,
            mapOf(
                Pair(GlobalScreenKeys.FEED_SCREEN, feedFragment),
                Pair(GlobalScreenKeys.AUTHORIZATION_SCREEN, authFragment)
            ),
            main_bottom_navigation
        )
    }

    private fun initBottomNavView(savedInstanceState: Bundle?) {
        main_bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.bottom_nav_action_my_tasks -> presenter.onFeedClick()
            }
            true
        }

        savedInstanceState ?: apply {
            //main_bottom_navigation.selectedItemId = R.id.bottom_nav_action_my_tasks
        }
    }

    private fun initBackStackChangeListener() {
        supportFragmentManager.addOnBackStackChangedListener {
            val lastFragment = supportFragmentManager.findFragmentById(R.id.main_fragment_container)
            if (lastFragment != null) {
                presenter.onFragmentChanged((lastFragment as BaseFragment).isShowBottomMenu())
            }
        }
    }

    private fun initFragment(tag: String, newInstance: () -> BaseFragment): BaseFragment {
        var fragment = supportFragmentManager.findFragmentByTag(tag)
        fragment ?: apply {
            fragment = newInstance()
            supportFragmentManager.beginTransaction()
                .add(R.id.main_fragment_container, fragment, tag)
                .detach(fragment)
                .commitNow()
        }
        return fragment as BaseFragment
    }

    private val feedFragment: BaseFragment by lazy {
        initFragment(GlobalScreenKeys.FEED_SCREEN) { FeedFragment() }
    }

    private val authFragment: BaseFragment by lazy {
        initFragment(GlobalScreenKeys.AUTHORIZATION_SCREEN) { AuthorizationFragment() }
    }

    override fun showBottomMenu(show: Boolean) {
        if (!show) main_bottom_navigation.visibility = View.GONE
        else main_bottom_navigation.visibility = View.VISIBLE
    }
}
