package ai.sterling.kchat.multicore.model

import cocoapods.AFNetworking.AFHTTPResponseSerializer
import cocoapods.AFNetworking.AFHTTPSessionManager
import platform.Foundation.*
import platform.UIKit.NSDocumentTypeDocumentAttribute
import platform.UIKit.NSHTMLTextDocumentType
import platform.UIKit.UITextView
import platform.UIKit.create

actual class Sample {
    actual fun checkMe() = 7
}

actual object Platform {
    actual fun name(): String = "iOS"
}

fun getAndShow(url: String, contentView: UITextView) {
    val manager = AFHTTPSessionManager()
    manager.responseSerializer = AFHTTPResponseSerializer()
    val onSuccess = { _: NSURLSessionDataTask?, response: Any? ->
        val html = NSAttributedString.create(
            data = response as NSData,
            options = mapOf(NSDocumentTypeDocumentAttribute as Any? to NSHTMLTextDocumentType),
            documentAttributes = null,
            error = null
        )!!
        contentView.attributedText = html
    }
    val onError = { _: NSURLSessionDataTask?, error: NSError? ->
        NSLog("Cannot get ${url}.")
        NSLog(error.toString())
    }

    manager.GET(url, null, onSuccess, onError)
}