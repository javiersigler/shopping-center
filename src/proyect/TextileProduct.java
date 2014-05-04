package proyect;

public class TextileProduct extends Product {

	public String color;
	public String size;// Sizes are XS , S , M , L and XL.
	public String counter;
	
	// tipo de mostrador que se usará para su almacenaje , que puede ser table or shelve.
	// preguntar a brin proque se hace igual que con el iva. 

     public TextileProduct( String color,String size,String counter){
 		// No se que de llamar al superconstructor Product ?
 		
    	this.color=color;
    	this.size=size;
    	this.counter=counter;
     }
	
}
