package models;

import java.io.Serializable;

public class CampaignModel implements Serializable 
{
	
	private static final long serialVersionUID = -8146492908907912044L;
	
	private EventLogModel eventLogModel;
	private PlayerModel playerModel;
	private ItemModel itemModel;
	
	public CampaignModel() 
	{
		eventLogModel = new EventLogModel();
		playerModel = new PlayerModel();
		itemModel = new ItemModel();
	}
	
	public EventLogModel getEventLogModel() 
	{
		return eventLogModel;
	}
	
	public PlayerModel getPlayerModel() 
	{
		return playerModel;
	}
	
	public ItemModel getItemModel() 
	{
		return itemModel;
	}
	
}
