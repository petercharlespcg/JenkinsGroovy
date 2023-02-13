import hudson.model.User;
import hudson.security.*;

class UserManager{
  Set allUsers(){
    return User.getAll();
  }
  
  void createUser(String userName, String password) {
    Jenkins instance = Jenkins.getInstance();
    def realm = new HudsonPrivateSecurityRealm(false);
    
    realm.createAccount(userName, password);
    instance.setSecurityRealm(realm);
    instance.save();
  }
  
  void deleteUser(String id){
    User u = User.get(id);
    u.delete();
  }
}


def mgr = new UserManager();

//mgr.createUser("test", "user");
mgr.deleteUser("test");

for (user in mgr.allUsers()) {
  println(user.id);
}

