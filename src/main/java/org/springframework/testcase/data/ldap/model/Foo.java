package org.springframework.testcase.data.ldap.model;

import javax.naming.Name;

import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;

@Entry(objectClasses = {"person", "top"})
public class Foo {
    @Id
    private Name dn;

    public Name getDn() {
        return this.dn;
    }

    public void setDn(Name dn) {
        this.dn = dn;
    }
}
