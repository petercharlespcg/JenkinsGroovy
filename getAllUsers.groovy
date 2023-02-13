import hudson.model.*;

for (user in User.getAll()) {
  println(user.id);
}