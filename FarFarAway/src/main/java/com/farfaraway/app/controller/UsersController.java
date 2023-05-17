package src.main.java.com.farfaraway.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.farfaraway.app.dto.Users;
import com.farfaraway.app.service.UsersService;

@RestController
public class UsersController {

	@Autowired
	UsersService usersService;

	@GetMapping("/users")
	public List<Users> listarUserss() {
		return usersService.listUsers();
	}

	@PostMapping("/users")
	public Users salvarUsers(@RequestBody Users users) {
		return usersService.saveUsers(users);
	}

	@GetMapping("/users/{id}")
	public Users usersXID(@PathVariable(name = "id") Long id) {
		return usersService.usersXID(id);
	}

	@PutMapping("/users/{id}")
	public Users actualizarUsers(@PathVariable(name = "id") Long id, @RequestBody Users users) {
		Users usersSelected = new Users();
		Users usersUpdated = new Users();

		usersSelected = usersService.usersXID(id);
		usersSelected.setAge(users.getAge());
		usersSelected.setUser_password(users.getUser_password());
		usersSelected.setEmail(users.getEmail());
		usersSelected.setUser_name(users.getUser_name());
		usersSelected.setSurname(users.getSurname());
		usersSelected.setPhone_number(users.getPhone_number());
		usersSelected.setFiscal_name(users.getFiscal_name());
		usersSelected.setCompany_cif(users.getCompany_cif());

		usersUpdated = usersService.updateUsers(usersSelected);

		return usersUpdated;
	}

	@DeleteMapping("/users/{id}")
	public void eliminarUsers(@PathVariable(name = "id") Long id) {
		usersService.deleteUsers(id);
	}
}
