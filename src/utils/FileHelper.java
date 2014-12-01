package utils;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import models.CampaignModel;

public final class FileHelper 
{
	private static final String FILE_EXTENSION = "cdm";
	
	public static void saveCampaign(CampaignModel model)
	{
		JFileChooser chooser = new JFileChooser();
		chooser.setFileFilter(new FileNameExtensionFilter("Campaign Data File (.cdm)", FILE_EXTENSION));
		
		if ( chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION )
		{
			try
			{
				FileOutputStream fileOut = new FileOutputStream(chooser.getSelectedFile() + "." + FILE_EXTENSION);
				ObjectOutputStream out = new ObjectOutputStream(fileOut);
				
				out.writeObject(model);
				
				out.close();
				fileOut.close();
				
				System.out.println("Done Saving");			// Change this to a real logger eventually
				
			}	catch(Exception e) { e.printStackTrace(); }
		}
	}
	
	public static CampaignModel loadCampaign()
	{
		JFileChooser chooser = new JFileChooser();
		chooser.setFileFilter(new FileNameExtensionFilter("Campaign Data File (.cdm)", FILE_EXTENSION));
		
		if ( chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION )
		{
			try
			{
				CampaignModel model = null;
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
