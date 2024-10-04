import java.util.Arrays;

public class VetorInteiros { 
    private int[] vetor;
    private int tamanho;
    private int posicaoLivre;

    public VetorInteiros(int tamanho) {
        this.tamanho = tamanho;
        this.vetor = new int[tamanho];
        Arrays.fill(vetor, -1); 
    }

    public boolean inserir(int n) {
        if (n <= 0 || posicaoLivre >= tamanho || existe(n)) {
            return false;
        }
        vetor[posicaoLivre++] = n;
        return true;
    }

    public boolean remover(int n) {
        for (int i = 0; i < posicaoLivre; i++) {
            if (vetor[i] == n) {
                vetor[i] = -1; 
                reorganizar(i);
                posicaoLivre--;
                return true;
            }
        }
        return false;
    }

    private void reorganizar(int index) {
        for (int i = index; i < posicaoLivre - 1; i++) {
            vetor[i] = vetor[i + 1];
        }
        vetor[posicaoLivre - 1] = -1; 
    }

    public int soma() {
        int soma = 0;
        for (int i = 0; i < posicaoLivre; i++) {
            if (vetor[i] != -1) {
                soma += vetor[i];
            }
        }
        return soma;
    }

    public double media() {
        if (posicaoLivre == 0) {
            return 0; 
        }
        return (double) soma() / posicaoLivre;
    }

    public boolean estaCheio() {
        return posicaoLivre == tamanho;
    }

    public void limpar() {
        Arrays.fill(vetor, -1);
        posicaoLivre = 0;
    }

    public int maior() {
        if (posicaoLivre == 0) {
            return -1;
        }
        int maiorPos = 0;
        for (int i = 1; i < posicaoLivre; i++) {
            if (vetor[i] > vetor[maiorPos]) {
                maiorPos = i;
            }
        }
        return maiorPos;
    }

    public int menor() {
        if (posicaoLivre == 0) {
            return -1; 
        }
        int menorPos = 0;
        for (int i = 1; i < posicaoLivre; i++) {
            if (vetor[i] < vetor[menorPos]) {
                menorPos = i;
            }
        }
        return menorPos;
    }

    public int valor(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            throw new IndexOutOfBoundsException("Posição inválida.");
        }
        return vetor[posicao];
    }

    public String imprime() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < tamanho; i++) {
            if (vetor[i] == -1) {
                sb.append("#");
            } else {
                sb.append(vetor[i]);
            }
            if (i < tamanho - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    private boolean existe(int n) {
        for (int i = 0; i < posicaoLivre; i++) {
            if (vetor[i] == n) {
                return true;
            }
        }
        return false;
    }
}

