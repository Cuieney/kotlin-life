# Life
####App界的一股清流


Life is a Multimedia information app based on Material Design + MVP + RxJava + Retrofit + Dagger2 + GreenDAO + Glide

life 是一个多媒体信息app，基于Material Design + MVP + RxJava + Retrofit + Dagger2 + GreenDAO + Glide

做这款app主要是出于Android日常开发中或多或少的都会仿着ios的样式来写ui（可能设计师就做了一份ios交互设计，android只能跟着去写相同ui），完全舍弃了MD风格，第一出于学习目的做的，第二出于想写一个完全按照MD风格的App。
目前包括以下内容：

视频来自：开眼 <http://www.eyepetizer.net/>汇集各种炫酷视频

音乐来自：余音 <http://app.mi.com/details?id=fm.wawa.mg/>文艺骚年专属

###tips
1.本项目目前只是在开发测试阶段，发现bug或有好的建议欢迎
[issues](https://github.com/Cuieney/vld/issues/ "悬停显示")
Email <cuieney@163.com> link.

2.本项目仅作为学习交流使用，API数据内容所有权归原公司所有，请勿用于其他用途

###Preview
![media icon](https://github.com/Cuieney/vld/blob/master/image/media.png)
![media icon](https://github.com/Cuieney/vld/blob/master/image/media_home.png)
![media icon](https://github.com/Cuieney/vld/blob/master/image/media_home_detail.png)
![media icon](https://github.com/Cuieney/vld/blob/master/image/music.png)
![media icon](https://github.com/Cuieney/vld/blob/master/image/music_home.png)
![media icon](https://github.com/Cuieney/vld/blob/master/image/music_detail.png)

### Download APK
(Android 5.0 or above)

[URL](https://github.com/Cuieney/vld/blob/master/image/app-debug.apk "悬停显示")

###Points
	使用RxJava配合Retrofit2做网络请求
	使用RxPresenter对订阅的生命周期做管理
	使用RxBus来方便组件间的通信
	使用RxJava其他操作符来做延时、轮询、转化、筛选等操作
	使用okhttp3对网络返回内容做缓存，还有日志、超时重连、头部消息的配置
	使用Material Design控件和动画
	使用MVP架构整个项目，对应于model、ui、presenter三个包
	使用Dagger2将M层注入P层，将P层注入V层，无需new，直接调用对象
	使用GreenDAO做阅读记录和收藏记录的增、删、查、改
	使用Glide做图片的处理和加载
	使用Fragmentation简化Fragment的操作和懒加载
	使用RecyclerView实现下拉刷新、上拉加载
	使用SVG及其动画实现progressbar的效果
	包含搜索、收藏、检测更新等功能


###Version

####V1.0.0
1.第一版本提交

###Thanks






