package online.kornienkov.classes

import Comments
import Donut
import Geo
import Likes
import Place
import Post
import Reports
import Views
import WallService
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before

class WallServiceTest {

    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }
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
    var postError = Post(2,
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
    var postCopy = Post(1,
        2,
        3,
        4,
        5,
        "Hello Kotlin and Android!",
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
    @Test
    fun add() {
        var actual = WallService.add(post).id
        assertEquals(1,actual)
    }

    @Test
    fun updateTrue() {
        WallService.add(post)
        assertTrue(WallService.update(postCopy))
    }

    @Test
    fun updateFalse() {
        WallService.add(post)
        assertFalse(WallService.update(postError))
    }
}