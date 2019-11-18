package propertycontroller.controllers;
import propertycontroller.interfaces.Controller;
import propertycontroller.models.Category;
import java.util.ArrayList;
/**
 * Essa classe é a CategoryController, essa classe faz a parte do controle do model Category
 * onde tem todos os métodos necessários para o funcionamento normal do programa.
 *
 * @author Louis Arthur Machado Bezerra do Nascimento - Github: louisarthur
 * @author Gabriel Paes Landim de Lucena - Github: lucena-fr4ct1ons
 *
 * @version 1.0 versão feita em 17 novembro de 2019
 */
public class CategoryController implements Controller {
    private ArrayList<Category> categories;
    /**
     * Metodo construtor para inicialização do array list;
     */
    public CategoryController() {
        categories = new ArrayList<>();
    }
    /**
     * Esse metodo consiste no armazenamento de uma categoria
     * @param name nome da categoria a ser armazenada
     * @param description descrição da categoria a ser armazenada
     * @param code código da categoria a ser armazenada
     * @return retorna um boolean informado o estado do armazenamento
     */
    public boolean store(String name, String description, String code){
        categories.add(new Category(name,description,code));
        return true;
    }
    /**
     * Esse metodo consiste em retornar um array com todos as categorias armazenadas.
     * @return Retorna um array com todos os nomes (String) das categorias contidas no sistema.
     */
    @Override
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
    /**
     * Esse metodo consiste em retornar um array com todos as categorias armazenadas.
     * @return Retorna um array com todos os objetos das categorias contidas no sistema.
     */
    public ArrayList<Category> getCategories(){
        return this.categories;
    }

}
