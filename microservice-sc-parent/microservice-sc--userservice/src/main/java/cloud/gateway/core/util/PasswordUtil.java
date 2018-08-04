package cloud.gateway.core.util;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import java.util.UUID;

public class PasswordUtil {

/*    public static String encodePassword(String password){
        String encodedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        return encodedPassword;
    }

    public static boolean verifyPassword(String targetPassword, String encodedPassword){
        return BCrypt.checkpw(targetPassword, encodedPassword);
    }*/

    private String algorithmName = "md5";	//指定散列算法为MD5,还有别的算法如：SHA256、SHA1、SHA512

    private int hashIterations = 2;		//散列迭代次数 md5(md5(pwd)): new Md5Hash(pwd, salt, 2).toString()


    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }

    public void setHashIterations(int hashIterations) {
        this.hashIterations = hashIterations;
    }

    //加密：输入明文得到密文
    public String encodePassword(String pwd, String salt) {

        //user.setSalt(randomNumberGenerator.nextBytes().toHex());

        String newPassword = new SimpleHash(
                algorithmName,
                pwd,
                ByteSource.Util.bytes(salt),
                hashIterations).toHex();

        return newPassword;
    }
    
    public boolean verifyPassword(String targetPassword, String pwd, String salt){
    	 String newPassword = this.encodePassword(targetPassword, salt);
    	 if(newPassword.equals(pwd)){
    		 return true;
    	 }else{
    		 return false;
    	 }
    }
	public static  void main(String[] args){

        String uuid = UUID.randomUUID().toString().replace("-","");
        System.out.println("uuid:"+uuid);
        String encodePassword = new PasswordUtil().encodePassword("123", uuid); //暗文密码
        System.out.println("password:"+encodePassword);
    }
}
