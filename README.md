# DbConfig

A lightweight java based ORM for simplifying connecting to and from an SQL database without the need for SQL or connection management. A less resource intensive ORM implementation for smaller applications where a single object is being managed at a time. 

## Technologies Used

* PostgreSQL - version 42.2.12  
* Java - version 8.0  
* Apache commons - version 2.1  

## Features
* Easy to use and straightforward user API.  
* No need for SQL, HQL, or any databse specific language.  
* Straightforward and simple Annotation based for ease of use. 
* Allow ORM to build table based on Annotations in Entities.

To-do list: [`for future iterations`]
* Mapping of join columns inside of entities.    
* Implement of aggregate functions.  
* Pre-configured metadata, connections and caching

  
## Usage  
  ### Annotating classes  
  All classes which represent objects in database must be annotated.
   - #### @Table(name = "tableName")  
      - Indicates that this class is associated with table 'tableName'  
   - #### @Column(name = "columnName")  
      - Indicates that the Annotated field is a column in the table with the name 'columnName'  
   - #### @FKRelation(columName = "columnName"
   -                  referenceTo ="PK"
   -                  tableNameRefTo = "tableName") 
      - Indicates that the annotated field has a foreign key relationship.
   - #### @ManyToMany(tableMappedTo = "columnName"
   -                  tableMappedFrom ="tableName"
   -                  fkTo = "tableName"
   -                  fkFrom = "tableName") 
      - Indicates that the annotated field has a ManyToMany relationship.
   - #### @Id(name = "columnName"
   -                  tableMappedFrom ="tableName"
   -                  fkTo = "tableName"
   -                  fkFrom = "tableName") 
      - Indicates that the annotated field is a serial key.

  ### User API  
  
  - #### `public int insertToDb()`  
     - Adds the given object to the database.  
  - #### `public void deleteFromDb()`  
     - Removes the given object from the database.    
  - #### `public void updateInDb()`
     - Updates the given object in the databse. Update columns is a comma seperated lsit fo all columns in the onject which need to be updated
  - #### `public void readFromDb()`
     - Retrieves a given object from the database.
  - #### `public void setCommit()`  
     - begin databse commit.  
  - #### `public void rollBack()`  
     - Rollback to previous commit.  
  - #### `public void rollBackToSavepoint(String name)`  
     - Rollback to previous commit with given name.  
  - #### `public void setSavepoint(String name)`  
     - Set a savepoint with the given name.  
  - #### `public void releaseSavepoint(Savepoint s)`  
     - Release the savepoint with the given name.
  - #### `public void beginTransaction()`  
     - Start a transaction block.



## License

This project uses the following license: [GNU Public License 3.0](https://www.gnu.org/licenses/gpl-3.0.en.html).

