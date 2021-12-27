package com.happiestlearning.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.happiestlearning.constants.RoleNameEnum;


@Entity
@Table(name = "user_profile")
public class UserProfile implements Serializable {

    private static final long serialVersionUID = 1257461189602165846L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "login")
    private String login;

    @Column(name = "name")
    private String name;

    @Column(name = "mail")
    private String mail;

    @Column(name = "group_id")
    private Integer groupId;

    @Column(name = "created_time")
    private Timestamp createdTime;

    @Column(name = "last_login_time")
    private Timestamp lastLoginTime;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    private transient boolean isApiChannel;

    //    @Transient
    //    private boolean activityGroupAdmin;

    public UserProfile() {
        /* Mandatory empty constructor */
    }

    /**
     * Create User with basic informations
     *
     * @param login
     * @param name
     * @param mail
     * @param groupId
     */
    public UserProfile(String login, String name, String mail, Integer groupId) {
        super();
        this.login = login;
        this.name = name;
        this.mail = mail;
        this.groupId = groupId;
    }

    /**
     * Create User with basic informations
     *
     * @param name
     * @param id
     * @param mail
     * @param login
     */
    public UserProfile(String name, Long id, String mail, String login) {
        super();
        this.id = id;
        this.login = login;
        this.name = name;
        this.mail = mail;
    }

    /**
     * Create User with just Name
     *
     * @param name
     **/
    public UserProfile(String name) {
        super();
        this.name = name;
    }

    /**
     * Create User with basic informations
     *
     * @param login
     * @param name
     * @param mail
     * @param groupId
     */
    public UserProfile(String login, String name, String mail, Integer groupId, Role role) {
        super();
        this.login = login;
        this.name = name;
        this.mail = mail;
        this.groupId = groupId;
        this.role = role;
    }

    /**
     * Create User with basic information
     *
     * @param login
     * @param name
     * @param mail
     * @param groupId
     * @param role
     * @param id
     * @param createdTime
     * @param lastLoginTime
     */
    public UserProfile(String login, String name, String mail, Integer groupId, Role role, long id,
            Timestamp createdTime, Timestamp lastLoginTime) {
        super();
        this.login = login;
        this.name = name;
        this.mail = mail;
        this.groupId = groupId;
        this.role = role;
        this.id = id;
        this.createdTime = createdTime;
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return this.id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return this.login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the mail
     */
    public String getMail() {
        return this.mail;
    }

    /**
     * @param mail the mail to set
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * @return the groupId
     */
    public Integer getGroupId() {
        return this.groupId;
    }

    /**
     * @param groupId the groupId to set
     */
    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    /**
     * @return the createdTime
     */
    public Timestamp getCreatedTime() {
        return this.createdTime;
    }

    /**
     * @param createdTime the createdTime to set
     */
    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * @return the lastLoginTime
     */
    public Timestamp getLastLoginTime() {
        return this.lastLoginTime;
    }

    /**
     * @param lastLoginTime the lastLoginTime to set
     */
    public void setLastLoginTime(Timestamp lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * @return True if the user is SuperAdmin
     */
    public boolean isSuperAdmin() {
        return role != null && RoleNameEnum.SUPER_ADMIN.name().equals(role.getName());
    }

    /**
     * To check if the user is activityGroupAdmin for any Activity
     *
     * @return
     */
    //    public boolean isActivityGroupAdmin() {
    //        return activityGroupAdmin;
    //    }

    /**
     * @return the isApiChannel
     */
    public boolean isApiChannel() {
        return isApiChannel;
    }

    /**
     * @param isApiChannel the isApiChannel to set
     */
    public void setApiChannel(boolean isApiChannel) {
        this.isApiChannel = isApiChannel;
    }

    /**
     * set value of activity group admin for user.
     *
     * @param activityGroupAdmin
     */
    //    public void setActivityGroupAdmin(boolean activityGroupAdmin) {
    //        this.activityGroupAdmin = activityGroupAdmin;
    //    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "UserProfile [id=" + this.id + ", login=" + this.login + ", name=" + this.name + "," + " mail="
                + this.mail + ", groupId=" + this.groupId + ", createdTime=" + this.createdTime + ", lastLoginTime="
                + this.lastLoginTime + "]";
    }

}