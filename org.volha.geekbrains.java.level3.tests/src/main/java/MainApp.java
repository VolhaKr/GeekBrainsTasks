public class MainApp {
    public static void main(String[] args) {
        ArrayOperations arrayOperations = new ArrayOperations();
        arrayOperations.arrayCut(new int[]{1, 5, 1, 1, 4});
        System.out.println ("CheckMembersResult " + arrayOperations.checkMembers(new int[]{1, 5, 1, 1, 4}));
//        int [] intput = new int[]{1, 44, 4, 5, 1, 1};
//        int [] expectedOutput = new int[]{5, 1, 1};
//        System.out.println("true? " + expectedOutput.equals(arrayOperations.arrayCut(intput)));
    }
}
