# RecyclerWheelView
[中文文档](https://github.com/wongzy/RecyclerWheelView/blob/master/README_CHINESE.md)

An efficient Android WheelView  based on RecyclerView, which is easy to use, and it can customized by yourself.

## Getting Started

First of all, this lib is based on androidx, *if your library do not migrate to androidx, there might be some problems* if you used this.

If you want to use this library, you should add those to your module's gradle

```
implementation 'cn.wongzhenyu:recyclerwheelview:0.0.3'
implementation 'androidx.recyclerview:recyclerview:XXX'
```

> Because RecyclerWheelView have dependency of recyclerview(library of androidx), and to avoid the conflicts of library version, I used compileonly to import recyclerview library, so you should add recyclerview by yourself.

## Result

there are two examples' results about recyclerwheelview in this project, if you used recyclerwheelview, you can  make this effect easily.

### String wheel view

<img width="360" height="780" src="https://i.loli.net/2020/05/10/f8uC3jUiHFA6qZY.jpg"/>

The attributes of StringWheelView and its explain as follows:

| attribute name                      | explain                                                         | example                                                         |
| --------------------------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| wheelSelectedItemTextColor  | the color of selected String                                         | app:wheelSelectedItemTextColor="@color/colorAccent"          |
| wheelSelectedTextSize       | the size of selected String                                         | app:wheelSelectedTextSize="18sp"                             |
| wheelSelectedItemBackground | the background of selected String item（can use custom drawable）                     | app:wheelSelectedItemBackground="@drawable/string_selected_wheel_bg" |
| wheelNormalTextSize         | the size of unselected String                                       | app:wheelNormalTextSize="15sp"                               |
| wheelNormalTextColor        | the color of unselected String                                       | app:wheelNormalTextColor="@color/colorPrimaryDark"           |
| wheelNormalItemBackground   | the background of unselected String item（can use costom drawable）                   | app:wheelNormalItemBackground="@drawable/string_nor_wheel_bg" |
| wheelItemHeight             | the height of String item, attention, the height of selected String item and unselected String item is same | app:wheelItemHeight="100dp"               |

### Custom wheel view

<img width="360" height="780" src="https://i.loli.net/2020/05/10/WizePB59CjLK1gw.jpg"/>

You can customize RecyclerWheelView just like recycler view， you can see how it realize in this demo project.



 
