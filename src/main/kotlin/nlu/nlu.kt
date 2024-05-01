import furhatos.app.newskill.flow.libraryBooks
import furhatos.nlu.EnumEntity
import furhatos.util.Language

// Our authors
class Author : EnumEntity(stemming = true, speechRecPhrases = true) {
    override fun getEnum(lang: Language): List<String> {
        return libraryBooks.keys.toList()
    }
}

// Our books
class Book : EnumEntity(stemming = true, speechRecPhrases = true) {
    override fun getEnum(lang: Language): List<String> {
        return libraryBooks.values.toList()
    }
}