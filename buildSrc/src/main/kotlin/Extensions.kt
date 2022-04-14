package itsz

import org.gradle.api.Project
import kotlin.math.pow

/**
 * Created by JK on 2022/4/13.
 */

// 对应的属性值定义在 gradle.properties 文件中
val Project.minSdk: Int
  get() = intProperty("minSdk")

val Project.targetSdk: Int
  get() = intProperty("targetSdk")

val Project.compileSdk: Int
  get() = intProperty("compileSdk")

val Project.versionName: String
  get() = stringProperty("VERSION_NAME")

val Project.versionCode: Int
  get() = versionName
    .takeWhile { it.isDigit() || it == '.' }
    .split('.')
    .map { it.toInt() }
    .reversed()
    .sumByIndexed { index, unit ->
      // 1.2.3 -> 102030
      (unit * 10.0.pow(2 * index + 1)).toInt()
    }

private fun Project.intProperty(name: String): Int {
  return (property(name) as String).toInt()
}

private fun Project.stringProperty(name: String): String {
  return property(name) as String
}

private inline fun <T> List<T>.sumByIndexed(selector: (Int, T) -> Int): Int {
  var index = 0
  var sum = 0
  for (element in this) {
    sum += selector(index++, element)
  }
  return sum
}
