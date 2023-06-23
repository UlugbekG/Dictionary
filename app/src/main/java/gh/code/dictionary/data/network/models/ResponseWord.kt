package gh.code.dictionary.data.network.models

data class ResponseWord(
    val word: String?,
    val phonetic: String?,
    val meanings: List<Meaning>? = listOf(),
    val sourceUrls: List<String>? = listOf(),
)