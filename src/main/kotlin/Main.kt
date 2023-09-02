
fun main() {
    var post = Post(1,2,3,4,5,"Hello Kotlin", 25424,5345,true,Comments(),Likes(), Reports(), Views(),"post", Geo("Home", "gefgs", Place()),35435345, true, true, true, true)

    println(WallService.add(post))
    println(WallService.add(post))
    println(WallService.add(post))
    println(WallService.add(post))
    println(WallService.see(1))
}