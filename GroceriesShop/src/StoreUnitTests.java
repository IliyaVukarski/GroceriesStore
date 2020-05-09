
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;


public class StoreUnitTests {
	@Test
	public void testProductDiscountForBuy1Get1HalfPriceWithSameTypeOfProducts() {
		
		String[] customerBasket = {"apple", "apple"};
		List<Product> marketProducts = new ArrayList<Product>(
				Arrays.asList(new Product("apple", 50), 
							  new Product("banana", 40),
							  new Product("tomato", 30),
							  new Product("potato", 26))
		);
		CustomerBasket basket = new CustomerBasket();
		basket.getSelectedCustomerProducts(customerBasket, marketProducts);
		
		int expectedTotal = 75;
		int actualTotal = (int) basket.calculateBill();
		Assert.assertEquals(expectedTotal, actualTotal);
	}
	
	@Test
	public void testProductDiscountForBuy1Get1HalfPriceWithTwoDifferentProducts() {
		
		String[] customerBasket = {"apple", "banana"};
		List<Product> marketProducts = new ArrayList<Product>(
				Arrays.asList(new Product("apple", 50), 
							  new Product("banana", 40),
							  new Product("tomato", 30),
							  new Product("potato", 26))
		);
		CustomerBasket basket = new CustomerBasket();
		basket.getSelectedCustomerProducts(customerBasket, marketProducts);
		
		int expectedTotal = 90;
		int actualTotal = (int) basket.calculateBill();
		Assert.assertEquals(expectedTotal, actualTotal);
	}
	
	@Test
	public void testProductDiscountForBuy1Get1HalfPrice() {
		String[] customerBasket = {"apple", "banana", "potato", "tomato","tomato"};
		List<Product> marketProducts = new ArrayList<Product>(
				Arrays.asList(new Product("apple", 50), 
							  new Product("banana", 40),
							  new Product("tomato", 30),
							  new Product("potato", 26))
		);
		CustomerBasket basket = new CustomerBasket();
		basket.getSelectedCustomerProducts(customerBasket, marketProducts);
		int expectedTotal = 135;
		int actualTotal = (int) basket.calculateBill();
		Assert.assertEquals(expectedTotal, actualTotal);
	}
	
	
	@Test
	public void testCalculate2For3Discount() {
		String[] customerBasket = {"apple", "banana", "potato"};
		List<Product> marketProducts = new ArrayList<Product>(
				Arrays.asList(new Product("apple", 50), 
							  new Product("banana", 40),
							  new Product("tomato", 30),
							  new Product("potato", 26))
		);
		CustomerBasket basket = new CustomerBasket();
		basket.getSelectedCustomerProducts(customerBasket, marketProducts);
		
		
		int expectedTotal = 90;
		int actualTotal = (int) basket.calculateBill();
		Assert.assertEquals(expectedTotal, actualTotal);
	}
	
	@Test
	public void testBillExample() {
		String[] customerBasket = {"apple", "banana", "banana", "potato", "tomato", "banana", "potato"};
		List<Product> marketProducts = new ArrayList<Product>(
				Arrays.asList(new Product("apple", 50), 
							  new Product("banana", 40),
							  new Product("tomato", 30),
							  new Product("potato", 26))
		);
		CustomerBasket basket = new CustomerBasket();
		basket.getSelectedCustomerProducts(customerBasket, marketProducts);
		
		int expectedTotal = 199;
		int actualTotal = (int) basket.calculateBill();
		Assert.assertEquals(expectedTotal, actualTotal);
	}
	
	@Test
	public void testAddingItems() {
		String[] customerBasket = {"apple", "banana", "banana", "potato", "tomato", "banana", "potato"};
		List<Product> marketProducts = new ArrayList<Product>(
				Arrays.asList(new Product("apple", 50), 
							  new Product("banana", 40),
							  new Product("tomato", 30),
							  new Product("potato", 26))
		);
		CustomerBasket basket = new CustomerBasket();
		basket.getSelectedCustomerProducts(customerBasket, marketProducts);
		int expectedSize= 7;
		int actualSize= basket.getProductsBought().size();
		
		Assert.assertEquals(expectedSize, actualSize);
	}
}