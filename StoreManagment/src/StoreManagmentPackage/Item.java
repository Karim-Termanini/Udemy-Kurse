package StoreManagmentPackage;

public class Item {
	int id;
	int quan;
	int price;
	String name;
	String type;
	String author;
	String nameType;

	// ----Constructor----
	public Item(int id, int quan, int price, String name, String type, String author, String nameType) {
		this.id = id;
		this.quan = quan;
		this.price = price;
		this.name = name;
		this.type = type;
		this.author = author;
		this.nameType = nameType;
	}

	// ----Properties----
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuan() {
		return quan;
	}

	public void setQuan(int quan) {
		this.quan = quan;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getNameType() {
		return nameType;
	}

	public void setNameType(String nameType) {
		this.nameType = nameType;
	}

	// ----Methods----
	public void addQuan(int quant) {
		this.quan += quant;
	}

}
