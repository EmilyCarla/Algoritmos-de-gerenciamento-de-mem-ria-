import java.util.*;

class Memoria {
    private int[] memoria;
    private Map<String, Integer> alocacoes;
    private int tamanho;

    public Memoria(int tamanho) {
        this.tamanho = tamanho;
        this.memoria = new int[tamanho];
        this.alocacoes = new HashMap<>();
    }

    public void executarAlgoritmo(AlgoritmoAlocacao algoritmo, List<Processo> processos) {
        limparMemoria();
        for (Processo processo : processos) {
            algoritmo.alocar(processo, this);
            exibirMapaMemoria();
        }
    }

    public boolean verificarEspacoLivre(int inicio, int tamanho) {
        for (int i = inicio; i < inicio + tamanho; i++) {
            if (memoria[i] == 1) {
                return false;
            }
        }
        return true;
    }

    public void alocarMemoria(int inicio, int tamanho, String id) {
        for (int i = inicio; i < inicio + tamanho; i++) {
            memoria[i] = 1;
        }
        alocacoes.put(id, inicio);
        System.out.println("Processo " + id + " alocado no bloco " + inicio);
    }

    public void desalocarMemoria(String id) {
        if (alocacoes.containsKey(id)) {
            int inicio = alocacoes.get(id);
            for (int i = inicio; i < tamanho && memoria[i] == 1; i++) {
                memoria[i] = 0;
            }
            alocacoes.remove(id);
            System.out.println("Processo " + id + " desalocado.");
        } else {
            System.out.println("Erro: Processo " + id + " não encontrado na memória.");
        }
    }

    public void limparMemoria() {
        Arrays.fill(memoria, 0);
        alocacoes.clear();
    }

    public void exibirMapaMemoria() {
        System.out.println(Arrays.toString(memoria));
    }

    public int[] getMemoria() {
        return memoria;
    }

    public int getTamanho() {
        return tamanho;
    }
}