package gh.code.dictionary.data.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import gh.code.dictionary.data.database.entity.MeaningR

class Converters {
    private val gson = Gson()

    @TypeConverter
    fun fromSourceUrl(sourceUrl: List<String>?): String =
        gson.toJson(sourceUrl)

    @TypeConverter
    fun toSourceUrl(str: String): List<String> =
        gson.fromJson(str, object : TypeToken<List<String>>() {}.type)

    @TypeConverter
    fun fromMeaningsList(meanings: List<MeaningR>): String =
        gson.toJson(meanings)

    @TypeConverter
    fun toMeaningsList(str: String): List<MeaningR> =
        gson.fromJson(str, object : TypeToken<List<MeaningR>>() {}.type)
}