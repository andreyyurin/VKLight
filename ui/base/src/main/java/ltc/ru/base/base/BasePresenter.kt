package ltc.ru.base.base

import com.arellomobile.mvp.MvpPresenter
import kotlinx.coroutines.*
import ltc.ru.base.base.exceptions.CommonExceptionHandler
import kotlin.coroutines.CoroutineContext


abstract class BasePresenter<View : BaseView> (protected val uiContext: CoroutineContext = Dispatchers.Main)
    : MvpPresenter<View>(), CoroutineScope {

    private val job = Job()
    override val coroutineContext = job + Dispatchers.Main + SupervisorJob()

    protected fun withExceptionHandler(){
        CommonExceptionHandler()
    }

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }
}

fun CoroutineScope.launch(func: suspend () -> Unit){
    launch { func.invoke() }
}