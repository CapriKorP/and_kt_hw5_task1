data class Post(

    var id: Int = 0,                                //Идентификатор записи.
    var owner_id: Int = 324534,                              //Идентификатор владельца стены, на которой размещена запись.
    var fromId: Int = 435345,                                //Идентификатор автора записи (от чьего имени опубликована запись).
    var created_by: Int = 4534,                            //Идентификатор администратора, который опубликовал запись (возвращается только для сообществ при запросе с ключом доступа администратора). Возвращается в записях, опубликованных менее 24 часов назад.
    var Date: Int = 34645325,                                  //Время публикации записи в формате unixtime.
    var text: String = "Hello Kotlin",                               //Текст записи.
    var replyOwnerId: Int = 57645,                          //Идентификатор владельца записи, в ответ на которую была оставлена текущая.
    var replyPostId: Int = 3423,                           //Идентификатор записи, в ответ на которую была оставлена текущая.
    var friendsOnly: Boolean = false,               //true если запись была создана с опцией «Только для друзей».
    val comments: Comments,                         //Информация о комментариях к записи, объект с полями.
    val likes: Likes,                               //Информация о лайках к записи, объект с полями
    val reports: Reports,                           //Информация о репостах записи («Рассказать друзьям»), объект с полями
    val views: Views,                               //Информация о просмотрах записи.
    var postType: String = "post",                           //Тип записи, может принимать следующие значения: post, copy, reply, postpone, suggest.
    val geo:Geo,                                    //Информация о местоположении
    var signerId: Int = 23346346,                              //Идентификатор автора, если запись была опубликована от имени сообщества и подписана пользователем;
    var canPin: Boolean = true,                            //Информация о том, может ли текущий пользователь закрепить запись
    var canDelete: Boolean = true,                         //Информация о том, может ли текущий пользователь удалить запись
    var canEdit: Boolean = true,                           //Информация о том, может ли текущий пользователь редактировать запись
    var isPinned: Boolean = true,                          //Информация о том, что запись закреплена.
    var markedAsAds: Boolean = true,                       //Информация о том, содержит ли запись отметку «реклама»
    var isFavirite: Boolean = true,                        //true, если объект добавлен в закладки у текущего пользователя.
    var postponedId: Int = 234245                            //Идентификатор отложенной записи. Это поле возвращается тогда, когда запись стояла на таймере.
)

class Comments(
    var count: Int = 0,                             //количество комментариев
    var canPost: Boolean = true,                    //информация о том, может ли текущий пользователь комментировать запись (true — может, false — не может);
    var groupsCanPost: Boolean = true,              //информация о том, могут ли сообщества комментировать запись
    var canClose: Boolean = false,                  // может ли текущий пользователь закрыть комментарии к записи
    var canOpen: Boolean = false                    // может ли текущий пользователь открыть комментарии к записи
)

class Likes(
    var count: Int = 0,                             //число пользователей, которым понравилась запись;
    var userLikes: Boolean = true,                  //наличие отметки «Мне нравится» от текущего пользователя
    var like: Boolean = true,                       //информация о том, может ли текущий пользователь поставить отметку «Мне нравится»
    var canPublish: Boolean = true                  //информация о том, может ли текущий пользователь сделать репост записи
)

class Reports(
    var count: Int = 0,                             //число пользователей, скопировавших запись;
    var userReposted: Boolean = false               // наличие репоста от текущего пользователя(true - есть, fasle - нет)
)

class Views(
    var count: Int = 0                              //число просмотров записи.
)

class Geo(
    var type: String = "Home",                               //тип места
    var coordinates: String = "N 363636, E 545454",           //координаты места;
    val place:Place                                 //описание места (если оно добавлено)
)


class Place(
    var id: Int = 1234,                                    //Идентификатор места.
    var title: String = "Москва",                              //Иазвание места.
    var latitude: Int = 363636,                              //Географическая широта, заданная в градусах (от -90 до 90).
    var longtitude: Int = 545454,                            //Географическая широта, заданная в градусах (от -90 до 90).
    var created: Int = 850729476,                               //Дата создания места в Unixtime.
    var icon: String = "https://www.kornienkov.online/icon.png",                               //Иконка места, URL изображения.
    var checkins: Int = 0,                              //Число отметок в этом месте.
    var updated: Int = 879766585,                               //Дата обновления места в Unixtime.
    var type: Int = 1,                                  //Тип места.
    var country: Int = 7,                               //Идентификатор страны.
    var city: Int = 495,                                  //Идентификатор города.
    var address: String = "Кремль"                             //Адрес места.
)


object WallService {


    private var posts = emptyArray<Post>()
    private var count = 0
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
}

