/**
 * RankingNode class that creates a node used by the RankingIndex class to create
 * a tree assembled according to a Wearable's rank. The RankingNode has a left 
 * node, a right node, an integer rank, and an integer arrayIdx as it's field. 
 * @author Rohan Dhermy
 * @version (05/12/2017)
 */
public class RankingNode {
    public RankingNode left; 
    public RankingNode right; 
    public int data; 
    public int arrayIdx; 
    
    /**
     * RankingNode constructor. Makes sure rank cannot be 0 or less 
     * @param data the rank
     * @param arrayIdx the array index the associated Wearable object is stored 
     */
    public RankingNode(int data, int arrayIdx){
        if (data <= 0){
            throw new IllegalArgumentException("Rank has to be more than 0"); 
        }
        this.left = null; 
        this.right = null;
        this.data = data; 
        this.arrayIdx = arrayIdx; 
    }
    
    /**
     * toString method that returns the rank the Node is holding as a String 
     * @return rank
     */
    public String toString(){
        return Integer.toString(this.data); 
    }
}
