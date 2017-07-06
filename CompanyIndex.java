/**
 * Class that creates a CompanyIndex object that creates a tree according to a 
 * Wearable's company name. 
 * @author Rohan Dhermy
 * @version (05/12/2017)
 */
public class CompanyIndex {
    private GenericNode root; 
    private Wearable[] wearableArray;
    
    /**
     * Constructor for a CompanyIndex object 
     */
    public CompanyIndex(Wearable[] wearableArray){
        this.root = null; 
        this.wearableArray = wearableArray; 
    }
    
    /**
     * public add method that allows Wearables class to add company in-order to 
     * make a tree and also pass the array index so that there is a reference to
     * the Wearable
     * @param newCompany company name added to tree in-order
     * @param arrayIdx the array index of where the Wearable is stored 
     */
    public void add(String newCompany, int arrayIdx){
        add(newCompany, arrayIdx, root); 
    }
    
    /**
     * Private add method that that does the work to add company in-order to 
     * make a tree and also pass the array index so that there is a reference to
     * the Wearable. Also makes sure duplicate companies are added as a SameNode 
     * @param newPrice company name added to tree in-order
     * @param arrayIdx the array index of where the Wearable is stored 
     */
    private void add(String newCompany, int arrayIdx, GenericNode startNode){
        GenericNode newNode = new GenericNode(newCompany, arrayIdx);
        if(root == null){
            root = newNode; 
        }
        else if(newCompany.compareTo((String)startNode.data) < 0){
            if(startNode.left == null){
                startNode.left = newNode; 
            }
            else{
                add(newCompany, arrayIdx, startNode.left);
            }
        }
        else if(newCompany.compareTo((String)startNode.data) == 0){
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
                add(newCompany, arrayIdx, startNode.right);
            }
        }
    }
    
    /**
     * Public search method that allows the Wearables class to search a tree by company name
     * @param searchCompany the company we are searching for 
     * @return the array index so Wearables can use it to find the corresponding 
     * Wearable object 
     */
    public int search(String searchCompany){
        return search(searchCompany, root);
    }
    
    /**
     * Private search method that does the work for public search method, 
     * allowing the Wearables class to search a tree by company name
     * @param searchPrice the company name we are searching for 
     * @return the array index so Wearables can use it to find the corresponding 
     * Wearable object 
     */
    private int search(String searchCompany, GenericNode startNode){
        if(startNode == null){
            return -1; 
        }
        else if(searchCompany.compareTo((String)startNode.data) == 0){
            return startNode.arrayIdx;
        }
        else if(searchCompany.compareTo((String)startNode.data) < 0){
            return search(searchCompany, startNode.left);
        }
        else{
            return search(searchCompany, startNode.right);
        }
    }
  
     /**
     * Public method that generates an in-order company tree
     * @return a String of the company tree as a list 
     */
    public String generateList(){
        String result = ""; 
        result += generateList(root);
        return result; 
    }
    
    /**
     * Private method that does the work for returning a String of the company tree
     * @param startNode start node the recursive call will use to move about the tree
     * @return String list/tree of the company tree
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
     * Public overloaded method that generates an in-order company tree within a range
     * @return a String of the company tree as a list within a range
     */
    public String generateList(String fromCompany, String toCompany){
        String result = ""; 
        result += generateList(fromCompany, toCompany, root);
        return result;
    }
    
    /**
     * Private overloaded method that does the work for returning a String of the company tree
     * within a range
     * @param startNode start node the recursive call will use to move about the tree
     * @return String list/tree of the company tree within a range
     */
    private String generateList(String fromCompany, String toCompany, GenericNode startNode){
        String result = ""; 
        if(startNode == null){
            return "";
        }
        else{
            result += generateList(fromCompany, toCompany, startNode.left);
            if((fromCompany.compareTo((String)startNode.data)) <= 0 && 
                    (toCompany.compareTo((String)startNode.data)) >= 0){
                result += wearableArray[startNode.arrayIdx] + "\n";
                GenericNode current = startNode; 
                while(current.same != null){
                    result += wearableArray[startNode.arrayIdx] + "\n";
                    current.same = current.same.same; 
                }
            }
            result += generateList(fromCompany, toCompany, startNode.right);
        }
        return result; 
    }
}
