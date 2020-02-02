package com.bookstore;

import com.bookstore.service.BookstoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {

    @Autowired
    private BookstoreService bookstoreService;

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {
            
            System.out.println("\nAdd author with books  ...");
            bookstoreService.addAuthorWithBooks();

            System.out.println("\nRemove a book of an author...");
            bookstoreService.removeBookOfAuthor();
            
            System.out.println("\nRemove all book of an author...");
            bookstoreService.removeAllBooksOfAuthor();
        };
    }
}
/*
 * How To Migrate MySQL Database Using Flyway - Database Created Via spring.flyway.schemas

Note: For production, don't rely on hibernate.ddl-auto (or counterparts) to export schema DDL to the database. Simply remove (disable) hibernate.ddl-auto or set it to validate. Rely on Flyway or Liquibase.

Description: This application is an example of migrating a MySQL database when the database is created by Flyway via spring.flyway.schemas. In this case, the entities should be annotated with @Table(schema = "bookstoredb") or @Table(catalog = "bookstoredb"). Here, the database name is bookstoredb.

Key points:

for Maven, in pom.xml, add the Flyway dependency
remove (disable) spring.jpa.hibernate.ddl-auto or set it to validate
in application.properties, set the JDBC URL as follows: jdbc:mysql://localhost:3306/
in application.properties, add spring.flyway.schemas=bookstoredb, where bookstoredb is the database that should be created by Flyway (feel free to add your own database name)
each entity that should be stored in this database should be annotated with, @Table(schema/catalog = "bookstoredb")
each SQL file containing the schema update add it in classpath:db/migration
each SQL file name it as V1.1__Description.sql, V1.2__Description.sql, ...
Output of migration history example:
 */
