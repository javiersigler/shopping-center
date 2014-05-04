package proyect;

public class Product {

	public String idCode;
	public String id; // the same id as in ProductType class .
	public String briefDescription; // it is important to say brief. 
	// tipo de Iva ( preguntar a Brin o a quien sea  como se haria eso, era algo del ENUM? )
	
	public String shopId; // id of the shop the product belongs to . 
	
	public Product(String idCode,String id, String briefDescription,String shopId){
		
		this.idCode=idCode;
		this.id=id;
		this.briefDescription=briefDescription;
		this.shopId=shopId;
		
	    }


}
