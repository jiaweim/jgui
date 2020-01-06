
# 简介
`ComboBox` 用于从一列值中选择一个。

`ComboBox` 为参数化类，可以设置存储特定的类型。也可以存储多种类型，不使用参数类型。

## 创建

```java
// 可以存储多种类型
ComboBox seasons = new ComboBox();

// 存储特定类型
ComboBox<String> seasons = new ComboBox<String>();

// 创建时指定值
ObservableList<String> seasonList = FXCollections.<String>observableArrayList(
"Spring", "Summer", "Fall", "Winter");
ComboBox<String> seasons = new ComboBox<>(seasonList);
```

## 添加值

```java
ComboBox<String> seasons = new ComboBox<>();
seasons.getItems().addAll("Spring", "Summer", "Fall", "Winter");
```

## 选择值
`ComboBox` 使用 `SingleSelectionModel` 类作为选择模型。

`value` 属性保存当前选择或输入的值。

### 检测值的变化
对 `selectedIndex` 或 `selectedItem` 添加 `ChangeListener` 即可。

当输入新的值，`selectedIndex` 不改变，因为新输入的值，并不在意 items中。
如果在值改变时，希望执行某些功能：

```java
ComboBox<String> list = new ComboBox<>();
list.setOnAction(e -> System.out.println("Value changed"));
```


## 编辑
`editable` 属性用于指定是否可编辑。默认不可编辑。

```java
ComboBox<String> breakfasts = new ComboBox<>();
// Add some items to choose from
breakfasts.getItems().addAll("Apple", "Banana", "Strawberry");

// By making the control editable, let users enter an item
breakfasts.setEditable(true);
```

当输入的值，不是字符串，则需要指定 `converter` 属性，将对应的值转换为字符串在 `ComboBox` 中显示。

`StringConverter<T>` 的 `toString(T object)` 用于将值转换为字符串；`fromString(String s)` 用于将字符串转换为值。


## 高度
`ComboBox` 默认最多显示 10 条。
- 如果值的数目超过10，则弹出列表多一个滚动条
- 如果数目少于10，则显示所有值

`ComboBox` 的 `visibleRowCount` 属性指定弹出列表中显示值的数目。

```
ComboBox<String> states = new ComboBox<>();
...
// Show five rows in the popup list
states.setVisibleRowCount(5);
```


# 使用 Node
`ComboBox` 包含两个区域：
- 用于显示选择项的按钮区域
- 用于显示列表的弹出列表区域

两个区域都使用 `ListCells` 显示值。`ListCell` 是一种 `Cell`，`Cell` 为 `Labeled` 控件，可显示文本、图形。
`ListView` 的每个值对应一个 `ListCell`。

`ComboBox` 可显示任意值，包括 `Node` 类型。但是不建议直接这么做。当将 node 作为列出项，它们是以图形的形式显示。
`Scene` 中一个 node 只能同时只能在一个地方显示，即一个节点只能在一个容器中。当选择了列表中的某个 node，该node从列表中移除，添加到按钮区域。
当弹出列表再次显示，该 node 不再在列表中显示，因为它已经在 button area 中。

# CellFactory



