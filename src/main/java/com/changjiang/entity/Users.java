package com.changjiang.entity;
public class Users {
    private Integer id;
    private String username;
    private String password;
    private Integer roleId;
    private String store;
    private Integer userInformation;
    private String enabled;
    private Role role;
    private UserInformation user;
    
    public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public UserInformation getUser() {
		return user;
	}
	public void setUser(UserInformation user) {
		this.user = user;
	}
	public Users() {
        super();
    }
    public Users(Integer id,String username,String password,Integer roleId,String store,Integer userInformation,String enabled) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
        this.roleId = roleId;
        this.store = store;
        this.userInformation = userInformation;
        this.enabled = enabled;
    }
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRoleId() {
        return this.roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getStore() {
        return this.store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public Integer getUserInformation() {
        return this.userInformation;
    }

    public void setUserInformation(Integer userInformation) {
        this.userInformation = userInformation;
    }

    public String getEnabled() {
        return this.enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

}
