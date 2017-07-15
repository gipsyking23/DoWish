package fr.dowish.error;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * Classe de gestion d'exception
 * @author Tabouré cheick
 * @version 0.1
 */


@RestControllerAdvice
	public class GlobalControllerExceptionHandler {

	    @ExceptionHandler(value = { ConstraintViolationException.class })
	    @ResponseStatus(HttpStatus.OK)
	    public ErrorResponse constraintViolationException() {
	        return new ErrorResponse(500, 5001,"la date saisie n'est pas valide !");
	    }

	    @ExceptionHandler(value = { DataIntegrityViolationException.class })
	    @ResponseStatus(HttpStatus.OK)
	    public ErrorResponse dataIntegrityViolationException() {
	        return new ErrorResponse(500, 5002, "l'un des champs saisis existe déjà !");
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





