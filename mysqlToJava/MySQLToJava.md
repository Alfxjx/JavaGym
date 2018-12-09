
# 如何将MySQL与JAVA-Eclipse相连接

- 首先是安装MySQL套件，注意下载的时候选择离线版本（300M)，安装的具体过程见[超详细MySQL安装及基本使用教程](https://blog.csdn.net/thelostlamb/article/details/78797643)，介绍的很详细了。

- 接下来顺便再命令行里面把测试用的数据库建好。**注意**，创建数据库之后，需要选择数据库。
```
CREATE DATABASE RUNOOB;
use RUNOOB；
```
```
CREATE TABLE `websites` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` char(20) NOT NULL DEFAULT '' COMMENT '站点名称',
  `url` varchar(255) NOT NULL DEFAULT '',
  `alexa` int(11) NOT NULL DEFAULT '0' COMMENT 'Alexa 排名',
  `country` char(10) NOT NULL DEFAULT '' COMMENT '国家',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
```
```
INSERT INTO `websites` VALUES ('1', 'Google', 'https://www.google.cm/', '1', 'USA'), ('2', '淘宝', 'https://www.taobao.com/', '13', 'CN'), ('3', '菜鸟教程', 'http://www.runoob.com', '5892', ''), ('4', '微博', 'http://weibo.com/', '20', 'CN'), ('5', 'Facebook', 'https://www.facebook.com/', '3', 'USA');
```

  - 另外就是数据库是大小写敏感的。

- [Eclipse中导入外部jar包](https://jingyan.baidu.com/album/ca41422fc76c4a1eae99ed9f.html?picindex=1)
  - 注意可能会出现 `./lib` 与主界面断开连接的问题，可以试着重启Eclipse。
  - 安装时，注意这边安装的是8.0及以上的版本的MySQL，导包和关联URL时和5.x版本的不一样。
  - 注册驱动：
  - `Class.forName("com.mysql.cj.jdbc.Driver");` 
  - URL：
  - `static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/RUNOOB?useSSL=false&serverTimezone=UTC";` 

- 测试用代码：
```java
package binaryZero;

import java.sql.*;

public class Main {
 
    // JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/RUNOOB?useSSL=false&serverTimezone=UTC";
 
    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "4568520";
 
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try{
            // 注册 JDBC 驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
        
            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
        
            // 执行查询
            System.out.println(" 实例化Statement对象...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT id, name, url FROM websites";
            ResultSet rs = stmt.executeQuery(sql);
        
            // 展开结果集数据库
            while(rs.next()){
                // 通过字段检索
                int id  = rs.getInt("id");
                String name = rs.getString("name");
                String url = rs.getString("url");
    
                // 输出数据
                System.out.print("ID: " + id);
                System.out.print(", 站点名称: " + name);
                System.out.print(", 站点 URL: " + url);
                System.out.print("\n");
            }
            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }finally{
            // 关闭资源
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }
}
```

- 如果一切正常的话，输出：
```
连接数据库...
 实例化Statement对象...
ID: 1, 站点名称: Google, 站点 URL: https://www.google.cm/
ID: 2, 站点名称: 淘宝, 站点 URL: https://www.taobao.com/
ID: 3, 站点名称: 菜鸟教程, 站点 URL: http://www.runoob.com
ID: 4, 站点名称: 微博, 站点 URL: http://weibo.com/
ID: 5, 站点名称: Facebook, 站点 URL: https://www.facebook.com/
Goodbye!

```
- 最后可以用`quit` 命令关闭数据库。