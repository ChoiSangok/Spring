package test02;

public class WomanProxy implements Develop{

	@Override
	public void classWork() {

		System.out.println("출석카드를 찍는다");
		try {
			new Woman().classWork();
		} catch (Exception e) {
			System.out.println("쉬는날이였따");
			// TODO: handle exception
		} finally {
			System.out.println("집에 간다");
		}
	}

	
}
