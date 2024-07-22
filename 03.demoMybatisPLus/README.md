# MyBatis Plus

### Introduction 

MyBatis Plus is an enhanced toolkit based on MyBatis. It not only retains the native flexibility of MyBatis, but also provides many convenient functions based on it, thus greatly simplifying common CRUD (create, read, update, delete) operation. Here are two key features and benefits of MyBatis Plus:

* CRUD operations

  ```
  It provides powerful CRUD operation encapsulation, which can be used with simple configuration, greatly reducing the trouble of handwriting SQL.
  ```

* Conditional constructor

  ```
  It has built-in rich condition constructors, which can easily splice various query conditions and support chain calls.
  ```

### Guides

The following guides illustrate how to use MyBatis Plus concretely:

* Add dependency 

  ```java
  <dependency>
      <groupId>com.baomidou</groupId>
      <artifactId>mybatis-plus-boot-starter</artifactId>
      <version>3.4.3.4</version>
  </dependency>
  ```

* Some configurations

  1. Configure data source
     Configure data source connection information, such as database URL, user name, password, etc.

  2. Create entity class
     Create an entity class corresponding to the database table and configure it using the annotations provided by MyBatis Plus.

  3. Create Mapper interface
     Create a Mapper interface that inherits from BaseMapper without writing an implementation class.

  4. Configure Mapper XML (optional)
     If you need custom SQL, you can write a Mapper XML file.

* Use Service

  Create a Service interface and implementation class, and use the ServiceImpl class provided by MyBatis Plus to encapsulate business logic.

### Internal logic

Operations like save and deleteById are basic CRUD operations that have been predefined by MyBatis Plus, and they correspond to database insertion and deletion operations respectively. Using these methods, you can add, delete, modify, and query the database without writing SQL statements.

The following are some commonly used CRUD methods and descriptions of their functions:

- save method:

​	Function: Insert an entity object into the database.
​	Use: userService.save(user);

- removeById method:

​	Function: Delete records in the database based on the primary key ID.
​	Use: userService.removeById(id);

- updateById method:

​	Function: Update records in the database based on the primary key ID.
​	Use: userService.updateById(user);

- getById method:

​	Function: Query the records in the database based on the primary key ID.
​	Use: userService.getById(id);

The specific implementation of these methods is in the IService interface provided by MyBatis Plus, which provides rich CRUD operations. When using it, you only need to call the implementation class of IService. Usually, we will inherit IService in the Service layer interface and implement these methods in its implementation class.

### Query Builder

These methods take advantage of the flexible query builders QueryWrapper and LambdaQueryWrapper provided by MyBatis Plus. These builders make it easy to implement complex query conditions without having to manually write SQL statements. These query builders already implement many commonly used methods, such as eq, like, between, etc.

My customized LambdaQueryWrapperX class extends the LambdaQueryWrapper of MyBatis Plus to support methods of adding query conditions after conditional judgment, such as likeIfPresent, eqIfPresent, etc. These methods will only add conditions to the query builder after determining whether the incoming value exists (that is, whether it is null), thus avoiding the problem of null value query.

#### Detailed explanation

- Query builder methods:

​	eq: indicates equal condition.
​	like: Indicates fuzzy matching conditions.
​	between: Indicates a condition between two values.
​	orderByDesc: indicates descending order.
These methods have been predefined in QueryWrapper and LambdaQueryWrapper of MyBatis Plus. You only need to call these methods and pass in the corresponding parameters.

- Custom methods likeIfPresent, eqIfPresent, etc.:

These methods are customized by you in LambdaQueryWrapperX and are used to add conditions to the query builder only when the parameters are not empty.
