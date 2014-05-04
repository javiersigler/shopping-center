package proyect;
import java.util.Scanner;
public class ShoppingCentre {

	public String name;
	public String address; 
	public String shop_identifier_shopping_center;//corregir!!!
	//Catálogo con productos ofrecidos (Clase + Atributos)
	public int access_doors;
	public int emergency_exits_number;
	public int parking_places_number;
	
	private Shop [] shop_center_list;
	private Employee [] employees_list;
	private StarCustomer [] star_customer_list;
	
	Scanner sc = new Scanner(System.in);
	
	
	//convertirlo luego todo a privado
	
	public ShoppingCenter(int N, int M, int P){
		
		shop_center_list = new Shop [N];
		employees_list = new Employee [M];
		star_customer_list = new StarCustomer [P];
		
		}
	
	int i;
	
	public void printShopData (){
		System.out.println("Do you want us to show all the shop data? (Y/N)");
		
		if(sc.next().equals("Y")){
			
		System.out.println("Name:" + shop_center_list[i].name);
		System.out.println("Shop Identifier:" + shop_center_list[i].shop_identifier);
		System.out.println("Shop Area:" + shop_center_list[i].shop_area);
		System.out.println("List of Working Employees" + Arrays.toString(shop_center_list[i].working_employees_set));
		System.out.println("Rent:" + shop_center_list[i].rent);
		System.out.println("State:" + shop_center_list[i].state);
		
		}
	}

	
	public Shop searchStore (String name){

		for (i = 0; i<shop_center_list.length; i++){
			if (shop_center_list[i].name.equals(name)){

					printShopData();

				return shop_center_list[i];
			}


		}
		return null;
	}

    public void searchEmployeesShops(ShopEmployee shopemployee1){

        System.out.println(Arrays.toString(shopemployee1.shop_identifier_shop_employee));

    }

    public void searchShopByBrand (String userbrand){

        for (int i = 0; i<0 ; i++){
            if ( ){


            }
        }

    }

    public void searchEmployeesByShoppingCenter(ShoppingCenter shoppingcenter) {
        System.out.println(Arrays.toString(employees_list)); //Returns all the employees in a shopping center
    }

    public Employee searchAllEmployees (ShoppingCenter shoppingcenter) {
        return null;
    }	
	
		
	
}
