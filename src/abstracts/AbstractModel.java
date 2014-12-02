package abstracts;

import java.util.ArrayList;

import javafx.collections.ObservableList;

public abstract class AbstractModel<T> 
{
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
