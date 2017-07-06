/**
 * Class that creates a Wearable object and provides access methods that can be 
 * used to retrieve important field data 
 * @author Rohan Dhermy
 * @version (05/12/2017)
 */
import java.lang.Comparable; 
public class Wearable implements Comparable{
    private int ranking; 
    private String name; 
    private Double price; 
    private String bodyLocation; 
    private String category; 
    private String company; 
    private String url; 
    private String location; 
    private String city; 
    private String state; 
    private String country; 
    
    /**
     * Constructor for a Wearable object. 
     * @param ranking
     * @param name
     * @param price
     * @param bodyLocation
     * @param category
     * @param company
     * @param url
     * @param location
     * @param city
     * @param state
     * @param country 
     */
    public Wearable(int ranking, String name, Double price, String bodyLocation,
            String category, String company, String url, String location,
            String city, String state, String country){
        
        this.ranking = ranking; 
        this.name = name; 
        this.price = price; 
        this.bodyLocation = bodyLocation; 
        this.category = category; 
        this.company = company; 
        this.url = url; 
        this.location = location; 
        this.city = city; 
        this.state = state;
        this.country = country;
    }
    
    /**
     * Method that returns the ranking
     * @return ranking 
     */
    public int getRanking(){
        return this.ranking; 
    }
    
    /**
     * Method that returns the name
     * @return name 
     */
    public String getName(){
        return this.name; 
    }
    
    /**
     * Method that returns the price
     * @return price 
     */
    public double getPrice(){
        return this.price;
    }
    
    /**
     * Method that returns the bodyLocation
     * @return bodyLocation 
     */
    public String getBodyLocation(){
        return this.bodyLocation; 
    }
    
    /**
     * Method that returns the category
     * @return category 
     */
    public String getCategory(){
        return this.category; 
    }
    
    /**
     * Method that returns the company
     * @return company 
     */
    public String getCompany(){
        return this.company; 
    }
    
    /**
     * Method that returns the url
     * @return url 
     */
    public String getUrl(){
        return this.url; 
    }
    
    /**
     * Method that returns the location
     * @return location 
     */
    public String getLocation(){
        return this.location; 
    }
    
    /**
     * Method that returns the city
     * @return city 
     */
    public String getCity(){
        return this.city; 
    }
    
    /**
     * Method that returns the state
     * @return state 
     */
    public String getState(){
        return this.state; 
    }
    
    /**
     * Method that returns the country
     * @return country 
     */
    public String getCountry(){
        return this.country; 
    }
    
    /**
     * toString Method that returns information on a Wearable 
     * @return Wearable info
     */
    public String toString(){
        return String.format("%-5d%-10.2f%-10s%-15s", this.ranking, this.price, this.company, this.name);
    }
    
    /**
     * Wearable implements comparable and this is the compareTo method that allows
     * us to compare to Wearable objects by their rank
     * @param obj
     * @return their comparison 
     */
    @Override
    public int compareTo(Object obj) {
        if (obj instanceof Wearable){
            return this.ranking - ((Wearable) obj).ranking; 
        }
        else{
            throw new IllegalArgumentException("Has to be a Wearable object");
        }
    }
}
