package proyect;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
// lo del extends es un apaño para remendar un error , como se importa una clase?buscar!!

public class ShoppingCentre extends SList{

	public String name;
	public String address; 	
	public int accessDoors;
	public int emergencyExits;
	public int parkingPlaces;
	
	public Shop [] shopsList;
	public CentreEmployee [] employeesCentreList; // sorted by Salaries.
	public StarCustomer [] starCustomerList;
	
	Scanner sc = new Scanner(System.in);
	
	
	//convertirlo luego todo a privado(una vez acabada la parte tres!!!!)
	
	
	//Constructor.
	public void ShoppingCenter(String name, String address, int accessDoors,int parkingPlaces, 
			                          int N, int M, int P){ 
		this.name=name;
		this.address=address;
		this.accessDoors=accessDoors;
		this.parkingPlaces=parkingPlaces;
		
		// We establish the lengths off these arrays when creating a shopping center as the guide says.
		
		shopsList= new Shop [N];  
		employeesCentreList= new CentreEmployee [M];
		starCustomerList = new StarCustomer [P];
		
		}
	
	
	
	
	//Additional Methods

	int i; // a "counter" for all the loops. The rest of ints below have the same purpose.
	int j;
	int a;
	int b;
	
	String word;// used when the name of a shop ,employee or brand is not found ("shop","employee","brand").
	
	
	
	public void printShoppingCenterEmployeeData(CentreEmployee centreEmployee){
		
		System.out.println("Name"+centreEmployee.name);
		System.out.println("Surmanes"+centreEmployee.surnames);
		System.out.println("DNI"+centreEmployee.DNI);
		System.out.println("Adress"+centreEmployee.address);
		System.out.println("Telephone Number"+centreEmployee.telephoneNumber);
		System.out.println("Social Insurance Number"+centreEmployee.socialInsuranceNnumber);
		System.out.println("Workshift"+centreEmployee.workShift);
		System.out.println("Salary"+centreEmployee.salary);
		System.out.println("Shopping Center name"+centreEmployee.shoppingCentreName);
		System.out.println("ID"+centreEmployee.idPrefix + centreEmployee.name);
		System.out.println();
		System.out.println();	
	
	}
	
	public void printShopEmployeeData(ShopEmployee shopEmployee){

		System.out.println("Name"+shopEmployee.name);
		System.out.println("Surmanes"+shopEmployee.surnames);
		System.out.println("DNI"+shopEmployee.DNI);
		System.out.println("Adress"+shopEmployee.address);
		System.out.println("Telephone Number"+shopEmployee.telephoneNumber);
		System.out.println("Social Insurance Number"+shopEmployee.socialInsuranceNnumber);
		System.out.println("Workshift"+shopEmployee.workShift);
		System.out.println("Salary"+shopEmployee.salary);
		System.out.println("List of shops this employee works:");
		traverseAndPrintShopNames(shopEmployee.shopsEmployeeWorks);
		System.out.println("ID"+shopEmployee.idPrefix + shopEmployee.name);
		System.out.println();
		System.out.println();	
	
	}
	
	public void traverseAndPrintShopNames(String [] shopsEmployeeWorks){// Prints arrays containing names of shops.
		for( i =0; i<shopsEmployeeWorks.length; i++){ 
			if(i==0){
				System.out.println(shopsEmployeeWorks[i]+","+""); // Starts printing the array in a new line with respect the rest of employees data.
			}
			else{
			System.out.print(shopsEmployeeWorks[i]+","+"");
			
			}
		}
	}
	
	
	
	public void emptyList ( String word){
		System.out.println("This"+ word+"is not found in this shopping center");
	}
	
	
	
	
	public void traverseAndPrintListNames(SList <Shop> shopsEmployeeWorks){ // Prints the name of the shop of a list of type Shop.
		
		for (SNode<Shop> node = shopsEmployeeWorks.getFirstNode(); node != null; node = node.nextNode){
			System.out.print(node.getElement().name+","+"");
		         
		       }
			}
	
	
	public void traverseAndPrintListNamesAndSurnames(SList <String> allEmployeesNames){
		 
		for (SNode<String> node = allEmployeesNames.getFirstNode(); node != null; node = node.nextNode){
			System.out.print(node.getElement());
		         
		       }
	         }
	
	
	
	
	
	
	
	public void traverseAndPrint(ShopEmployee [] employeesList){ //Prints the name of all the employees from "list of employees" of a specific shop.
		                                                              
		for( i =0; i<employeesList.length; i++){ 
			if (i==0){
				System.out.println(employeesList[i].name+""+ employeesList[i].surnames+","+"");	/* Starts printing the array in a new line with respect 
				                                                                                            the rest of the shop data*/
			}
		
			else{
			System.out.print(employeesList[i].name+""+ employeesList[i].surnames+","+"");
			
			                            }
		                             }
	                              }
	
		
	
