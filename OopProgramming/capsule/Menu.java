package capsule;

import java.io.*;
import java.util.*;
public class Menu {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   
      Scanner sc= new Scanner(System.in);
      private Accounting accounting;
      private Sales sales;
      //사용자가 판매할 커피의 가짓수를 선택가능
      private Coffee[] coffeeArr;

   
   public Menu() {
      accounting = new Accounting();
      System.out.println("잔고를 입력하세요 : ");
      //사용자에게 잔고를 입력받아서 balance에 전달
      accounting.setBalance(sc.nextInt());
      
      sales = new Sales(accounting);
      System.out.println("=====================");
      System.out.println("커피 종류의 가짓수를 입력하세요 : ");
      coffeeArr = new Coffee[sc.nextInt()];
      
      System.out.println("=====================");
      
      for(int i=0;i<coffeeArr.length;i++) {
         Coffee coffee= new Coffee(accounting);
         
         System.out.println((i+1)+"번째 커피의 이름을 등록하세요");
         coffee.setName(sc.next());
         
         System.out.println((i+1)+"번째 커피의 판매가을 등록하세요");
         coffee.setSalesPrice(sc.nextInt());
         
         System.out.println((i+1)+"번째 커피의 매입가을 등록하세요");
         coffee.setPurchasePrice(sc.nextInt());
         
         System.out.println((i+1)+"번째 커피의 재고를 등록하세요");
         coffee.setStock(sc.nextInt());
         
         System.out.println((i+1)+"번째 커피의 안전재고을 등록하세요");
         coffee.setSafetyStock(sc.nextInt());
         
         System.out.println("=====================");      
         coffeeArr[i] =coffee;
      }
   }
   public void showIndex() {
      do {
         System.out.println("\n========메뉴========");
         System.out.println("메뉴(0) ");
         System.out.println("현황(1) ");
         System.out.println("환불(2) ");
         System.out.println("종료(3) ");
         System.out.println("입력 : ");
         int inputMenu = sc.nextInt();
         
         switch(inputMenu) {
            case 0: showMenu(); break;
            case 1: showState();break;
            //환불
            case 2: showRefund(); break;
            case 3: System.out.println("* 프로그램 종료"); return;
            
            default : System.out.println("* 잘못된 번호 입력 ");
         }
         
      }while(true);
   }
   
   
   private void showMenu() {
      System.out.println("\n *******음료 메뉴");
      for(int i=0;i<coffeeArr.length;i++) {
         System.out.println(coffeeArr[i].getName()+"("+i+")");
      }
      showSales();
   }
   
   
   
   private void showState() {
      System.out.println("\n=====================");
      
      for(Coffee coffee :coffeeArr) {
         System.out.printf("%10s 재고 : %d개 | 판매량 : %d \n", coffee.getName(),coffee.getStock(),coffee.getSalesCount());
      }
      System.out.println("* 잔고 : "+accounting.getBalance()
                  + "| 매출 : "+accounting.getSalesPrice()
                  +" | 지출 : "+accounting.getExpences());      
   }
   
   private void showSales() {
      System.out.println("\n * 판매한 커피의 코드를 입력하세요 : ");
      int inputType = sc.nextInt();
      
      System.out.println("* 주문량을 입력하세요 : ");
      int orderCnt = sc.nextInt();
      
      int payPrice= sales.sellProduct(coffeeArr[inputType], orderCnt);
      
      if(payPrice>0) {
         System.out.println("\n 제품명 : "+coffeeArr[inputType].getName()
               + "\n 판매가 : "+coffeeArr[inputType].getSalesCount()
               + "\n 구매갯수 : "+orderCnt
               + "\n 결제 금액 : "+payPrice
               + "\n 남은 재고 : "+coffeeArr[inputType].getStock()
               );
      }
   }
   private void showRefund() {
      System.out.println("\n * 환불할 커피의 코드를 입력하세요 : ");
      int inputType = sc.nextInt();
      System.out.println("* 환불량을 입력하세요 : ");
      int coffeeCnt = sc.nextInt();
      
      int refund= sales.refundProduct(coffeeArr[inputType],coffeeCnt);
      
      if(refund>0) {
         System.out.println("\n 제품명 : "+coffeeArr[inputType].getName()
               + "\n 판매가 : "+coffeeArr[inputType].getSalesCount()
               + "\n 구매갯수 : "+coffeeCnt
               + "\n 남은 재고 : "+coffeeArr[inputType].getStock()
               );
      }
      }
      
   }


