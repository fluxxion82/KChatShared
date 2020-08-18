package ai.sterling.kchat.kinject

actual class Singleton = String()

//fun getAndShow(url: String, contentView: UITextView) {
//    val manager = AFHTTPSessionManager()
//    manager.responseSerializer = AFHTTPResponseSerializer()
//    val onSuccess = { _: NSURLSessionDataTask?, response: Any? ->
//        val html = NSAttributedString.create(
//            data = response as NSData,
//            options = mapOf(NSDocumentTypeDocumentAttribute as Any? to NSHTMLTextDocumentType),
//            documentAttributes = null,
//            error = null
//        )!!
//        contentView.attributedText = html
//    }
//    val onError = { _: NSURLSessionDataTask?, error: NSError? ->
//        NSLog("Cannot get ${url}.")
//        NSLog(error.toString())
//    }
//
//    manager.GET(url, null, onSuccess, onError)
//}