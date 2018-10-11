
public class ResizeableArray {
	private int count;
	private String[]elem;
	
	//Constructors
	public ResizeableArray(){
		count = 0;
		elem = new String[10];
	}
	
	//Method to add new words to this structure, resizing the array if necessary.
	public void add(String str){
		if(count >= elem.length){
			String[] temporary = new String [2*count];
			System.arraycopy(elem, 0, temporary, 0, elem.length);
			elem = temporary;
		}
		elem[count] = str;
		count++;
	}

	//Method returns the number of words that have been added.
	public int size(){
		return count;
	}
	
	//Method takes an index as a parameter and returns the word stored at that index in the underlying array.
	public String get(int position){
		return elem[position];
	}
}

