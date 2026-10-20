package mainaha.hibernate.demo.bean;

public class ProductBean {
	
	private int productId;
	
	private String productName;
	
	private float price;

	
	public ProductBean( String productName, float price) {
		super();
		this.productName = productName;
		this.price = price;
	}
	
	
	
	public ProductBean(int productId, String productName, float price) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ProductBean [productId=" + productId + ", productName=" + productName + ", price=" + price + "]";
	}

}
