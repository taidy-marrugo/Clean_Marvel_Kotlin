package com.puzzlebench.clean_marvel_kotlin.presentation.adapter.viewholder

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import com.puzzlebench.clean_marvel_kotlin.domain.model.Character
import com.puzzlebench.clean_marvel_kotlin.presentation.extension.getImageByUrl
import com.puzzlebench.clean_marvel_kotlin.presentation.listener.CharacterListener
import kotlinx.android.synthetic.main.character_cards_layout.view.*


class CharactersAdapterViewHolder(view: View, val listener: CharacterListener) : RecyclerView.ViewHolder(view) {

    fun bind(item: Character) = with(itemView) {
        tv_item.text = item.name
        val dot="."
        val path=item.thumbnail.path
        val extension=item.thumbnail.extension
        val string ="$path$dot$extension"
        image_thumbnail.getImageByUrl(string)
        setOnClickListener { listener(item) }
    }
}