
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import org.jibble.pircbot.IrcException;
import org.jibble.pircbot.NickAlreadyInUseException;


public class HiloBot extends Thread{
	private static TwitchBot bot;
	private static String oauthT="";
	private static String canalConnec="";	
	private static HiloBot hilo;

	public static void main(String[] args) {
		hilo=new HiloBot();
		hilo.leerConfig();
	}
	
	
	public void leerConfig(){
		System.out.println("----------------BotPuntos v1--------------------");
		System.out.println("--------------------------by @Dm94Dani----------");
		
		String cad = null;
		String canalHoster = "chavaledro";
		String oauth = "";
		String admin = "";
		
		if(admin==null){//Si no hay nada en el admin el hoster se pone de admin
			admin=canalHoster;
		}
		if(canalHoster!=null && oauth!=null && admin!=null){
			System.out.println("--------------------Config--------------------");
			System.out.println("Canal a conectarse: "+canalHoster);
			System.out.println("Admin: "+admin);
			System.out.println("---------------------Bot----------------------");
			
			try {
				crearBot(canalHoster,oauth,admin);
			} catch (IOException | IrcException e) {
				System.out.println("Error al inicial el bot");
			}
		}else{
			System.out.println("Los datos de configuracion son incorrectos");
		}
		
	}
	
	private void crearBot(String canalHoster, String oauth,String admin) throws NickAlreadyInUseException, IOException, IrcException{
		
		bot= new TwitchBot(admin,canalHoster);
		bot.setVerbose(true);
		bot.connect("irc.twitch.tv" ,6667,oauth);
		bot.joinChannel("#"+canalHoster);
		canalConnec=canalHoster;
		oauthT=oauth;
		
	}
	
	public static void conectarBot(){
		if(!bot.isConnected()){
			try {
				bot.connect("irc.twitch.tv" ,6667,oauthT);
			} catch (NickAlreadyInUseException e) {
				System.out.println(e.getMessage());
			} catch (IOException e) {
				System.out.println(e.getMessage());
			} catch (IrcException e) {
				System.out.println(e.getMessage());
			}
			bot.joinChannel("#"+canalConnec);
		}
	}
	
	public static synchronized void mandarMensaje(String canalHoster,String mensaje){
		bot.sendMessage("#"+canalHoster,mensaje);
		//System.out.println(mensaje);
	}
	

}
