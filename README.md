# NotificationBar
An Android Alerting Library aims to overcome the limitations of Toasts and Snackbars, while reducing the complexity of your layouts.


![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-NotificationBar-blue.svg)  [![](https://jitpack.io/v/MuhamedKhaled/NotificationBar.svg)](https://jitpack.io/#MuhamedKhaled/NotificationBar)


<img src="./Images/app_demo.gif" width="360" height="600">

# Installation
Gradle:
Step 1. Add the JitPack repository to your build file
```groovy
allprojects {
    repositories {
	...
	maven { url 'https://jitpack.io' }
      }
}
Step 2. Add the dependency
dependencies {
      implementation 'com.github.MuhamedKhaled:NotificationBar:1.0.0'
} 
```
Maven:
```xml
<repositories>
   <repository>
      <id>jitpack.io</id>
      <url>https://jitpack.io</url>
   </repository>
</repositories>

<dependency>
  <groupId>com.github.MuhamedKhaled</groupId>
     <artifactId>NotificationBar</artifactId>
     <version>Tag</version>
</dependency>
```
# Usage
## Create basic Notification
### Using Kotlin
```kotlin
NotificationBar.create(this@MainActivity)
               .setTitle("notification_title")
               .setTitleColor(R.color.default_title_color)
               .setMessage("notification_body")
               .setNotificationPosition(NotificationBar.BOTTOM)
               .show();
```
### Using Java
```java
NotificationBar.create(MainActivity.this)
		.setTitle(R.string.notification_title)
                .setTitleColor(R.color.orange)
                .setMessage(R.string.notification_body)
                .setNotificationPosition(NotificationBar.BOTTOM)
                .show();
```
## Create a Notification with a custom layout
```java
NotificationBar.create(MainActivity.this)
     .setCustomView(R.layout.custome_notification)
     .setCustomViewInitializer(new CustomViewInitializer() {
         @Override
         public void initView(View view) {
           Button btnOpen = view.findViewById(R.id.custom_btn_open);
           View.OnClickListener btnListener = new View.OnClickListener() {

              @Override
              public void onClick(View view) {
                Button button = (Button) view;
                Toast.makeText(view.getContext(),"Open Button Clicked...",Toast.LENGTH_SHORT).show();
                     }};

                btnOpen.setOnClickListener(btnListener);}})
                .setAction("Close", new OnActionClickListener() {
                    @Override
                    public void onClick() {
                                NotificationBar.dismiss(MainActivity.this);
                            }
                        })
                .setTitle(R.string.notification_title)
                .setMessage(R.string.notification_body)
                .setEnableAutoDismiss(false)
                .setSwipeToDismiss(false)
                .setBackgroundColor(R.color.colorPrimary)
                .setActionColor(R.color.default_action_color)
                .setNotificationPosition(NotificationBar.BOTTOM)
                .show();
```
## Dynamically set Notification properties
 * Notification position (Top/Bottom)
 * Display duration
 * Body text
 * Body text color
 * Action text color
 * Swipe to dismiss (true/false)
 * Background color
 * Title text
 * Title text color
 * Icon
 * Icon Animation
 * In/Out animations for Notification
 * View layout
## License
```
MIT License

Copyright (c) 2018 Mohamed khaled

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
