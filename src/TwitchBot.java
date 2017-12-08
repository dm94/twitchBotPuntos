

import java.util.Random;

import org.jibble.pircbot.PircBot;

public class TwitchBot extends PircBot{
	private static String canal;
	private static String admin;
	private static int i=0;
	private static Random rnd;
	private Utilidades util;
	
	//Para que cambien los !comandos solo hace falta que esos comandos no llegen a estar definidos.
	
	public TwitchBot(){
		this.setName("noname");
		canal="noname";
		admin="";
		rnd=new Random();
	}

	public TwitchBot(String nombre, String canal){
		this.setName(nombre);
		this.canal=canal;
		this.admin=nombre;
		rnd=new Random();
		util=new Utilidades();
	}
	
	public static String getCanal(){
		return canal;
	}
	
	public void onMessage(String channel,String sender, String login, String hostname, String message) {
		
		if(sender.toLowerCase().contains("wizebot") || sender.toLowerCase().contains("wzbot")){
			System.out.println(message);
			if(message.contains("You opened the right door, you are now safe")){
				/*
				 * Juego de las Puertas - Funciona
				 */
				String ganador=util.sacarGanadorPuertas(message);
				
				if(ganador.length()>0){
					HiloBot.mandarMensaje(canal, "!bonus "+ganador+" 300");
				}
			}else if(message.contains("PLEASE WAIT 60 SECONDS FOR THE NEXT RUN.")){
				/*
				 * Tiro al pato - Funciona
				 */
				
				String ganador=util.sacarGanadorPato(message);
				
				if(ganador.length()>0){
					HiloBot.mandarMensaje(canal, "!bonus "+ganador+" 300");
				}
			}else if(message.contains("diffuse")){
				/*
				 * La bomba
				 */
				
				
				String ganador=util.sacarGanadorBomba(message);
				
				if(ganador.length()>0){
					HiloBot.mandarMensaje(canal, "!bonus "+ganador+" 300");
				}
			}else if(message.contains("PLEASE WAIT 60 SECONDS FOR THE NEXT DROP")){
				/*
				 * Juego del take - Funciona
				 */
				
				String ganador=util.sacarGanadorTake(message);
				
				if(ganador.length()>0){
					HiloBot.mandarMensaje(canal, "!bonus "+ganador+" 500");
				}
			}
		}
	}
}
