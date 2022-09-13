package sparsearray;

// 数组维度异常
public class DimensionException extends RuntimeException{
    public DimensionException(String message) {
        super(message);
    }
}
