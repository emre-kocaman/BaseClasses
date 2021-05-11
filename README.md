# Base Classes
This library will increase your code reusability

[![](https://jitpack.io/v/emre-kocaman/BaseClasses.svg)](https://jitpack.io/#emre-kocaman/BaseClasses)

## Setup

#### Step 1

To setup your project for desugaring, you need to first ensure that you are using [Android Gradle plugin](https://developer.android.com/studio/releases/gradle-plugin#updating-plugin) 4.0.0 or higher.

Then add the JitPack repository to your project level `build.gradle`:

```groovy
allprojects {
 repositories {
    google()
    jcenter()
    maven { url "https://jitpack.io" }
 }
}
```

#### Step 2

Add BaseClasses library to your app `build.gradle`:

```groovy
dependencies {
        implementation 'com.github.emre-kocaman:BaseClasses:<latest-version-here>'
}
```

You can find the latest version of `BaseClasses` on the JitPack badge above the preview images.

