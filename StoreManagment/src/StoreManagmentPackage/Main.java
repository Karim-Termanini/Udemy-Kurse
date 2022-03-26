/*
 * 
 */
package StoreManagmentPackage;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * The Class Main.
 */
public class Main {

	/** The item. */
	// ------Item Class-------
	public static Item[] item = new Item[20];

	/** The size. */
	public static int size = 0;

	/** The customer. */
	// ------Customer Class-------
	public static Customer[] customer = new Customer[20];

	/** The customer size. */
	public static int customerSize = 0;

	/** The cart. */
	public static String[] cart = new String[10];

	/** The sales. */
	// ------Sale Class-------
	public static Sale[] sales = new Sale[20];

	/** The sale size. */
	public static int saleSize = 0;

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	// ------MAIN-------
	public static void main(final String[] args) {

		for (int i = 0; i < cart.length; i++) {
			cart[i] = "Empty";
		}
		mainMenu();
	}

	/**
	 * Main menu.
	 */
	// ----JopionPane Menu Erstellen----
	public static void mainMenu() {
		while (true) {

			final String menu = "Store System Menu:\n" + "1. Add a new Item to the Store.\n"
					+ "2. Add a new Customer to the Store.\n" + "3. Add an Item to the Customer Shopping Cart.\n"
					+ "4. Remove an Item from Customer Shopping Cart.\n"
					+ "5. View the Items in the Customer Shopping Cart.\n" + "6. End Shopping and go to checkout.\n"
					+ "7. Make the Customer Shopping Cart Empty.\n" + "8. Exit the Program.";

			// -----------------------
			final String numberMenu = JOptionPane.showInputDialog(null, menu);
			final int n_M = Integer.parseInt(numberMenu);

			switch (n_M) {
			case 1: {
				addItem();
				break;
			}
			case 2: {
				addCstomer();
				break;
			}
			case 3: {
				addItemCustomerCart();
				break;
			}
			case 4: {
				final String ID = JOptionPane.showInputDialog(null, "Enter Customer Id Number: ");
				final int id = Integer.parseInt(ID);
				removenItemFromCustomerShoppingCart(id);
				break;
			}
			case 5: {
				final String IDC = JOptionPane.showInputDialog(null, "Enter Customer Id Number: ");
				final int idc = Integer.parseInt(IDC);
				display(idc);
				break;
			}
			case 6: {
				final String IDC = JOptionPane.showInputDialog(null, "Enter Customer Id Number: ");
				final int idc = Integer.parseInt(IDC);
				endShoppingAndGoToCheckout(idc);
				break;
			}
			case 7: {
				final String IDC = JOptionPane.showInputDialog(null, "Enter Customer Id Number: ");
				final int idc = Integer.parseInt(IDC);
				makeTheCustomerShoppingCartEmpty(idc);
				break;
			}
			case 8: {
				System.exit(0);
			}

			}

		}
	}

	/**
	 * Make the customer shopping cart empty.
	 *
	 * @param iDC the i DC
	 */
	public static void makeTheCustomerShoppingCartEmpty(final int iDC) {
		if (-1 != searchIdCustomer(iDC)) {
			for (int i = 0; i < saleSize; i++) {
				if (iDC == sales[i].getIdCustomer()) {
					final int qua = sales[i].getQuantity();
					final int index = searchNameItem(sales[i].getItemName());
					final int total = qua + item[index].getQuan();
					item[index].setQuan(total);
					for (int j = i; j < saleSize; j++) {
						if (saleSize - 1 == j) {
							saleSize--;
						}
						sales[j] = sales[j + 1];
					}
				}
			}

		} else {
			JOptionPane.showMessageDialog(null, "ID Number DOSN'T exists!!");
		}
	}

