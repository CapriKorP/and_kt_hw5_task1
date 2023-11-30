import java.lang.NullPointerException
import javax.xml.stream.events.Comment

class PostNotFoundException(message: String) : RuntimeException(message)
data class Post(

    var id: Int = 0,                                   //Идентификатор записи.
    var owner_id: Int,                              //Идентификатор владельца стены, на которой размещена запись.
    var fromId: Int,                                //Идентификатор автора записи (от чьего имени опубликована запись).
    var created_by: Int,                            //Идентификатор администратора, который опубликовал запись (возвращается только для сообществ при запросе с ключом доступа администратора). Возвращается в записях, опубликованных менее 24 часов назад.
    var Date: Int,                                  //Время публикации записи в формате unixtime.
    var text: String,                               //Текст записи.
    var replyOwnerId: Int,                          //Идентификатор владельца записи, в ответ на которую была оставлена текущая.
    var replyPostId: Int,                           //Идентификатор записи, в ответ на которую была оставлена текущая.
    var friendsOnly: Boolean = false,                //true если запись была создана с опцией «Только для друзей».
    val comments: Comments,                         //Информация о комментариях к записи, объект с полями.
    val likes: Likes
)

class Comments(
    var count: Int = 0,                                  //количество комментариев
    var canPost: Boolean = true,                            //информация о том, может ли текущий пользователь комментировать запись (true — может, false — не может);
    var groupsCanPost: Boolean = true,                      //информация о том, могут ли сообщества комментировать запись
    var canClose: Boolean = false,                            // может ли текущий пользователь закрыть комментарии к записи
    var canOpen: Boolean = false                              // может ли текущий пользователь открыть комментарии к записи
)

class Likes(
    var count: Int = 0,                            //число пользователей, которым понравилась запись;
    var userLikes: Boolean = true,                  //наличие отметки «Мне нравится» от текущего пользователя
    var like: Boolean = true,                       //информация о том, может ли текущий пользователь поставить отметку «Мне нравится»
    var canPublish: Boolean = true                  //информация о том, может ли текущий пользователь сделать репост записи
)

object WallService {

    private var count = 0
    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comments>()

    fun add(post: Post): Post {
        count++
        posts += post.copy(id = count)
        return posts.last()

    }

    fun update(updatePost: Post): Boolean {
        for ((index, post) in posts.withIndex()) {
            if (post.id == updatePost.id) {
                posts[index] = post.copy(text = updatePost.text)
                return true
            }
        }
        return false
    }

    fun clear() {
        posts = emptyArray()
        count = 0
    }

    fun see(num: Int): Post {
        if (num < 1) {
            return posts.last()
        } else {
            return posts[num - 1]
        }
    }

    fun createComment(postId:Int, comment: Comments): Comments {
        for (post in posts) {
            if (post.id == postId) {
                comments += comment
                return comments.last()
            }
        }
        throw PostNotFoundException("Post id $postId not found")
    }
}