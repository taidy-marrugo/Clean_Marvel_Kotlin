package com.puzzlebench.clean_marvel_kotlin.presentation.mvp

import android.view.View
import com.puzzlebench.clean_marvel_kotlin.R
import com.puzzlebench.clean_marvel_kotlin.domain.model.Character
import com.puzzlebench.clean_marvel_kotlin.presentation.extension.getImageByUrl
import com.puzzlebench.clean_marvel_kotlin.presentation.extension.showToast
import com.puzzlebench.clean_marvel_kotlin.presentation.fragment.DetailCharacterFragmentDialog
import kotlinx.android.synthetic.main.fragment_dialog_detail_character.*
import java.lang.ref.WeakReference

class CharacterDetailView(fragment: DetailCharacterFragmentDialog) {
    private val fragmentRef = WeakReference(fragment)
    var idCharacter: Int? = null

    fun init() {
        val fragment = fragmentRef.get()
        if (fragment != null) {
            idCharacter = fragment.idCharacter
        }
    }

    fun showToastNoItemToShow() {
        val fragment = fragmentRef.get()
        if (fragment != null) {
            val message = fragment.resources.getString(R.string.message_no_detail_to_show)
           fragmentRef.get()?.activity?.showToast(message)
        }
    }

    fun showToastNetworkError(error: String) {
        fragmentRef.get()?.activity?.showToast(error)
    }

    fun showCharactersDetail(character: Character) {
        val fragment = fragmentRef.get()
        if (fragment != null) {
            fragment.text_dialog_detail_character_name.text = character.name
            fragment.text_dialog_detail_character_description.text = character.description
            val string = character.thumbnail.path + "." + character.thumbnail.extension
            fragment.characterPicture.getImageByUrl(string)
        }
    }
}