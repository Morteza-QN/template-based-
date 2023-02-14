package com.mQorbani.template_based.common

const val DATABASE_NAME = "db_adorateb"
const val DATABASE_VERSION = 1
const val DATASTORE_KEY = "adora_datastore"
const val TOKEN_KEY = "user_token"
const val PREFIX_JWT_TOKEN = "Bearer "

object Table {
    const val ID_NAME = "ID"

    object Personal {

        const val NAME = "Personal"
    }
}

object Api {
    const val BASE_URL = "http://"
    const val BASE_URL_TEST = "http://"
    const val SUFFIX_URL = "api/v1/"

    const val CONNECTION_TIMEOUT = 60L
}

object Named {
    const val NAMED_BASEURL = "named_baseurl"
    const val NAMED_BASE = "named_base"
    const val NAMED_BODY = "named_body"
}