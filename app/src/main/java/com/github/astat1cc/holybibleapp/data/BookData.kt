package com.github.astat1cc.holybibleapp.data

import com.github.astat1cc.holybibleapp.core.Abstract
import com.github.astat1cc.holybibleapp.data.cache.BookCache
import com.github.astat1cc.holybibleapp.domain.BookDomain

data class BookData(
    private val id: Int,
    private val name: String
) : Abstract.Object<BookDomain, BookDataToDomainMapper>(),
    ToBookCache<BookCache, BookDataToCacheMapper> {

    override fun map(mapper: BookDataToDomainMapper) = mapper.map(id, name)

    override fun toCache(mapper: BookDataToCacheMapper) = mapper.map(id, name)
}

interface ToBookCache<T, M : Abstract.Mapper> {

    fun toCache(mapper: M): T
}
