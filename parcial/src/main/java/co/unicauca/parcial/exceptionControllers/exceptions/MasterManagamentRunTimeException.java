package co.unicauca.parcial.exceptionControllers.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public abstract class MasterManagamentRunTimeException extends RuntimeException{

    protected ErrorCode errorCode;

    public abstract String formatException();
}
