package online.kornienkov.classes

import Comments
import Likes
import Post
import PostNotFoundException
import WallService
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before

class WallServiceTest {

    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    var post = Post(1,1,1,1,1,"Hello",1,1,false,Comments(1),Likes())
    var postCopy = Post(1,1,1,1,2,"Hello world",1,1,false,Comments(0),Likes())
    var postError = Post(2,1,1,1,2,"Hello world",1,1,false,Comments(0),Likes())

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

    @Test
    fun createComment() {
        val postId = WallService.add(post).id
        val commentCreated = WallService.createComment(postId, Comments(155,1,true,false,true,true))
        assertEquals(155, commentCreated.id)
    }

    @Test(expected = PostNotFoundException::class)
    fun shouldThrow() {
        WallService.createComment(1,Comments(2,1,true,true,true,true))
    }
}