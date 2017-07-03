package fr.dowish.error;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
	public class GlobalControllerExceptionHandler {

	    @ExceptionHandler(value = { ConstraintViolationException.class })
	    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	    public ErrorResponse constraintViolationException() {
	        return new ErrorResponse(500, 5001,"le champ saisi existe déjà !");
	    }


	    @ExceptionHandler(value = { DataIntegrityViolationException.class })
	    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	    public ErrorResponse dataIntegrityViolationException() {
	        return new ErrorResponse(500, 5002, "le champ ne correspond pas au format attendu !");
	    };
	    
	    @ExceptionHandler(value = { NullPointerException.class })
	    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	    public ErrorResponse NullPointerException() {
	        return new ErrorResponse(500, 5003, "Erreur de Traitement !");
	    }
	    
	    
	    @ExceptionHandler(value = { org.hibernate.NonUniqueResultException.class })
	    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	    public ErrorResponse NonUniqueResultException() {
	        return new ErrorResponse(500, 5003, "le résultat renvoit plusieurs éléments !");
	    }
	}





