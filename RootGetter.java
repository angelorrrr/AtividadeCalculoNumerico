import java.util.Optional;
public abstract class RootGetter {
    public static final double admissibleError = 0.01;
    private static Optional<Double> intrinsicAdmissibleError = null;
    public static double calculate(double minBound, double maxBound, SelfFunction<Double, Double> function) {
        double currentValue = (minBound+maxBound)/2;
        double absoluteAdmissibleError = Math.abs(function.apply(currentValue));
        
        if(absoluteAdmissibleError<=admissibleError){
            intrinsicAdmissibleError = Optional.of(absoluteAdmissibleError);
            return currentValue;
        }
        if(function.apply(minBound) * function.apply(currentValue) < 0)maxBound = currentValue;
        else minBound = currentValue;

        return calculate(minBound, maxBound, function);
    }
    public static double getIntrinsicAdmissibleError(){
        try{
            return intrinsicAdmissibleError.get();
        }catch(Exception e){}finally{
            if(intrinsicAdmissibleError != null)intrinsicAdmissibleError = null;
        }
        throw new IllegalArgumentException("Você precisa calcular a raíz da função antes de requerir o erro da mesma!");
    }
}
