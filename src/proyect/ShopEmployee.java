package proyect;
import java.util.Arrays;
import java.util.Scanner;




public class ShopEmployee extends Employee {
	
	String prefix = "T";
	
	public String identifier;
	public String status; //Shop manager/Staff
	public String [] shop_identifier_shop_employee; // Escrito como un array, hay que crear un método que meta los valores dentro (tiendas)

    Scanner sc = new Scanner(System.in);

    public ShopEmployee (String identifier_number){

        this.identifier = prefix + identifier_number;


    }
    public int n = 0;
    public void shopsWhereWorks () {

        System.out.println("Introduce the name of the shop in which the employee is working, all together using spaces." +
                "Type 'Supercalifragilisticoespialidoso' When you are done.");

        while (!sc.next().equals("Supercalifragilisticoespialidoso")) {
            shop_identifier_shop_employee[n] = sc.next();
            n++;
        }
        Arrays.sort(shop_identifier_shop_employee);


    }

}

