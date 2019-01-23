package com.puzzlebench.clean_marvel_kotlin.data.local

interface RealmWrapper<T> {

    fun queryAll(clazz : Class<T>) : List<T>
    fun save(obj: T)
    fun deleteAll(clazz: Class<T>)
}