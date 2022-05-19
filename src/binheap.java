public class binheap {
    private String[] heap;
    private int end = 0;
    private int comp = 0;

    public binheap() {
        this.heap = new String[100];
    }

    void insert(int key) {

    }

    void deleteMin() {

    }
    void printElements() {
        if (heap[0] == null) {
            System.out.println("empty");
            return;
        }

        StringBuilder sb = new StringBuilder(heap[0]);
        int i = 1;

        while (heap[i] != null) {
            sb.append(", ");
            sb.append(heap[i]);
            i++;
        }

        System.out.println(sb);
    }

    void printMin() {
        System.out.printf("MIN: %s", (heap[0] == null) ? "none" : heap[0]);
    }

    void printComparisons() {
        System.out.printf("COMPARISONS: %d", comp);
    }
}
