package counter;

public class Main {
    public static void main(String[] args) {
        WordArray runner=new WordArray();
        Copy bigOne=new Copy();
        
        runner.input(bigOne.pared());
        runner.run();
        System.out.println(runner);
    }
}
