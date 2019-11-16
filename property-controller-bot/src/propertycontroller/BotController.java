package propertycontroller;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.lang.reflect.Array;
import java.util.*;
import propertycontroller.controllers.AssetController;
import propertycontroller.controllers.CategoryController;
import propertycontroller.controllers.LocationController;
import propertycontroller.models.*;
import propertycontroller.state.BotStates;


public class BotController extends TelegramLongPollingBot{

    private String bufferName;
    private String bufferDescription;
    private String bufferCode;
    private Location bufferLocation;
    private Category bufferCategory;
    private BotStates state = BotStates.IDLE;
    private LocationController locationControl = new LocationController();
    private AssetController assetControl = new AssetController();
    private CategoryController categoryControl = new CategoryController();

    public void onUpdateReceived(Update update) {
        String commandReceived = update.getMessage().getText();
        SendMessage message = new SendMessage();


//      ***********************  MAIN PROCEDURES ***********************
        if(state == BotStates.IDLE) {
            if (commandReceived.equals("/about")) {
                System.out.println("Sending message about bot.");
                message.setText("Olá! Meu nome é Bot Controller e eu controlo um patrimonio. Esse bot ainda é um W.I.P então por favor, tenha paciencia, ok? Obrigado :D");
            }
            else if(commandReceived.equals("teste")){
                categoryControl.store("Eletrodomestico","Ligados com energia","f12345");
                categoryControl.store("Moveis","Rusticos","f123as");
                categoryControl.store("Imoveis","Legais","5412");

                locationControl.store("Sala","Sala massa");
                locationControl.store("Cozinha","Muito legal");
                locationControl.store("Banheiro","Legal demais");

                bufferLocation = locationControl.getLocals().get(1);
                bufferCategory = categoryControl.getCategories().get(1);

                assetControl.store("PC","Pc gamer","12345abc",bufferLocation,bufferCategory);
                assetControl.store("Mouse","mouse gamer","12345abc",bufferLocation,bufferCategory);
                assetControl.store("Teclado","teclado gamer","12345abcf",bufferLocation,bufferCategory);
                message.setText("Ok, foram adicionados 3 Categorias,3 Locais e 3 Produtos, para fazer um teste unitário");
            }
            else if (commandReceived.equals("/addlocation")){
                System.out.println("Adding Local");
                message.setText("Ok, vamos adicionar um local. Primeiramente, insira o nome do local a ser adicionado.");
                state = BotStates.WAITING_LOCATION_NAME;
            }
            else if (commandReceived.equals("/addcategory")){
                System.out.println("Adding a category");
                message.setText("Ok, vamos adicionar uma categoria. Primeiramente, insira o nome da categoria a ser adicionada.");
                state = BotStates.WAITING_CATEGORY_NAME;
            }
            else if (commandReceived.equals("/addproduct")){
                System.out.println("Adding an asset");
                message.setText("Ok, vamos adicionar um bem. Primeiramente, insira o nome do bem a ser adicionado.");
                state = BotStates.WAITING_ASSET_NAME;
            }
            else if (commandReceived.equals("/listlocation")){
                if(locationControl.index() == null){
                    message.setText("Nenhum Local adicionado até o momento");
                }
                else{
                    message.setText(String.valueOf(locationControl.index()).replace(",",
                            "\n").replace("[", "").replace(
                            "]", "").replace(" ", ""));
                }
            }
            else if( commandReceived.equals("/listproduct")){
                if(assetControl.index() == null){
                    message.setText("Nenhum produto adicionado até o momento");
                }
                else{
                    message.setText(String.valueOf(assetControl.index()).replace(",",
                        "\n").replace("[", "").replace(
                                "]", "").replace(" ", ""));
                }
            }
            else if (commandReceived.equals("/listcategories")) {
                if(categoryControl.index() == null ) {
                    message.setText("Nenhuma categoria foi adicionada até o momento");
                }
                else{
                    message.setText(String.valueOf(categoryControl.index()).replace(",",
                            "\n").replace("[", "").replace(
                            "]", "").replace(" ", ""));
                }
            }
            else if (commandReceived.equals("/listproductsbylocation")){}
            else if (commandReceived.equals("/searchbycode")) {
                System.out.println("Here, we will search by code");
                message.setText("Digite o código:\n");

                state = BotStates.SEARCHING_ASSET_BY_CODE;
            }
            else if (commandReceived.equals("/searchbyname")) {
                System.out.println("search by name");
                message.setText("\nDigite o nome do produto: \n");
                state = BotStates.SEARCHING_ASSET_BY_NAME;
            }
            else if (commandReceived.equals("/searchbydescription")) {
                System.out.println("Search by description");
                message.setText("\nDigite a descrição do produto: \n");
                state = BotStates.SEARCHING_ASSET_BY_DESCRIPTION;
            }
            else if (commandReceived.equals("/moveproduct")) {
                System.out.println("Move the product");
            }
            else if (commandReceived.equals("/report")) {
                System.out.println("Make the report");
            }
        }
//      ***********************  MAIN PROCEDURES ***********************


//      ***********************  ASSET PROCEDURES ***********************
        else if(state == BotStates.WAITING_ASSET_NAME){
            bufferName = commandReceived;
            message.setText("Ok! O nome do bem a ser adicionado é: \n" +
                    bufferName +
                    "\n Agora, adicione a descrição desse bem.");
            state = BotStates.WAITING_ASSET_DESCRIPTION;
        }
        else if (state == BotStates.WAITING_ASSET_DESCRIPTION) {
            bufferDescription = commandReceived;
            message.setText("Entendido! A descricao do bem a ser adicionado é: \n" +
                    bufferDescription +
                    "\nAgora, adicione o código.");
            state = BotStates.WAITING_ASSET_CODE;
        }
        else if(state == BotStates.WAITING_ASSET_CODE) {
            bufferCode = commandReceived;
            message.setText("Certo! o código do bem a ser adicionado é: \n" +
                    bufferCode+"\n" +
                    "Muito bem, agora adicione o local que o produto estará\n" +
                    "Só precisa adicionar o número");
            if(locationControl.index() == null){
                message.setText("\nExiste um pequeno problema, ainda não foi adicionado nenhum local!\n" +
                        "portanto, irei reiniciar lhe redirecionando para o menu.\n");
                state = BotStates.IDLE;
            }
            else{
                message.setText(String.valueOf(locationControl.index()).replace(",",
                        "\n").replace("[", "").replace(
                        "]", "").replace(" ", ""));
                state = BotStates.WAITING_ASSET_LOCATION;
            }
        }
        else if(state== BotStates.WAITING_ASSET_LOCATION){
            int bufferTemporary = Integer.parseInt(commandReceived);
//          tem que fazer o tratamento de erros.
            bufferLocation = locationControl.getLocals().get(bufferTemporary - 1);
            message.setText("Entendido! o local selecionado foi: " + bufferLocation.getName() + "\n" +
                    "Agora, iremos selecionar a categoria do produto\n");
            if(categoryControl.index() == null){
                message.setText("\nExiste um pequeno problema, ainda não foi adicionado nenhuma categoria!\n" +
                        "portanto, irei reiniciar lhe redirecionando para o menu.\n\n\n");
                state = BotStates.IDLE;
            }
            else{
                message.setText(String.valueOf(categoryControl.index()).replace(",",
                        "\n").replace("[", "").replace(
                        "]", "").replace(" ", ""));
                state = BotStates.WAITING_ASSET_CATEGORY;
            }
        }
        else if(state == BotStates.WAITING_ASSET_CATEGORY){
            if(categoryControl.index() == null) {
                message.setText("\nExiste um pequeno problema, ainda não foi adicionado nenhuma categoria!\n" +
                        "portanto, irei reiniciar lhe redirecionando para o menu.\n\n\n");
                state = BotStates.IDLE;
            }
            else{
                int bufferTemporary = Integer.parseInt(commandReceived);
                bufferCategory = categoryControl.getCategories().get(bufferTemporary-1);
                assetControl.store(bufferName,bufferDescription,bufferCode,bufferLocation,bufferCategory);
                message.setText("Entendido!!! a categoria selecionada foi: "+bufferCategory.getName()+"\n" +
                        "O item a seguir foi adicionado ao nosso banco de dados. \n" +
                        "Nome: "+ assetControl.getAssets().get(0).getName()+"\n" +
                        "Descrição: "+assetControl.getAssets().get(0).getDescription()+"\n" +
                        "Código: "+ assetControl.getAssets().get(0).getCode()+"\n" +
                        "Categoria: "+assetControl.getAssets().get(0).getMyCategory().getName()+"\n" +
                        "Localização: "+ assetControl.getAssets().get(0).getMyLocation().getName()+"\n");
                state = BotStates.IDLE;
            }
        }
//      ***********************  ASSET SEARCH ***********************
        else if (state == BotStates.SEARCHING_ASSET_BY_NAME){
            bufferName = commandReceived;
            if(assetControl.searchByName(bufferName) == null){
                message.setText("Nenhum produto foi encontrado com esse nome!");
            }
            else{
                Asset array = assetControl.searchByName(bufferName).get(0);
                message.setText("Item encontrado!\nNome: "+array.getName()+"\nCódigo: "+array.getCode()+"\nDescrição: "+array.getDescription()
                        +"\nCategoria: "+array.getMyCategory().getName()+"\nLocalização: "+array.getMyCategory().getName().replace(",",
                        "\n").replace("[", "").replace(
                        "]", "").replace(" ", ""));
            }
            state = BotStates.IDLE;
        }
        else if(state == BotStates.SEARCHING_ASSET_BY_CODE){
            bufferName = commandReceived;
            if(assetControl.searchByCode(bufferName) == null){
                message.setText("Nenhum produto foi encontrado com esse código!");
            }
            else{
                Asset array = assetControl.searchByCode(bufferName).get(0);
                message.setText("Item encontrado!\nNome: "+array.getName()+"\nCódigo: "+array.getCode()+"\nDescrição: "+array.getDescription()
                        +"\nCategoria: "+array.getMyCategory().getName()+"\nLocalização: "+array.getMyCategory().getName().replace(",",
                        "\n").replace("[", "").replace(
                        "]", "").replace(" ", ""));
            }
            state = BotStates.IDLE;
        }
//      ***********************  ASSET PROCEDURES ***********************


//      ***********************  CATEGORY PROCEDURES ***********************
        else if(state == BotStates.WAITING_CATEGORY_NAME){
            bufferName = commandReceived;
            message.setText("Entendido! o nome da categoria a ser adicionada é:\n"
            + bufferName + "\nAgora adicione uma descrição para essa categoria: ");
            state = BotStates.WAITING_CATEGORY_DESCRIPTION;
        }
        else if(state == BotStates.WAITING_CATEGORY_DESCRIPTION){
            bufferDescription = commandReceived;
            message.setText("Perfeito! o a descrição a ser adicionada é: \n" +
                    bufferDescription + "\nAgora adicione um código para essa categoria: ");
            state= BotStates.WAITING_CATEGORY_CODE;
        }
        else if(state == BotStates.WAITING_CATEGORY_CODE){
            bufferCode = commandReceived;
            categoryControl.store(bufferName,bufferDescription, bufferCode);
            message.setText("Certo! o código para essa categoria é: \n"+ bufferCode +
                    "\n Pronto, criamos a categoria! \n" + "\n"+
                    "Nome: " + categoryControl.getCategories().get(0).getName()+"\n"+
                    "Descrição: " + categoryControl.getCategories().get(0).getDescription()+"\n"+
                    "código: " + categoryControl.getCategories().get(0).getCode()+"\n");
            state = BotStates.IDLE;
        }
//      ***********************  CATEGORY PROCEDURES ***********************

//      ***********************  LOCATION PROCEDURES ***********************
        else if(state== BotStates.WAITING_LOCATION_NAME){
            bufferName = commandReceived;
            message.setText("Perfeito!o nome do local adicionado é: "+bufferName+"\n" +
                    "Agora adicione uma breve descrição desse local\n");
            state = BotStates.WAITING_LOCATION_DESCRIPTION;
        }
        else if(state == BotStates.WAITING_LOCATION_DESCRIPTION){
            bufferDescription = commandReceived;
            locationControl.store(bufferName, bufferDescription);
            message.setText("Certo! a descrição desse local é :\n" +
                    bufferDescription+"\n"+
                    "\nPronto, criamos o local! \n"+"\n" +
                    "Nome: "+ locationControl.getLocals().get(0).getName()+"\n" +
                    "Descrição: "+ locationControl.getLocals().get(0).getDescription()+"\n");
            state = BotStates.IDLE;
        }
//      ***********************  LOCATION PROCEDURES ***********************


        message.setChatId(update.getMessage().getChatId());
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    public String getBotUsername() {
        return "patrimony_controller_bot";
    }
    public String getBotToken() {
        return "806147067:AAG9SSRMruwytYdBwkcxdpgrlQPzRVskbk0";
    }
}
