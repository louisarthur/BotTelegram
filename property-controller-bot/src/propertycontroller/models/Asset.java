package propertycontroller.models;

public class Asset{
    private int id;
    private String name;
    private String description;
    private String code;
    private Location myLocation;
    private Category myCategory;

    public Asset(String newName, String newDescription, String newCode,Location myLocation, Category myCategory)
    {
        name = newName;
        description = newDescription;
        code = newCode;
        this.myLocation = myLocation;
        this.myCategory = myCategory;
    }

    public String getCode() { return code; }
    public void setCode(String newCode) {
        this.code = newCode;
    }
    public Location getMyLocation() {
        return myLocation;
    }
    public void setMyLocation(Location newLocation) {
       this.myLocation = newLocation;
    }
    public Category getMyCategory() {
        return myCategory;
    }
    public void setMyCategory(Category newCategory) {
        this.myCategory = newCategory;
    }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public void setName(String newName) {
        this.name = newName;
    }
}