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
public class Account {
    private String accountNo; // 账号id
    private String accountName; // 账号名
    private BigDecimal balance; // 余额
    private boolean freezed; // 是否冻结
    public String getAccountNo() {
        return accountNo;
    }
    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }
    public String getAccountName() {
        return accountName;
    }
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
    public BigDecimal getBalance() {
        return balance;
    }
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
    public boolean isFreezed() {
        return freezed;
    }
    public void setFreezed(boolean freezed) {
        this.freezed = freezed;
    }
    public Account() {
    }
    public Account(String accountNo, String accountName, BigDecimal balance, boolean freezed) {
        this.accountNo = accountNo;
        this.accountName = accountName;
        this.balance = balance;
        this.freezed = freezed;
    }
    public void deposit(double value){
        if(freezed == false){ // 成功
            this.balance = this.balance.add(BigDecimal.valueOf(value));
            System.out.println("success");
        }else if(freezed == true){ // 冻结
            System.out.println("freezed");
        }
    }
    public void withdraw(double value){
        if(freezed == false && balance.compareTo(BigDecimal.valueOf(value)) >= 0){
            this.balance = this.balance.subtract(BigDecimal.valueOf(value));
            System.out.println("success");
        }else if(freezed == true){ // 冻结
            System.out.println("freezed");
        }else{ // 余额不足
            System.out.println("not enough");
        }
    }
}