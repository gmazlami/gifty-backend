package ch.gmazlami.gifty.models.friends;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ch.gmazlami.gifty.models.user.User;

@Entity
@Table(name="friends")
public class Friends {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
	private Long id;

	@ManyToOne
	private User userA;
	
	@ManyToOne
	private User userB;


	public Friends(){
		super();
	}
	
	
	public Long getId() {
		return id;
	}


	public User getUserA() {
		return userA;
	}


	public void setUserA(User userA) {
		this.userA = userA;
	}


	public User getUserB() {
		return userB;
	}

	
	public void setUserB(User userB) {
		this.userB = userB;
	}


	@Override
	public String toString() {
		return "Friends [userA=" + userA + ", userB=" + userB + "]";
	}
	
	
	
	
	
}
