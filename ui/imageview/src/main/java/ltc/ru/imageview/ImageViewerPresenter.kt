package ltc.ru.imageview

import com.arellomobile.mvp.InjectViewState
import kotlinx.coroutines.launch
import ltc.ru.base.base.BasePresenter
import javax.inject.Inject

@InjectViewState
internal class ImageViewerPresenter : BasePresenter<ImageViewerView>(){
    @JvmField
    @Inject
    protected var imageUrl = "-1"
}