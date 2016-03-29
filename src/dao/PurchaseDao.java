package dao;

import java.util.ArrayList;

import model.Purchase;
import model.User;

public interface PurchaseDao {
	public boolean AddPurchase(Purchase purchase);
	public boolean DeletePurchase(Purchase purchase);
	public boolean DeletePurchase(String purchase_id);
	public boolean AdjustPurchase(Purchase purchase);
	public ArrayList<Purchase> ListPurchases(User usr);
}
