@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
  versionCatalogs {
    // 默认的 name 就是 libs,如果要修改，可以在项目根目录的 settings.gradle 中修改，在这里修改貌似无效
    // 修改方式 在 settings.gradle -> dependencyResolutionManagement 闭包中设置 defaultLibrariesExtensionName.set("yourName") 即可
    create("libs") {
      from(files("../gradle/libs.versions.toml"))
    }

    // 可以声明多个，方便自己测试
   /* create("testLibs") {
      from(files("gradle/test-libs.versions.toml"))
    }*/
  }
}