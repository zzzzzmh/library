package com.lashouinc.library;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.lashou.common.util.Page;
import com.lashouinc.library.service.BookService;
import com.lashouinc.library.service.UserService;
import com.lashouinc.library.service.domain.Book;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:spring/spring-context.xml"},inheritLocations=false)
@Transactional
public class TestAop {
	
	@Resource
	BookService bookService;
	
	@Resource
	UserService userService;
	
	@Resource(name="redisTemplate_db0") 
	RedisTemplate<String, Object> redisTemplate;
	
	
	@Test  
    public void testHelloworld() {  
        
        Map<String, Object> map = new HashMap<String, Object>();
		map.put("borrower", 10);
		map.put("bookId", 18);
		map.put("page", 1);
		map.put("pageSize", 1);
		Page<Book> result = bookService.findByCondition(map);
		List<Book> books = result.getResult();
		if(books.size() > 0) {
			Book book = books.get(0);
			bookService.updateStatusById(book);
		} else {
			//没借不能还哦
		}
    }
	
	@Test
	public void testRedis() {
	
		redisTemplate.boundHashOps("key");
//		redisTemplate.set
		//redisTemplate.opsForValue().set("jedis-key", "jedis-test3");
		
		redisTemplate.opsForValue().set("jedis-test-2", "jedis-test-2-value", 15, TimeUnit.SECONDS);
		System.out.println(redisTemplate.opsForValue().get("jedis-test-2"));
		
		//redisTemplate.opsForHash().
		//redisTemplate.delete("jedis-test-2");
		
		//System.out.println(redisTemplate.opsForValue().get("jedis-key"));
		//System.out.println("redis inject test");
	}
//	
//	@Test  
//	public void testShiro() {  
//	    //1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager  
//	    Factory<org.apache.shiro.mgt.SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
//	    //2、得到SecurityManager实例 并绑定给SecurityUtils  
//	    org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();  
//	    SecurityUtils.setSecurityManager(securityManager);  
//	    //3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）  
//	    Subject subject = SecurityUtils.getSubject();  
//	    UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");  
//		try {
//			subject.login(token);
//		} catch (AuthenticationException e) {
//			
//		}
//	  
//	    assertEquals(true, subject.isAuthenticated()); //断言用户已经登录
//	    //6、退出  
//	    subject.logout();  
//	}
//	
	
	@Test
	public void testEncode() {
		
//		
////		UserService
//		String str = "hello";  
//		String base64Encoded = Base64.encodeToString(str.getBytes());  
//		System.out.println(base64Encoded);
//		String str2 = Base64.decodeToString(base64Encoded);  
//		System.out.println(str2);
//		assertEquals(str, str2);
//		
//		DefaultHashService hashService = new DefaultHashService(); //默认算法SHA-512  
//		hashService.setHashAlgorithmName("SHA-512");  
//		hashService.setPrivateSalt(new SimpleByteSource("123")); //私盐，默认无  
//		hashService.setGeneratePublicSalt(true);//是否生成公盐，默认false  
//		hashService.setRandomNumberGenerator(new SecureRandomNumberGenerator());//用于生成公盐。默认就这个  
//		hashService.setHashIterations(1); //生成Hash值的迭代次数  
//		  
//		HashRequest request = new HashRequest.Builder()  
//		            .setAlgorithmName("MD5").setSource(ByteSource.Util.bytes("hello"))  
//		            .setSalt(ByteSource.Util.bytes("123")).setIterations(2).build();  
//		//String hex = hashService.computeHash(request).toHex();   
//		String hex = hashService.computeHash(request).toString();
//		
//		System.out.println(hex);
//		
		
//		String string = "123456";
//		String salt = "";
//		Md5Hash s = new Md5Hash(string, salt, 2);
//		System.out.println(s.toHex());
//		System.out.println(s.toString());
//		
//		public User createUser(User user) {
//			user.setPassword(hashPassword(user.getPassword()));
//			userMapper.saveUser(user);
//			return user;
//		}
		
//		User user = new User();
//		user.setUsername("hello3");
//		user.setPassword("123456");
//		userService.createUser(user);
		
		userService.changePassword(2L, "123456");
		
	}
	
	@Test
	public void testBean() {

		ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:spring/spring-context.xml");  
        //context.getBean("", requiredType)
	}
}
