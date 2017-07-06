/**
 * SameNode class that creates a node used by the PriceIndex and CompanyIndex
 * classes to store duplicate values for price and company name when creating a 
 * tree with those values. The SameNode does not hold any data just SameNode 
 * references to keep adding duplicates to a GenericNode and it holds the arrayIdx
 * to where the associated Wearable object is stored. 
 * @author Rohan Dhermy
 * @version (05/12/2017)
 */
public class SameNode {
    public SameNode same; 
    public int arrayIdx; 
    
    /**
     * Constructor for a SameNode node object 
     * @param arrayIdx 
     */
    public SameNode(int arrayIdx){
        this.same = null; 
        this.arrayIdx = arrayIdx; 
    }
}
