package com.github.astat1cc.holybibleapp.data

import com.github.astat1cc.holybibleapp.core.Abstract
import com.github.astat1cc.holybibleapp.core.Book
import com.github.astat1cc.holybibleapp.domain.BooksDomain
import java.lang.Exception

sealed class BooksData : Abstract.Object<BooksDomain, BookDataToDomainMapper>() {

    class Success(private val books: List<Book>) : BooksData() {
        override fun map(mapper: BookDataToDomainMapper) = mapper.map(books)
    }

    class Fail(private val e: Exception) : BooksData() {

        override fun map(mapper: BookDataToDomainMapper) = mapper.map(e)
    }
}