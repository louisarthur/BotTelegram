package propertycontroller.state;
/**
 * Esse enum foi necessário para fazer a criação da máquina de estados,
 * a maquina de estados vai fazer o nosso projeto funcionar em cima de
 * somente um método principal.
 *
 * @author Louis Arthur Machado Bezerra do Nascimento
 * @author Gabriel Paes Landim de Lucena
 * @version 1.0 versão feita em 17 novembro de 2019
 */
public enum BotStates
{
        IDLE,
        WAITING_ASSET_NAME, WAITING_ASSET_DESCRIPTION, WAITING_ASSET_CODE, WAITING_ASSET_CATEGORY, WAITING_ASSET_LOCATION,
        WAITING_LOCATION_NAME, WAITING_LOCATION_DESCRIPTION,
        WAITING_CATEGORY_NAME, WAITING_CATEGORY_DESCRIPTION, WAITING_CATEGORY_CODE,
        LISTING_ASSET_BY_LOCATION,
        SEARCHING_ASSET_BY_CODE,SEARCHING_ASSET_BY_NAME,SEARCHING_ASSET_BY_DESCRIPTION,
        MOVING_WAITING_ASSETNAME, MOVING_WAITING_LOCATIONNAME, MOVING_WAITING_ASSETCODE
}