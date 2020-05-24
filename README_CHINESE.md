# RecyclerWheelView

一个可以简易地使用的WheelView， 基于RecyclerView实现，可简便地实现自定义。

## Getting Started

首先，因为这个库使用的数AndroidX版本的RecyclerView实现，*如果你的项目还没有迁移到AndroidX，那么使用这个库可能会出现问题*

如果你要使用这个库，需要在需要使用这个库的module的gradle文件里加上这两句。
```
implementation 'cn.wongzhenyu:recyclerwheelview:0.0.3'
implementation 'androidx.recyclerview:recyclerview:XXX'
```

> 因为RecyclerView基于RecyclerView进行实现，为了避免版本冲突，为使用了compileonly进行引入，当你使用时需要手动添加

## Result

这里时StringWheelView和自定义WheelView的两个例子，如果你使用了RecyclerWheelView，你可以很容易地实现他们


### String wheel view

<img width="360" height="780" src="https://i.loli.net/2020/05/10/f8uC3jUiHFA6qZY.jpg"/>

各个属性的用法及说明如下

| 属性名                      | 说明                                                         | 示例                                                         |
| --------------------------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| wheelSelectedItemTextColor  | 被选中的字符串的颜色                                         | app:wheelSelectedItemTextColor="@color/colorAccent"          |
| wheelSelectedTextSize       | 被选中的字符串的大小                                         | app:wheelSelectedTextSize="18sp"                             |
| wheelSelectedItemBackground | 被选中的字符串的背景（可自定义drawable）                     | app:wheelSelectedItemBackground="@drawable/string_selected_wheel_bg" |
| wheelNormalTextSize         | 未被选中的字符串的大小                                       | app:wheelNormalTextSize="15sp"                               |
| wheelNormalTextColor        | 未被选中的字符串的颜色                                       | app:wheelNormalTextColor="@color/colorPrimaryDark"           |
| wheelNormalItemBackground   | 未被选中的字符串的背景（可自定义drawable）                   | app:wheelNormalItemBackground="@drawable/string_nor_wheel_bg" |
| wheelItemHeight             | 字符串列的高度，注意，未被选择的字符串和被选中的字符串高度时一样的，都是使用的这个属性 | app:wheelItemHeight="100dp"               |



### 自定义 wheel view

<img width="360" height="780" src="https://i.loli.net/2020/05/10/WizePB59CjLK1gw.jpg"/>

你可以像RecyclerView一样自定义WheelView，你可以在本demo中找到如何使用它。

