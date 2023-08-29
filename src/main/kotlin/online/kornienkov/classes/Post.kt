package online.kornienkov.classes

data class Post(
    var id: Int, //id поста
    var ownerId: Long, //id владельца стены
    var fromId: Long, //id автора
    var date: Long, //дата поста в формате Unix
    var text: String, //текст поста(долден быть в массиве
    var friendOnly: Boolean, //доступен только для друзей
    var postType: String, //тип поста
    var canPin: Boolean, // может ли пользователь закрепить пост
    var canDelete: Boolean, //можно ли удалить пост
    var canEdit: Boolean,//можно ли править пост
    var isPinned: Boolean, //пост закреплен
    val likes: Likes,
)

object WallService {

    private var postsArray = emptyArray<Post>() //инициалиpируем пустой массив
    private var count = 0

    fun add(post: Post): Post { //
        postsArray += post.copy(id = count++)
        return postsArray.last()
    }

    fun update(updatePost: Post): Boolean {
        for ((index, post) in postsArray.withIndex()) {
            if(post.id == updatePost.id) {
                post.text = updatePost.text
                return true
            }
        }
        return false
    }

}