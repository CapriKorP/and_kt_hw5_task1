import online.kornienkov.classes.Likes
import online.kornienkov.classes.Post
import online.kornienkov.classes.WallService

fun main() {
    val post = Post(1,
        1,
        2,
        29082023,
        "Hello IDEA",
        true,
        "good",
        true,
        true,
        true,
        true,
        Likes()
    )

        val updatePost = Post(1,
            1,
            2,
            29082023,
            "Hello IDEA and Kotlin",
            true,
            "good",
            true,
            true,
            true,
            true,
            Likes()
        )

    WallService.add(post)
    println(post)
    WallService.update(updatePost)
    println(updatePost)
}
