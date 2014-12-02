package utils;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import models.CampaignModel;

public final class FileHelper 
{
	private static final String FILE_EXTENSION = "cdm";
	
	public static boolean saveCampaign(CampaignModel model)
	{
		JFileChooser chooser = new JFileChooser();
		chooser.setFileFilter(new FileNameExtensionFilter("Campaign Data File (.cdm)", FILE_EXTENSION));
		
		if ( chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION )
		{
			try
			{
				String file_name = chooser.getSelectedFile().toString();
				if ( !file_name.endsWith( "." + FILE_EXTENSION ) )
					file_name += "." + FILE_EXTENSION;
				FileOutputStream fileOut = new FileOutputStream(file_name);
				ObjectOutputStream out = new ObjectOutputStream(fileOut);
				
				out.writeObject(model);
				
				out.close();
				fileOut.close();
				
				return true;
				
			}	catch(Exception e) { e.printStackTrace(); }
		}
		
		return false;
	}
	
	public static CampaignModel loadCampaign()
	{
		JFileChooser chooser = new JFileChooser();
		chooser.setFileFilter(new FileNameExtensionFilter("Campaign Data File (.cdm)", FILE_EXTENSION));
		
		if ( chooser.showDialog(null, "Open") == JFileChooser.APPROVE_OPTION )
		{
			try
			{
				CampaignModel model;
				FileInputStream inputStream = new FileInputStream(chooser.getSelectedFile());
				ObjectInputStream in = new ObjectInputStream(inputStream);
				
				model = (CampaignModel) in.readObject();
				
				in.close();
				inputStream.close();
				
				return model;
			} catch (Exception e) { e.printStackTrace(); }
		}
		
		return null;
	}
}
