FragmentTransactionExtended
===========================

![Logo](fragmentTransactionExample/cap1.gif)   ![Logo](fragmentTransactionExample/cap2.gif)

`FragmentTransactionExtended` is a library which provide us a set of custom animations between fragments. 
`FragmentTransaction` only accepts some simple animations (TRANSIT_FRAGMENT_CLOSE, TRANSIT_FRAGMENT_FADE, TRANSIT_FRAGMENT_OPEN...). 

List of animations added:
-  `SCALEX`
- `SCALEY`
- `SCALEXY`
- `FADE`
- `FLIP_HORIZONTAL`
- `FLIP_VERTICAL`
- `SLIDE_VERTICAL`
- `SLIDE_HORIZONTAL`
- `SLIDE_HORIZONTAL_PUSH_TOP`
- `SLIDE_VERTICAL_PUSH_LEFT`
- `GLIDE`
- `SLIDING`
- `STACK`
- `CUBE`
- `ROTATE_DOWN`
- `ROTATE_UP`
- `ACCORDION`
- `TABLE_HORIZONTAL`
- `TABLE_VERTICAL`
- `ZOOM_FROM_LEFT_CORNER`
- `ZOOM_FROM_RIGHT_CORNER`
- `ZOOM_SLIDE_HORIZONTAL`
- `ZOOM_SLIDE_VERTICAL`


Because `FragmentTransaction.setCustomAnimations` needs to use `ObjectAnimator` in XML and the animations of this library needs some fractional values is necesary to extends the fragment container from `SlidingRelativeLayout`, this class contains the necessary getters and setters.

```xml
<com.desarrollodroide.libraryfragmenttransitionextended.SlidingRelativeLayout
        xmlns:android="http://schemas.android.com/apk/res/android"
        android:layout_width="match_parent"
        android:layout_height="match_parent">
</com.desarrollodroide.libraryfragmenttransitionextended.SlidingRelativeLayout>
```


The container of the fragments must extends from `SlidingRelativeLayout` like the example
```xml
<com.desarrollodroide.libraryfragmenttransactionextended.SlidingRelativeLayout
        xmlns:android="http://schemas.android.com/apk/res/android"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="@drawable/back1" >
    <ListView
            android:id="@android:id/list"
            android:layout_width="match_parent"
            android:layout_height="match_parent"/>
</com.desarrollodroide.libraryfragmenttransactionextended.SlidingRelativeLayout>
```
You need to declare in your activity manifest if you need to manage change orientations:
```xml
android:configChanges="keyboardHidden|orientation|screenSize"
```


Usage FragmentTransitionExtended
=====

Constructor: 
```java
FragmentTransactionExtended fragmentTransactionExtended = new FragmentTransactionExtended(context, fragmentTransaction, firstFragment, secondFragment, containerID);
```

AddTransition:
```java
fragmentTransactionExtended.addTransition(FragmentTransactionExtended.*);
```
Example:

```java
FragmentManager fm = getFragmentManager();
FragmentTransaction fragmentTransaction = fm.beginTransaction();
FragmentTransactionExtended fragmentTransactionExtended = new FragmentTransactionExtended(this, fragmentTransaction, firstFragment, secondFragment, R.id.fragment_place);
fragmentTransactionExtended.addTransition(FragmentTransactionExtended.GLIDE);
fragmentTransactionExtended.commit();
```
Gradle
-----
```java
dependencies {
    compile 'com.desarrollodroide:fragmenttransactionextended:1'
}
```

Special Thanks
-----
* Daniel Olshansky. - From DevBytes [Sliding Fragments][1].

Developed By
============

Antonio Corrales desarrollogit@gmail.com


License
=======

Copyright 2014 Antonio Corrales

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

 [1]: https://plus.google.com/+AndroidDevelopers/posts/PcFbxqa55e4


