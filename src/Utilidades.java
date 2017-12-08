
public class Utilidades {

	public String sacarGanadorPuertas(String message) {
		String canal="";
		
		int numero=0;
		
		numero=message.indexOf("You");
		
		canal=message.substring(0,numero).trim();
		
		return canal;
	}
	
	public String sacarGanadorTake(String message) {
		String canal="";
		
		int inicio=0;
		int fin=0;
		
		inicio=message.indexOf("HEY");
		fin=message.indexOf("!");
		
		canal=message.substring(inicio+3,fin).trim();
		
		return canal;
	}
	
	public String sacarGanadorPato(String message) {
		String canal="";
		
		int inicio=0;
		int fin=0;
		
		inicio=message.indexOf("HEY");
		fin=message.indexOf("!");
		
		canal=message.substring(inicio+9,fin).trim();
		
		return canal;
	}
	
	public String sacarGanadorBomba(String message) {
		String canal="";
		
		int inicio=0;
		int fin=0;
		
		inicio=message.indexOf("by");
		fin=message.indexOf("! (");
		
		canal=message.substring(inicio+2,fin).trim();
		
		return canal;
	}

}
