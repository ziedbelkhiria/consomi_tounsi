package tn.esprit.spring.entity;

public class Responsemodel {
	private String message ;

	public String getMessage() {
		return message;
	}

	public Responsemodel(String message) {
		super();
		this.message = message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
