
# 概述
JavaFX 的 `javafx.scene.image` 包提供了图片显示和读写功能。类图如下所示：

![](images\image_1.png)

说明：
- `Image` 类表示图片。
- `ImageView` 用于在 scene 中显示图片。
- 图片由像素组成，像素数据的有多种来源，`PixelFormat` 定义了像素数据的存储方式
- `WritablePixelFormat` 定义了输出格式
- `PixelReader` 和 `PixelWriter` 接口分别定义了从 `Image` 读写数据、输出数据到 `WritableImage` 的方法。

# 读取图片
`Image` 支持 BMP, PNG, JPEG 和 GIF 图片格式。通过其构造函数即可载入图片：

```java
Image(InputStream is)
Image(InputStream is, double requestedWidth, double requestedHeight, boolean preserveRatio, boolean smooth)
Image(String url)
Image(String url, boolean backgroundLoading)
Image(String url, double requestedWidth, double requestedHeight, boolean preserveRatio, boolean smooth)
Image(String url, double requestedWidth, double requestedHeight, boolean preserveRatio, boolean smooth, boolean backgroundLoading)
```

# 显示图片

```java
Image image = new Image ("http://projavafx.com/images/earthrise.jpg");
ImageView imageView = new ImageView(image);
```