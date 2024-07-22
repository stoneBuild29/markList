Mybatis

When I meet with a compound project，the mapper and code would be very complicated. So Mybatis plus would be a better tool to reduce code redundancy.

````
MyBatis-Plus 是一个 MyBatis 的增强工具，在 MyBatis 的基础上只做增强不做改变，为简化开发、提高效率而生。以下是 MyBatis-Plus 的基本使用步骤：

### 1. 添加依赖

首先，在你的项目中添加 MyBatis-Plus 的依赖。以 Maven 为例：

```xml
<dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>mybatis-plus-boot-starter</artifactId>
    <version>3.5.1</version>
</dependency>
```

### 2. 配置数据源

在 `application.yml` 或 `application.properties` 中配置数据源：

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/your_db?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC
    username: root
    password: your_password
    driver-class-name: com.mysql.cj.jdbc.Driver
```

### 3. 配置 MyBatis-Plus

创建 MyBatis-Plus 的配置类：

```java
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBatisPlusConfig {

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return interceptor;
    }
}
```

### 4. 创建实体类

创建一个实体类并添加 MyBatis-Plus 的注解：

```java
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user")
public class User {

    @TableId
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
```

### 5. 创建 Mapper 接口

创建一个 Mapper 接口并继承 `BaseMapper`：

```java
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
```

### 6. 创建 Service

创建一个 Service 接口和实现类：

```java
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

public interface UserService extends IService<User> {
}

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
```

### 7. 使用 Service

在你的 Controller 中使用 Service：

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public List<User> list() {
        return userService.list();
    }

    @PostMapping("/add")
    public boolean add(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping("/update")
    public boolean update(@RequestBody User user) {
        return userService.updateById(user);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id) {
        return userService.removeById(id);
    }
}
```

### 8. 启动项目

启动 Spring Boot 应用，访问相应的接口进行测试。

### 常用功能示例

#### 1. 条件查询

使用 `QueryWrapper` 进行条件查询：

```java
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

@GetMapping("/findByName")
public List<User> findByName(@RequestParam String name) {
    QueryWrapper<User> queryWrapper = new QueryWrapper<>();
    queryWrapper.eq("name", name);
    return userService.list(queryWrapper);
}
```

#### 2. 分页查询

使用 `Page` 进行分页查询：

```java
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

@GetMapping("/page")
public Page<User> page(@RequestParam int current, @RequestParam int size) {
    Page<User> page = new Page<>(current, size);
    return userService.page(page);
}
```

#### 3. 自定义 SQL

在 Mapper 接口中定义自定义 SQL：

```java
import org.apache.ibatis.annotations.Select;

public interface UserMapper extends BaseMapper<User> {

    @Select("SELECT * FROM user WHERE age > #{age}")
    List<User> selectByAge(@Param("age") int age);
}
```

使用自定义 SQL：

```java
@GetMapping("/findByAge")
public List<User> findByAge(@RequestParam int age) {
    return userMapper.selectByAge(age);
}
```

通过以上步骤和示例，你可以快速上手 MyBatis-Plus，简化你的数据访问层代码，提高开发效率。
````





````
是的，使用 MyBatis-Plus 你不需要在 Mapper 接口中手动编写常见的 CRUD 方法，因为 MyBatis-Plus 已经为你提供了许多默认实现。你只需要继承 `BaseMapper` 接口即可，这些默认的 CRUD 方法包括：

- `insert(T entity)`：插入一条记录。
- `deleteById(Serializable id)`：根据 ID 删除一条记录。
- `updateById(T entity)`：根据 ID 更新一条记录。
- `selectById(Serializable id)`：根据 ID 查询一条记录。
- `selectList(Wrapper<T> queryWrapper)`：查询所有记录。

下面是一个简单的例子：

### 示例代码

#### 实体类

```java
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user")
public class User {
    @TableId
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
```

#### Mapper 接口

```java
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
```

#### Service 接口和实现类

```java
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

public interface UserService extends IService<User> {
}

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
```

#### Controller 示例

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public List<User> list() {
        return userService.list();
    }

    @PostMapping("/add")
    public boolean add(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping("/update")
    public boolean update(@RequestBody User user) {
        return userService.updateById(user);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id) {
        return userService.removeById(id);
    }

    @GetMapping("/get/{id}")
    public User getById(@PathVariable Long id) {
        return userService.getById(id);
    }
}
```

在这个例子中，`UserMapper` 继承了 `BaseMapper` 接口，因此 `UserMapper` 接口已经拥有了 `insert`、`deleteById`、`updateById` 和 `selectById` 等方法的实现。你可以在 Service 或 Controller 中直接使用这些方法。

### 注意事项

- 虽然 MyBatis-Plus 提供了许多默认的 CRUD 方法，但在某些情况下你可能需要编写自定义的 SQL 语句。这时你可以在 `Mapper` 接口中使用注解（如 `@Select`、`@Insert` 等）或者 XML 文件编写自定义的 SQL 语句。
- 如果你需要复杂的查询条件，可以使用 MyBatis-Plus 提供的 `QueryWrapper` 和 `UpdateWrapper` 来构建查询和更新条件。

通过以上的方式，你可以充分利用 MyBatis-Plus 提供的便捷功能，简化你的数据访问层代码，提高开发效率。
````



