package mainaha.hibernate.demo.bean;

public class VendorBean {

	private int vendorId;

	private String vendorName;

	private String location;

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public VendorBean(int vendorId, String vendorName, String location) {
		super();
		this.vendorId = vendorId;
		this.vendorName = vendorName;
		this.location = location;
	}

	@Override
	public String toString() {
		return "VendorBean [vendorId=" + vendorId + ", vendorName=" + vendorName + ", location=" + location + "]";
	}
	
	
}
