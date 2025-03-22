import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
public abstract class RootGetter {
    public static final double admissibleError = 0.01;
    private static AtomicReference<Optional<Double>> intrinsicAdmissibleError = new AtomicReference<>(Optional.empty());
    public static double calculate(double minBound, double maxBound, SelfFunction<Double, Double> function) {
        double currentValue = (minBound+maxBound)/2;
        double absoluteAdmissibleError = Math.abs(function.apply(currentValue));
        
        if(absoluteAdmissibleError<=admissibleError){
            intrinsicAdmissibleError.set(Optional.of(absoluteAdmissibleError));
            return currentValue;
        }
        if(function.apply(minBound) * function.apply(currentValue) < 0)maxBound = currentValue;
        else minBound = currentValue;

        return calculate(minBound, maxBound, function);
    }
    public static double getIntrinsicAdmissibleError(){
        if(intrinsicAdmissibleError.get().isPresent()){
            return intrinsicAdmissibleError.getAndSet(Optional.empty()).get();
        }
        throw new IllegalArgumentException("Você precisa calcular a raíz da função antes de requerir o erro da mesma!");
        
    }
}
