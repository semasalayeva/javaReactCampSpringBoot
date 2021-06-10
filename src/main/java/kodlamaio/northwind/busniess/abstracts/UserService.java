package kodlamaio.northwind.busniess.abstracts;

import kodlamaio.northwind.core.entities.User;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;

public interface UserService {
    DataResult<User> findByEmail(String email);
    Result add(User user);

}