	/**
	 * End shopping and go to checkout.
	 *
	 * @param idc the idc
	 */
	public static void endShoppingAndGoToCheckout(final int idc) {
		if (-1 != searchIdCustomer(idc)) {
			display(idc);
			empty(idc);
			for (int i = 0; i < customerSize; i++) {
				if (idc == customer[i].getId()) {
					for (int j = i; j < customerSize; j++) {
						if (customerSize - 1 == j) {
							customerSize--;
							JOptionPane.showMessageDialog(null, "Deleted!");
							break;
						}
						customer[i] = customer[i + 1];
					}
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "ID Number DOSN'T exists!!");
		}
	}

	/**
	 * Empty.
	 *
	 * @param idc the idc
	 */
	public static void empty(final int idc) {
		for (int i = 0; i < saleSize; i++) {
			if (idc == sales[i].getIdCustomer()) {
				for (int j = i; j < saleSize; j++) {
					if (saleSize - 1 == j) {
						saleSize--;
					}
					sales[j] = sales[j + 1];
				}
			}
		}

	}

	/**
	 * Display.
	 *
	 * @param idc the idc
	 */
	public static void display(final int idc) {
		if (-1 != searchIdCustomer(idc)) {
			int total = 0;
			String data = "Item id|        |Name|        |Quantity|        |Unit Price|        |Total Price ";
			for (int i = 0; i < saleSize; i++) {
				if (idc == sales[i].getIdCustomer()) {
					final int index = searchNameItem(sales[i].getItemName());
					data += "\n" + sales[i].getIdItem() + "|             |" + sales[i].getItemName() + "|          |"
							+ sales[i].getQuantity() + "|              |" + item[index].getPrice()
							+ "|                |" + (item[index].getPrice() * sales[i].getQuantity());
					total += sales[i].getQuantity() * item[index].getPrice();
				}
			}
			data += "\n                                                                           total Price: "
					+ total;
			JOptionPane.showMessageDialog(null, data);
		} else {
			JOptionPane.showMessageDialog(null, "ID Number DOSN'T exists!!");
		}

	}

	/**
	 * Remove item from customer shopping cart.
	 *
	 * @param id the id
	 */
	public static void removenItemFromCustomerShoppingCart(final int id) {
		final int searchId = searchIdCustomer(id);
		final ArrayList<String> nameItemsSales = new ArrayList<String>();
		final ArrayList<Integer> indexItemSales = new ArrayList<Integer>();
		if (searchId != -1) {
			String data = "The Customer No: [ " + customer[searchId].getId() + " ] Customer Name: [ "
					+ customer[searchId].getName() + "\n";
			for (int i = 0; i < saleSize; i++) {
				nameItemsSales.add(sales[i].getItemName());
				indexItemSales.add(i);
				if (id == sales[i].getIdCustomer()) {
					data += " \n(" + (i + 1) + ").\nCustomer-id:    " + sales[i].getIdCustomer() + "        Name:    "
							+ sales[i].getItemName() + "\nItem-quantity:    " + sales[i].getQuantity() + "\n";
				}
			}
			final String quastion = "What do you want to Modify?\n" + "          ############          \n"
					+ "R. remove item from the Cart.\n" + "M. return to the main menu.\n"
					+ "          ############          \n" + "Enter your choice [R Remove, M Main Menu]:";
			final String choice = JOptionPane.showInputDialog(null, data + "\n" + quastion);
			if (choice.toUpperCase().equals("M")) {
				return;
			} else if (choice.toUpperCase().equals("R")) {
				final String CHOICE = JOptionPane.showInputDialog(null,
						data + ".......\n0.Return to the main menu\nEnter your Item option number: ");
				final int choiceInt = Integer.parseInt(CHOICE);
				if (choiceInt == 0) {
					return;
				}
				final String nameItem = nameItemsSales.get(choiceInt - 1);
				final String message = "The Item [" + sales[indexItemSales.get(choiceInt - 1)].getIdItem() + "       "
						+ nameItem + "      Quantity [" + sales[indexItemSales.get(choiceInt - 1)].getQuantity()
						+ "] ] is removed from the shopping Cart";
				final int Quan = deleteItem(nameItem, id);
				final int indexNameItem = searchNameItem(nameItem);
				final int total = item[indexNameItem].getQuan() + Quan;
				item[indexNameItem].setQuan(total);
				JOptionPane.showMessageDialog(null, message);

			} else {
				JOptionPane.showMessageDialog(null, "Invalid Charachter!!");
			}
		} else {
			JOptionPane.showMessageDialog(null, "ID Number DOSN'T exists");
		}

	}

	/**
	 * Delete item.
	 *
	 * @param nameItem the name item
	 * @param id       the id
	 * @return the int
	 */
	public static int deleteItem(final String nameItem, final int id) {
		for (int i = 0; i < saleSize; i++) {
			if (id == sales[i].getIdCustomer()) {

				if (nameItem.equals(sales[i].getItemName())) {
					if (saleSize - 1 == i) {
						final int quan = sales[i].getQuantity();
						saleSize--;
						return quan;
					}
					final int quan = sales[i].getQuantity();
					sales[i] = sales[i + 1];
					saleSize--;
					return quan;
				}
			}
		}
		return 0;
	}

	/**
	 * Adds the item cart.
	 *
	 * @param index the index
	 * @return the int
	 */
	// ----showing the Cart Details and choosing from it Method---
	public static int addItemCart(final int index) {
		int n = -1;
		do {

			String data = "The Customer No: [ " + customer[index].getId() + " ] Customer Name: [ "
					+ customer[index].getName() + " ].\nItems in the Stor: ";
			final ArrayList<String> list = new ArrayList<>();

			for (int i = 0; i < size; i++) {
				list.add(item[i].getName());
				data += " \n(" + (i + 1) + ").\nItem-id:    " + item[i].getId() + "        Name:    "
						+ item[i].getName();

			}
			data += "\n" + "0. Return to a the Main Menu.\n" + "Enter your Item choise :";

			final String numberChoise = JOptionPane.showInputDialog(null, data);
			final int nC = Integer.parseInt(numberChoise);
			if (nC == 0) {
				return -1;
			} else {
				String choseOption = " ";
				String itemName = " ";
				String itemTitle = " ";
				String itemAuthor = " ";
				int quantity = 0;
				int idItem = -1;
				int itemPrice = 0;

				for (int i = 0; i < size; i++) {
					if (list.get(nC - 1).equals(item[i].getName())) {
						quantity = item[i].getQuan();
						idItem = item[i].getId();
						itemName = item[i].getName();
						itemTitle = item[i].getNameType();
						itemAuthor = item[i].getAuthor();
						itemPrice = (item[i].getPrice() * quantity);

						choseOption = "Item-id:    " + idItem + "        Name:    " + itemName + "\nQuantity:    "
								+ quantity + "        Price:    " + itemPrice + "\nItem Title:        " + itemTitle
								+ "        Item Author:        " + itemAuthor + "\nEnter the Required Quantity: ";
						break;
					}
				}

				final String quanRequired = JOptionPane.showInputDialog(null, choseOption);
				final int qR = Integer.parseInt(quanRequired);
				if (quantity >= qR && quantity > 0 && quantity != 0) {
					sales[saleSize] = new Sale(customer[index].getId(), idItem, qR, itemName);
					final int totla = quantity - qR;
					final int indexItemName = searchNameItem(itemName);
					item[indexItemName].setQuan(totla);
					saleSize++;
					JOptionPane.showMessageDialog(null, "The Product has been added to your Shopping Cart.");
					return -1;
				}
				final String YesOrNo = JOptionPane.showInputDialog(null,
						"Sorry the Required Quantity is't available,the available Quantity is [" + quantity
								+ "],try agein!");
				n = Integer.parseInt(YesOrNo);
			}

		} while (n == 1);
		return 0;
	}

	/**
	 * Adds the item customer cart.
	 */
	// -----Add Items to the Customer Cart Method -----
	public static void addItemCustomerCart() {
		int qustion = -1;
		do {
			// -----Take the Customer ID-----
			final String IDCustomer = JOptionPane.showInputDialog(null, "Enter Customer ID:");
			final int id = Integer.parseInt(IDCustomer);
			// ....Using the Search Id Customer Method.....
			final int index = searchIdCustomer(id);
			// -----
			if (index != -1) {
				final int number = addItemCart(index);
				if (number == 0) {
					return;
				}
			}

			final String numberYes = JOptionPane.showInputDialog(null, "do you want to try again(1/0)?");
			qustion = Integer.parseInt(numberYes);
		} while (qustion == 1);
	}

	/**
	 * Adds the Customer.
	 */
	// -----Add Customer Method -----
	public static void addCstomer() {
		int n = -1;
		do {
			final JTextField id = new JTextField();
			final JTextField name = new JTextField();

			final Object[] message = { "Enter Customer Number: ", id, " ,Enter Customer Name: ", name };

			final int YES = JOptionPane.showConfirmDialog(null, message);

			// -------------------------------------
			// ----condition to get the Value from the Variables----
			// -------------------------------------
			if (YES == JOptionPane.YES_OPTION) {
				final int ID = Integer.parseInt(id.getText());
				final String Name = name.getText();
				if (searchIdCustomer(ID) != -1) {
					JOptionPane.showMessageDialog(null, "The Customer Id is already registred!.");
					return;
				}

				// -------------------------------------
				// -----------------Cart Number---------
				int numberCartInt = -1;
				boolean status = true;
				do {
					String numberCart = "NuCart          Status\n";
					for (int i = 0; i < cart.length; i++) {
						numberCart += "     " + (i + 1) + "                    " + cart[i] + "\n";
					}
					final String numberCartString = JOptionPane.showInputDialog(null, numberCart);
					numberCartInt = Integer.parseInt(numberCartString);
					// ---------------------------------------------------------------
					// -----------------Check if there an Empty Shopping Cart---------
					if (cart[numberCartInt - 1].equals("Empty")) {
						cart[numberCartInt - 1] = ID + "";
						status = false;
					}
				} while (status);

				customer[customerSize] = new Customer(ID, numberCartInt - 1, Name);
				customerSize++;
				JOptionPane.showMessageDialog(null, "This Customer has been added.");

			}
			final String option = JOptionPane.showInputDialog(null, "Do you want add another Customer (1/0)?");
			n = Integer.parseInt(option);
		} while (n == 1);

	}

	/**
	 * Adds the item.
	 */
	// -----Add Method -----
	public static void addItem() {
		int n = -1;
		do {

			final JTextField id = new JTextField();
			final JTextField name = new JTextField();
			final JTextField price = new JTextField();
			final JTextField type = new JTextField();
			final JTextField quan = new JTextField();
			final JTextField author = new JTextField();
			final JTextField nameType = new JTextField();

			final Object[] message1 = { "Enter Item Number: ", id, "Enter Item Name: ", name, "Enter Item Quantity ",
					quan, "Enter Item Price: ", price, "Enter the Type of Items(B)Book,(S)Shose,(G)Games? ", type };
			final int yesOrno = JOptionPane.showConfirmDialog(null, message1);

			// ----Sorting the Types-----
			final Object[] book = { "Enter the Book Type(Comedy/Classic/Lerning....): ", nameType,
					"Enter Book Author: ", author };
			final Object[] shoes = { "Enter the Shoes Type(S/B/L): ", nameType, "Enter Shoes Author: ", author };
			final Object[] game = { "Enter the Game Type(RTS/FPS/RPG....): ", nameType, "Enter Game Author: ", author };

			/*
			 * 
			 * Results
			 * 
			 */

			int result1 = 1;

			// ----condition-Type of the Items----
			if (type.getText().toUpperCase().equals("B")) {
				result1 = JOptionPane.showConfirmDialog(null, book);
			} else if (type.getText().toUpperCase().equals("S")) {
				result1 = JOptionPane.showConfirmDialog(null, shoes);
			} else if (type.getText().toUpperCase().equals("G")) {
				result1 = JOptionPane.showConfirmDialog(null, game);
			} else {
				JOptionPane.showMessageDialog(null, "Invalid Charachter");
			}
			// -------------------------------------
			// ----condition to get the Value from the Variables----
			// -------------------------------------
			if (yesOrno == JOptionPane.YES_OPTION) {
				// ------------------------------------
				// -------------------------------------
				final int ID = Integer.parseInt(id.getText());
				final String Name = name.getText();
				final int Quan = Integer.parseInt(quan.getText());
				final int Price = Integer.parseInt(price.getText());
				final String Type = type.getText();
				final String NameType = nameType.getText();
				final String Author = author.getText();
				// ------------------------------------
				// -------------------------------------
				final int index = searchIdItem(ID);
				final int indexName = searchNameItem(Name);
				// -------------------------------------
				// -----------------ID------------------
				if (index == -1) {
					item[size] = new Item(ID, Quan, Price, Name, Type, Author, NameType);
					size++;
					JOptionPane.showMessageDialog(null, "Sucsessfully.!");
				} else {
					JOptionPane.showMessageDialog(null, "Item ID already exists!!");
				}
				// -------------------------------------
				// -----------------Names and Quantity----------------
				if (indexName != -1) {
					item[indexName].addQuan(Quan);
					JOptionPane.showMessageDialog(null,
							"Item ID already exists,the new Quantity will be added to the old Quantity");
					return;
				}

			}

			final String option = JOptionPane.showInputDialog(null, "Do you want add another item (1/0)?");
			n = Integer.parseInt(option);
		} while (n == 1);
	}

	/**
	 * Search id item.
	 *
	 * @param iD the i D
	 * @return the int
	 */
	// ----Check if the ID has been or not----
	public static int searchIdItem(final int iD) {
		for (int i = 0; i < size; i++) {
			if (iD == item[i].getId()) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Search name item.
	 *
	 * @param name the name
	 * @return the int
	 */
	// ----Check if the Name has been or not----
	public static int searchNameItem(final String name) {
		for (int i = 0; i < size; i++) {
			if (name.equals(item[i].getName())) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Search id customer.
	 *
	 * @param iD the i D
	 * @return the int
	 */
	// ----Check if the ID Customer has been added or not---
	public static int searchIdCustomer(final int iD) {
		for (int i = 0; i < customerSize; i++) {
			if (customer[i].getId() == iD) {
				return i;
			}
		}
		return -1;
	}

}
