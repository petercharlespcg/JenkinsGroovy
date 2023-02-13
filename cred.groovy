import com.cloudbees.plugins.credentials.*;
import com.cloudbees.plugins.credentials.common.*;
import com.cloudbees.plugins.credentials.impl.UsernamePasswordCredentialsImpl;

class CredentialManager{
  Set getAll(){
    return CredentialsProvider.lookupCredentials(StandardUsernameCredentials.class, Jenkins.instance, null, null)
  }
}

def mgr = new CredentialManager();

for (cred in mgr.all) {
  println(cred.id + '\t' + cred.description);
}