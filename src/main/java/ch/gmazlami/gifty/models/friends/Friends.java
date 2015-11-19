package ch.gmazlami.gifty.models.friends;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import ch.gmazlami.gifty.models.user.User;

@Entity
@Table(name="friends")
public class Friends {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
	private Long id;
	
    @Column(name = "userA_id", nullable = false)
	private Long userA;
	
    @Column(name = "userB_id", nullable = false)
	private Long userB;


	public Friends(Long userA, Long userB) {
		super();
		this.userA = userA;
		this.userB = userB;
	}
	

	
	
	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public Long getUserA() {
		return userA;
	}




	public void setUserA(Long userA) {
		this.userA = userA;
	}




	public Long getUserB() {
		return userB;
	}




	public void setUserB(Long userB) {
		this.userB = userB;
	}




	@Override
	public String toString() {
		return "Friends [userA=" + userA + ", userB=" + userB + "]";
	}
	
	
	
	
	
}
