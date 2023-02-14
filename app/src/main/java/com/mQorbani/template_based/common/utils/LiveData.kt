package com.mQorbani.template_based.common.utils

import androidx.lifecycle.liveData
import com.mQorbani.template_based.data.model.BaseModel
import timber.log.Timber

fun <T> liveDataModel(block: suspend () -> BaseModel<T>) =
    liveData {
        val result = try {
            val baseModel = block()
            if (baseModel.errorCode == 0) {
                val model = baseModel.data
                Result.success(model)
            } else {
                Timber.tag("LiveDataUtils").e(
                    "fires: response status is ${baseModel.errorCode} msg is ${baseModel.errorMsg}"
                )
                Result.failure(RuntimeException(baseModel.errorMsg))
            }
        } catch (e: Exception) {
            Timber.tag("LiveDataUtils").e(e.toString())
            Result.failure(e)
        }
        emit(result)
    }

fun <T> liveDataFire(block: suspend () -> Result<T>) =
    liveData {
        val result = try {
            block()
        } catch (e: Exception) {
            Timber.tag("LiveDataUtils").e("fire $e")
            Result.failure(e)
        }
        emit(result)
    }