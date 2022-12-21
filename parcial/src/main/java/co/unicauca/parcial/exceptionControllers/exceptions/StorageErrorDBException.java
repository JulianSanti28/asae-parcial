package co.unicauca.parcial.exceptionControllers.exceptions;

public class StorageErrorDBException extends RuntimeException{
    private final String messageKey;
    private final String code;

    public StorageErrorDBException(ErrorCode code) {
        super(code.getCode());
        this.messageKey = code.getMessageKey();
        this.code = code.getCode();
    }

    public StorageErrorDBException(final String message) {
        super(message);
        this.messageKey = ErrorCode.STORAGE_DB_VIOLATION.getMessageKey();
        this.code = ErrorCode.STORAGE_DB_VIOLATION.getCode();
    }
}
