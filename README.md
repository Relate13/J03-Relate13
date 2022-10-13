# J03

## 任务一

**对代码工作原理的理解：**

对于隐写内容，本项目使用了一个隐写图像模块，将项目中的example.BubbleSorter编译为字节码后隐写入图像中。

对于类型加载，本项目中使用了SteganographyClassLoader，是ClassLoader的一个子类，通过覆写实现了新的findClass方法，从而实现通过url找到对应图片，再将图片中的隐写信息提取，从隐写的字节码中加载类型并返回，生成一个新的类型example.BubbleSorter。随后实例化了一个该类型的对象，将其设为项目的排序器。

## 任务二

**选择排序:** https://i0.hdslb.com/bfs/new_dyn/27d3e14ad51da62c0c45b5ebaeaf56242877232.png

**快速排序:** https://i0.hdslb.com/bfs/new_dyn/2a3fd0d26ad19aaf03aa04b76489e0982877232.png

## 任务三

**详见:** https://www.bilibili.com/video/BV1mK411Q7ro

## 任务四

感谢 **杨青云** 同学友情提供图片

运行过程详见任务三中给出的链接
