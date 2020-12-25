package com.megaProject.OnlineFoodOrder.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "offers")
public class Offers {
	@Id
	@Column(name = "offer_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int OfferId;

	@Column(name = "offer_title")
	private String OfferTitle;

	@Column(name = "code")
	private String code;

	@Column(name = "offer_percent")
	private int offerPercent;

	@Column(name = "offer_image_path")
	private String offerImagePath;
	
	public Offers() {
		
	}

	public Offers(int offerId, String offerTitle, String code, int offerPercent, String offerImagePath) {
		OfferId = offerId;
		OfferTitle = offerTitle;
		this.code = code;
		this.offerPercent = offerPercent;
		this.offerImagePath = offerImagePath;
	}

	public int getOfferId() {
		return OfferId;
	}

	public void setOfferId(int offerId) {
		OfferId = offerId;
	}

	public String getOfferTitle() {
		return OfferTitle;
	}

	public void setOfferTitle(String offerTitle) {
		OfferTitle = offerTitle;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getOfferPercent() {
		return offerPercent;
	}

	public void setOfferPercent(int offerPercent) {
		this.offerPercent = offerPercent;
	}

	public String getOfferImagePath() {
		return offerImagePath;
	}

	public void setOfferImagePath(String offerImagePath) {
		this.offerImagePath = offerImagePath;
	}

}
