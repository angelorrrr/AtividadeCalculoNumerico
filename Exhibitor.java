import java.util.LinkedList;

public final class Exhibitor {
    private static int counter = 1;
    public static void showAnswers(SelfFunction<Double, Double> function){
        double answer = RootGetter.calculate(SelfFunction.minBound, SelfFunction.maxBound, function);
        double error = RootGetter.getIntrinsicAdmissibleError();
        System.out.printf("Questão %d: (raiz, erro) -> (%.8f, %.8f)\n", counter, answer, error);
        counter++;
    }
    @SuppressWarnings("unchecked")
    public static final LinkedList<SelfFunction<Double, Double>> feedFunctions(
        SelfFunction<Double, Double>... functions){
        LinkedList<SelfFunction<Double, Double>> list = new LinkedList<>();
        for(SelfFunction<Double, Double> function : functions){
            list.add(function);
        }
        return list;
    }
}
