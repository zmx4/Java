public class LoginService
{
	public boolean allowLogin(String username, String password)
	{
		boolean result = false;
		if(username.equals("admin") &&password.equals("123456"))
		{
			result = true;
		}
		return result;
	}
}