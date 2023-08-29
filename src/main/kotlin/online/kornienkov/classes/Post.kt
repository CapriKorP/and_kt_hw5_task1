package online.kornienkov.classes

data class Post(
    val id: Int,
    val ownerId: Long,
    val fromId: Long,
    val date: Date,
    val text: String,
    var friendOnly: Boolean,
    val postType: String,
    var canPin: Boolean,
    var canDelete: Boolean,
    var canEdit: Boolean,
    var isPinned: Boolean,
    val likes: Likes
)

object WallService {

    var posts = emptyArray<Post>()

    fun add(post: Post): Post {
        posts += post
        return post
    }

    fun update(post: Post): Boolean {
        TODO()
    }

}