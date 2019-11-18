package propertycontroller.interfaces;
import java.util.ArrayList;
/**
 * Essa é uma interface controller, essa interface reproduz um método para outras classes controllers.
 *
 * @author Louis Arthur Machado Bezerra do Nascimento - Github: louisarthur
 * @author Gabriel Paes Landim de Lucena - Github: lucena-fr4ct1ons
 *
 * @version 1.0 versão feita em 17 novembro de 2019
 */
public interface Controller {
    /**
     * Esse metodo consiste em retornar um array de string respectivamente para onde for chamado
     * @return Retorna um array de string
     */
    ArrayList<String> index();
}
