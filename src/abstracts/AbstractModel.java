package abstracts;

import java.io.Serializable;
import java.util.ArrayList;

import javafx.collections.ObservableList;

public abstract class AbstractModel<T> implements Serializable
{
	private static final long serialVersionUID = 1668942002196166259L;
	private ArrayList<T> arrayList;
	
	public AbstractModel()
	{
		arrayList = new ArrayList<T>();
	}
	
	public ArrayList<T> getArrayList() 
	{
		return arrayList;
	}
	
	public void setArrayList(ObservableList<T> observableList) 
	{
		arrayList.clear();
		arrayList.addAll(observableList);
	}
}
