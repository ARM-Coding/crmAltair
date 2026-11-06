package edu.altair.crmAltair.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(DepartamentoNotFoundException.class)
	public ProblemDetail manejarDepartamentoNoEncontrado(DepartamentoNotFoundException ex) {
		ProblemDetail problem = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
		problem.setTitle("Departamento no encontrado");
		problem.setProperty("timestamp", Instant.now());
		return problem;
	}
	
	@ExceptionHandler(CodigoAlreadyExistsException.class)
	public ProblemDetail manejarCodigoDuplicado(CodigoAlreadyExistsException ex) {
		ProblemDetail problem = ProblemDetail.forStatusAndDetail(HttpStatus.CONFLICT, ex.getMessage());
		problem.setTitle("Conflicto de datos");
		problem.setProperty("timestamp", Instant.now());
		return problem;
	}
	
}
