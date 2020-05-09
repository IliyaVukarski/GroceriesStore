
public class Product implements Productable {
	
	private String name;
	private int price;
	
	public Product(String name, int price) {
		this.setName(name);
		this.setPrice(price);
	}
	
	public String getName() {
		return name;
	}
	
	private void setName(String name) {
		this.name = name;
	}
	
	public int getPrice() {
		return price;
	}
	
	private void setPrice(int price) {
		this.price = price;
	}
}
