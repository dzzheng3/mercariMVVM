# mercari-android-test
For Technical interview

## Description

The App was pretty straight forward to implement

I have used MVVM design patterns. Its good for readability and clarity when you are dealing with application having lot of activities and with complex activities

There two user case local and remote. You can use LocalRepository and RemoteRepository to easily shift between local and remote.

I create the basic dagger component and module. However it is not good practice to apply on MVVM because of context reference and affect the viewmodle lifecycle.

Library used: Rxjava, ViewModel, LiveData, Dagger2, Glide, Kotlin
# mercariMVVM
