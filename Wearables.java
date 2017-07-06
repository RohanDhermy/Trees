/**
 * Class that creates a Wearables object. The Wearables object reads a text file
 * of Wearables and creates Wearable objects and stores them in an array. The
 * object then makes use of the Index classes to generate ranking, price, and 
 * company name based trees and also allows searching those trees by price, rank,
 * and company name for Wearable objects 
 * @author Rohan Dhermy
 * @version (05/12/2017)
 */
import java.util.Scanner; 
import java.io.File; 
import java.io.FileNotFoundException; 
import java.util.Arrays;

public class Wearables {
    private Wearable[] wearableArray; 
    private int arraySize;
    private RankingIndex rankingIndex; 
    private PriceIndex priceIndex; 
    private CompanyIndex companyIndex; 
    
    /**
     * Constructor for Wearables object. Uses private methods like readFromFile 
     * and add to create Wearable objects and store them in an array 
     */
    public Wearables(){
       readFromFile("Wearables.txt");
       this.rankingIndex = generateRankingTree(); 
       this.priceIndex = generatePriceTree(); 
       this.companyIndex = generateCompanyTree(); 
    }
    
    /**
     * Method to add a Wearable object to the wearableArray
     * @param index the location the Wearable object will be stored 
     * @param newWearable Wearable object being added 
     */
    private void add(int index, Wearable newWearable){
        this.wearableArray[index] = newWearable; 
    }
    
    /**
     * Method used by Wearables constructor that reads from a text file to create
     * Wearable objects and add them to the wearableArray
     * @param fileName the fileName to read 
     */
    private void readFromFile(String fileName){
        try{
            Scanner inFile = new Scanner(new File(fileName));
            this.arraySize = inFile.nextInt(); 
            this.wearableArray = new Wearable[arraySize]; 
            inFile.nextLine(); 
            inFile.nextLine();
            int ranking = 0; 
            String name = ""; 
            Double price = 0.0; 
            String bodyLocation = ""; 
            String category = ""; 
            String company = ""; 
            String url = ""; 
            String location = ""; 
            String city = ""; 
            String state = "";
            String country = ""; 
            int index = 0; 
            while(inFile.hasNextLine()){
                String line = inFile.nextLine(); 
                Scanner lineScanner = new Scanner(line);
                lineScanner.useDelimiter("@");
                if(lineScanner.hasNextInt()){
                    ranking = lineScanner.nextInt();
                }
                if(lineScanner.hasNext()){
                    name = lineScanner.next();
                }
                if(lineScanner.hasNextDouble()){
                    price = lineScanner.nextDouble();
                }
                if(lineScanner.hasNext()){
                    bodyLocation = lineScanner.next();
                }
                if(lineScanner.hasNext()){
                    category = lineScanner.next();
                }
                if(lineScanner.hasNext()){
                    company = lineScanner.next();
                }
                if(lineScanner.hasNext()){
                    url = lineScanner.next();
                }
                if(lineScanner.hasNext()){
                    location = lineScanner.next();
                }
                if(lineScanner.hasNext()){
                    city = lineScanner.next();
                }
                if(lineScanner.hasNext()){
                    state = lineScanner.next();
                }
                if(lineScanner.hasNext()){
                    country = lineScanner.next();
                }
                Wearable newWearable = new Wearable(ranking, name, price,
                        bodyLocation, category, company, url, location, city, 
                            state, country); 
                add(index, newWearable); 
                index++; 
            }
        }catch(FileNotFoundException e){
            System.out.println("[]"); 
        }
    }
    
    /**
     * Method that instantiates a RankingIndex object and uses it's add method 
     * to add and create a tree based on a Wearable's rank
     * @return a list/tree of Wearable's by rank
     */
    public RankingIndex generateRankingTree(){
        RankingIndex rankingTree = new RankingIndex(this.wearableArray); 
        for(int idx = 0; idx < arraySize; idx++){
            rankingTree.add(this.wearableArray[idx].getRanking(), idx);
        }
        return rankingTree;
    }
    
    /**
     * Method that instantiates a PriceIndex object and uses it's add method 
     * to add and create a tree based on a Wearable's price
     * @return a list/tree of Wearable's by price
     */
    public PriceIndex generatePriceTree(){
        PriceIndex priceTree = new PriceIndex(this.wearableArray); 
        for(int idx = 0; idx < arraySize; idx++){
            priceTree.add(this.wearableArray[idx].getPrice(), idx);
        }
        return priceTree;
    }
 
    /**
     * Method that instantiates a CompanyIndex object and uses it's add method 
     * to add and create a tree based on a Wearable's company name
     * @return a list/tree of Wearable's by company name
     */
    public CompanyIndex generateCompanyTree(){
        CompanyIndex companyTree = new CompanyIndex(this.wearableArray); 
        for(int idx = 0; idx < arraySize; idx++){
            companyTree.add(this.wearableArray[idx].getCompany(), idx);
        }
        return companyTree;
    }
    
    /**
     * Search method that traverses the ranking tree and returns the Wearable 
     * with the passed in rank 
     * @param rank search Wearable object by rank 
     * @return Wearable with that rank 
     */
    public Wearable searchByRank(int rank){
        int idx = this.rankingIndex.search(rank);
        if(idx == -1){
            return null; 
        }
        return wearableArray[idx];
    }
    
    /**
     * Search method that traverses the price tree and returns the Wearable 
     * with the passed in price 
     * @param price search Wearable object by price
     * @return Wearable with that price 
     */
    public Wearable searchByPrice(Double price){
        int idx = this.priceIndex.search(price); 
        if(idx == -1){
            return null; 
        }
        return wearableArray[idx]; 
    }
    
    /**
     * Search method that traverses the company tree and returns the Wearable 
     * with the passed in company name 
     * @param company search Wearable object by company name 
     * @return Wearable with that company name 
     */
    public Wearable searchByCompany(String company){
        int idx = this.companyIndex.search(company);
        if(idx == -1){
            return null; 
        }
        return wearableArray[idx];
    }
    
    /**
     * Get a Wearable by it's index 
     * @param index of the Wearable in the array 
     * @return Wearable 
     */
    public Wearable get(int index){
        return wearableArray[index];
    }
    
    /**
     * Method that returns a String representation of the tree by rank
     * @return tree by rank 
     */
    public String displayByRank(){
        return this.rankingIndex.generateList(); 
    }
    
    /**
     * Method that returns a String representation of the tree in a range of rank
     * @return tree by rank(in a range)
     */
    public String displayByRank(int fromRank, int toRank){
        return this.rankingIndex.generateList(fromRank, toRank); 
    }
    
    /**
     * Method that returns a String representation of the tree by price
     * @return tree by price 
     */
    public String displayByPrice(){
        return this.priceIndex.generateList(); 
    }
    
    /**
     * Method that returns a String representation of the tree in a price range
     * @return tree by price range
     */
    public String displayByPrice(Double fromPrice, Double toPrice){
        return this.priceIndex.generateList(fromPrice, toPrice); 
    }
    
    /**
     * Method that returns a String representation of the tree by company name
     * @return tree by company name
     */
    public String displayByCompany(){
        return this.companyIndex.generateList(); 
    }
    
    /**
     * Method that returns a String representation of the tree in a company name range
     * @return tree by company name(in a range) 
     */
    public String displayByCompany(String fromCompany, String toCompany){
        return this.companyIndex.generateList(fromCompany, toCompany); 
    }
    
}
