package online.kornienkov.classes

data class Likes(
   var count: Int = 0,
   var userLikes: Boolean = true,
   var canLike: Boolean = true,
   var canPublish: Boolean = true
)
