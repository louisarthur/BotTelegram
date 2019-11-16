package propertycontroller.state;

public enum BotStates
{
        IDLE,
        WAITING_ASSET_NAME, WAITING_ASSET_DESCRIPTION, WAITING_ASSET_CODE, WAITING_ASSET_CATEGORY, WAITING_ASSET_LOCATION,
        WAITING_LOCATION_NAME, WAITING_LOCATION_DESCRIPTION,
        WAITING_CATEGORY_NAME, WAITING_CATEGORY_DESCRIPTION, WAITING_CATEGORY_CODE,
        LISTING_ASSET_BY_LOCATION,
        SEARCHING_ASSET_BY_CODE,SEARCHING_ASSET_BY_NAME,SEARCHING_ASSET_BY_DESCRIPTION
}