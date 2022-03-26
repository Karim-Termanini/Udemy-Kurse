package StoreManagmentPackage;

public class Customer {
	int id;
	int cart;
	String name;

	// ----Constructor----
	public Customer(int id, int cart, String name) {
		this.id = id;
		this.cart = cart;
		this.name = name;
	}

	// ----Properties----
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCart() {
		return cart;
	}

	public void setCart(int cart) {
		this.cart = cart;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
