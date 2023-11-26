package be.PaulA.pojo;

public class Person {
	protected String firstname;
	protected String lastname;
	protected String nationnality;
	
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

	@Override
	public String toString() {
		return "Referee : " + firstname+ " " + lastname +" ";
	}
	@Override 
	public int hashCode() {
		return super.hashCode();
	}
	@Override
	public boolean equals(Object o) {
		return this.toString().hashCode()==o.toString().hashCode() ? true : false;
	}
	
	
	
}
