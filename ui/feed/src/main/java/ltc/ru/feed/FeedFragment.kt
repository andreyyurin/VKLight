package ltc.ru.feed

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
import kotlinx.android.synthetic.main.fragment_feed.*
import ltc.ru.base.base.BaseFragment
import ltc.ru.base.di.ProjectComponent
import ltc.ru.feed.FeedView
import ltc.ru.feed.R

class FeedFragment : BaseFragment(), FeedView {
    @InjectPresenter
    internal lateinit var presenter: FeedPresenter

    override fun layoutId(): Int = R.layout.fragment_feed


    override fun createComponent(projectComponent: ProjectComponent) {
        DaggerFeedComponent.builder()
            .projectComponent(projectComponent)
            .build()
            .inject(presenter)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        test_text.setOnClickListener { presenter.sendData() }
    }

    override fun setData(res: String) {
       test_text.text = res
    }

    override fun isShowBottomMenu() = true

}