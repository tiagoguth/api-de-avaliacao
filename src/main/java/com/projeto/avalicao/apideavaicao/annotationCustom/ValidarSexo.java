package com.projeto.avalicao.apideavaicao.annotationCustom;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidarSexo implements ConstraintValidator<ValidSexo, Character> {
	public void inicializar(ValidSexo validSexo)
    {
       
    }

    public boolean isValid(Character validSexo, ConstraintValidatorContext constraintContext)
    {   
        if (validSexo == null)
        {
            return false;
        }
        if(validSexo.equals('F') || validSexo.equals('M') || validSexo.equals('f') || validSexo.equals('m')){
            return true;   
        
        }else
        {
            return false;
        }

    }
}
