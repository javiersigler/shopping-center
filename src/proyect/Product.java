package proyect;
import java.util.Scanner;
import java.util.Arrays;

public class Product {
	
	public long code;
	public String activity_identifier;
	public String short_description; //SHORT DESCRIPTION
	public double price;
	public int IVA;
	public String [] shop_identifier_product;
    public String name;
    String brandGivenByUser;
    public String brand;
	
	public double final_price;
	
	//Constructor para CARD que pida nombre y precio, que se usará junto con una lista de fechas
	
	public Product (int iva){

        this.final_price = price + (price*iva)/100;

    }

    public Product (String brandGivenByUser){
        this.brand = brandGivenByUser.toLowerCase();
    }

    Scanner sc = new Scanner(System.in);
    int n = 0;

    public void shopsThatSell () {

        System.out.println("Introduce the shops that sell this brand. Type 'Supercalifragilisticoespialidoso' when you're done.");

        while (!sc.next().equals("Supercalifragilisticoespialidoso")) {
            shop_identifier_product[n] = sc.next();
            n++;
        }
        Arrays.sort(shop_identifier_product);


    }
}