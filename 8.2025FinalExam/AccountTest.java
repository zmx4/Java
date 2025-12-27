import java.math.BigDecimal;
/*
按以下要求编写程序：(20分) 
为了帮助某银行对账户进行管理，请定义一个账户
(Account)的类，其中有: 
属性：账户号（accountNo），账户名称（accountName），
余额（balance），是否已冻结（freezed） 
构造方法：无参构造方法；有参构造方法，并且能够对各
个属性进行初始化。 
方法： 
存款（deposit），注意检查账户状态是否已冻结。 
取款（withdraw），注意检查账户状态和余额是否足够。 
编写测试类进行测试。
*/
public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account("001","qwq",new BigDecimal(100),false);
        System.out.println("Initial Balance: " + account.getBalance());

        // 测试存款
        System.out.println("Depositing 100...");
        account.deposit(100);
        System.out.println("Balance after deposit: " + account.getBalance());
        
        account.setFreezed(true);
        System.out.println("Account frozen.");
        // 测试取钱
        System.out.println("Withdrawing 1 (frozen)...");
        account.withdraw(1);
        System.out.println("Balance after frozen withdrawal attempt: " + account.getBalance());

        account.setFreezed(false);
        System.out.println("Account unfrozen.");
        // 测试取钱
        System.out.println("Withdrawing 1000 (insufficient)...");
        account.withdraw(1000);
        System.out.println("Balance after insufficient withdrawal attempt: " + account.getBalance());

        // 测试取钱
        System.out.println("Withdrawing 100...");
        account.withdraw(100);
        System.out.println("Balance after withdrawal: " + account.getBalance());
    }
}
