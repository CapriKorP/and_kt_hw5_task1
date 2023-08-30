package online.kornienkov.classes

import Comments
import Likes
import Post
import WallService
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before

class WallServiceTest {

    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    var post = Post(1,1,1,1,1,"Hello",1,1,false,Comments(),Likes())
    var postCopy = Post(1,1,1,1,2,"Hello world",1,1,false,Comments(),Likes())
    var postError = Post(2,1,1,1,2,"Hello world",1,1,false,Comments(),Likes())
    @Test
    fun add() {
        WallService.add(post)
        assertEquals(1,post.id)
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