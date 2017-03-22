package xshop.core;

import xshop.entity.UserInfo;
import xshop.data.UserRepository;
import java.util.List;

public class UserService{
	UserRepository repository;
	
	public UserService(){
		repository = new UserRepository();
	}
	
    public boolean add(UserInfo user){
        return repository.add(user);
    }
    public List<UserInfo> getAll(){
        return repository.getAll();
    }
    public boolean edit(UserInfo user){
        return repository.edit(user);
    }
    public UserInfo getById(int userId){
        return repository.getById(userId);
    }

    public UserInfo getByUserId(String userId){
        return repository.getByUserId(userId);
    }


  /*  

  
    

    public boolean remove(int userId){
        return repository.remove(userId);
    }*/
}