public class Application extends Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        createGraph();
        String toContinue;
        do {
            solution.takeInput();
            System.out.println("\nIf you want to continue, type Yes or any key to cancel: ");
            toContinue = input.nextLine().toUpperCase();
        }
        while (toContinue.equals("YES") || toContinue.equals("yes"));
        input.close();
    }
}
