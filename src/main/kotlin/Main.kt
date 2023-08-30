
fun main() {
    var post = Post(1,1,1,1,1,"Hello",1,1,false,Comments(),Likes())
    var postCopy = Post(1,1,1,1,2,"Hello world",1,1,false,Comments(),Likes())
    println(WallService.add(post))
    println(WallService.add(post))
    println(WallService.add(post))
    println(WallService.add(post))
    println(WallService.update(postCopy))
    println(WallService.see(1))
}