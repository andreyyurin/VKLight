package ltc.ru.authorization

import android.app.Application
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.vk.api.sdk.VK
import com.vk.api.sdk.auth.VKAccessToken
import com.vk.api.sdk.auth.VKAuthCallback
import com.vk.api.sdk.auth.VKScope
import kotlinx.android.synthetic.main.fragment_authorization.*
import ltc.ru.base.base.BaseFragment
import ltc.ru.base.di.ProjectComponent

class AuthorizationFragment : BaseFragment(), AuthorizationView{

    @InjectPresenter
    internal lateinit var presenter: AuthorizationPresenter

    override fun layoutId(): Int = R.layout.fragment_authorization


    override fun createComponent(projectComponent: ProjectComponent) {
        DaggerAuthorizationComponent.builder()
            .projectComponent(projectComponent)
            .build()
            .inject(presenter)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initTestBtn()
    }

    private fun vkLogin(){
        VK.login(requireActivity(), arrayListOf(VKScope.WALL, VKScope.FRIENDS))
    }

    private fun initTestBtn(){
        test_btn.let {
            it.setOnClickListener { vkLogin() }
        }
    }


    override fun isShowBottomMenu() = false
}