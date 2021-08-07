package ai.sterling.kinject

import platform.UIKit.UIDevice

actual class Test actual constructor() {
    actual val platform: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}
