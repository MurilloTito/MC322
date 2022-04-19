package  pt.c02oo.s03relacionamento.s04restaum;

public class Tabuleiro { // o tabuleiro vai ser uma matriz de objetos(pecas)
	Pecas tabuleiro[][];
	
	Tabuleiro() {
		this.tabuleiro = new Pecas[7][7];
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				if ((i == 0 || i == 1 || i == 5 || i == 6) && 
						(j == 0 || j == 1 || j == 5 || j == 6)) {
					tabuleiro[i][j] = null;
				} else if (i == 3 && j == 3){
					tabuleiro[i][j] = new Pecas(0, this);
				} else {
					tabuleiro[i][j] = new Pecas(1, this);
				}
			}
		}
	}
	
	public int converterLinhas(String commands[], int l, int k) {
		char linha = commands[l].charAt(k);
		int conversaoLinha = Character.getNumericValue(linha);
		int linhaMatriz = conversaoLinha - 1;
		return linhaMatriz;
	}



	public int converterColunas(String commands[], int l, int k) {
		char coluna = commands[l].charAt(k);
		int conversaoColuna;
		if (coluna == 'a') {
			conversaoColuna = 0;
		} else if(coluna == 'b') {
			conversaoColuna = 1;
		} else if (coluna == 'c') {
			conversaoColuna = 2;
		} else if (coluna == 'd') {
			conversaoColuna = 3;
		} else if (coluna == 'e') {
			conversaoColuna = 4;
		} else if (coluna == 'f') {
			conversaoColuna = 5;
		} else {
			conversaoColuna = 6;
		}
		return conversaoColuna;
	}

	public boolean temPeca(String commands[], int l, int k, int colunaDestino, int linhaDestino) {
		if ((tabuleiro[linhaDestino][colunaDestino].temPeca == 1) || 
				(tabuleiro[linhaDestino][colunaDestino] == null)) {
			return true;
		} else {
			return false;
		}
	}

	public void mover(String commands[], int l, int k) {
		int colunaOrigem = converterColunas(commands, l, k);
		int linhaOrigem = converterLinhas(commands, l, k + 1);
		int colunaDestino = converterColunas(commands, l, k + 3);
		int linhaDestino = converterLinhas(commands, l, k + 4);
		int distanciaLinha = Math.abs(linhaDestino - linhaOrigem);
		int distanciaColuna = Math.abs(colunaDestino - colunaOrigem);
		if (temPeca(commands, l, k, colunaDestino, linhaDestino) == false) {
			if (distanciaLinha <= 2 && distanciaColuna <= 2) {
				if (colunaOrigem > colunaDestino) { // movimento pra esquerda
					tabuleiro[linhaDestino][colunaDestino].temPeca = 1;
					tabuleiro[linhaOrigem][colunaOrigem].temPeca = 0;
					tabuleiro[linhaOrigem][colunaOrigem - 1].temPeca = 0;
				} else if (colunaOrigem < colunaDestino) { // movimento pra direita
					tabuleiro[linhaDestino][colunaDestino].temPeca = 1;
					tabuleiro[linhaOrigem][colunaOrigem].temPeca = 0;
					tabuleiro[linhaOrigem][colunaOrigem + 1].temPeca = 0;
				} else if (linhaOrigem > linhaDestino) { // movimento pra cima
					tabuleiro[linhaDestino][colunaDestino].temPeca = 1;
					tabuleiro[linhaOrigem][colunaOrigem].temPeca = 0;
					tabuleiro[linhaOrigem - 1][colunaOrigem].temPeca = 0;
				} else { // movimento pra baixo
					tabuleiro[linhaDestino][colunaDestino].temPeca = 1;
					tabuleiro[linhaOrigem][colunaOrigem].temPeca = 0;
					tabuleiro[linhaOrigem + 1][colunaOrigem].temPeca = 0;
				}
			}
		}
	}
	
	public char[][] apresentar() {
		char[][] tabuleiroChar;
		tabuleiroChar = new char[7][7];
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				if (tabuleiro[i][j] == null) {
					tabuleiroChar[i][j] = ' ';
				} else if (tabuleiro[i][j].temPeca == 0) {
					tabuleiroChar[i][j] = '-';
				} else {
					tabuleiroChar[i][j] = 'P';
				}
			}
		}
		return tabuleiroChar;
	}
}



