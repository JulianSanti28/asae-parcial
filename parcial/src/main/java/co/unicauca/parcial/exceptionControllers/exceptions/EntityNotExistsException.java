package co.unicauca.parcial.exceptionControllers.exceptions;

import lombok.Getter;

@Getter
public class EntityNotExistsException extends RuntimeException{
    private final String messageKey;
    private final String code;

    public EntityNotExistsException(ErrorCode code) {
        super(code.getCode());
        this.messageKey = code.getMessageKey();
        this.code = code.getCode();
    }

    public EntityNotExistsException(final String message) {
        super(message);
        this.messageKey = ErrorCode.ENTITY_NOT_EXIST.getMessageKey();
        this.code = ErrorCode.ENTITY_NOT_EXIST.getCode();
    }
}
