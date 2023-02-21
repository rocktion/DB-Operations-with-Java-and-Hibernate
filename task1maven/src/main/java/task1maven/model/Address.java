package task1maven.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "city")
	private String city;
	
	@Column(name = "district")
	private String district;

	@Column(name = "zip")
	private int zip;
	
	@Column(name = "open")
	private String open;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	
	public Address() {
		super();
	}


	public Address(String city, String district, int zip, String open, Customer customer) {
		super();
		this.city = city;
		this.district = district;
		this.zip = zip;
		this.open = open;
		this.customer = customer;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getDistrict() {
		return district;
	}


	public void setDistrict(String district) {
		this.district = district;
	}


	public int getZip() {
		return zip;
	}


	public void setZip(int zip) {
		this.zip = zip;
	}


	public String getOpen() {
		return open;
	}


	public void setOpen(String open) {
		this.open = open;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	@Override
	public String toString() {
		return "Address [id=" + id + ", city=" + city + ", district=" + district + ", zip=" + zip + ", customer=" + customer + "]";
	}
	
	

}
