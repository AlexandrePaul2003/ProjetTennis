package be.PaulA.pojo;

public class Person {
	private String firstname;
	private String lastname;
	private String nationnality;
	
	public Person(String firstname, String lastname, String nationnality) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.nationnality = nationnality;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getNationnality() {
		return nationnality;
	}

	public void setNationnality(String nationnality) {
		this.nationnality = nationnality;
	}
	
	
	
}
