package com.api.crechau.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String resourceName, String fieldName, String fieldValue){
        super(String.format("%s não encontrado com %s = %s", resourceName, fieldName, fieldValue));
    }
}
