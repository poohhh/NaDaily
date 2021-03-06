package kr.kerri.nadaily.models

import com.google.firebase.database.IgnoreExtraProperties

// [START comment_class]
@IgnoreExtraProperties
data class Comment(
    var uid: String? = "",
    var author: String? = "",
    var text: String? = "",
    var date: String? = ""
)
// [END comment_class]