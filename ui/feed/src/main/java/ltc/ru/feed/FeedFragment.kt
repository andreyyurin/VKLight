package ltc.ru.feed

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.AdapterView
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.fragment_feed.*
import ltc.ru.base.base.BaseFragment
import ltc.ru.base.di.ProjectComponent
import ltc.ru.domain.models.VKPhotoFeed
import ltc.ru.domain.models.VKUser
import ltc.ru.feed.adapter.FeedPhotosAdapter
import ltc.ru.feed.adapter.FeedSpinnerAdapter

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
        initSpinner(view)
        initProgressBar()
        initRecyclerView(view)
        initSwipeRefreshLayout()
        getDataFeedPhotos()
    }

    private fun initSpinner(view: View){
        val listSpinner = arrayOf("Histories", "Photos", "News")
        feed_spinner.adapter = FeedSpinnerAdapter(view.context, listSpinner)

        feed_spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }
    }

    private fun initProgressBar() {
        feed_progress_bar.spin()
    }

    private fun getDataFeedPhotos() {
        presenter.getFeedPhotos()
    }

    private fun getUpdateDataFeedPhotos() {
        presenter.updateFeedPhotos()
    }

    private fun getUsersInformation(listIds: String){
        presenter.getUsers(listIds)
    }

    private fun initSwipeRefreshLayout() {
        swipe_container.setOnRefreshListener { getUpdateDataFeedPhotos() }
    }

    private fun initRecyclerView(view: View) {
        feed_photos_recycler.layoutManager = LinearLayoutManager(view.context)
        feed_photos_recycler.adapter = adapter
    }

    private val adapter: FeedPhotosAdapter by lazy {
        FeedPhotosAdapter(this.requireContext(), presenter::openFullImageScreen)
    }

    override fun setDataPhotos(res: VKPhotoFeed) {
        getUsersInformation(algthStringOfAllIds(res))
        adapter.swapPhotoItems(res.response.items)
        feed_progress_bar.visibility = View.GONE
    }

    override fun updateDataPhotos(res: VKPhotoFeed) {
        getUsersInformation(algthStringOfAllIds(res))
        adapter.swapPhotoItems(res.response.items)
        swipe_container.isRefreshing = false
    }

    override fun loadDataUsers(res: VKUser) {
        adapter.swapUserItems(res.response)
    }

    private fun algthStringOfAllIds(res: VKPhotoFeed): String{
        var finalString = ""
        for(i in res.response.items){
            finalString+=((i.sourceId.toString()+","))
        }
        finalString = finalString.substring(0, finalString.length-1)
        return finalString
    }


    override fun isShowBottomMenu() = true

}