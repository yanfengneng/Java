**String与StringBuiler的效率比较：**

* 在java中，由于字符串不可变的，因此使用`String+`连接时，首先为新字符串分配足够的空间，复制旧字符串中的内容并附加新字符串中。时间复杂度为O(n^2^)。
* StringBulider其实是个char[]，在append时，是将String对象转为char后放入StringBuilder的char[]，时间复杂度为O(n)。

![](D:\My Program\Java Project\homework_three\picture\效率.png)

