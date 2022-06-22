import java.util.Scanner;

public class TrabalhoFinal {

    TrabalhoFinal() {

        Scanner s = new Scanner(System.in);

        String[][] palavras = new String[5][2];
        char[][] mapa = new char[10][5];

        palavrasEntrada(palavras);
        mapaEntrada(mapa);
        mapaPesquisa(palavras, mapa);

        int acao = 0;
        do {

            System.out.println("_____ Menu: Caça Palavras _____");
            System.out.println("1. listar palavras");
            System.out.println("2. listar mapa");
            System.out.println("3. listar respostas");
            System.out.println("4. sair");
            System.out.print(" __ opção: ");
            acao = s.nextInt();

            switch (acao) {
                case 1:
                    palavrasImprimir(palavras);
                    break;
                case 2:
                    mapaImprimir(mapa);
                    break;
                case 3:
                    palavrasResposta(palavras);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opção ERRADA!...");
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
        mapa[ 0][ 0]='D';  mapa[ 0][ 1]='C';  mapa[ 0][ 2]='Q';  mapa[ 0][ 3]='W';  mapa[ 0][ 4]='E';
        mapa[ 1][ 0]='I';  mapa[ 1][ 1]='X';  mapa[ 1][ 2]='F';  mapa[ 1][ 3]='O';  mapa[ 1][ 4]='R';
        mapa[ 2][ 0]='F';  mapa[ 2][ 1]='F';  mapa[ 2][ 2]='R';  mapa[ 2][ 3]='G';  mapa[ 2][ 4]='F';
        mapa[ 3][ 0]='E';  mapa[ 3][ 1]='L';  mapa[ 3][ 2]='I';  mapa[ 3][ 3]='H';  mapa[ 3][ 4]='W';
        mapa[ 4][ 0]='L';  mapa[ 4][ 1]='S';  mapa[ 4][ 2]='F';  mapa[ 4][ 3]='O';  mapa[ 4][ 4]='U';
        mapa[ 5][ 0]='S';  mapa[ 5][ 1]='D';  mapa[ 5][ 2]='G';  mapa[ 5][ 3]='T';  mapa[ 5][ 4]='S';
        mapa[ 6][ 0]='E';  mapa[ 6][ 1]='J';  mapa[ 6][ 2]='H';  mapa[ 6][ 3]='E';  mapa[ 6][ 4]='T';
        mapa[ 7][ 0]='I';  mapa[ 7][ 1]='I';  mapa[ 7][ 2]='I';  mapa[ 7][ 3]='J';  mapa[ 7][ 4]='M';
        mapa[ 8][ 0]='X';  mapa[ 8][ 1]='C';  mapa[ 8][ 2]='K';  mapa[ 8][ 3]='B';  mapa[ 8][ 4]='G';
        mapa[ 9][ 0]='V';  mapa[ 9][ 1]='E';  mapa[ 9][ 2]='T';  mapa[ 9][ 3]='O';  mapa[ 9][ 4]='R';
    }

    public String[][] mapaPesquisa(String[][] palavras, char[][] mapa) {

        for (int i = 0; i < palavras.length; i++) {
            String palavra = palavras[i][0];
            for (int linha = 0; linha < mapa.length; linha++) {
                for (int coluna = 0; coluna < mapa[0].length; coluna++) {

                        if (palavra.charAt(0) == mapa[linha][coluna]) {
                            for (int marcador = 0; marcador < palavra.length(); marcador++) {
                                int movimento = coluna - marcador;
                                if (movimento < 0) {
                                    break;
                                } else if (palavra.charAt(marcador) != mapa[linha][movimento]) {
                                    break;
                                }
                                if (marcador == palavra.length() - 1) {
                                    palavras[i][1] = "[" + linha + "," + coluna + "]";
                                }
                            }
                            for (int marcador = 0; marcador < palavra.length(); marcador++) {
                                int movimento = linha + marcador;
                                if (movimento >= mapa.length) {
                                    break;
                                } else if (palavra.charAt(marcador) != mapa[movimento][coluna]) {
                                    break;
                                }
                                if (marcador == palavra.length() - 1) {
                                    palavras[i][1] = "[" + linha + "," + coluna + "]";
                                }
                            }
                            for (int marcador = 0; marcador < palavra.length(); marcador++) {
                                int movimento = linha - marcador;
                                if (movimento < 0) {
                                    break;
                                } else if (palavra.charAt(marcador) != mapa[movimento][coluna]) {
                                    break;
                                }
                                if (marcador == palavra.length() - 1) {
                                    palavras[i][1] = "[" + linha + "," + coluna + "]";
                                }
                            }
                            for (int marcador = 0; marcador < palavra.length(); marcador++) {
                                int movimento = coluna + marcador;
                                if (movimento >= mapa[0].length) {
                                    break;
                                } else if (palavra.charAt(marcador) != mapa[linha][movimento]) {
                                    break;
                                }
                                if (marcador == palavra.length() - 1) {
                                    palavras[i][1] = "[" + linha + "," + coluna + "]";
                                }
                            }
                        }

                }

            }
        }
        return palavras;
    }

    public void palavrasImprimir(String[][] palavras) {
        for (String[] palavra : palavras) {
            System.out.println(palavra[0]);
        }
    }

    public void mapaImprimir(char[][] mapa) {
        System.out.println("---------------------");
        String relatorio = "";
        for (char[] linha : mapa) {
            relatorio = "|";
            for (char letra : linha) {
                relatorio += " " + letra + " |";
            }
            System.out.println(relatorio);
            System.out.println("---------------------");
        }
    }

    public void palavrasResposta(String[][] palavras) {
        for (String[] palavra : palavras) {
            if (palavra[1] == null) {
                palavra[1] = "Palavra NÃO encontrada";
            }
            System.out.println(palavra[1] + " - " + palavra[0]);
        }
    }

    public static void main(String[] args) throws Exception {
        new TrabalhoFinal();
    }
}
