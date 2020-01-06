
# 简介
`TabPane` 包含两部分：标题和内容。

标题包含以下几个部分，如图所示：

![](images\tabpane_1.png)

说明：
- Headers region 是标题全部区域
- Tab header background 为标题背景
- Control buttons 则是在分栏太多无法显示时，用于选择特定 tab
- tab 区域包含一个 `Label` 和一个 close button，Label 用于显示tab的标题和图标，close button 为关闭 tab 的按钮

# 创建 Tab

__不带标题的__

```java
Tab tab1 = new Tab();
```

__设置标题__

```java
tab1.setText("General");
```

__创建时带标题__

```java
Tab tab2 = new Tab("General");
```

# 设置 Tab 的标题和内容
`Tab` 包含如下属性用于设置标题和内容：
- text，设置标题文本
- graphic，设置标题图标
- closable，tab 是否可关闭
- content

__设置图标__

```java
// Create an ImageView for graphic
String imagePath = "resources/picture/address_icon.png";
URL imageUrl = getClass().getClassLoader().getResource(imagePath);
Image img = new Image(imageUrl.toExternalForm());
ImageView icon = new ImageView(img);

// Create a Tab with "Address" text
Tab addressTab = new Tab("Address");

// Set the graphic
addressTab.setGraphic(icon);
```

# 创建 TabPanes

```
TabPane tabPane = new TabPane();
```
