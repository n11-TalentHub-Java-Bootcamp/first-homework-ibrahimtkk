package entityservice;

import dao.UserDao;
import dto.UserDto;
import entity.User;

public class UserEntityService {

    private UserDao userDao;

    public UserEntityService() {
        userDao = new UserDao();
    }

    public UserDto findById(Long id){
        final User user = userDao.findById(id);
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .surname(user.getSurname())
                .email(user.getEmail())
                .phone(user.getPhone())
                .build();
    }
}
