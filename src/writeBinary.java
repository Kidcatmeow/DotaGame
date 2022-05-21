public class writeBinary {
    public static void main (String[] args){
        writeBinary(44);
    }

    public static void writeBinary (int n){
        if (n < 2) {
            // base case
            System.out.print(n);
        } else {
            // recursive case
            writeBinary(n / 2);
            writeBinary(n % 2);
        }
    }
}
