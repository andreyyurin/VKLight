package ltc.ru.imageview

import android.net.Uri
import android.os.Bundle
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.bumptech.glide.Glide
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.drawee.drawable.ProgressBarDrawable
import com.facebook.drawee.drawable.ScalingUtils
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder
import com.facebook.imagepipeline.request.ImageRequest
import com.github.chrisbanes.photoview.PhotoViewAttacher
import kotlinx.android.synthetic.main.image_view_layout.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import ltc.ru.base.base.BaseFragment
import ltc.ru.base.di.ProjectComponent

class ImageViewerFragment : BaseFragment(), ImageViewerView {

    companion object {
        private const val ARGS_IMAGE_URL = "ImageViewerFragment.imageUrl"

        fun newInstance(imageUrl: String): ImageViewerFragment {
            val fragment = ImageViewerFragment()

            val args = Bundle()
            args.putString(ARGS_IMAGE_URL, imageUrl)
            fragment.arguments = args

            return fragment
        }
    }

    private lateinit var photoAttacher: PhotoViewAttacher

    @InjectPresenter
    internal lateinit var presenter: ImageViewerPresenter

    override fun layoutId(): Int = R.layout.image_view_layout


    override fun createComponent(projectComponent: ProjectComponent) {
        DaggerImageViewerComponent.builder()
            .projectComponent(projectComponent)
            .imageViewerModule(ImageViewerModule(arguments!!.getString(ARGS_IMAGE_URL)))
            .build()
            .inject(presenter)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAttach()
    }

    private fun initAttach() {
        Glide
            .with(main_image.context)
            .load(arguments!!.getString(ARGS_IMAGE_URL))
            .into(main_image)
        photoAttacher = PhotoViewAttacher(main_image)
    }

    override fun isShowBottomMenu() = false

}