import java.io.File
import java.math.BigInteger
import java.security.MessageDigest

fun readInput(name: String) = File("src", "$name.txt").readLines()

fun readInputAsInts(name: String) = File("src", "$name.txt").readLines().map { it.toInt() }

fun String.md5(): String = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray())).toString(16)
