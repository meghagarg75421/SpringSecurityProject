package com.example.dataobjects;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name="userData")
public class User{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1503350078189021690L;

	@GeneratedValue
	@Id
	private Integer Id;
	
	//@Column (unique = true)
	@Column(name="username")
	@NotBlank (message = "Username cannot be blank")
	private String userName;
	
	@NotBlank (message = "Password cannot be blank")
	private String passWord;
	
	@Column(nullable = false)
	private boolean enabled;
	
	/*@Transient
	private MyRole roleName;*/
	
	private String authority;
	@OneToOne(fetch = FetchType.LAZY,cascade =  CascadeType.ALL,  mappedBy = "user")
	@Valid
	private UserPersonalDetails userPersonalDetails;
	
	@OneToOne(fetch = FetchType.LAZY,cascade =  CascadeType.ALL,  mappedBy = "user")
	@Valid
	private RoleTable roleTable;
	public User() {}
	
	
	//private Collection<? extends GrantedAuthority> authorities;
	
	/*public Users(Integer id, @NotBlank(message = "Username cannot be blank") String userName,
			@NotBlank(message = "Password cannot be blank") String passWord, boolean enabled,
			@Valid UserPersonalDetails userPersonalDetails, String roles,
			Collection<? extends GrantedAuthority> authorities) {
		super();
		Id = id;
		this.userName = userName;
		this.passWord = passWord;
		this.enabled = enabled;
		this.userPersonalDetails = userPersonalDetails;
		this.ROLE_NAME = ROLE_NAME;
		this.authorities = authorities;
	}*/

	/*public Users(Integer id, String userName, String passWord,boolean enabled,
            boolean accountNonExpired,
            boolean credentialsNonExpired,
            boolean accountNonLocked,UserPersonalDetails userPersonalDetails) {
		super();
		Id = id;
		this.userName = userName;
		this.passWord = passWord;
		this.userPersonalDetails=userPersonalDetails;
	}
	
	public Users(java.lang.String username,
            java.lang.String password,
            
            java.util.Collection<? extends GrantedAuthority> authorities) {
		this.userName = userName;
		this.passWord = passWord;
		this.userPersonalDetails=userPersonalDetails;
	}
	*/
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	

	public User(Integer id, @NotBlank(message = "Username cannot be blank") String userName,
			@NotBlank(message = "Password cannot be blank") String passWord, boolean enabled, String authority,
			@Valid UserPersonalDetails userPersonalDetails, @Valid RoleTable roleTable) {
		super();
		Id = id;
		this.userName = userName;
		this.passWord = passWord;
		this.enabled = enabled;
		this.authority = authority;
		this.userPersonalDetails = userPersonalDetails;
		this.roleTable = roleTable;
	}


	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	@Override
	public String toString() {
		return "Users [Id=" + Id + ", userName=" + userName + ", passWord=" + passWord + "]";
	}
	

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public UserPersonalDetails getUserPersonalDetails() {
		return userPersonalDetails;
	}

	public void setUserPersonalDetails(UserPersonalDetails userPersonalDetails) {
		this.userPersonalDetails = userPersonalDetails;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


	public String getAuthority() {
		return authority;
	}


	public void setAuthority(String authority) {
		this.authority = authority;
	}


	public String getUserName() {
		return userName;
	}


	public String getPassWord() {
		return passWord;
	}


	public RoleTable getRoleTable() {
		return roleTable;
	}


	public void setRoleTable(RoleTable roleTable) {
		this.roleTable = roleTable;
	}

	
	
	


	/*public Role getRoleName() {
		return roleName;
	}


	public void setRoleName(Role roleName) {
		this.roleName = roleName;
	}*/


	

	


	
	
	
	
}
