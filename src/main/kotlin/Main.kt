import online.kornienkov.classes.*

fun main() {
    var post = Post(1,
        2,
        3,
        4,
        5,
        "Hello Kotlin",
        25424,
        5345,
        true,
        Comments(),
        Likes(),
        Reports(),
        Views(),
        "post",
        Geo("Home",
            "gefgs",
            Place()),
        35435345,
        true,
        true,
        true,
        true,
        true,
        true,
        12214,
        Donut(),
        attachments = arrayOf(
            PhotoAttachment(Photo(1,1,1,1)),
            VideoAttachments(Video(1,1,1,1)),
            AudioAttachments(Audio(1,1,"Джага-джага","",4)),
            FileAttachments(File(1,1,"c://",12214,"d://")),
            GiftAttachments(Gift(1,"1","2","3")
            )
    )
    )

    println(WallService.add(post))
    println(WallService.add(post))
    println(WallService.add(post))
    println(WallService.add(post))
    println(WallService.see(1))
}