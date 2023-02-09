package co.unicauca.parcial.exceptionControllers.exceptions;

public class BusinessRuleException extends MasterManagamentRunTimeException{

    private static final String FORMATO_EXCEPCION = "%s - Violación a regla de negocio: %s";

    private final String businessRule;

    public BusinessRuleException(final String businessRule) {
        super(ErrorCode.BUSINESS_RULE_VIOLATION);
        this.businessRule = businessRule;
    }

    @Override
    public String formatException() {
        return String.format(FORMATO_EXCEPCION, errorCode.getCode(), businessRule);
    }

}
