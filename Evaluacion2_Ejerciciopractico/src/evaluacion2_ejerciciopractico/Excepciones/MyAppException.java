public class MyAppException extends Exception {

    public MyAppException(String message) {
        super(message);
    }
}

// Excepción específica de validación
class ValidationException extends MyAppException {
    public ValidationException(String message) {
        super(message);
    }
}

// Excepción específica de conexión
class ConnectionException extends MyAppException {
    private int errorCode;

    public ConnectionException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }
}