package dev.vengateshm.kotlin_multiplatform_samples

class IOSAppLogger: AppLogger{
    override fun log(msg: String) {
        println(msg)
    }
}