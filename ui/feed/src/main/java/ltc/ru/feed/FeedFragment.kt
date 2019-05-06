package ltc.ru.feed

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.fragment_feed.*
import ltc.ru.base.base.BaseFragment
import ltc.ru.base.di.ProjectComponent
import ltc.ru.domain.models.VKPhotoFeed
import ltc.ru.feed.adapter.FeedPhotosAdapter

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
        initProgressBar()
        initRecyclerView(view)
        initSwipeRefreshLayout()
        getDataFeedPhotos()
    }

    private fun initProgressBar(){
        feed_progress_bar.spin()
    }

    private fun getDataFeedPhotos(){
        presenter.getFeedPhotos()
    }

    private fun getUpdateDataFeedPhotos(){
        presenter.updateFeedPhotos()
    }


    private fun initSwipeRefreshLayout(){
        swipe_container.setOnRefreshListener{ getUpdateDataFeedPhotos() }
    }

    private fun initRecyclerView(view: View) {
        feed_photos_recycler.layoutManager = LinearLayoutManager(view.context)
        feed_photos_recycler.adapter = adapter
    }

    private val adapter: FeedPhotosAdapter by lazy {
        FeedPhotosAdapter(this.requireContext())
    }

    override fun setDataPhotos(res: VKPhotoFeed) {
        adapter.swapItems(res.response.items)
        feed_progress_bar.visibility = View.GONE
    }

    override fun updateDataPhotos(res: VKPhotoFeed){
        adapter.swapItems(res.response.items)
        swipe_container.isRefreshing = false
    }

    override fun isShowBottomMenu() = true

}