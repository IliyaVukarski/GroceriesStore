import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomerBasket implements CalculatableBillOfProducts {
	
	private List<Product> productsBoughtRepo;
	private List<Product> twoForThreeDealProductsRepo;
	private List<Product> buyOneGetOneHalfPriceProductsRepo;
	
	public CustomerBasket() {
		this.productsBoughtRepo = new ArrayList<Product>();
		this.twoForThreeDealProductsRepo = new ArrayList<Product>();
		this.buyOneGetOneHalfPriceProductsRepo = new ArrayList<Product>();
	}
	
	public List<Product> getProductsBought() {
		return Collections.unmodifiableList(productsBoughtRepo);
	}
	
	public List<Product> getTwoForThreeDealProducts() {
		return Collections.unmodifiableList(twoForThreeDealProductsRepo);
	}

	public List<Product> getBuyOneGetOneHalfPriceProducts() {
		return Collections.unmodifiableList(buyOneGetOneHalfPriceProductsRepo);
	}

	public double calculateBill() {
		double total = 0;
		total = calculateBill(productsBoughtRepo, total);
		total = calculate2For3Discount(twoForThreeDealProductsRepo, total);
		total = calculateBuy1Get1HalfPrice(buyOneGetOneHalfPriceProductsRepo, total);
		return total;
	}

	private double calculateBuy1Get1HalfPrice(List<Product> products, double total) {
		double tempPrice = 0;
		for (int index = 0; index < products.size(); index++) {
			double currentPrice = products.get(index).getPrice() * 0.50;
			tempPrice += currentPrice;
		}
		total -= tempPrice;
		return total;
	}
	
	private double calculate2For3Discount(List<Product> products, double total) {
		double tempPrice = getDiscountFor2For3Discount(products);
		total -= tempPrice;
		return total;
	}

	private double getDiscountFor2For3Discount(List<Product> products) {
		int tempPrice = 0;
		for (int index = 0; index < 3; index++) {
			tempPrice = Math.min(products.get(0).getPrice(), 
								 products.get(index).getPrice());
		}
		return tempPrice;
	}

	private double calculateBill(List<Product> products, double total) {
		for (int index = 0; index < products.size(); index++) {
			total += products.get(index).getPrice();
		}
		return total;
	}
	
	public void getSelectedProducts(String typeOfRepo, String[] customerBasket,
			List<Product> marketProducts) {
		for (int index = 0; index < customerBasket.length; index++) {
			getSelectedProduct(typeOfRepo, customerBasket, marketProducts, index);
		}
	}

	private void getSelectedProduct(String typeOfRepo, String[] customerBasket, 
				List<Product> products, int index) {
		String currentProduct = customerBasket[index];
		switch (currentProduct) {
			case "apple":
				addProductToRepository(typeOfRepo, products, 0);
				break;
			case "banana":
				addProductToRepository(typeOfRepo, products, 1);
				break;
			case "tomato":
				addProductToRepository(typeOfRepo, products, 2);
				break;
			case "potato":
				addProductToRepository(typeOfRepo, products, 3);
				break;
		}
	}

	private void addProductToRepository(String typeOfRepo, 
			List<Product> marketProducts, int marketProductIndex) {
		if(typeOfRepo.equals("productsBoughtRepo")) {
			productsBoughtRepo.add(marketProducts.get(marketProductIndex));
		}else if(typeOfRepo.equals("twoForThreeDealProductsRepo")) {
			twoForThreeDealProductsRepo.add(marketProducts.get(marketProductIndex));
		}else if(typeOfRepo.equals("buyOneGetOneHalfPriceProductsRepo")) {
			buyOneGetOneHalfPriceProductsRepo.add(marketProducts.get(marketProductIndex));
		}
	}
}