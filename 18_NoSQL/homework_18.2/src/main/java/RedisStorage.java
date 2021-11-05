import org.redisson.Redisson;
import org.redisson.api.RScoredSortedSet;
import org.redisson.api.RedissonClient;
import org.redisson.client.RedisConnectionException;
import org.redisson.client.codec.StringCodec;
import org.redisson.config.Config;

public class RedisStorage {

    private RedissonClient redisson;
    private final static String KEY = "registered_users"; //Значение ключа
    private RScoredSortedSet<String> registeredUsers;

    public void init(){
        try {
            Config config = new Config();
            config.useSingleServer().setAddress("redis://127.0.0.1:6379");
            redisson = Redisson.create(config);
            registeredUsers = redisson.getScoredSortedSet(KEY, StringCodec.INSTANCE);
        } catch (RedisConnectionException ex){
            ex.printStackTrace();
        }
    }

    public void shutdown(){
        redisson.shutdown();
    }

    public void addRegisteredUser(double registrationTime, String userName){
        registeredUsers.add(registrationTime, userName);
    }

    public String[] getAnArrayOfElements(){
        String[] arrayOfElements = new String[registeredUsers.size()];
        registeredUsers.toArray(arrayOfElements);
        return arrayOfElements;
    }
}
