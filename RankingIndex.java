/**
 * Class that creates a RankingIndex object that creates a tree according to a 
 * Wearable's rank. 
 * @author Rohan Dhermy
 * @version (05/12/2017)
 */
public class RankingIndex {
    private RankingNode root; 
    private Wearable[] wearableArray;
    
    /**
     * Constructor for a RankingIndex object 
     */
    public RankingIndex(Wearable[] wearableArray){
        this.root = null; 
        this.wearableArray = wearableArray; 
    }
    
    /**
     * public add method that allows Wearables class to add ranks in-order to 
     * make a tree and also pass the array index so that there is a reference to
     * the Wearable
     * @param newRanking rank added to tree in-order
     * @param arrayIdx the array index of where the Wearable is stored 
     */
    public void add(int newRanking, int arrayIdx){
        add(newRanking, arrayIdx, root); 
    }
    
    /**
     * Private add method that that does the work to add ranks in-order to 
     * make a tree and also pass the array index so that there is a reference to
     * the Wearable
     * @param newRanking rank added to tree in-order
     * @param arrayIdx the array index of where the Wearable is stored 
     */
    private void add(int newRanking, int arrayIdx, RankingNode startNode){
        RankingNode newNode = new RankingNode(newRanking, arrayIdx);
        if(root == null){
            root = newNode; 
        }
        else if(newRanking < startNode.data){
            if(startNode.left == null){
                startNode.left = newNode; 
            }
            else{
                add(newRanking, arrayIdx, startNode.left);
            }
        }
        else{
            if(startNode.right == null){
                startNode.right = newNode; 
            }
            else{
                add(newRanking, arrayIdx, startNode.right);
            }
        }
    }
    
    /**
     * Public search method that allows the Wearables class to search a tree by rank
     * @param searchRank
     * @return the array index so Wearables can use it to find the corresponding 
     * Wearable object 
     */
    public int search(int searchRank){
        return search(searchRank, root);
    }
    
    /**
     * Private search method that does the work for public search method, 
     * allowing the Wearables class to search a tree by rank
     * @param searchRank
     * @return the array index so Wearables can use it to find the corresponding 
     * Wearable object 
     */
    private int search(int searchRank, RankingNode startNode){
        if(startNode == null){
            return -1; 
        }
        else if(searchRank == startNode.data){
            return startNode.arrayIdx;
        }
        else if(searchRank < startNode.data){
            return search(searchRank, startNode.left);
        }
        else{
            return search(searchRank, startNode.right);
        }
    }
  
    /**
     * Public method that generates an in-order ranking tree
     * @return a String of the ranking tree as a list 
     */
    public String generateList(){
        return generateList(root);
    }
    
    /**
     * Private method that does the work for returning a String of the ranking tree
     * @param startNode start node the recursive call will use to move about the tree
     * @return String list/tree of the ranking tree
     */
    private String generateList(RankingNode startNode){
        if(startNode == null){
            return "\n";
        }
        else{
            return generateList(startNode.left) + wearableArray[startNode.arrayIdx] + generateList(startNode.right);
        }
    }
  
    /**
     * Public overloaded method that generates an in-order ranking tree within a range
     * @return a String of the ranking tree as a list within a range 
     */
    public String generateList(int fromRank, int toRank){
        String result = "";  
        result += generateList(fromRank, toRank, root);
        return result; 
    }
    
    /**
     * Private overloaded method that does the work for returning a String of the ranking tree
     * within a range
     * @param startNode start node the recursive call will use to move about the tree
     * @return String list/tree of the ranking tree within a range
     */
    private String generateList(int fromRank, int toRank, RankingNode startNode){
        String result = ""; 
        if(startNode == null){
            return "";
        }
        else{
            result += generateList(fromRank, toRank, startNode.left);
            if(startNode.data >= fromRank && startNode.data <= toRank){
                result += wearableArray[startNode.arrayIdx]+"\n";
            }
            result += generateList(fromRank, toRank, startNode.right);
        }
        return result; 
    }
}
