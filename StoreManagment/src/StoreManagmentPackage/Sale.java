package StoreManagmentPackage;

public class Sale {
	int idCustomer;
	int idItem;
	int quantity;
	String itemName;

	// ----Constructor----
	public Sale(int idCustomer, int idItem, int quantity, String itemName) {
		this.idCustomer = idCustomer;
		this.idItem = idItem;
		this.quantity = quantity;
		this.itemName = itemName;
	}

	// ----Properties----
	public int getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}

	public int getIdItem() {
		return idItem;
	}

	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

}
