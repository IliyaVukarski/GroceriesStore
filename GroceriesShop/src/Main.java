import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	private static final String[] typeOfRepositories = {
		"productsBoughtRepo",
		"twoForThreeDealProductsRepo",
		"buyOneGetOneHalfPriceProductsRepo"
	};
	private static List<Product> marketProducts = new ArrayList<Product>(
			Arrays.asList(new Product("apple", 50), 
						  new Product("banana", 40),
						  new Product("tomato", 30),
						  new Product("potato", 26))
	);
	
	private static void printBill(double total) {
		int aws = (int) (total / 100);
		int clouds = (int) (total - (aws * 100));
		System.out.printf("%d aws and %d clouds", aws, clouds);
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] twoForThreeDealProducts = scanner.nextLine().split("\\,\\s+");
		String[] buyOneGetOneHalfPrice = scanner.nextLine().split("\\,\\s+");
		String[] customerBasket = scanner.nextLine().split("\\,\\s+");
		CustomerBasket basket = new CustomerBasket();
		basket.getSelectedProducts(typeOfRepositories[0], customerBasket, marketProducts);
		basket.getSelectedProducts(typeOfRepositories[1], twoForThreeDealProducts, marketProducts);
		basket.getSelectedProducts(typeOfRepositories[2], buyOneGetOneHalfPrice, marketProducts);
		
		double total = basket.calculateBill();
		printBill(total);
	}
}
