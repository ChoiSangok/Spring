package capsule;

public class Sales {

	private Accounting accounting;
	
	public Sales() {}
	
	public Sales(Accounting accounting) {
		
		this.accounting=accounting;
		
	}
	
	//제품판매
	public int sellProduct(Coffee coffee, int salesCnt) {
		
		//커피 객체에 판매를 등록하고 결제금액을 반환받는다
		int payPrice = coffee.registerSales(salesCnt);
		//결제금액이 0 보다 크면 결제가 정상적으로 진행
		if(payPrice >0) {
			//계좌 객체에 매출 등록
			accounting.registerSales(payPrice);
		}
		//결제 금액을 반환
		return payPrice;
	}
	
	//제품 환불
    public int refundProduct(Coffee coffee,int coffeeCnt) {            
       if(coffee.getSalesCount()>=coffeeCnt) {
          //재고추가
          coffee.addStock(coffeeCnt, coffee.getSalesPrice());
          //잔고-
          accounting.setBalance(accounting.getBalance()-(coffeeCnt*coffee.getSalesPrice()));      
          coffee.setSalesCount(coffee.getSalesCount() - coffeeCnt);
       }else {
          System.out.println("판매량보다 많은 수입니다!");
       }   
       return 0;
    }
}
