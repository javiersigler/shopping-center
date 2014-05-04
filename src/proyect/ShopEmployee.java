package proyect;

public class ShopEmployee extends Employee {
	
	public static String idPrefix = "T"; 
	public String id;
	
	// public String Status : shop manager and stuff. 
	public String [] shopsEmployeeWorks;// we only need the name shops the shops , no more data. 

	
	
		public ShopEmployee(String name, String surnames, String DNI, String address,String telephoneNumber,
                     String socialInsuranceNnumber,String workShift, double salary,String id,  String [] shopsEmployeeWorks){

			this.name=name;
			this.surnames=surnames;
			this.DNI=DNI;
			this.address=address;
			this.telephoneNumber=telephoneNumber;
			this.socialInsuranceNnumber=socialInsuranceNnumber;
			this.workShift=workShift;
			this.salary=salary;
	        this.id=id;
	        this.shopsEmployeeWorks=shopsEmployeeWorks;
	
		           }
		
		      }



