package bo.edu.ucb.sis.bahiapirata.bl;

import bo.edu.ucb.sis.bahiapirata.dao.UserDao;
import bo.edu.ucb.sis.bahiapirata.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBl {

    private UserDao userDao;

    @Autowired
    public UserBl(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<UserModel> findAllActives() {
        return this.userDao.findAllActives();
    }

    public UserModel findUserById(int userId) {
        return this.userDao.findUserById(userId);
    }
}