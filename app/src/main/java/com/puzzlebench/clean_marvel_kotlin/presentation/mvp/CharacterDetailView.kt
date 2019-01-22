package com.puzzlebench.clean_marvel_kotlin.presentation.mvp

import android.util.Log
import android.view.View
import com.puzzlebench.clean_marvel_kotlin.R
import com.puzzlebench.clean_marvel_kotlin.domain.model.Character
import com.puzzlebench.clean_marvel_kotlin.presentation.Util
import com.puzzlebench.clean_marvel_kotlin.presentation.extension.getImageByUrl
import com.puzzlebench.clean_marvel_kotlin.presentation.extension.showToast
import com.puzzlebench.clean_marvel_kotlin.presentation.fragment.DetailCharacterFragmentDialog
import kotlinx.android.synthetic.main.fragment_dialog_detail_character.*
import java.lang.ref.WeakReference

class CharacterDetailView(fragment: DetailCharacterFragmentDialog) {
   private  val fragment=fragment
    var idCharacter: Int= Util.DEFAULT_ID_CHARACTER

    fun init() {

        if (fragment != null) {
            idCharacter = fragment.idCharacter
        }
    }

    fun showToastNoItemToShow() {
        val message = fragment?.resources?.getString(R.string.message_no_detail_to_show)
        message?.let { fragment?.activity?.showToast(it) }
    }

    fun showToastNetworkError(error: String) {
        fragment?.activity?.showToast(error)
    }

    fun showCharactersDetail(character: Character) {
            fragment?.text_dialog_detail_character_name?.text = character.name
            fragment?.text_dialog_detail_character_description?.text = character.description
            val string =character.thumbnail.path.plus(".").plus(character.thumbnail.extension)
            fragment?.characterPicture?.getImageByUrl(string)
    }
}