package proyect;

public class CentreEmployee extends Employee {
 
	public static String idPrefix = "CC"; //Prefix and identifier number are glued into a constructor
	public String id; //There's a constructor related to this below. 
	
	public String shoppingCentreName ; // name of the Shopping center he/she works.
	// String duty : clean ,administration, security,customer care and other(ENUM?)
	

	public CentreEmployee(String name, String surnames, String DNI, String address,String telephoneNumber,
			                String socialInsuranceNnumber,String workShift, double salary,String id,String shoppingCentreName){
	
	this.name=name;
	this.surnames=surnames;
	this.DNI=DNI;
	this.address=address;
	this.telephoneNumber=telephoneNumber;
	this.socialInsuranceNnumber=socialInsuranceNnumber;
	this.workShift=workShift;
	this.salary=salary;
	this.id=id;
	this.shoppingCentreName=shoppingCentreName;
		
	
	        }
	
          }


