package propertycontroller;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
/**
 * Essa classe é a Main, a classe main faz a inicialização da API do Telegram
 * para a utilização do BOT, o interessante ressaltar que o bot foi construído
 * utilizando uma maquina da estados para facilitar o processamento de somente
 * um único método principal, o projeto foi construído em dois padrões de projeto,
 * O MVC (Movel, View e Controller) e o STATE.
 *
 * @author Louis Arthur Machado Bezerra do Nascimento - Github: louisarthur
 * @author Gabriel Paes Landim de Lucena - Github: lucena-fr4ct1ons
 *
 * @version 1.0 versão feita em 17 novembro de 2019
 */
public class Main {
    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new BotController());

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
