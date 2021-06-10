package kodlamaio.northwind.busniess.concretes;

import kodlamaio.northwind.busniess.abstracts.UserService;
import kodlamaio.northwind.core.dataAccess.UserDao;
import kodlamaio.northwind.core.entities.User;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.core.utilities.results.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManager implements UserService {
    private UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public DataResult<User> findByEmail(String email) {
        return new SuccessDataResult<>(userDao.findByEmail(email),"kulanici bulundu");
    }

    @Override
    public Result add(User user) {
        userDao.save(user);
        return new SuccessResult("kulanici eklendi");
    }
}
