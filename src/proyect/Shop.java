package proyect;

public class Shop {

	public String name;
	public String id;//it´s a String because we don´t know if an identifier contains letters.
	public String area; 
	public ShopEmployee [] employeesList;
	public Catalog [] catalog ; //list of product types. 
	public double rent;
	public boolean state; //Opened or closed.
	public Product [] productsList; /*list of products available at the store . 
	                                   Not the same as the catalog */
	                                     
	
	public Shop(String name,String id,String area,ShopEmployee [] employeesList,Catalog [] catalog,  
			              double rent, boolean state,Product [] productsList){
		
		this.name=name;
		this.id=id;
		this.area=area;
		this.employeesList=employeesList;
		this.catalog=catalog;
		this.rent=rent;
		this.state=state;
		this.productsList=productsList;
		
	               }
	
                }
