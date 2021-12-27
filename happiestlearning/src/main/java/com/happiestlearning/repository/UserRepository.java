package com.happiestlearning.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.happiestlearning.entity.UserProfile;



public interface UserRepository extends JpaRepository<UserProfile, Long> {

    /**
     * This method returns the User profile based on login provided
     *
     * @param login login id
     * @return Matched user profile by login name provided
     */
    UserProfile findByLogin(String login);

    /**
     * This method returns the User profile based on group id provided
     *
     * @param group id
     * @return Matched user profile group id provided
     */
    List<UserProfile> findByGroupId(Integer groupId);

    /**
     * This method returns all the User profiles matches with the role name provided
     *
     * @param roleName Role of the user
     * @return Matched User Profiles with Role names
     */
    List<UserProfile> findByRoleName(String roleName);

    /**
     * To fetch all user profile interface object
     * @param created user Id
     * @return List of reference Beans
     **/
    // @Query(value = "SELECT id, login, name, mail FROM user_profile", nativeQuery
    // = true)
    // List<UserProfileIBean> fetchAllAsBean();
    
    /**
     * To fetch all user profile interface object
     * (replacing list of Interface bean to list of object for better performance)
     * @param created user Id
     * @return List of reference Beans
     **/
    @Query(value = "select id, login, name, mail, group_id, created_time, last_login_time, role_id  from user_profile", nativeQuery = true)
    List<Object[]> fetchAllUserDetails();
    
    /**
     * To fetch the user id by email address.
     * @param email
     * @return
     */
    List<UserProfile> findByMailIn(String[] email);

}
