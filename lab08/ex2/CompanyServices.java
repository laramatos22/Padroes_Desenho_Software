public class CompanyServices {
    private SocialSecurity ss;
    private Insurance ins;
    private Parking park;
    private double avg;

    public CompanyServices(){}
    
    public void RegisterEmployee(Employee e){
        ss.regist(e);
        ins.regist(e);
        makeCartao();
        if(e.getSalary()>avg) park.allow(e);
    }
    public void setAvg(double avg){
        this.avg=avg;
    }
    private void makeCartao(){
        System.out.println("Cartao feito");
    }
}
