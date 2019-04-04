package com.example.assignment2.models;

public class item {
    // I have not decided on what should be the item in recycler , so using the generic term "item"
    String name ;
    String description ;
    int image_resource_id ;
    public item(String name, String description, int image_resource_id){
        this.name = name;
        this.description = description ;
        this.image_resource_id = image_resource_id ;
    }
    public item(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage_resource_id() {
        return image_resource_id;
    }

    public void setImage_resource_id(int image_resource_id) {
        this.image_resource_id = image_resource_id;
    }
}
