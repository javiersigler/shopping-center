package proyect;

public class CentreEmployee extends Employee {

	static String prefix = "CC"; //Prefix and identifier number are glued into a constructor

	public String identifier; //There's a contructor below
	public String [] duties; //Tareas a las que se dedica (limpiar, colocar cosas, etc)
	public String shoping_center; //Está linkeado al identifier de la tienda
	



    public void CenterEmployee (String identifier_number){ //Here is the constructor that creates the identifier

        this.identifier= prefix + identifier_number;
    }
}
