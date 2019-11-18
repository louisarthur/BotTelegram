package propertycontroller.controllers;
import propertycontroller.exceptions.InvalidOptionException;
import propertycontroller.interfaces.Controller;
import propertycontroller.models.Asset;
import propertycontroller.models.Category;
import propertycontroller.models.Location;
import java.util.ArrayList;
/**
 * Essa classe é a AssetController, essa classe faz a parte do controle do model Asset
 * onde tem todos os métodos necessários para o funcionamento normal do programa.
 *
 * @author Louis Arthur Machado Bezerra do Nascimento - Github: louisarthur
 * @author Gabriel Paes Landim de Lucena - Github: lucena-fr4ct1ons
 *
 * @version 1.0 versão feita em 17 novembro de 2019
 */
public class AssetController implements Controller {
    private ArrayList<Asset> assets;
    /**
     * Metodo construtor para inicialização do array list;
     */
    public AssetController() {
        assets = new ArrayList<>();
    }
    /**
     * Esse metodo consiste no armazenamento de um produto
     * @param bufferName nome do produto a ser armazenado
     * @param bufferDescription descrição do produto a ser armazenado
     * @param bufferCode código do produto a ser armazendao
     * @param bufferLocation localização do produto a ser armazenado
     * @param bufferCategory categoria do produto a ser armazenado
     * @return retorna um boolean informado o armazenamento
     */
    public boolean store(String bufferName, String bufferDescription, String bufferCode, Location bufferLocation, Category bufferCategory){
        assets.add(new Asset(bufferName, bufferDescription, bufferCode, bufferLocation, bufferCategory));
        return true;
    }

    /**
     * Esse metodo consiste em retornar um array com todos os produtos armazenados.
     * @return Retorna um array com todos os nomes (String) de produtos contidos no sistema.
     */
    @Override
    public ArrayList<String> index(){
        System.out.println("Existe: "+assets.size()+" itens adicionados nos produtos");
        if(assets.size()==0) {
            return null;
        }
        int counter = 0;
        ArrayList<String> assetsName = new ArrayList();
        for (Asset k : assets) {
            ++counter;
            assetsName.add(counter + " - " + k.getName());
        }
        return assetsName;
    }

    /**
     * Esse metodo consiste em retornar um array com todos os produtos armazenados.
     * @return Retorna um array com todos os objetos de produtos(assets) contidos no sistema.
     */
    public ArrayList<Asset> getAssets(){
        return this.assets;
    }
    /**
     * Esse método é o de pesquisa pelo nome.
     * @param name Recebe o nome do produto
     * @return Retorna um array com todos os objetos de produtos(assets) contidos no sistema com o nome igual o do parametro recebido.
     */
    public ArrayList<Asset> searchByName (String name){
        ArrayList<Asset> bufferArray = new ArrayList<>();
        for (Asset a : assets) {
            System.out.println(a.getName());
            if (a.getName().equals(name)) {
                bufferArray.add(a);
            }
        }
        if(bufferArray.size() == 0){
            return null;
        }
        else{
            return bufferArray;
        }
    }
    /**
     * Esse método é o de pesquisa pelo código.
     * @param code Recebe o código do produto
     * @return Retorna um array com todos os objetos de produtos(assets) contidos no sistema com o código igual o do parametro recebido.
     */
    public ArrayList<Asset> searchByCode (String code){
        ArrayList<Asset> bufferArray = new ArrayList<>();
        for (Asset a : assets) {
            System.out.println(a.getName());
            if (a.getCode().equals(code)) {
                bufferArray.add(a);

            }
        }
        if(bufferArray.size() == 0){
            return null;
        }
        else{
            return bufferArray;
        }
    }
    /**
     * Esse método é o de listagem por localização
     * @param compare recebe uma localização
     * @return retorna em string todos os produtos por localização.
     */
    public String listByLocation(String compare){

        String toReturn = "Ok, esses são os bens na localização " + compare + ":\n";
        for (int i = 0; i < assets.size(); i++)
        {
            if(assets.get(i).getMyLocation().getName().equals(compare))
            {
                toReturn += assets.get(i).getName() + ";\n";
            }
        }
        if(toReturn.equals("Ok, esses são os bens na localização " + compare + ":\n"))
            return "Não foi encontrado nenhum bem que esteja na localização que você enviou!";

        return toReturn;
    }

    public Asset getAsset(int index) throws InvalidOptionException
    {
        if(index < 1 || index >assets.size())
        {
            throw new InvalidOptionException();
        }
        else
        {
            return assets.get(index - 1);
        }
    }

}
