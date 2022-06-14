class ProxyBankAccount implements BankAccount {
	
    private BankAccount bankAc;
    
    ProxyBankAccount(BankAccount bankAc) {
        this.bankAc=bankAc;
    }
    public void deposit(double amount) {
        bankAc.deposit(amount);
	}
	public boolean withdraw(double amount) {
		if (Company.user.equals(User.OWNER)){
            return bankAc.withdraw(amount);
        }
		else return false;
	}
	public double balance() {
		if (Company.user.equals(User.OWNER)){
            return bankAc.balance();
        }
		else return 0;
	}
}