package propertycontroller.controllers;
import propertycontroller.models.Asset;
import propertycontroller.models.Category;
import propertycontroller.models.Location;

import java.util.ArrayList;

public class AssetController {
    private ArrayList<Asset> assets;

    public AssetController() {
        assets = new ArrayList<>();
    }
    public boolean store(String bufferName, String bufferDescription, String bufferCode, Location bufferLocation, Category bufferCategory){
        assets.add(new Asset(bufferName, bufferDescription, bufferCode, bufferLocation, bufferCategory));
        return true;
    }
    public ArrayList<String> index(){
//       Necessário ajustar ainda o padrão de retornar multriplos tipos de váriavéis
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
    public ArrayList<Asset> getAssets(){
        return this.assets;
    }
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

}
