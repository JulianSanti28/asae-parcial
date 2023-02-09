package co.unicauca.parcial.exceptionControllers.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ErrorCode {

    GENERIC_ERROR("GC-0001", "ERROR GENERICO"),
    ENTITY_EXIST("GC-0002", "ERROR ENTIDAD YA EXISTE"),
    ENTITY_NOT_EXIST("GC-0003", "ERROR ENTIDAD NO ENCONTRADA"),
    BUSINESS_RULE_VIOLATION("GC-0004", "VIOLACION REGLA DE NEGOCIO"),
    STORAGE_DB_VIOLATION("GC-0005","VIOLACION ALMACENAMIENTO DB");


    private final String code;
    private final String messageKey;
}
