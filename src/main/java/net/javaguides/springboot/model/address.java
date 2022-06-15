package net.javaguides.springboot.model;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.persistence.*;


@Entity
@Table(name = "address1")


public class address {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private long id;
	
	
	@NotBlank(message = "Please provide first Name")
	@Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9-]*$", message = "first name must be alphanumeric and start with character")
	private String firstName;
	
	@NotBlank(message = "Please provide last Name")
	@Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9-]*$", message = "last name must be alphanumeric and start with character")
	private String lastName; 
	
	@NotBlank(message = "Please provide email id")
	
	@Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "enter valid email id")
	private String email;
	
	@NotBlank(message = "Please provide phone number")
	@Pattern(regexp = "[0-9]{10}", message = "enter 10 digit nnumber")
	private String phonenumber; 
	
	@NotBlank(message = "Please provide phone number")
	private String address1;
	
	public address() {
		
	}
	
	
	public address(String firstName, String lastName, String email, String phonenumber, String address1) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phonenumber = phonenumber;
		this.address1 = address1;
	}
	
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name = "first_name",nullable = false )
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@Column(name = "last_name",nullable = false )
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(name = "email",nullable = false )
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name = "phone_number",nullable = false )
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	
	@Column(name = "address_info",nullable = false )
	public String getAddress() {
		return address1;
	}
	public void setAddress(String address1) {
		this.address1 = address1;
	}
	
	@Override
	public String toString() {
		return "Address [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + email+ ", Address="+address1+"]";
	}
}
