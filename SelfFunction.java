public interface SelfFunction<T, V>{
    T apply(V value);
    double maxBound = Math.PI/2;
    double minBound = -Math.PI/2;
}
