/**
 * This is the main method that instantiates a Wearables object and then
 * we call instance methods to generate a tree according to ranking, price, and 
 * the company name. Main will also display the use of the searchByRanking, Price, 
 * and Company methods along with the get method; 
 * @author Rohan Dhermy
 * @version (05/12/17)
 */
public class Proj05_RohanDhermy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Wearables wearables = new Wearables(); 
        System.out.println("---------RANKING TREE--------------");
        System.out.println(wearables.displayByRank());
        System.out.println("---------PRICE TREE--------------");
        System.out.println(wearables.displayByPrice());
        System.out.println("---------COMPANY TREE--------------");
        System.out.println(wearables.displayByCompany());
        //wearables.printArray();
        System.out.println("----------SearchByRank------------\n"); 
        System.out.println(wearables.searchByRank(1)); 
        System.out.println(wearables.searchByRank(2));
        System.out.println(wearables.searchByRank(581));
        System.out.println(); 
        System.out.println("----------SearchByPrice------------\n"); 
        System.out.println(wearables.searchByPrice(19.99)); 
        System.out.println(wearables.searchByPrice(24.99));
        System.out.println(wearables.searchByPrice(99.99));
        System.out.println(); 
        System.out.println("----------SearchByCompany------------\n"); 
        System.out.println(wearables.searchByCompany("Belkin")); 
        System.out.println(wearables.searchByCompany("Samsung"));
        System.out.println(wearables.searchByCompany("Fitbit"));
        System.out.println();
        System.out.println("----------get()------------\n");
        System.out.println(wearables.get(1));
        System.out.println(wearables.get(300));
        System.out.println(wearables.get(581));
        System.out.println();
        System.out.println("---------Print range of values: Rank------\n"); 
        System.out.println(wearables.displayByRank(1, 10)); 
        System.out.println("---------Print range of values: Price------\n"); 
        System.out.println(wearables.displayByPrice(19.99, 119.99));
        System.out.println("---------Print range of values: Company------\n"); 
        System.out.println(wearables.displayByCompany("Belkin", "Samsung"));
    }
    
}
