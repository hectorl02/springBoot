package com.hectorl.fundamentos.bean;

public class MyBeanPropertiesImplement implements MyBeanProperties{
    private String nombre;
    private  String apellido;

    public MyBeanPropertiesImplement(String name, String apellido) {
        this.nombre = name;
        this.apellido = apellido;
    }

    @Override
    public String function() {
        return nombre +"--"+apellido;
    }

}
