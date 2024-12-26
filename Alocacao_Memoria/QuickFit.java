import java.util.*;

class QuickFit implements AlgoritmoAlocacao {
    private Map<Integer, List<Integer>> listasLivres = new HashMap<>();

    @Override
    public void alocar(Processo processo, Memoria memoria) {
        prepararListas(memoria);

        List<Integer> blocosLivres = listasLivres.get(processo.tamanho);
        if (blocosLivres != null && !blocosLivres.isEmpty()) {
            int inicio = blocosLivres.remove(0);
            memoria.alocarMemoria(inicio, processo.tamanho, processo.id);
        } else {
            System.out.println("Erro: Não foi possível alocar o processo " + processo.id);
        }
    }

    private void prepararListas(Memoria memoria) {
        listasLivres.clear();
        int[] mem = memoria.getMemoria();
        int inicio = -1;

        for (int i = 0; i < mem.length; i++) {
            if (mem[i] == 0) {
                if (inicio == -1) {
                    inicio = i;
                }
            } else {
                if (inicio != -1) {
                    int tamanho = i - inicio;
                    listasLivres.computeIfAbsent(tamanho, k -> new ArrayList<>()).add(inicio);
                    inicio = -1;
                }
            }
        }

        if (inicio != -1) {
            int tamanho = mem.length - inicio;
            listasLivres.computeIfAbsent(tamanho, k -> new ArrayList<>()).add(inicio);
        }
    }
}