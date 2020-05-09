import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomerBasket implements CalculatableBillOfProducts {
	
	private List<Product> productsBought;
	
	public CustomerBasket() {
		this.productsBought = new ArrayList<Product>();
	}
	
	public List<Product> getProductsBought() {
		return Collections.unmodifiableList(productsBought);
	}

	public double calculateBill() {
		double total = 0;
		total = calculateBill(productsBought, total);
		total = calculate2For3Discount(productsBought, total);
		total = calculateBuy1Get1HalfPrice(productsBought, total);
		return total;
	}

	private double calculateBuy1Get1HalfPrice(List<Product> products,
			double total) {
		double tempPrice = 0;
		tempPrice = getProductDiscountForBuy1Get1HalfPrice(products);
		total -= tempPrice;
		return total;
	}

	private double getProductDiscountForBuy1Get1HalfPrice(List<Product> products) {
		double tempPrice = 0;
		if(products.size() > 4) {
			for (int index = 3; index < products.size(); index++) {
				String firstProduct = products.get(index).getName();
				for (int j = index + 1; j < products.size(); j++) {
					String secondProduct = products.get(j).getName();
					if(firstProduct.equals(secondProduct)) {
						tempPrice = (products.get(j).getPrice() * 0.5);
					}
				}
			}
		}else if(products.size() == 2) {
			if(products.get(0).getName().equals(products.get(1).getName())) {
				tempPrice = products.get(1).getPrice() * 0.5;
			}
		}
		return tempPrice;
	}

	private double calculate2For3Discount(List<Product> products, double total) {
		int tempPrice = getDiscountFor2For3Discount(products);
		total-=tempPrice;
		return total;
	}

	private int getDiscountFor2For3Discount(List<Product> products) {
		int tempPrice = 0;
		if(products.size() > 2) {
			for (int index = 0; index < 3; index++) {
				tempPrice = Math.min(products.get(0).getPrice(), 
								     products.get(index).getPrice());
			}
		}
		return tempPrice;
	}

	private double calculateBill(List<Product> products, double total) {
		for (int index = 0; index < products.size(); index++) {
			total += products.get(index).getPrice();
		}
		return total;
	}
	
	public void getSelectedCustomerProducts(String[] customerBasket,
			List<Product> marketProducts) {
		for (int index = 0; index < customerBasket.length; index++) {
			getSelectedProduct(customerBasket, marketProducts, index);
		}
	}

	private void getSelectedProduct(String[] customerBasket,
			List<Product> marketProducts, int index) {
		String currentProduct = customerBasket[index];
		switch (currentProduct) {
			case "apple":
				productsBought.add(marketProducts.get(0));
				break;
			case "banana":
				productsBought.add(marketProducts.get(1));
				break;
			case "tomato":
				productsBought.add(marketProducts.get(2));
				break;
			case "potato":
				productsBought.add(marketProducts.get(3));
				break;
		}
	}
}