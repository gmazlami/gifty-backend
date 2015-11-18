package ch.gmazlami.gifty.models.gift;

import org.springframework.data.annotation.Id;

public class Gift {

	@Id
	private String id;
	
	private String userId;
	
	private String description;
	
	private String link;

	private GiftStatus status;
	
	public Gift(){}
	
	
	public Gift(String id, String userId, String description, String link, GiftStatus status) {
		super();
		this.id = id;
		this.userId = userId;
		this.description = description;
		this.link = link;
		this.status = status;
	}

	
	public GiftStatus getStatus() {
		return status;
	}

	public void setStatus(GiftStatus status) {
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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
	
	
	
	
	
}