	public void askUserShopsData(SList <Shop> shopsEmployeeWorks ){// If the user wants , all data shop will be given.
		System.out.println("Do you want us to show all the shops data? (Y/N)");
		
		if(sc.next().equalsIgnoreCase("Y")){
	 
			// we traverse the whole list , get its elements and call another method to print them 
			for(SNode<Shop> node = shopsEmployeeWorks.getFirstNode(); node != null; node = node.nextNode){              
				printShopData(node.getElement());
			
			}	    
		}
	}
	
	
	
	public void printShopData(Shop shop){ // Receives a shop and prints all its data;
			
		System.out.println("Name:" + shop.name);
		System.out.println("Shop Identifier:" + shop.id);
		System.out.println("Shop Area:" + shop.area);
		System.out.println("List of Working Employees:");
		traverseAndPrint(shop.employeesList);
		System.out.println("Rent:" + shop.rent);
		System.out.println("State:" + shop.state);
		System.out.println(); // To separate shops if there is more than one to print.
		System.out.println();
	
	}

	
	
	
	
	// Mandatory methods 
	
	public Shop searchStore (String name){ /* Receives the name of a store and returns a reference to the Shop object
	                                             it can also print all the data of that Shop (if the user wants)*/
      
	   Shop shop1= new Shop(); // We prepare the comparator so that the binary search along the list of shops works .
       shop1.name= name;
       Comparator<Shop> compareByName1 = new Comparator<Shop>() {
			@Override
			public int compare(Shop o1, Shop o2) {
				return o1.name.compareToIgnoreCase(o2.name);
			
			}
	};
      
	   Arrays.sort(shopsList, compareByName1);
       int index = Arrays.binarySearch(shopsList, shop1, compareByName1);/* This binary search returns the index (in the array) of the 
		                                                                      the shop whose name we were looking for*/     
       
       if (index<0){ // if index<0 , the shop does not exist , so we return null as the guide says.                                                      
	        
			return null;
		 }
		                    
		 else { 	
			 System.out.println("Do you want us to show all the shop data? (Y/N)");
				
				if(sc.next().equalsIgnoreCase("Y")){
			 
					printShopData(shopsList[index]);
			    
				   }
				}

			return shopsList[index]; 
			
		 }
	
	

	
	
	
	public void searchEmployeeShops(String name){/*Receives the name of an employee and returns a list of shops where the 
	                                                        employee works*/
		
		 public SList <Shop> shopsEmployeeWorks = new SList <Shop>();

		 ShopEmployee shopEmployee1= new ShopEmployee( ); // We prepare the comparator so that the binary search along the list of shops works .
		 shopEmployee1.name = name;
	       Comparator<ShopEmployee> compareByName2 = new Comparator<ShopEmployee>() {
				@Override
				public int compare(ShopEmployee o1, ShopEmployee o2) {
					return o1.name.compareToIgnoreCase(o2.name);
					
					for ( i =0 ; i < shopsList.length;i++){// traversing all the shops 
						
						  
							Arrays.sort(shopsList[i].employeesList,compareByName2);
						       int index = Arrays.binarySearch(shopsList[i].employeesList,shopEmployee1, 
						    		                 compareByName2);
			
						       if (index>=0){/* If the name of that employee is inside the list of employees of the shop we are  checking , 
						    	                   we put that shop in a dynamic list */
						    	      
						    	   shopsEmployeeWorks.addLast(shopsList[i]);
						                         
						                      }    
						                   }
			
			        if(ShopsEmployeeWorks.getSize()==0){// "This employee does not exist in this shopping center"
						word= "employee";					
						emptyList(word);
					       }
					
					// now we print the list and ask the user about shop info.
					else {
						
						traverseAndPrintListNames(shopsEmployeeWorks);
						askUserShopsData(shopsEmployeeWorks);
	 
					       }
				         }
	                     
	    /* It is very obvious that the parameter should be the name of a shop employee and not one of a center employee. 
	     Taking into account this and the things we are asked for in the guide for this method , 
	                   we are only going to search in the list of employees of Shops .*/
	
	
					
	
	   public void searchShopByBrand(String name){ //Receives the name of a bran and gives the shops whose products have that brand.

		 public SList <Shop> shopsSellingThatBrand = new SList<Shop>();
		
		
		 Catalog catalog1= new Catalog ( ); // We prepare the comparator so that the binary search along the list of shops works .
	       catalog1.brand= name;
	       Comparator<Catalog> compareByName3 = new Comparator<Catalog>() {
				@Override
				public int compare(Catalog o1, Catalog o2) {
					return o1.name.compareToIgnoreCase(o2.name);
				
				}
		};
	      
		
		for ( i =0 ; i < shopsList.length;i++){
			
		   Arrays.sort(shopsList[i].catalog,compareByName3);
	       int index = Arrays.binarySearch(shopsList[i].catalog, catalog1, compareByName3);
	                  
	       if (index>=0){ /* If a product from the catalog has the given brand  of the shop we are  
                                   checking , we put the name of that shop in a dynamic list */
  
	    	   shopsSellingThatBrand.addLast(shopsList[i]);
	    	                         
	                                }
                                  } 
		                       	      
	       if(ShopsEmployeeWorks.getSize()==0){ // "This brand does not exist in this shopping center"
				word="brand";
				emptyList(word);
			}
	       
	       else {
	    	   
	    	   traverseAndPrintListNames(shopsSellingThatBrand);
	    	   askTheUserShopsData(shopsSellingThatBrand);  
	
		       }
	   
	   
	
	
	public void searchEmployeesByShoppingCenter(ShoppingCentre shoppingCentre){ /*List with the data for all shopping center employees 
		                                                                                         in a given shopping center  */
			for( i =0 ; i < shoppingCentre.employeesCentreList.length;i++){
			printShoppingCentreEmployeeData(shoppingCentre.employeesCentreList[i]);
		
			
			}
	     }
	
	   
	
	public  void searchAllEmployees(ShoppingCentre shoppingCentre){
	
		public SList <String> allEmployeesNames = new SList <String>();
		
		for(i=0;i<shoppingCentre.employeesCentreList.length; i++){ // Adds all center employees' names ( with surname)
			
			allEmployeesNames.addLast(employeesCentreList[i].name + ""+ employeesCentreList[i].surnames);
		
	/*Now , as the guide says , We have to offer data´s employee for every employee separately . In other words, " The method must provide an option
	 * to print or hide the data for each employee .        
	 */
		
			System.out.println("Do you want us to show all the data for" + employeesCentreList[i].name +
					                  ""+ employeesCentreList[i].surnames +" ? (Y/N)");
			
			if(sc.next().equalsIgnoreCase("Y")){
		 
				printShoppingCenterEmployeeData(employeesCentreList[i]);
		    
			   }
		
		}
		
		
		
		for(i=0;i<shoppingCentre.shopsList.length; i++){ // Adds all shopping centers' shop  employees' names (with surname)
		  for(j=0; j<shopsList[i].employeesList.length; j++){
			  addLast(shopsList[i].employeesList[j].name +""+ shopsList[i].employeesList[j].surnames);
			  
			  
			  System.out.println("Do you want us to show all the data for" +shopsList[i].employeesList[j].name + ""+ 
			                        shopsList[i].employeesList[j].surnames+" ? (Y/N)");
				
				if(sc.next().equalsIgnoreCase("Y")){
					
					printShopEmployeeData(shopsList[i].employeesList[j]);
			    
				                                   }
			  		  
		                                        }
				
		                                    }
		
		            traverseAndPrintListNamesAndSurnames(allEmployeesNames);
	                                    
	                                   }
	
	
	
	
	
	public static int topSalaries=5;
	
	public void searchEmployeesWithBiggerSalary(){
	
	public SList <Double> allSalariesAllEmployeesList = new SList <Double>();// esto tendria que ser double y no Double.	
		
	for(i=0;i<employeesCentreList.length;i++){ // We add all shopping center employees' salaries to the created list. 
		allSalariesAllEmployeesList.addLast(employeesCentreList[i].salary);
	                  
	                       }
	
	for(i=0;i<shopsList.length; i++){ // We add all shop employees' salaries to the created list.
	 for(j=0;j<shopsList[i].employeesList.length;j++){
		 allSalariesAllEmployeesList.addLast(shopsList[i].employeesList[j].salary); 
	                  
	                   }
	                 }
	
	public double [] allSalariesAllEmployeesArray = new double [allSalariesAllEmployeesList.getSize() ]; //An array of salaries to be sorted.
	   
	     i=0;
	 for (SNode<Double> node = allSalariesAllEmployeesList.getFirstNode(); node != null; node = node.nextNode){//Adds the salaries from the list to the new array.
		     
		       allSalariesAllEmployeesArray[i]= node.getElement();
	     
	                             }
	
	        Arrays.sort(allSalariesAllEmployeesArray);
	                         
	                        }
	
	public SList <double> usedSalaries = new SList <double>();// This list will have different numbers, any of them is repeated.
	public SList <String> topSalariesCentreEmployees = SList <String>();
	public SList <String> topSalariesShopEmployeesRepetitions = SList <String>(); // As shop employees can work at many shops , this list may have repeated names.
	
	/* There can be cases where salaries are repeated ( two or more different employees have the same salary). Now that we are going to link
	 *  salaries from the first array with their corresponding employees' names and surnames , we should not repeat names nor surnames.
	 *  That is the reason why we have created the list "usedSalaries". 
	 */
	
	// In this for We only pick the five biggest salaries.
	
	for(j=allSalariesAllEmployeesArray.lenght-1; j=allSalariesAllEmployeesArray.lenght-5; j--){// And now let's compare with the data of the system.
		int counter=0;	
		
		for(SNode<double> node = usedSalaries.getFirstNode(); node != null; node = node.nextNode){ // Let´s see if the current salary has already been used.
			
			if(allSalariesAllEmployeesArray[j]!= node.getElement()){
				counter++;
			           }
					
		             }
		
		
		
		
		if (counter==usedSalaries.getSize()){/* If the current value is different from the others that we have already used, starts adding employees names,else,
			                                      does nothing especial and go directly to the next salary*/
		
			
			for(i=0; i<employeesCentreList.length;i++){
				if(allSalariesAllEmployeesArray[j]== employeesCentreList[i].salary){ // Comparing with employeesCentreList.
					topSalariesCentreEmployees.addLast(employeesCentreList[i].name+""+employeesCentreList[i].surnames);	
				                    }
			for(a=0;a<shopsList.length;a++)	{//  The same with all the lists of shops with lists of shop employees of type ShopEmployee.
				for(b=0; b<shopsList[a].employeesList.length;b++){
					if(allSalariesAllEmployeesArray[j]== shopsList[a].employeesList[b].salary){
						topSalariesShopEmployeesRepetitions.addLast(shopsList[a].employeesList[b].name+""+shopsList[a].employeesList[b].surnames);
						
					                  }
				                   }
				
			                    }
		 
			usedSalaries.addLast (allSalariesAllEmployeesArray[j]); /* As the current salary has not been used , We can put it in usedSalaries list so that we 
			                                                                do no repeat values.*/
				
			                }
		
		                  }
	
		public SList <String> topSalariesShopEmployees =new SList <String>();
		
		/* As we said , there are shop employees that work in many shops . 
		  * to avoid the repetition of names  we have create this new array and the following algorithm */
		  
		
		
	       while (topSalariesShopEmployees.getSize()!=topSalaries){
	    	   
	    	   if(topSalariesShopEmployees.isEmpty()){
	    		   
	    		public String  firstNodeElement = topSalariesShopEmployeesRepetitions.getFirstNode().getElement(); 
	    		topSalariesShopEmployees.addFirst(firstNodeElement);
	    		topSalariesShopEmployeesRepetitions.removeFirst();
	    	   
	    	   }
	    	   
	    	    else{ /* Checks if the current value is repeated in the list whose names are not repeated.If is not , it is added to the not
	    	              repeated values list and deleted from the first one; else , it is only deleted*/
	    		 
	    		   a=0;
	    		  
	    		   for(SNode<String> nodeIt = topSalariesShopEmployees.getFirstNode(); nodeIt != null; nodeIt = nodeIt.nextNode){
	    			   
	    			   if(topSalariesShopEmployeesRepetitions.firstNode.getElement().equalsIgnoreCase(nodeIt.getElement())){
	    				  
	    				   //Do nothing 
	    			   }	   
	    			   else{
	    				   a++;
	    			   }
	    		   }
	    		   
	    		   if (a = topSalariesShopEmployees.getSize()){/* The current name is not on the second list, so , let's add it and delete 
	    		                                                     it from the previous list.*/ 
	    			    
	    			   String nonRepeatedSalary= topSalariesShopEmployeesRepetitions.firstNode.getElement();   
	    			   topSalariesShopEmployees.addLast(nonRepeatedSalary); 
	    			   topSalariesShopEmployeesRepetitions.removeFirst();
	    			   
	    		   }
	    		   
	    	   }
	    	   
	       //And now let's print the two arrays.
	       
	    	   System.out.println("And the "+topSalaries+" employees of the shopping center with the biggest salaries are:");
	       
	    	   for(SNode<String> node1 = topSalariesShopEmployees.getFirstNode(); node1 != null; node1 = nodeIt.nextNode){  
	    	              System.out.println(node1.getElement());
	    	         
	    	             }
	          
	    	   for(SNode<String> node2 = topSalariesCentreEmployees.getFirstNode(); node1 != null; node2 = nodeIt.nextNode){  
 	              System.out.println(node2.getElement());
 	         
 	             }
	       
	          }
	       
		   }
	
	    };
	
	 }
	
		
	
	       
	
	       
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

