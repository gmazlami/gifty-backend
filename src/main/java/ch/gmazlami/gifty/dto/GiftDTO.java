package ch.gmazlami.gifty.dto;

import ch.gmazlami.gifty.models.gift.GiftStatus;

public class GiftDTO {

    private String userId;
    
    private String title;
    
	private String description;
	
	private String link;

	private GiftStatus status;

	
	public GiftDTO(String userId, String title, String description,String link, GiftStatus status) {
		super();
		this.userId = userId;
		this.title = title;
		this.description = description;
		this.link = link;
		this.status = status;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public GiftStatus getStatus() {
		return status;
	}

	public void setStatus(GiftStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "GiftDTO [userId=" + userId + ", title=" + title
				+ ", description=" + description + ", link=" + link
				+ ", status=" + status + "]";
	}
	
	
	
	
	
	
}
