package com.puzzlebench.clean_marvel_kotlin.presentation.fragment


import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import com.puzzlebench.clean_marvel_kotlin.R
import com.puzzlebench.clean_marvel_kotlin.data.service.CharacterServicesImpl
import com.puzzlebench.clean_marvel_kotlin.domain.usecase.GetCharacterDetailServiceUseCase
import com.puzzlebench.clean_marvel_kotlin.presentation.Util
import com.puzzlebench.clean_marvel_kotlin.presentation.base.BaseRxFragmentDialog
import com.puzzlebench.clean_marvel_kotlin.presentation.mvp.CharacterDetailPresenter
import com.puzzlebench.clean_marvel_kotlin.presentation.mvp.CharacterDetailView


private const val ARG_ID = "ID_CHARACTER"

open class DetailCharacterFragmentDialog : BaseRxFragmentDialog() {
    var idCharacter: Int=Util.DEFAULT_ID_CHARACTER
    val getCharacterDetailServiceUseCase = GetCharacterDetailServiceUseCase(CharacterServicesImpl())
    val presenter = CharacterDetailPresenter(CharacterDetailView(this), getCharacterDetailServiceUseCase, subscriptions)

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater?.inflate(R.layout.fragment_dialog_detail_character, container, false)!!
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        arguments?.let {
            idCharacter = it.getInt(ARG_ID)
            idCharacter = it.getInt(ARG_ID)
        }

        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        return dialog
    }

    override fun onStart() {
        super.onStart()
        presenter.init()
        presenter.requestGetCharacterDetail()
    }

    companion object {

        fun newInstance(idCharacter: Int) =
                DetailCharacterFragmentDialog().apply {
                    arguments = Bundle().apply {
                        putInt(ARG_ID, idCharacter)
                    }
                }
    }
}