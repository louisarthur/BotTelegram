package propertycontroller.models;
/**
 * Essa classe é a Category, essa classe é um model Category (Categoria).
 *
 * @author Louis Arthur Machado Bezerra do Nascimento - Github: louisarthur
 * @author Gabriel Paes Landim de Lucena - Github: lucena-fr4ct1ons
 *
 * @version 1.0 versão feita em 17 novembro de 2019
 */
public class Category{
    /**
     * Variaveis do objeto category
     */
    private String name;
    private String description;
    private String code;
    /**
     * Método construtor do model category
     * @param name  nome da nova categoria a ser instânciada
     * @param description descrição da nova categoria a ser instânciada
     * @param code código da nova categoria a ser instânciada
     */
    public Category(String name, String description, String code){
        this.name = name;
        this.description = description;
        this.code = code;
    }
    /**
     * método de retornar código do model category
     * @return código da category intânciada
     */
    public String getCode() {
        return code;
    }
    /**
     * método de modificar o código do model category
     * @param newCode novo código do model category
     */
    public void setCode(String newCode) {
        code = newCode;
    }
    /**
     * método de retornar o nome do model category
     * @return nome da category intânciada
     */
    public String getName() { return name; }
    /**
     * método de retornar a descrição do model category
     * @return descrição da category intânciada
     */
    public String getDescription() { return description; }
    /**
     * método de modificar o nome do model category
     * @param newName novo nome do model category
     */
    public void setName(String newName) {
        name = newName;
    }
    /**
     * método de modificar a descrição do model category
     * @param newDescription nova descrição do model category
     */
    public void setDescription(String newDescription) { description = newDescription; }
}