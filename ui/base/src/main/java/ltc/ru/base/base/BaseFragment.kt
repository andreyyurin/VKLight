package ltc.ru.base.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.arellomobile.mvp.MvpAppCompatFragment
import ltc.ru.base.app.ProjectApplication
import ltc.ru.base.di.ProjectComponent

abstract class BaseFragment : MvpAppCompatFragment(), BaseView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        createComponent((context!!.applicationContext as ProjectApplication).projectComponent)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutId(), container, false)
    }

    protected abstract fun createComponent(projectComponent: ProjectComponent)

    open fun isShowBottomMenu() = false

    protected abstract fun layoutId(): Int
}