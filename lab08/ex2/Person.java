//Diogo Mendes e Lara Matos, 88801 e 95228

class Person {
	
private String name;
private BankAccount bankAccount;

	public Person(String n) {
		name = n;
		bankAccount = new BankAccountImpl("PeDeMeia", 0);
	}

	public String getName() {
		return name;
	}
	
	public BankAccount getBankAccount() {
		if (Company.user.equals(User.OWNER)){
			return bankAccount;
		}
		else return new ProxyBankAccount(bankAccount);
	}
}