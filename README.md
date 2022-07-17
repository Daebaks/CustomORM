# Custom Object Relational Mapping Library myorm

# Technologies

- HikariCP 5.0.1
- PostgreSQL 42.3.3
- Java E8
- commons-dbcp2 2.9.0
- slf4j-simple 2.0.0-alpha0

# What can it do

- CRUD operations
- 1:M relation
- M:1 relation
- M:M relation
- Connection pooling

# Using the ORM

- Clone the GitHub repository from `https://github.com/Daebaks/project_1`
- Execute `nvm install`
- Add the dependency in your pom.xml

```
<groupId>com.revature</groupId>
<artifactId>project1</artifactId>
<version>0.0.1-SNAPSHOT</version>

```

# Annotations/relations

- To create a table
  `@Table(tableName = "TableName")`
- To create a PK
  `@Id(columnName = "PKname")`
- To create a column
  `@Column(columnName = "ColumnName")`
- To create a 1:M, M:1 FK relation
  `@FkRelation(columnName = "FKname", referencesTo = "PKname_references", tableNameRefTo = "Table_references")`
- To create a M:M FK relation (junction table)
  `@ManyToMany(fkFrom = "Junction_table_PK1", fkTo = "Junction_table_PK2", tableMappedFrom = "PK1_table", tableMappedTo = "PK_table")`

# Getting started

- Add the annotated classes by creating a myorm.config.xml file in your project and insert the classes path like this

```
<classes>
<class>com.sample.models.class1</class>
<class>com.sample.models.class2</class>
<class>com.sample.models.class3</class>
</classes>
```

- Set the path to this config file by using `<your_config>.setXmlPath("")`

- Configure the DB by using either individual methods, or a long one line method

`void setupConnection(String dnUrl, String dbUsername, String dbPassword, String dbSchema, String driverName)`
`void setupConnection(String dnUrl, String dbUsername, String dbPassword, String dbSchema)`
`void setupConnection(String dbUrl, String dbUsername, String dbPassword)`

- You have more controles on your on your connection by using the below

  `void setConnectionTimeout(long time)`
  `void setMaxLifetime(long maxlife)`
  `void setAutoCommit(boolean auto)`
  `void setIdleTimeout(long idle)`
  ` void setSchema(String schema)`
  `void setDriver(String driverName)`
  ``

- Then execute `buildDb()`

- Then build a session `Session s = new Session();`

- After creating the tables, building the session, you can use the CRUD methods to build your DAOs to use the ORM

`int insertToDb(Object obj)` inserts an object to the DB returns generated PK id
`void deleteFromDb(Object obj)` deletes an object from the DB
`void updateInDb(Object obj)` updates an object in the DB
`void readFromDb(Object obj) ` reads an object from the DB

# Transactions

- Savepoints are stored as a HashMap.

`void commit()` - commit transaction.

`void releaseSavepoint(String name)` - removes the specified Savepoint.

`void rollback()` - undo all changes for the current transaction.

`void rollback(String name)` - undo all the changes after the given savepoint.

`void setAutoCommit(boolean isEnabled)` - changes auto commit mode for the current connection.

`void setSavepoint(String name)` - set savepoint with specified name.

# TO-DO
- Full support of M:M
