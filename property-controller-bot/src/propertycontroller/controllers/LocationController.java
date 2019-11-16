package propertycontroller.controllers;

import propertycontroller.models.Location;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class LocationController {
    private ArrayList<Location> locals;

    public LocationController(){
        locals = new ArrayList<>();
    }
    public boolean store(String bufferName,String bufferDescription){
        locals.add(new Location(bufferName, bufferDescription));
        System.out.println("Existe: "+locals.size()+" itens adicionados nos locais");
        return true;
    }
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
    public ArrayList<Location> getLocals(){
        return this.locals;
    }
}
