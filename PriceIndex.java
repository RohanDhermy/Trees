/**
 * Class that creates a PriceIndex object that creates a tree according to a 
 * Wearable's price. 
 * @author Rohan Dhermy
 * @version (05/12/2017)
 */
public class PriceIndex {
    private GenericNode root; 
    private Wearable[] wearableArray;
    
    /**
     * Constructor for a PriceIndex object 
     */
    public PriceIndex(Wearable[] wearableArray){
        this.root = null; 
        this.wearableArray = wearableArray; 
    }
    
    /**
     * public add method that allows Wearables class to add price in-order to 
     * make a tree and also pass the array index so that there is a reference to
     * the Wearable
     * @param newPrice price added to tree in-order
     * @param arrayIdx the array index of where the Wearable is stored 
     */
    public void add(double newPrice, int arrayIdx){
        add(newPrice, arrayIdx, root); 
    }
    
    /**
     * Private add method that that does the work to add price in-order to 
     * make a tree and also pass the array index so that there is a reference to
     * the Wearable. Also makes sure duplicate prices are added as a SameNode 
     * @param newPrice price added to tree in-order
     * @param arrayIdx the array index of where the Wearable is stored 
     */
    private void add(double newPrice, int arrayIdx, GenericNode startNode){
        GenericNode newNode = new GenericNode(newPrice, arrayIdx);
        if(root == null){
            root = newNode; 
        }
        else if(Double.compare(newPrice, (Double)startNode.data) < 0){
            if(startNode.left == null){
                startNode.left = newNode; 
            }
            else{
                add(newPrice, arrayIdx, startNode.left);
            }
        }
        else if(Double.compare(newPrice, (Double)startNode.data) == 0){
            SameNode newSameNode = new SameNode(arrayIdx);
            if(startNode.same == null){
                startNode.same = newSameNode; 
            }
            else{
                SameNode current = startNode.same; 
                while(current.same != null){
                    current = current.same;
                }
                current.same = newSameNode; 
            }
        }
        else{
            if(startNode.right == null){
                startNode.right = newNode; 
            }
            else{
                add(newPrice, arrayIdx, startNode.right);
            }
        }
    }
    
    /**
     * Public search method that allows the Wearables class to search a tree by price
     * @param searchPrice the price we are searching for 
     * @return the array index so Wearables can use it to find the corresponding 
     * Wearable object 
     */
    public int search(Double searchPrice){
        return search(searchPrice, root);
    }
    
    /**
     * Private search method that does the work for public search method, 
     * allowing the Wearables class to search a tree by price
     * @param searchPrice the price we are searching for 
     * @return the array index so Wearables can use it to find the corresponding 
     * Wearable object 
     */
    private int search(Double searchPrice, GenericNode startNode){
        if(startNode == null){
            return -1; 
        }
        else if(Double.compare(searchPrice, (Double)startNode.data) == 0){
            return startNode.arrayIdx;
        }
        else if(Double.compare(searchPrice, (Double)startNode.data) < 0){
            return search(searchPrice, startNode.left);
        }
        else{
            return search(searchPrice, startNode.right);
        }
    }
    
    /**
     * Public method that generates an in-order price tree
     * @return a String of the price tree as a list 
     */
    public String generateList(){
        String result = ""; 
        result += generateList(root);
        return result; 
    }
    
    /**
     * Private method that does the work for returning a String of the price tree
     * @param startNode start node the recursive call will use to move about the tree
     * @return String list/tree of the price tree
     */
    private String generateList(GenericNode startNode){
        String result = ""; 
        if(startNode == null){
            return "\n";
        }
        else{
            result += generateList(startNode.left);
            result += wearableArray[startNode.arrayIdx] + "\n";
             GenericNode current = startNode; 
                while(current.same != null){
                    result += wearableArray[startNode.arrayIdx] + "\n";
                    current.same = current.same.same; 
                }
            result += generateList(startNode.right);
        }
        return result; 
    }
    
    /**
     * Public overloaded method that generates an in-order price tree within a range
     * @return a String of the price tree as a list within a range
     */
    public String generateList(Double fromPrice, Double toPrice){
        String result = ""; 
        result += generateList(fromPrice, toPrice, root);
        return result; 
    }
    
    /**
     * Private overloaded method that does the work for returning a String of the price tree
     * within a range
     * @param startNode start node the recursive call will use to move about the tree
     * @return String list/tree of the price tree within a range
     */
    private String generateList(Double fromPrice, Double toPrice, GenericNode startNode){
        String result = ""; 
        if(startNode == null){
            return "";
        }
        else{
            result += generateList(fromPrice, toPrice, startNode.left);
            if(Double.compare((Double)startNode.data, fromPrice) >= 0 && 
                    Double.compare((Double)startNode.data, toPrice) <= 0){
                result += wearableArray[startNode.arrayIdx] + "\n";
                GenericNode current = startNode; 
                while(current.same != null){
                    result += wearableArray[startNode.arrayIdx] + "\n";
                    current.same = current.same.same; 
                }
            }
            result+= generateList(fromPrice, toPrice, startNode.right);
        }
        return result; 
    }
}
