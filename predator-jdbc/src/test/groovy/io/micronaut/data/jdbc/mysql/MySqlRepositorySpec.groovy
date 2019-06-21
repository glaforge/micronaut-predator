package io.micronaut.data.jdbc.mysql

import io.micronaut.context.ApplicationContext
import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.runtime.config.SchemaGenerate
import io.micronaut.data.tck.repositories.AuthorRepository
import io.micronaut.data.tck.repositories.BookRepository
import io.micronaut.data.tck.repositories.CompanyRepository
import io.micronaut.data.tck.repositories.PersonRepository
import io.micronaut.data.tck.tests.AbstractRepositorySpec
import org.testcontainers.containers.MySQLContainer
import spock.lang.AutoCleanup
import spock.lang.Shared

class MySqlRepositorySpec extends AbstractRepositorySpec {
    @Shared @AutoCleanup MySQLContainer mysql = new MySQLContainer<>()
    @Shared @AutoCleanup ApplicationContext context

    @Override
    PersonRepository getPersonRepository() {
        return context.getBean(MySqlPersonRepository)
    }

    @Override
    BookRepository getBookRepository() {
        return context.getBean(MySqlBookRepository)
    }

    @Override
    AuthorRepository getAuthorRepository() {
        return context.getBean(MySqlAuthorRepository)
    }

    @Override
    CompanyRepository getCompanyRepository() {
        return context.getBean(MySqlCompanyRepository)
    }

    @Override
    void init() {
        mysql.start()
        context = ApplicationContext.run(
                "datasources.default.url":mysql.getJdbcUrl(),
                "datasources.default.username":mysql.getUsername(),
                "datasources.default.password":mysql.getPassword(),
                "datasources.default.schema-generate": SchemaGenerate.CREATE,
                "datasources.default.dialect": Dialect.MYSQL
        )

    }
}
