public class binheap {
    private final int[] heap;
    private int end = 0;
    private int comp = 0;

    public binheap() {
        this.heap = new int[100];
    }

    void insert(int key) {
        heap[end++] = key;
        bubbleUp();
    }

    private void bubbleUp() {
        int eltIdx = end - 1;
        while (eltIdx >= 0) {
            int elt = heap[eltIdx];
            int childIdx = eltIdx * 2 + 1;
            if (childIdx < end) {
                comp++;
                int child = heap[childIdx];
                if (childIdx + 1 < end && child > heap[childIdx+1]) child = heap[++childIdx];
                if (elt <= child) return;
                swap(eltIdx, childIdx);
            }
            eltIdx = eltIdx % 2 == 1 ? (eltIdx - 1) / 2 : (eltIdx - 2) / 2;
        }
    }

    void deleteMin() {
        if (heap[0] == 0) System.out.println("false");
        System.out.printf("true: %d\n", heap[0]);
        swap(0, --end);
        heap[end] = 0; //full delete
        if (end <= 1) return;
        bubbleDown();
    }

    private void bubbleDown() {
        int eltIdx = 0;
        int childIdx = 1;
        int elt = heap[eltIdx];
        int child = heap[childIdx];
        comp++;
        if (childIdx + 1 < end) {
            if (child > heap[childIdx + 1]) childIdx++;
        } else if (elt <= child) {
            return;
        }
        swap(eltIdx, childIdx);
        eltIdx = childIdx;
        childIdx = eltIdx * 2 + 1;

        while (childIdx < end) {
            elt = heap[eltIdx];
            child = heap[childIdx];
            if (childIdx + 1 < end) {
                comp++;
                if (child > heap[childIdx + 1]) child = heap[++childIdx];
            }
            if (elt <= child) {
                comp++;
                return;
            }
            swap(eltIdx, childIdx);
            eltIdx = childIdx;
            childIdx = eltIdx * 2 + 1;
        }
    }

    void printElements() {
        if (heap[0] == 0) {
            System.out.println("empty");
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(heap[0]);

        for (int i = 1; i < end; i++) {
            sb.append(", ");
            sb.append(heap[i]);
        }

        System.out.println(sb);
    }

    void printMin() {
        System.out.printf("MIN: %s\n", (heap[0] == 0) ? "none" : heap[0]);
    }

    void printComparisons() {
        System.out.printf("COMPARISONS: %d\n", comp);
    }

    private void swap(int a, int b) {
        int tmp = heap[a];
        heap[a] = heap[b];
        heap[b] = tmp;
    }
}
