package org.springframework.testcase.data.ldap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ldap.core.ContextSource;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.ldap.repository.config.EnableLdapRepositories;
import org.springframework.testcase.data.ldap.model.Foo;

@SpringBootApplication
public class SpringDataLdapApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringDataLdapApplication.class, args);
    }

    @Configuration
    @EnableLdapRepositories(basePackageClasses = Foo.class)
    static class LdapConfiguration {
        @Bean
        ContextSource contextSource() {
            LdapContextSource contextSource = new LdapContextSource();
            contextSource.setUrl("ldap://localhost:389/");
            return contextSource;
        }

        @Bean
        LdapTemplate ldapTemplate() {
            return new LdapTemplate(contextSource());
        }
    }
}
