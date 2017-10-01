# springmvc
springMVC学习练习(IDE：IDEA)

## 使用IDEA时，先用Git就项目clone下来，直接打开项目(如：springmvc-1)。
## 注意事项：
> 1、要设置好资源根目录(设置src)  
> 2、用tomcat做web容器时，在intellij中有多处设置jdk version的地方，这些都必须要留意的，可能其中一个没一致或者没改就会出问题:
>> 1）在project structure中的"project" 及 "module"，都是可以设置jdk版本的；  
>> 2）“settings”中，找到“java compolier”，这里也是可以设置的；其中遇到过这里没改，所以就算1）中改了，依然编译出问题。 

## 使用.gitignor 失效时
>使用命令 git rm -r --cached .idea、git rm --cached demo-project.iml 等删除已存在的关联
