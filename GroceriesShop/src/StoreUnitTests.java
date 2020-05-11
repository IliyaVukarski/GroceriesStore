
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;


public class StoreUnitTests {
	private final static List<Product> marketProducts = new ArrayList<Product>(
			Arrays.asList(new Product("apple", 50), 
					  	  new Product("banana", 40),
					      new Product("tomato", 30),
					      new Product("potato", 26))
	);
	
	private final static String[] twoForThreeDealProductsRepo = {"apple", "banana", "banana"};
	private final static String[] buyOneGetOneHalfPriceProductsRepo = {"potato"};
	private final static String[] customerBasket = {"apple", "banana", "banana", "potato", "tomato", "banana", "potato"};
	
	@Test
	public void testcalculateBillMethod_test() {
		
		CustomerBasket basket = new CustomerBasket();
		basket.getSelectedProducts("twoForThreeDealProductsRepo", twoForThreeDealProductsRepo, marketProducts);
		basket.getSelectedProducts("buyOneGetOneHalfPriceProductsRepo", buyOneGetOneHalfPriceProductsRepo, marketProducts);
		basket.getSelectedProducts("productsBoughtRepo", customerBasket, marketProducts);
		int expectedTotal = (int) basket.calculateBill();
		int actualTotal = (int) 199.0;
		Assert.assertEquals(expectedTotal, actualTotal);
	}
	
	@Test
	public void testAddingTwoForThreeDealProductsRepoPriceCustomerItems() {
		CustomerBasket basket = new CustomerBasket();
		basket.getSelectedProducts("twoForThreeDealProductsRepo", twoForThreeDealProductsRepo, marketProducts);
		int expectedSize= 3;
		int actualSize= basket.getTwoForThreeDealProducts().size();
		Assert.assertEquals(expectedSize, actualSize);
	}
	
	@Test
	public void testAddingbuyOneGetOneHalfPriceCustomerItems() {
		CustomerBasket basket = new CustomerBasket();
		basket.getSelectedProducts("buyOneGetOneHalfPriceProductsRepo", buyOneGetOneHalfPriceProductsRepo, marketProducts);
		int expectedSize= 1;
		int actualSize= basket.getBuyOneGetOneHalfPriceProducts().size();
		Assert.assertEquals(expectedSize, actualSize);
	}
	
	@Test
	public void testAddingCustomerItems() {
		CustomerBasket basket = new CustomerBasket();
		basket.getSelectedProducts("productsBoughtRepo", customerBasket, marketProducts);
		int expectedSize= 7;
		int actualSize= basket.getProductsBought().size();
		Assert.assertEquals(expectedSize, actualSize);
	}
}