package propertycontroller.models;
/**
 * Essa classe é a Location, essa classe é um model Location (Local).
 *
 * @author Louis Arthur Machado Bezerra do Nascimento - Github: louisarthur
 * @author Gabriel Paes Landim de Lucena - Github: lucena-fr4ct1ons
 *
 * @version 1.0 versão feita em 17 novembro de 2019
 */
public class Location{
    /**
     * Variaveis do objeto location
     */
    private String name;
    private String description;
    /**
     * Método construtor do model location
     * @param name  nome da nova location a ser instânciada
     * @param description descrição da nova location a ser instânciada
     */
    public Location(String name, String description){
        this.name = name;
        this.description = description;
    }
    /**
     * método de retornar o nome do model location
     * @return nome da location intânciada
     */
    public String getName() { return name; }
    /**
     * método de retornar a descrição do model location
     * @return a descrição da location intânciada
     */
    public String getDescription() { return description; }
    /**
     * método de modificar o nome do model location
     * @param newName novo nome do model location
     */
    public void setName(String newName) {
        name = newName;
    }
    /**
     * método de modificar a descrição do model location
     * @param newDescription nova descrição do model location
     */
    public void setDescription(String newDescription) { description = newDescription; }
}
