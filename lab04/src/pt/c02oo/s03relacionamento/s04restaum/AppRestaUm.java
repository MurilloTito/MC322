package pt.c02oo.s03relacionamento.s04restaum;

public class AppRestaUm {

	   public static void main(String[] args) {
		   AppRestaUm.executaJogo(null, null);
	   }
	   
	   public static void executaJogo(String arquivoEntrada, String arquivoSaida) {
	      Toolkit tk = Toolkit.start(arquivoEntrada, arquivoSaida);
	      
	      String commands[] = tk.retrieveCommands();
	      
	      Tabuleiro tab = new Tabuleiro();
		  char tabuleiro[][] = tab.apresentar();
		  tk.writeBoard("Tabuleiro inicial", tabuleiro);
		  for (int l = 0; l < commands.length; l++) {
			  tab.mover(commands, l, 0);
			  tabuleiro = tab.apresentar();
			  tk.writeBoard(commands[l], tabuleiro);
		}
	      
	      tk.stop();
	   }
}