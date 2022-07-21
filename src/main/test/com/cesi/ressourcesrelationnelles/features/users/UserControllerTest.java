package com.cesi.ressourcesrelationnelles.features.users;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.cesi.ressourcesrelationnelles.domain.User;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
@AutoConfigureDataMongo
public class UserControllerTest {

	@InjectMocks
	@Autowired
	private UserController userController;

	@Autowired
	private UserRepository userRepository;

	private User user = new User("1L", "fisrtname.secondname@gmail.com", "1234567890", "FirstName", "LastName", 1);
	private final Exception nullBodyException = new Exception("Response body is null");

	@SuppressWarnings("deprecation")
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		saveUser();
	}

	private void saveUser() {
		try {
			userRepository.save(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void getUserByIdTest() throws Exception {
		ResponseEntity<User> reponse = userController.getUserById("1L", null);
		assert (reponse.getStatusCode() == HttpStatus.OK);
		try {
			assert (reponse.getBody().getId().equals(user.getId()));
		} catch (Exception e) {
			throw nullBodyException;
		}
	}

	@Test
	public void getUserByIdWithEmailTest() throws Exception {
		ResponseEntity<User> reponse = userController.getUserById(null, "fisrtname.secondname@gmail.com");
		assert (reponse.getStatusCode() == HttpStatus.OK);
		assert (reponse.getBody().getEmail().equals(user.getEmail()));
	}

	@Test
	public void getUserByIdTest_NO_CONTENT() throws Exception {
		ResponseEntity<User> reponse = userController.getUserById("99L", null);
		assert (reponse.getStatusCode() == HttpStatus.NO_CONTENT);
	}

	@Test
	public void getUsersTest() throws Exception {
		ResponseEntity<List<User>> reponse = userController.getUsers(null, null);
		assert (reponse.getStatusCode() == HttpStatus.OK);
		List<User> reponseUserList = reponse.getBody();
		assert (reponseUserList.contains(user));
	}

	@Test
	public void getUsersByByLastNameTest() throws Exception {
		ResponseEntity<List<User>> reponse = userController.getUsers(null, "LastName");
		assert (reponse.getStatusCode() == HttpStatus.OK);
		assert (reponse.getBody().contains(user));
	}

	@Test
	public void createUserTest() throws Exception {
		User user2 = new User("2L", "newuser@gmail.com", "psswrd", "FirstName2", "LastName2", 1);
		ResponseEntity<User> reponse = userController.createUser(user2);
		assert (reponse.getStatusCode() == HttpStatus.CREATED);
		assert (userController.getUsers(null, null).getBody().contains(user2));
	}

	@Test
	public void updateUserTest() {
		User user2 = new User("1L", "newuser@gmail.com", "psswrd", "FirstName2", "LastName2", 1);
		ResponseEntity<User> reponse = userController.updateUser("1L", user2);
		assert (reponse.getStatusCode() == HttpStatus.OK);
		assert (userController.getUserById("1L", null).getBody().getEmail().equals(user2.getEmail()));
		assert (userController.getUserById("1L", null).getBody().getPassword().equals(user2.getPassword()));
		assert (userController.getUserById("1L", null).getBody().getFirstName().equals(user2.getFirstName()));
		assert (userController.getUserById("1L", null).getBody().getLastName().equals(user2.getLastName()));
	}
	
	@Test
	public void deleteUserTest() {
		ResponseEntity<HttpStatus> reponse = userController.deleteUser("1L");
		assert(reponse.getStatusCode() == HttpStatus.OK);
		assert(!userController.getUsers(null, null).getBody().contains(user));
	}
}
