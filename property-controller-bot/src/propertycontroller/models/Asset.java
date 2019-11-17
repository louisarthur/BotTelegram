package propertycontroller.models;
/**
 * Essa classe é a Asset, essa classe é um model Asset (produto).
 *
 * @author Louis Arthur Machado Bezerra do Nascimento - Github: louisarthur
 * @author Gabriel Paes Landim de Lucena - Github: lucena-fr4ct1ons
 *
 * @version 1.0 versão feita em 17 novembro de 2019
 */
public class Asset{
    /**
     * Variaveis do objeto asset
     */
    private String name;
    private String description;
    private String code;
    private Location myLocation;
    private Category myCategory;

    /**
     * Método construtor do model
     * @param newName nome do novo asset a ser instânciado
     * @param newDescription descrição do novo asset a set instânciado
     * @param newCode código do novo asset a ser instânciado
     * @param myLocation objeto local a ser instânciado
     * @param myCategory objeto categoria a ser instânciado
     */
    public Asset(String newName, String newDescription, String newCode,Location myLocation, Category myCategory) {
        name = newName;
        description = newDescription;
        code = newCode;
        this.myLocation = myLocation;
        this.myCategory = myCategory;
    }

    /**
     * método de retornar código do model asset
     * @return código do asset intânciado
     */
    public String getCode() { return code; }

    public void setCode(String newCode) {
        this.code = newCode;
    }
    /**
     * método de retornar location do model asset
     * @return código do asset intânciado
     */
    public Location getMyLocation() {
        return myLocation;
    }
    /**
     * método de modificar a location do model asset
     * @param newLocation nova localização do asset
     */
    public void setMyLocation(Location newLocation) {
       this.myLocation = newLocation;
    }
    /**
     * método de retornar a categoria do model asset
     * @return código do asset intânciado
     */
    public Category getMyCategory() {
        return myCategory;
    }
    /**
     * método de modificar a categoria do model asset
     * @param newCategory nova categoria do asset
     */
    public void setMyCategory(Category newCategory) {
        this.myCategory = newCategory;
    }
    /**
     * método de retornar o nome do model asset
     * @return código do asset intânciado
     */
    public String getName() { return name; }
    /**
     * método de retornar a descrição do model asset
     * @return código do asset intânciado
     */
    public String getDescription() { return description; }
    public void setName(String newName) {
        this.name = newName;
    }
}