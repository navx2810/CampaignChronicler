package abstracts;

import java.util.ArrayList;
import java.util.Iterator;

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
		Iterator<T> iterator = observableList.iterator();
		while( iterator.hasNext() )
			arrayList.add( iterator.next() );
	}
}
