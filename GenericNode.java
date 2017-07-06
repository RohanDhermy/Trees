/**
 * GenericNode class that creates a node used by the PriceIndex and CompanyIndex
 * classes to create a tree assembled according to a Wearable's price or company  
 * name. It has a left node, a right node, and same node(that holds references to
 * Wearables with duplicate prices or company name with the use of a SameNodean),
 * a generic field that will either hold a String for company name or the Double 
 * for the price, and the array index of where the Wearable is located in the array. 
 * @author Rohan Dhermy
 * @version (05/12/2017)
 */
public class GenericNode<T> {
    public GenericNode left; 
    public GenericNode right; 
    public SameNode same; 
    public T data; 
    public int arrayIdx; 
    
    /**
     * Constructor for a GenericNode.
     * @param data generic data, will be either Double price or String company in
     * our case
     * @param arrayIdx the array index the associated Wearable object is stored 
     */
    public GenericNode(T data, int arrayIdx){
        this.left = null; 
        this.right = null; 
        this.same = null; 
        this.data = data; 
        this.arrayIdx = arrayIdx; 
    }
    
    /**
     * toString method that returns as a String the price or company name the 
     * Node is holding 
     * @return price or company
     */
    public String toString(){
        String result = String.valueOf(this.data);
        GenericNode current = this; 
        while(current.same != null){
            result += ", " + this.data;
            current.same = current.same.same; 
        }
        return result; 
    }
}
