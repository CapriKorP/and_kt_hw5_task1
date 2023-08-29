import online.kornienkov.classes.Post
import online.kornienkov.classes.Likes
import online.kornienkov.classes.WallService
import online.kornienkov.classes.Date

fun main() {
    val post = Post(1,
        1,
        2,
        Date(1,1,2023),
        "Hello",
        true,
        "good",
        true,
        true,
        true,
        true,
        Likes(1,true,true,true)
    )


    WallService.add(post)
    println(post)

    WallService.add(post)
    println(post)

    WallService.update(post){
        if(post)
    }

}
