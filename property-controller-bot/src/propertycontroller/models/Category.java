package propertycontroller.models;

import java.io.*;

public class Category{
    private String name;
    private String description;
    private String code;

    public Category(String name, String description, String code){
        this.name = name;
        this.description = description;
        this.code = code;
    }

    public String getCode() {
        return code;
    }
    public void setCode(String newCode) {
        code = newCode;
    }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public void setName(String newName) {
        name = newName;
    }
    public void setDescription(String newDescription) { description = newDescription; }
}