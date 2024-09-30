package org.jsf.spring.demo.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "userBean")
@RequestScoped
public class UserBean {

    private String name;
    private String greeting;

    // Getter and Setter for 'name'
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter for 'greeting'
    public String getGreeting() {
        return greeting;
    }

    // Method to generate the greeting based on user input
    public void greet() {
        if (name != null && !name.isEmpty()) {
            greeting = "Hello, " + name + "!";
        } else {
            greeting = "Hello, guest!";
        }
    }
}
