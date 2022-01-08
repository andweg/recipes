package recipes.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import recipes.user.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

}
