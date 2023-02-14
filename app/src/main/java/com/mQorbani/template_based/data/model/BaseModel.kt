package com.mQorbani.template_based.data.model

data class BaseModel<T>(
    val `data`: T,
    val errorCode: Int,
    val errorMsg: String
)