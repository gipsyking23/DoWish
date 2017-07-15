package fr.dowish.error;

/**
 * Classe de gestion d'erreur: message
 * @author Tabouré cheick
 * @version 0.1
 */
public class ErrorResponse {

	private int status;
	private int code;
	private String message;

	public ErrorResponse(int status, int code, String message) {
		this.status = status;
		this.code = code;
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "ErrorResponse{" + "status=" + status + ", code=" + code + ", message=" + message + '}';
	}

}
