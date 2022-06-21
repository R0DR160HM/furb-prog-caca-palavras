import java.util.Scanner;

import javax.print.DocFlavor.STRING;

public class CacaPalavras {

    CacaPalavras() {

        Scanner s = new Scanner(System.in);

        String[][] palavras = new String[5][2];
        char[][] mapa = new char[10][5];

        palavrasEntrada(palavras);
        mapaEntrada(mapa);

        int acao = 0;
        do {

            System.out.println("_____ Menu: Caça Palavras _____");
            System.out.println("1. listar palavras");
            System.out.println("2. listar mapa");
            System.out.println("3. listar respostas");
            System.out.println("4. sair");
            acao = s.nextInt();

            switch (acao) {
                case 1: palavrasImprimir(palavras);
                break;
                case 2: mapaImprimir();
                break;
                case 3: palavrasResposta();
                break;
                case 4: return;
                default: System.out.println("Opção ERRADA!...");
            }


        } while (acao != 4);

        s.close();
    }

    public void palavrasEntrada(String[][] vetor) {
        vetor[0][0] = "IFELSE";
        vetor[1][0] = "FORA";
        vetor[2][0] = "WHILE";
        vetor[3][0] = "OBJETO";
        vetor[4][0] = "VETOR";
    }

    public void mapaEntrada(char[][] mapa) {
        mapa[0][0] = 'D';  mapa[0][1] = 'C';  mapa[0][2] = 'Q';  mapa[0][3] = 'W';  mapa[0][4] = 'E';
        mapa[1][0] = 'I';  mapa[1][1] = 'X';  mapa[1][2] = 'F';  mapa[1][3] = 'O';  mapa[1][4] = 'R';
        mapa[2][0] = 'F';  mapa[2][1] = 'F';  mapa[2][2] = 'R';  mapa[2][3] = 'G';  mapa[2][4] = 'F';
        mapa[3][0] = 'E';  mapa[3][1] = 'L';  mapa[3][2] = 'I';  mapa[3][3] = 'H';  mapa[3][4] = 'W';
        mapa[4][0] = 'L';  mapa[4][1] = 'S';  mapa[4][2] = 'F';  mapa[4][3] = 'O';  mapa[4][4] = 'U';
        mapa[5][0] = 'S';  mapa[5][1] = 'D';  mapa[5][2] = 'G';  mapa[5][3] = 'T';  mapa[5][4] = 'S';
        mapa[6][0] = 'E';  mapa[6][1] = 'J';  mapa[6][2] = 'H';  mapa[6][3] = 'E';  mapa[6][4] = 'T';
        mapa[7][0] = 'I';  mapa[7][1] = 'I';  mapa[7][2] = 'I';  mapa[7][3] = 'J';  mapa[7][4] = 'M';
        mapa[8][0] = 'X';  mapa[8][1] = 'C';  mapa[8][2] = 'K';  mapa[8][3] = 'B';  mapa[8][4] = 'G';
        mapa[9][0] = 'V';  mapa[9][1] = 'E';  mapa[9][2] = 'T';  mapa[9][3] = 'O';  mapa[9][4] = 'R';
    }

    public void mapaPesquisa(String[][] palavras, char[][] mapa) {
        palavras[0][1] = pesquisaPalavra(palavras[0][0], mapa) ? "OK" : "Palavra NÃO encontrada";
        palavras[1][1] = pesquisaPalavra(palavras[1][0], mapa) ? "OK" : "Palavra NÃO encontrada";
        palavras[2][1] = pesquisaPalavra(palavras[2][0], mapa) ? "OK" : "Palavra NÃO encontrada";
        palavras[3][1] = pesquisaPalavra(palavras[3][0], mapa) ? "OK" : "Palavra NÃO encontrada";
        palavras[4][1] = pesquisaPalavra(palavras[4][0], mapa) ? "OK" : "Palavra NÃO encontrada";
    }

    private boolean pesquisaPalavraEmUmaDirecao(String palavra, char[][] mapa, int l, int c, String direcao) {
        for (int i = 0; i < palavra.length(); i++) {
            if (l == mapa.length || c == mapa[0].length || l < 0 || c < 0) {
                return false;
            }
            if (i + 1 == palavra.length()) {
                return true;
            }
            if (palavra.charAt(i) != mapa[l][c]) {
                return false;
            }
            switch (direcao) {
                case "cima": l--;
                break;
                case "direita": c++;
                break;
                case "baixo": l++;
                break;
                case "esquerda": c--;
                break;
            }
        }
        return false;
    }

    private boolean pesquisaPalavra(String palavra, char[][] mapa) {
        for (int linha = 0; linha < mapa.length; linha++) {
            for (int coluna = 0; coluna < mapa[0].length; coluna++) {
                if (palavra.charAt(0) == mapa[linha][coluna]) {

                    if (pesquisaPalavraEmUmaDirecao(palavra, mapa, linha, coluna, "cima") || 
                        pesquisaPalavraEmUmaDirecao(palavra, mapa, linha, coluna, "direita") ||
                        pesquisaPalavraEmUmaDirecao(palavra, mapa, linha, coluna, "baixo") ||
                        pesquisaPalavraEmUmaDirecao(palavra, mapa, linha, coluna, "esquerda")) {
                        return true;
                    } else {
                        return false;
                    }

                }
            }
        }
        return false;
    }

    public void palavrasImprimir(String[][] palavras) {
        for (String[] palavra : palavras) {
            System.out.println(palavra);
        }
    }

    public void mapaImprimir() {}

    public void palavrasResposta() {}

    public static void main(String[] args) throws Exception {
        new CacaPalavras();
    }
}
