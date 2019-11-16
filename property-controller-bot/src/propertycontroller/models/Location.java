package propertycontroller.models;

public class Location{
    private String name;
    private String description;

    public Location(String name, String description){
        this.name = name;
        this.description = description;
    }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public void setName(String newName) {
        name = newName;
    }
    public void setDescription(String newDescription) { description = newDescription; }
}
