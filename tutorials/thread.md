# 参考
- https://docs.oracle.com/javase/8/javafx/api/toc.htm

# Task
`FutureTask` 的 observable 实现。实现 `Task` 的类必须覆盖 `call()` 方法。

## 不返回值

使用 `Void` 返回类型：

```java
final String filePath = "/foo.txt";
final String contents = "Some contents";
Task<Void> task = new Task<Void>() {
    @Override protected Void call() throws Exception {
        File file = new File(filePath);
        FileOutputStream out = new FileOutputStream(file);
        // ... and other code to write the contents ...

        // Return null at the end of a Task of type Void
        return null;
    }
};
```