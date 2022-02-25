package quanganh.service;

import quanganh.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private static Map<Integer, User> userMap = new HashMap<>();

    static {
        userMap.put(1, new User(1, "01628706136", 18, "tran anh", "anh tuan", "tincanxh@gmail.com"));
        userMap.put(2, new User(2, "01628706136", 18, "tran anh2", "anh tuan", "tincanxh@gmail.com"));
        userMap.put(3, new User(3, "01628706136", 18, "tran anh3", "anh tuan", "tincanxh@gmail.com"));
        userMap.put(4, new User(4, "01628706136", 18, "tran anh4", "anh tuan", "tincanxh@gmail.com"));
    }


    @Override
    public List<User> findAll() {
        return new ArrayList<>(userMap.values());
    }

    @Override
    public void save(User user) {
        userMap.put(user.getId(), user);
    }

    @Override
    public User findById(int id) {
        return userMap.get(id);
    }

    @Override
    public void update(int id, User user) {
        userMap.put(id, user);
    }

    @Override
    public void remove(int id) {
        userMap.remove(id);
    }
}