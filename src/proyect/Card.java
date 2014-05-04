package proyect;

public class Card {

	// the name of the customer is associated to the fidelity card (constructor)
	public String name;
	public String id;	
	public SList <BoughtProduct> listBroughtProducts;// Bought products whose points are still not used. 
	public SList <BoughtProduct> listBroughtProductsCurrentPurchase;
 
	public double accumulatedPoints =0;//constructor.
	public double pointsInThisPurchase; // With "This" I mean current.
	
	
	public static int pointRule1=50;  
	public static int pointRule2=200;          
	public static int pointRule3=1;
	public static int pointRule4=2;
	public static int pointRule5=3;
	

	
	/*If the product has a prize less than 50 euro , 1 point is assigned, between 50 and 200 euro , 2 points ,
	 * and over 200 , 3 points.
	 */
	
	
	
	
	
	
	public static double ratioPoints= 10;// minimum 10 points accumulated to apply discount.
    public static int maxNumberDiscount= 4;//  
    public double valueDicountEveryTenPoints= 0.05;// "10 points are equivalent to a 5% discount".
   
    public double maxDiscountWholePurchase= 0.20;/*" A maximum of 20% accumulated discounts can be applied 
                                                       to a customer for one acquisition. */



    
    public Card (StarCustomer starCustomer, String id, SList<BoughtProduct> listBroughtProducts,
    		             SList<BoughtProduct> listBroughtProductsCurrentPurchase){
    	
    	this.name= starCustomer.name;
    	this.id=id;
    	this.listBroughtProducts= listBroughtProducts;
    	this.listBroughtProductsCurrentPurchase=listBroughtProductsCurrentPurchase;
    	
    	
    }
    
    
}







	
	
	

