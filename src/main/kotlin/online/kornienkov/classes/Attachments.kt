package online.kornienkov.classes

data class Photo(val id: Int, val albumId: Int, val ownerId: Int, val userId: Int )
data class Video(val id: Int, val albumId: Int, val ownerId: Int, val userId: Int)
data class Audio(val id: Int, val ownerId: Int, val artist: String, val title: String, val duration: Int)
data class File(val id: Int, val ownerId: Int, val title:String, val size: Int, val ext: String)
data class Gift(val id: Int, val thumb256: String, val thumb96: String, val thumb48: String)


abstract class Attachments (val type: String)

class PhotoAttachment (val photo: Photo) : Attachments("photo")
class VideoAttachments(val video: Video) : Attachments("video")
class AudioAttachments (val audio: Audio) : Attachments("audio")
class FileAttachments(val file: File) : Attachments("file")
class GiftAttachments(val gift: Gift) : Attachments("gift")