public class SmooshTest {

    public static void smoosh(int[] ints) {
        
        int size = ints.length;
        int[] outcome = new int[size];
        int fillNum = 0;
        int key = ints[0];

        outcome[0] = ints[0];
        for (int i = 0; i < size - 1; i++) {
            if (ints[i] == ints[i+1])
                key = key;
            else {
                key = ints[i+1];
                fillNum += 1;
                ints[fillNum] = key;
            }
        }

        for (int i = fillNum + 1; i < size; i++)
            ints[i] = -1;
    }

    public static void main(String[] args) {
        int[] input = { 0, 0, 0, 0, 1, 1, 0, 0, 0, 3, 3, 3, 1, 1, 0 };
        
        smoosh(input);
        for (int i : input)
            System.out.print(i + " ");
    }
}
