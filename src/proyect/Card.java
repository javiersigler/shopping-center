package proyect;

public class Card {

	public String card_identifier;
	public String customer_name;
	public int points; //Customer hace call a points para ver el descuento
	public int discount; 

	/* El cliente va acumulando puntos mientras hace sus compras
	 * Decide cuando utilizar esos puntos
	 * Cuando lo hace, se le aplica el discount acumulado hasta entonces
	 */
	// Lista de productos comprados (Stack(?))( queue???)) o mejor dejarlo todo en arrays?
}
