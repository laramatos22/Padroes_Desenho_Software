//package lab03;
public class Voo{ 
    private final String code;
    private final Plane plane;
 
    public Voo(String code, Plane plane) {
	    this.code = code;
	    this.plane = plane;

    }
    
    public Voo(String code, String exec, String tur) {
	    this.code = code;
	    this.plane = new Plane(exec,tur);
    }
    
    public Voo(String code, String tur) {
	    this.code = code;
	    this.plane = new Plane(tur);
    }

	
    public String getCode() {
	    return code;
    }

    public Plane getPlane() {
        return plane;
    }
    
  

    @Override
    public String toString() {
        String s = code + " " + plane.toString(); 
	    return s;
    }
}