package com.puzzlebench.clean_marvel_kotlin.data.service

import android.telecom.Call
import com.puzzlebench.clean_marvel_kotlin.data.mapper.CharacterMapperService
import com.puzzlebench.clean_marvel_kotlin.data.service.api.MarvelApi
import com.puzzlebench.clean_marvel_kotlin.data.service.response.CharacterResponse
import com.puzzlebench.clean_marvel_kotlin.domain.model.Character
import io.reactivex.Observable
import java.util.concurrent.Callable


class CharacterServicesImpl(private val api: MarvelResquestGenerator = MarvelResquestGenerator(), private val mapper: CharacterMapperService = CharacterMapperService()) {


    fun getCaracters(): Observable<List<Character>> {
            return Observable.fromCallable(Callable<List<Character>>() {
                val callResponse = api.createService(MarvelApi::class.java).getCharacter()
                val response = callResponse.execute()
                return@Callable response.body()?.data?.characters?.let { mapper.transform(it) }
            });
    }

    fun getCaractersDetail(id: Int): Observable<List<Character>> {
        return Observable.fromCallable(Callable<List<Character>>() {
            val callResponse = api.createService(MarvelApi::class.java).getCharacterDetail(id)
            val response = callResponse.execute()
            return@Callable response.body()?.data?.characters?.let { mapper.transform(it) }
        });
    }
}