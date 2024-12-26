import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Processo> processos = Arrays.asList(
            new Processo("P1", 5), new Processo("P2", 4), new Processo("P3", 2),
            new Processo("P4", 5), new Processo("P5", 8), new Processo("P6", 3)
        );

        Memoria memoria = new Memoria(32);

        
        System.out.println("Executando First Fit:");
        AlgoritmoAlocacao firstFit = new FirstFit();
        memoria.executarAlgoritmo(firstFit, processos);

        System.out.println("\nExecutando Next Fit:");
        AlgoritmoAlocacao nextFit = new NextFit();
        memoria.executarAlgoritmo(nextFit, processos);

        System.out.println("\nExecutando Best Fit:");
        AlgoritmoAlocacao bestFit = new BestFit();
        memoria.executarAlgoritmo(bestFit, processos);

        System.out.println("\nExecutando Worst Fit:");
        AlgoritmoAlocacao worstFit = new WorstFit();
        memoria.executarAlgoritmo(worstFit, processos);

        System.out.println("\nExecutando Quick Fit:");
        AlgoritmoAlocacao quickFit = new QuickFit();
        memoria.executarAlgoritmo(quickFit, processos);
    }
}
















