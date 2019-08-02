package gdut.tackout.bean;

import java.util.ArrayList;

public class HomeInfo {
	ArrayList<Promotion> promotionList;
	ArrayList<Category> categorieList;
	ArrayList<Seller> nearbySellerList;
	ArrayList<Seller> otherSellerList;
	
	
	
	public HomeInfo(ArrayList<Promotion> promotionList,
			ArrayList<Category> categorieList,
			ArrayList<Seller> nearbySellerList,
			ArrayList<Seller> otherSellerList) {
		super();
		this.promotionList = promotionList;
		this.categorieList = categorieList;
		this.nearbySellerList = nearbySellerList;
		this.otherSellerList = otherSellerList;
	}
	
	
	public ArrayList<Promotion> getPromotionList() {
		return promotionList;
	}
	public void setPromotionList(ArrayList<Promotion> promotionList) {
		this.promotionList = promotionList;
	}
	public ArrayList<Category> getCategorieList() {
		return categorieList;
	}
	public void setCategorieList(ArrayList<Category> categorieList) {
		this.categorieList = categorieList;
	}
	public ArrayList<Seller> getNearbySellerList() {
		return nearbySellerList;
	}
	public void setNearbySellerList(ArrayList<Seller> nearbySellerList) {
		this.nearbySellerList = nearbySellerList;
	}
	public ArrayList<Seller> getotherSellerList() {
		return otherSellerList;
	}
	public void setotherSellerList(ArrayList<Seller> otherSellerList) {
		this.otherSellerList = otherSellerList;
	}

}
