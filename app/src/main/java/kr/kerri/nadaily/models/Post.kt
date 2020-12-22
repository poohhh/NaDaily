package kr.kerri.nadaily.models

import com.google.firebase.database.Exclude
import com.google.firebase.database.IgnoreExtraProperties
import java.util.HashMap

// [START post_class]
@IgnoreExtraProperties
data class Post(
    var uid: String? = "",
    var author: String? = "",
    var title: String? = "",
    var body: String? = "",
    var heartCount: Int = 0,
    var hearts: MutableMap<String, Boolean> = HashMap()
) {

    // [START post_to_map]
    @Exclude
    fun toMap(): Map<String, Any?> {
        return mapOf(
            "uid" to uid,
            "author" to author,
            "title" to title,
            "body" to body,
            "heartCount" to heartCount,
            "hearts" to hearts
        )
    }
    // [END post_to_map]
}
// [END post_class]