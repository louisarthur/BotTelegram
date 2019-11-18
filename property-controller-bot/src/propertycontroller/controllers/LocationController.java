package propertycontroller.controllers;
import propertycontroller.interfaces.Controller;
import propertycontroller.models.Location;
import java.util.ArrayList;
/**
 * Essa classe é a LocationController, essa classe faz a parte do controle do model Location
 * onde tem todos os métodos necessários para o funcionamento normal do programa.
 *
 * @author Louis Arthur Machado Bezerra do Nascimento - Github: louisarthur
 * @author Gabriel Paes Landim de Lucena - Github: lucena-fr4ct1ons
 *
 * @version 1.0 versão feita em 17 novembro de 2019
 */
public class LocationController implements Controller {
    private ArrayList<Location> locals;
    /**
     * Metodo construtor para inicialização do array list;
     */
    public LocationController(){
        locals = new ArrayList<>();
    }
    /**
     * Esse metodo consiste no armazenamento de uma categoria
     * @param bufferName nome do local a ser armazenado
     * @param bufferDescription descrição do local a ser armazenado
     * @return retorna um boolean informado o estado do armazenamento
     */
    public boolean store(String bufferName, String bufferDescription){
        locals.add(new Location(bufferName, bufferDescription));
        System.out.println("Existe: "+locals.size()+" itens adicionados nos locais");
        return true;
    }
    /**
     * Esse metodo consiste em retornar um array com todos os locais armazenados.
     * @return Retorna um array com todos os nomes (String) dos locais contidas no sistema.
     */
    @Override
    public ArrayList<String> index(){
        System.out.println("Existe: "+locals.size()+" itens adicionados nos locais");
        if(locals.size()==0){
            return null;
        }
        int counter = 0;
        ArrayList<String> localsName = new ArrayList();
        for(Location k: locals){
            ++counter;
            localsName.add(counter+" - " + k.getName());
        }
        return localsName;
    }
    /**
     * Esse metodo consiste em retornar um array com todos as categorias armazenadas.
     * @return Retorna um array com todos os objetos dos locais contidos no sistema.
     */
    public ArrayList<Location> getLocals(){
        return this.locals;
    }
}
