package online.kornienkov.classes

data class Likes(
   var count: Int = 0 ,
   var userLikes: Boolean = false,
   var canLike: Boolean = false,
   var canPublish: Boolean = false
)
