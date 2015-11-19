package ch.gmazlami.gifty.models.gift;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ch.gmazlami.gifty.models.user.User;

@Entity
@Table(name="gifts")
public class Gift {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
	private Long id;
	
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
    
    @Column(name = "title", nullable = false)
    private String title;
    
    @Column(name = "description", nullable = false)
	private String description;
	
    @Column(name = "link", nullable = false)
	private String link;

    @Column(name = "status", nullable = false)
	private GiftStatus status;
	
	public Gift(){}
	
	
	public Gift(User user, String description, String link, GiftStatus status, String title) {
		this.user = user;
		this.description = description;
		this.link = link;
		this.status = status;
		this.title = title;
	}

	
	public GiftStatus getStatus() {
		return status;
	}

	
	
	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public void setStatus(GiftStatus status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
