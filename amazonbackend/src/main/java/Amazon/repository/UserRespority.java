package Amazon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Amazon.entity.User;


public interface UserRespority extends JpaRepository<User, Integer> {
	
	

}
