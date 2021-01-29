
public class Guest {
	private String lastName;
	private String firstName;
	private String email;
	private String phoneNumber;
	
	public Guest(String lastName, String firstName, String email, String phoneNumber) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	
	public Guest() {
		
	}
	/*
	public int checkGuest (Guest g) {
		if(this.lastName.equals(g.lastName) && this.firstName.equals(g.firstName)
				|| this.email.equals(g.email) || this.phoneNumber.equals(g.phoneNumber))
			return -1;	
		return 0;
		}
	*/	
	
	/*
	public boolean checkGuest (String lastName, String firstName) {
		if (this.lastName.equals(lastName) && this.firstName.equals(firstName))
			return true;
		return false;
	}
	
	public boolean checkGuest (String phoneNumber) {
		if (this.phoneNumber.equals(phoneNumber))
			return true;
		return false;
	}
	*/
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public void updateLastName(String lastName) {
		this.lastName = lastName;
		System.out.println("Nume de familie modificat.");
	}
	
	public void updateFirstName(String firstName) {
		this.firstName = firstName;
		System.out.println("Prenume modificat.");
	}
	
	public void updateEmail(String email)
	{
		this.email = email;
		System.out.println("Email modificat.");
	}
	
	public void updatePhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber; 
		System.out.println("Numar de telefon modificat.");
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		if (this == obj)
			return true;
		
		return false;
	}
	
}


