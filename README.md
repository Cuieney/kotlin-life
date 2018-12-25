# ![media icon](https://github.com/Cuieney/vld/blob/master/app/src/main/res/mipmap-xxxhdpi/logo.png) 
# Life
#### App界的一股清流

目前项目持续更新重构中(向kotlin靠拢)

Life is a Multimedia information app based on Material Design Kotlin + MVP + RxJava + Retrofit + Dagger2 + GreenDAO + Glide

life 是一个多媒体信息app，基于Material Design Kotlin + MVP + RxJava + Retrofit + Dagger2 + GreenDAO + Glide

做这款app主要是出于Android日常开发中或多或少的都会仿着ios的样式来写ui（可能设计师就做了一份ios交互设计，android只能跟着去写相同ui），完全舍弃了MD风格，第一出于学习目的做的，第二出于想写一个完全按照MD风格的App。
目前包括以下内容：

视频来自：开眼 <http://www.eyepetizer.net/>汇集各种炫酷视频

音乐来自：余音 <http://app.mi.com/details?id=fm.wawa.mg/>文艺骚年专属

文章来自：余音 <http://www.wufazhuce.com/>韩寒主编和监制

全景图片来自：kuula <https://kuula.co/>主要是图片质量很高

### tips
1.本项目目前只是在开发测试阶段，发现bug或有好的建议欢迎
[issues](https://github.com/Cuieney/vld/issues/ "悬停显示")
Email <cuieney@163.com> link.

2.本项目仅作为学习交流使用，API数据内容所有权归原公司所有，请勿用于其他用途

3.目前项目几乎已经转型到kotlin了，代码所在目录 [dir](https://github.com/Cuieney/kotlin-life/tree/master/app/src/main/java/org/cuieney/videolife/kotlin "悬停显示")

4.针对第一次拉代码安装apk闪退（ClassNotFoundException），再次运行一下就好

### Preview
![media icon](https://github.com/Cuieney/vld/blob/master/image/pano.gif)

![media icon](https://github.com/Cuieney/vld/blob/master/image/pano_home.png)
![media icon](https://github.com/Cuieney/vld/blob/master/image/pano.png)
![media icon](https://github.com/Cuieney/vld/blob/master/image/media.png)
![media icon](https://github.com/Cuieney/vld/blob/master/image/media_home.png)
![media icon](https://github.com/Cuieney/vld/blob/master/image/media_home_detail.png)
![media icon](https://github.com/Cuieney/vld/blob/master/image/music.png)
![media icon](https://github.com/Cuieney/vld/blob/master/image/music_home.png)
![media icon](https://github.com/Cuieney/vld/blob/master/image/music_detail.png)
![media icon](https://github.com/Cuieney/vld/blob/master/image/essay_home.png)
![media icon](https://github.com/Cuieney/vld/blob/master/image/essay_detail.png)



### Download APK
(Android 5.0 or above)

[URL](https://github.com/Cuieney/vld/blob/master/image/app-debug.apk "悬停显示")

### Points
	使用Rx家族配合Retrolambda减少代码量
	使用RxJava配合Retrofit2做网络请求
	使用Rxlifecycle对订阅的生命周期做管理
	使用RxBus来方便组件间的通信
	使用RxJava其他操作符来做延时、轮询、转化、筛选等操
	使用okhttp3对网络返回内容做缓存，还有日志、超时重连、头部消息的配置
	使用Material Design控件和动画
	使用Ijkplayer来实现播放视频功能
	使用MVP架构整个项目，对应于model、ui、presenter三个包
	使用Dagger2将M层注入P层，将P层注入V层，无需new，直接调用对象
	使用GreenDAO做阅读记录和收藏记录的增、删、查、改
	使用Glide做图片的处理和加载
	使用Fragmentation简化Fragment的操作和懒加载
	使用Statusbaruitl动态的改变通知栏颜色
	使用XRecyclerView实现下拉刷新、上拉加载
	使用SVG及其动画实现progressbar的效果
	包含搜索、收藏、检测更新等功能


### Version

#### V2.7.0
1.修复视频不能播放 vr 不能展示 音乐播放问题待修复

#### V2.6.0
1.修复vr tab 不能展示vr 图片功能


#### V2.5.0
1.增加vr模块panorama liveview 代码（to kotlin）

2.类似于insta360 全景图片预览

3.你们的支持就是我最大的动力，持续更新中 （to kotlin）


#### V2.4.0
1.更新音乐和视频播放页面代码（to kotlin）

2.添加umeng 收集错误

3.你们的支持就是我最大的动力，持续更新中 （to kotlin）

#### V2.3.0
1.music tab 更新为kotlin代码(功能并未完善)

2.你们的支持就是我最大的动力，持续更新中 （to kotlin）

#### V2.2.0
1.video tab 更新为kotlin代码(功能并未完善)

2.你们的支持就是我最大的动力，持续更新中 （to kotlin）

#### V2.1.0
1.添加kotlin代码块，essay tab 目前项目是kotlin and java 混编

2.增加kotlin act and fragment 基类 dagger2等 (功能并未完善)

3.持续更新中 （to kotlin）

#### V2.0.0
1.增加essay tab页面，修改了一些bug 更新了app icon(功能并未完善)


#### V1.0.0
1.第一版本提交(功能并未完善)

### Thanks

#### API

[开眼](http://www.eyepetizer.net/ "悬停显示") [余音](http://app.mi.com/details?id=fm.wawa.mg/ "悬停显示")
[一个](http://www.wandoujia.com/apps/one.hh.oneclient/ "悬停显示")
[kuula](https://kuula.co/ "悬停显示")

#### APP:

[Material Design](https://material.io/guidelines/components/bottom-navigation.html#bottom-navigation-behavior "悬停显示") 官方提供了部分设计思路

[android-architecture](https://github.com/googlesamples/android-architecture"悬停显示")和
[GankClient-Kotlin](https://github.com/githubwing/GankClient-Kotlin "悬停显示")提供了Dagger2配合MVP的架构思路

还参考了很多大神的类似作品，感谢大家的开源精神

#### RES

[iconfont](http://www.iconfont.cn/plus/search/index "悬停显示")
 提供了icon素材
 
 [material UP ](https://material.uplabs.com/ "悬停显示")
 提供了Material Design风格的素材


### LIB
#### UI

1. [BottomNavigation](https://github.com/Ashok-Varma/BottomNavigation "悬停显示")
 
2. [floatingsearchview](https://github.com/arimorty/floatingsearchview "悬停显示")

3. [expandableTextView](https://github.com/Manabu-GT/ExpandableTextView "悬停显示")

4. [xrecyclerview](https://github.com/jianghejie/XRecyclerView "悬停显示")

5. [statusbaruitl](https://github.com/laobie/StatusBarUtil "悬停显示")

#### RX
1. [RxJava](https://github.com/ReactiveX/RxJava "悬停显示")

2. [RxAndroid](https://github.com/ReactiveX/RxAndroid "悬停显示")

3. [RxPermissions](https://github.com/tbruyelle/RxPermissions "悬停显示")

4. [RxLifecycle](https://github.com/trello/RxLifecycle "悬停显示")

#### VIDEO
1. [ijkplayer](https://github.com/Bilibili/ijkplayer "悬停显示")

2. [GSYVideoPlayer](https://github.com/CarGuo/GSYVideoPlayer "悬停显示")

#### NETWORK

1. [Retrofit](https://github.com/square/retrofit "悬停显示")

2. [OkHttp](https://github.com/square/okhttp "悬停显示")

3. [Glide](https://github.com/bumptech/glide "悬停显示")

4. [Gson](https://github.com/google/gson "悬停显示")

#### DI
1. [Dagger2](https://github.com/google/dagger "悬停显示")

2. [ButterKnife](https://github.com/JakeWharton/butterknife "悬停显示")

#### FRAGMENT
1. [Fragmentation](https://github.com/YoKeyword/Fragmentation "悬停显示")

#### LOG
1. [Logger](https://github.com/orhanobut/logger "悬停显示")

#### DB
1. [greenDAO](https://github.com/greenrobot/greenDAO "悬停显示")

#### CANARY
1. [BlockCanary](https://github.com/markzhai/AndroidPerformanceMonitor "悬停显示")
2. [leakcanary](https://github.com/square/leakcanary "悬停显示") 

## License

Copyright (c) 2017 cuieney

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.




