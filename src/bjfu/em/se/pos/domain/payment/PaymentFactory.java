package bjfu.em.se.pos.domain.payment;

/**
 * 支付类族的工程类
 * @author Roy
 *
 */
public class PaymentFactory {
	/**
	 * 创建支付类
	 * @param amount
	 * @param type
	 * @return
	 */
	public static Payment createPayment(int amount,PaymentType type) {
		Payment payment=null;
		switch(type) {
		case ByCash:
			payment=new CashPayment(amount);
			break;
		case ByCreditCard:
			payment=new CreditCardPayment(amount);
			break;
		case ByCheck:
			payment=new CheckPayment(amount);
			break;
		}
		return payment;
	}
}
