package com.example.sampleproject.data.remote.model.response

data class CharacterListInfo (
    val count: Int,
    val pages: Int,
    val next: String,
    val prev: String?
)

