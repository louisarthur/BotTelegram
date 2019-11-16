package propertycontroller.controllers;
import propertycontroller.models.Category;
import java.util.ArrayList;

public class CategoryController {
    private ArrayList<Category> categories;

    public CategoryController() {
        categories = new ArrayList<>();
    }
    public boolean store(String name, String description, String code){
        categories.add(new Category(name,description,code));
        return true;
    }
    public ArrayList<String> index(){
        System.out.println("Existe: "+categories.size()+" itens adicionados nas categorias");
        if(categories.size()==0){
            return null;
        }
        int counter = 0;
        ArrayList<String> categoriesName = new ArrayList();
        for(Category k : categories) {
            ++counter;
            categoriesName.add(counter+ " - " + k.getName());
        }
        return categoriesName;
    }
    public ArrayList<Category> getCategories(){
        return this.categories;
    }

}
