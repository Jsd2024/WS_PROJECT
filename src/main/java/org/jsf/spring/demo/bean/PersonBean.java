package org.jsf.spring.demo.bean;

import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;

@Component
@ManagedBean
public class PersonBean {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void submit() {
        System.out.println("Submitted Name: " + name);
    }
}
