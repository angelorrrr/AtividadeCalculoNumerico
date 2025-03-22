import java.util.LinkedList;

public class Main {
    @SuppressWarnings("unchecked")
    private static final LinkedList<SelfFunction<Double, Double>> functions = 
    Exhibitor.feedFunctions(
        (x)->Math.cos(x)-x,
        (x)->Math.sin(2*x)-x,
        (x)->Math.tan(2*x)-x,
        (x)->2*Math.sin(x)-x,
        (x)->Math.pow(Math.E, x)-Math.tan(x),
        (x)->2*Math.cos(x)-Math.log(x)
    );
    public static void main(String[] args) {
        functions.forEach(Exhibitor::showAnswers);
    }
}
