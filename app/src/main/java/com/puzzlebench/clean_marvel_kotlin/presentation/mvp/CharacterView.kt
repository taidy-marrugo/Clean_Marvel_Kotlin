package com.puzzlebench.clean_marvel_kotlin.presentation.mvp

import android.support.v7.widget.GridLayoutManager
import android.view.View
import com.puzzlebench.clean_marvel_kotlin.R
import com.puzzlebench.clean_marvel_kotlin.domain.model.Character
import com.puzzlebench.clean_marvel_kotlin.presentation.MainActivity
import com.puzzlebench.clean_marvel_kotlin.presentation.adapter.CharacterAdapter
import com.puzzlebench.clean_marvel_kotlin.presentation.extension.showToast
import com.puzzlebench.clean_marvel_kotlin.presentation.fragment.DetailCharacterFragmentDialog
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.ref.WeakReference

class CharacterView(activity: MainActivity) {
    private  val activity = activity
    private val SPAN_COUNT = 1
    private var adapter: CharacterAdapter? = null
    fun init() {

        if (activity != null) {
                adapter = CharacterAdapter { character ->
                val fragment = DetailCharacterFragmentDialog.newInstance(character.id)
                fragment.show(activity.fragmentManager,"Detail")
            }
            activity.recycleView.layoutManager = GridLayoutManager(activity, SPAN_COUNT)
            activity.recycleView.adapter = adapter
            showLoading()
        }
    }

    fun showToastNoItemToShow() {
        activity?.resources?.getString(R.string.message_no_items_to_show)?.let { activity?.applicationContext?.showToast(it) }
    }

    fun showToastNetworkError(error: String) {
        activity?.applicationContext?.showToast(error)
    }

    fun hideLoading() {
        activity?.progressBar?.visibility = View.GONE
    }

    fun showCharacters(characters: List<Character>) {
        adapter?.data = characters
    }

    fun showLoading() {
        activity?.progressBar?.visibility = View.VISIBLE
    }
}
