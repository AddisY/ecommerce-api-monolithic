package com.addisy.ecommerceapi.store.controller;

import com.addisy.ecommerceapi.store.config.SecurityUtility;
import com.addisy.ecommerceapi.store.domian.User;
import com.addisy.ecommerceapi.store.domian.Role;
import com.addisy.ecommerceapi.store.domian.UserRole;
import com.addisy.ecommerceapi.store.service.RoleService;
import com.addisy.ecommerceapi.store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public Map<String, Object> registerUser(HttpServletRequest request, @RequestBody HashMap<String, String> mapper) {
		String username = mapper.get("username");
		String userEmail = mapper.get("email");
		String password = mapper.get("password");
		String firstName = mapper.get("firstName");
		String lastName = mapper.get("lastName");

		if (userService.findUserByUsername(username) != null) {
			return Collections.singletonMap("message", "Username already exists");
		}

		if (userService.findByEmail(userEmail) != null) {
			return Collections.singletonMap("message", "email already exists");
		}

		User user = new User();
		user.setUsername(username);
		user.setEmail(userEmail);
		user.setFirstName(firstName);
		user.setLastName(lastName);

		String encryptedPassword = SecurityUtility.passwordEncoder().encode(password);
		user.setPassword(encryptedPassword);

		Role role = new Role();
		String roleTitle = "ROLE_USER";
		Role userRole = roleService.findRoleByRoleName(roleTitle);
		int userRoleId = userRole.getRoleId();
		role.setRoleId(userRoleId);
		role.setName("ROLE_USER");
		Set<UserRole> userRoles = new HashSet<>();
		userRoles.add(new UserRole(user, role));

		User user1 = userService.createUser(user, userRoles);

		Map<String,Object> response = new HashMap<>();

		response.put("message", "Registration successful!");
		response.put("user", user1);

		return response;
	}


	@RequestMapping(value="/update", method=RequestMethod.POST)
	public Map<String,Object> editUser(
			@RequestBody HashMap<String, Object> mapper
	){

		Integer id =  (Integer) mapper.get("id");
		String email = (String) mapper.get("email");
		String username = (String) mapper.get("username");
		String firstName = (String) mapper.get("firstName");
		String lastName = (String) mapper.get("lastName");
		String currentPassword = (String) mapper.get("currentPassword");
		String newPassword = (String) mapper.get("newPassword");

		User user = userService.findById(Long.valueOf(id)).orElse(null);

		if(user == null) {
			return Collections.singletonMap("message", "User not found");
		}

		BCryptPasswordEncoder passwordEncoder = SecurityUtility.passwordEncoder();
		String dbPassword = user.getPassword();

		if(passwordEncoder.matches(currentPassword, dbPassword)) {
			user.setPassword(passwordEncoder.encode(newPassword));
			user.setEmail(email);
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setUsername(username);
		} else {
			return Collections.singletonMap("message", "Incorrect current password");
		}

		User user1 = userService.save(user);

		Map<String,Object> response = new HashMap<>();

		response.put("message", "update successful!");
		response.put("user", user1);

		return response;
	}

	@RequestMapping("/{id}")
	public User getUser(@PathVariable("id") Long id) {

		User user = userService.findById(id).orElse(null);

		return user;
	}

	/** Uncomment the line below to restrict action only to admins. It is disabled for testing purposes. The basic config for this has been set, so method level restrictions like this one can be simply made on other methods as well **/
	//@Secured("ROLE_ADMIN")
	@RequestMapping(value="/delete/{id}")
	public Map<String, String> delete(@PathVariable("id") Long id) {

		userService.removeUserById(id);
		return Collections.singletonMap("message", "User removed");

	}

	//@Secured("ROLE_ADMIN")
	@RequestMapping("/list")
	public List<User> getUserList() {

		return userService.findAll();
	}


}